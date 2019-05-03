package Huffman;

import java.util.*;

/*
@author Qinyuan Zhang
@date 02/05/2019
*/
public class HuffmanCode {

   // We first need to have a method to sort the map
   public static Map<String, Double> sort (Map<String,Double> map) {
      List<Map.Entry<String,Double>> list = new ArrayList<>(map.entrySet());

      Collections.sort(list,new Comparator<Map.Entry<String,Double>>() {
         @Override
         public int compare(Map.Entry<String, Double> o1,
                            Map.Entry<String, Double> o2) {
            return o1.getValue().compareTo(o2.getValue());
         }
      });

      Map<String,Double> sortedMap = new LinkedHashMap<>();
      for (Map.Entry<String,Double> mapping:list) {
         sortedMap.put(mapping.getKey(),mapping.getValue());
      }

      return sortedMap;
   }

   // This method take D least element and assemble them into one element.
   public static Map<String, Double> assembleNewMap(Map<String, Double> sortedMap, int D) {
      Map<String, Double> returnMap = new LinkedHashMap<>();
      int count = 0;
      String newElement = "";
      Double newFreq = 0.0;
      for (Map.Entry<String, Double> entry : sortedMap.entrySet()) {
         if (count < D) {
            newElement += entry.getKey();
            newFreq += entry.getValue();
            if (count == D - 1 || count == sortedMap.size() - 1) {
               returnMap.put(newElement, newFreq);
            }
         }
         else {
            returnMap.put(entry.getKey(), entry.getValue());
         }
         count++;
      }
      return returnMap;
   }

   // This method build the actual tree by returning every layers of the tree as a map
   public static List<Map<String, Double>> buildHuffmanTree(Map<String,Double> pmf, int D) {

      // We need to add dumpy symbol first
      int dumpyCount = 0;
      while ((pmf.size()-1) / (D-1) - (pmf.size()-1) / (double)(D-1) != 0.0) {
            pmf.put("empty"+dumpyCount, 0.0);
            dumpyCount++;
      }
      List<Map<String,Double>> tree = new ArrayList<>();
      // Add the first layer first
      tree.add(sort(pmf));
      // Calculate steps we need, or layers the algorithm will has
      int stepsWeNeed = (pmf.size() - 1)/(D - 1);
      // Add new layers by using layer above it
      for (int i = 1; i < stepsWeNeed + 1; i++) {
         if (i == 1) {
            tree.add(assembleNewMap(sort(pmf), D));
         } else {
            tree.add(assembleNewMap(sort(tree.get(i - 1)), D));
         }
      }

      return tree;
   }

   // This method encode or generate codes by using the tree
   public static Map<String, String> encode(List<Map<String, Double>> tree) {
      Map<String, String> finalResults = new LinkedHashMap<>();

      // Give the second layer (the layer under root layer) a series of numbers
      int index = 0;
      for (Map.Entry<String, Double> entry : tree.get(tree.size() - 2).entrySet()) {
         finalResults.put(entry.getKey(), Integer.toString(index));
         index++;
      }

      // Follow down the layers and pass numbers downward
      for (int i = tree.size() - 3; i > -1; i--) {
         Map<String, String> newFinalResults = new LinkedHashMap<>();
         int newIndex = 0;
         for (Map.Entry<String, Double> entry : tree.get(i).entrySet()) {
            for (Map.Entry<String, Double> entry2 : tree.get(i + 1).entrySet()) {
               if(entry.getKey().equals(entry2.getKey())) {
                  newFinalResults.put(entry.getKey(), finalResults.get(entry.getKey()));
                  break;
               }
               else if(entry2.getKey().contains(entry.getKey())) {
                  newFinalResults.put(entry.getKey(), finalResults.get(entry2.getKey()) + Integer.toString(newIndex));
                  newIndex++;
                  break;
               }
            }
         }
         finalResults = newFinalResults;
      }

      // Return the final results
      return finalResults;
   }

   public static void main(String[] args) {
      Map<String, Double> map = new LinkedHashMap<>();

      // Add your personal characters and pmf here.
      map.put("A", 0.28182733);
      map.put("T", 0.28302858);
      map.put("C", 0.21806686);
      map.put("G", 0.21707721);

      // Build the tree, change the D here
      List<Map<String, Double>> getList = buildHuffmanTree(map, 2);

      // You can also inspect different layers' situations here
//      List<String> keys = new ArrayList<>();
//      List<Double> values = new ArrayList<>();
//      for (Map.Entry<String, Double> entry : getList.get(3).entrySet()) {
//         keys.add(entry.getKey());
//         values.add(entry.getValue());
//      }
//      System.out.println("=========================================");
//      for (String key: keys) {
//         System.out.print("||  " + key + "\t\t\t");
//      }
//      System.out.println("||");
//      for (Double value: values) {
//         System.out.print("||  " + Double.toString(value) + "\t");
//      }
//      System.out.println("||");
//      System.out.println("=========================================");

      // Print out the final results
      System.out.println(encode(getList));
   }
}
