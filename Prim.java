/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlab3;

/**
 *
 * @author Greg
 */

import java.util.*; 
import java.lang.*; 
import java.io.*; 
  
class Prim 
{ 
    private static final int V=5; 
  
    
    void print(int parent[], int n, int graph[][]) 
    { 
        System.out.println("Edge \tWeight"); 
        for (int i = 1; i < V; i++) 
            System.out.println(parent[i]+" - "+ i+"\t"+ 
                            graph[i][parent[i]]); 
    } 
    
    int min(int key[], Boolean mstSet[]) 
    { 
        int min = Integer.MAX_VALUE, min_index=-1; 
  
        for (int v = 0; v < V; v++) 
            if (mstSet[v] == false && key[v] < min) 
            { 
                min = key[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 


    void prim(int graph[][]) 
    { 
        int parent[] = new int[V]; 
  
        int key[] = new int [V]; 
  
        Boolean tf[] = new Boolean[V]; 

        for (int i = 0; i < V; i++) 
        { 
            key[i] = Integer.MAX_VALUE; 
            tf[i] = false; 
        } 
  
        key[0] = 0;    
                        
        parent[0] = -1; 
  
        for (int count = 0; count < V-1; count++) 
        { 
            int j = min(key, tf); 
 
            tf[j] = true; 

            for (int k = 0; k < V; k++) 

                if (graph[j][k]!=0 && tf[k] == false && 
                    graph[j][k] < key[k]) 
                { 
                    parent[k] = j; 
                    key[k] = graph[j][k]; 
                } 
        } 

        print(parent, V, graph); 
    } 
  
    public static void main (String[] args) 
    { 

        Prim mst = new Prim(); 
        int graph[][] = new int[][] {{0, 9, 3, 0, 6}, 
                                    {9, 0, 0, 4, 5}, 
                                    {3, 0, 0, 0, 8}, 
                                    {0, 4, 0, 0, 0}, 
                                    {6, 5, 8, 0, 0}}; 
        mst.prim(graph); 
    } 
}
