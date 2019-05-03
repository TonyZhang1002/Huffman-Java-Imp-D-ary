package Huffman;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/*
@author Qinyuan Zhang
@date 03/05/2019
*/
public class Comparison {
   public static void main(String[] args) {
      File OriginalFile = new File("src/Huffman/NC_000964.3.seq");
      File D2File = new File("src/Huffman/NCoutputD2.txt");
      File D3File = new File("src/Huffman/NCoutputD3.txt");
      File D4File = new File("src/Huffman/NCoutputD4.txt");
      Reader reader;
      try {
         reader = new InputStreamReader(new FileInputStream(OriginalFile));
         int origCount = 0;
         while (reader.read() != -1) {
            origCount++;
         }
         System.out.println("The length of original file: " + origCount);

         reader = new InputStreamReader(new FileInputStream(D2File));
         int d2Count = 0;
         while (reader.read() != -1) {
            d2Count++;
         }
         System.out.println("The length of d2 file: " + d2Count +
                 ". Average length of the encoding: " + ((double)d2Count) / origCount);

         reader = new InputStreamReader(new FileInputStream(D3File));
         int d3Count = 0;
         while (reader.read() != -1) {
            d3Count++;
         }
         System.out.println("The length of d3 file: " + d3Count +
                 ". Average length of the encoding: " + ((double)d3Count) / origCount);

         reader = new InputStreamReader(new FileInputStream(D4File));
         int d4Count = 0;
         while (reader.read() != -1) {
            d4Count++;
         }
         System.out.println("The length of d4 file: " + d4Count +
                 ". Average length of the encoding: " + ((double)d4Count) / origCount);

      } catch (Exception e) {
         e.printStackTrace();
      }
   }

}
