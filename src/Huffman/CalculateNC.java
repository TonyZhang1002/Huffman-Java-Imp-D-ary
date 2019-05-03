package Huffman;

import java.io.*;

/*
@author Qinyuan Zhang
@date 03/05/2019
*/
public class CalculateNC {
   public static void main(String[] args) {
      File file = new File("src/Huffman/NC_000964.3.seq");
      Reader reader;
      try {
         // 一次读一个字符
         reader = new InputStreamReader(new FileInputStream(file));
         int tempchar;
         int countA = 0;
         int countT = 0;
         int countC = 0;
         int countG = 0;
         while ((tempchar = reader.read()) != -1) {
            if (((char) tempchar) == 'A') {
               countA++;
            }
            else if (((char) tempchar) == 'T') {
               countT++;
            }
            else if (((char) tempchar) == 'C') {
               countC++;
            }
            else if (((char) tempchar) == 'G') {
               countG++;
            }
         }
         reader.close();
         int sum = countA + countC + countG + countT;
         double freqA = ((double)(countA) / sum);
         double freqT = ((double)(countT) / sum);
         double freqC = ((double)(countC) / sum);
         double freqG = ((double)(countG) / sum);
         System.out.println("A: " + freqA + " T: " + freqT + " C: "
                 + freqC + " G: " + freqG);
         double entropy = 0 - freqA * Math.log(freqA) - freqT * Math.log(freqT) -
                 freqC * Math.log(freqC) - freqG * Math.log(freqG);
         System.out.println("Entropy of X: " + entropy);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
