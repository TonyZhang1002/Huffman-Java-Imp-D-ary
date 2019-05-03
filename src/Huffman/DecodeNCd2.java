package Huffman;

import java.io.*;

/*
@author Qinyuan Zhang
@date 03/05/2019
*/
public class DecodeNCd2 {
   public static void main(String[] args) {
      File ReadFile = new File("src/Huffman/NCoutputD2.txt");
      Reader reader;
      try{
         reader = new InputStreamReader(new FileInputStream(ReadFile));
         int tempchar;
         String first10 = "";
         int count = 0;
         while ((tempchar = reader.read()) != -1 && count<10) {
            if ((tempchar) == 49) {
               tempchar = reader.read();
               if (tempchar == 49) {
                  first10 += "C";
               }
               else {
                  first10 += "G";
               }
            }
            else {
               tempchar = reader.read();
               if (tempchar == 49) {
                  first10 += "T";
               }
               else {
                  first10 += "A";
               }
            }
            count++;
         }
         System.out.println("The first 10 decoded chars are: " + first10);
         reader.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
