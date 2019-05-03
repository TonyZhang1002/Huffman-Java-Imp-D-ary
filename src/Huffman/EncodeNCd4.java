package Huffman;

import java.io.*;

/*
@author Qinyuan Zhang
@date 03/05/2019
*/
public class EncodeNCd4 {
   public static void main(String[] args) {
      File ReadFile = new File("src/Huffman/NC_000964.3.seq");
      File writename = new File("src/Huffman/NCoutputD4.txt");
      Reader reader;
      try {
         reader = new InputStreamReader(new FileInputStream(ReadFile));
         writename.createNewFile();
         BufferedWriter out = new BufferedWriter(new FileWriter(writename));
         int tempchar;
         while ((tempchar = reader.read()) != -1) {
            if ((((char) tempchar) == 'A')) {
               out.write("2");
            }
            else if ((((char) tempchar) == 'C')) {
               out.write("1");
            }
            else if ((((char) tempchar) == 'T')) {
               out.write("3");
            }
            else if ((((char) tempchar) == 'G')) {
               out.write("0");
            }
         }
         reader.close();
         out.flush();
         out.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
