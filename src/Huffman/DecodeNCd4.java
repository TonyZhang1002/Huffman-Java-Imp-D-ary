package Huffman;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/*
@author Qinyuan Zhang
@date 03/05/2019
*/
public class DecodeNCd4 {
   public static void main(String[] args) {
      File ReadFile = new File("src/Huffman/NCoutputD4.txt");
      Reader reader;
      try{
         reader = new InputStreamReader(new FileInputStream(ReadFile));
         int tempchar;
         String first10 = "";
         int count = 0;
         while ((tempchar = reader.read()) != -1 && count < 10) {
            if (tempchar == 48) {
               first10 += "G";
               count++;
            }
            else if (tempchar == 49) {
               first10 += "C";
               count++;
            }
            else if (tempchar == 50){
               first10 += "A";
               count++;
            }
            else {
               first10 += "T";
               count++;
            }
         }
         System.out.println("The first 10 decoded chars are: " + first10);
         reader.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
