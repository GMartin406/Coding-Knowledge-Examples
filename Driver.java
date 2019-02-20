/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci232outlab2.outlab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Greg Martin 
 * 10/7/18
 * 
 */
public class Driver {

   public static void main(String[] args){
      HashTable table = new HashTable(5);
      String key,value;
      String[] array = new String[2];
        try {
            File file = new File("input.txt"); //I removed the double spaces in
            //the .txt file. I just assumed they weren't supposed to be there.
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
               array = line.split(" ");
               table.add(array[0], array[1]);
            }
            fileReader.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        table.print();
        System.out.println("Removing: "+table.get("1234"));
        table.remove("1234");
        table.print();
   }
} 
