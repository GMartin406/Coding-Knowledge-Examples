/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci232outlab2.outlab2;

/**
 * Greg Martin
 * HashTable.java
 * 10/7/18
 *
 * 
 */
public class HashTable {

   //Class for holding key-value pair information
   private static class Node {
      String key;
      String value;
      Node next; 
   }

   private Node[] array;
   private int count;

   //Main class with all of the functions of the hashtable
   public HashTable(int size) {
      if (size <= 0)
         System.out.println("You must enter a valid size.");
      array = new Node[size];
   }

   //Add method that accepts a key value pair and creates a new node and adds it
   //to the array after its correct position is found.
   public void add(String key, String value) {
      if(key == null){
          return;
      }
      int hashVal = hash(key);
      
      Node temp = array[hashVal];
      while (temp != null) {
         if (temp.key.equals(key))
            break;
         temp = temp.next;
      }
      if (temp != null) {
         temp.value = value;
      }
      else {
         if (count >= 0.80*array.length) {
            resize();
            hashVal = hash(key);
         }
         Node toAdd = new Node();
         toAdd.key = key;
         toAdd.value = value;
         toAdd.next = array[hashVal];
         array[hashVal] = toAdd;
         count++;
      }
   }
   
   //Remove method. Removes item in the array given the key. Does so without
   //messing up any other of the nodes.
   public void remove(String key) {  
      
      int hashVal = hash(key);
      if (array[hashVal] == null) {
         return; 
      }  
      if (array[hashVal].key.equals(key)) {
         array[hashVal] = array[hashVal].next;
         count--;
         return;
      }
      Node prev = array[hashVal];
      Node curr = prev.next;
      while (curr != null && !(curr.key.equals(key))) {
         curr = curr.next;
         prev = curr;
      }
      if (curr != null) {
         prev.next = curr.next;
         count--;
      }
   }
   //Returns the value of a given key if that key is in the hashtable
   public String get(String key) {
      int hashVal = hash(key);
      
      Node temp = array[hashVal];
      while (temp != null) {
         if (temp.key.equals(key))
            return temp.value;
         temp = temp.next;
      }
      
      return null;  
   }

   //returns the current count of the array, which is increased for every add
   //and decreased for every remove
   public int size() {
      return count;
   }

   //hash method 
   private int hash(String key) {
      return Integer.parseInt(key) % array.length;
   }

   //Doubles the size of the array when greater than 80% load
   private void resize() {
      Node[] newtable = new Node[array.length*2];
      for (int i = 0; i < array.length; i++) {
         Node list = array[i];
         while (list != null) {
            Node next = list.next;
            int hash = Integer.parseInt(list.key) % newtable.length;
            list.next = newtable[hash];
            newtable[hash] = list;
            list = next;
         }
      }
      array = newtable;
   }
   //Prints out the hashtable in a readable format  
   void print() {
      System.out.println();
      for (int i = 0; i < array.length; i++) {
         System.out.print("Slot "+i + "=>");
         Node temp = array[i];
         while (temp != null) {
            System.out.print(" " + temp.key + "," + temp.value + "");
            temp = temp.next;
         }
         System.out.println();
      }
   }
}
