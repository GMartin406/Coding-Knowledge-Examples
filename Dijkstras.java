/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlab3;

import java.util.*; 
import java.lang.*; 
import java.io.*; 
  
class Dijkstras 
{ 
    static final int V=5; 
    int min(int data[], Boolean tf[]) 
    { 
        int min = Integer.MAX_VALUE, min_index=-1; 
  
        for (int v = 0; v < V; v++) 
            if (tf[v] == false && data[v] <= min) 
            { 
                min = data[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
    void print(int data[], int n) 
    { 
        System.out.println("   "); 
        for (int i = 0; i < V; i++) 
            System.out.println(i+" is this far away: "+data[i]); 
    } 

    void dijkstra(int data[][], int src) 
    { 
        int dist[] = new int[V];

        Boolean tf[] = new Boolean[V]; 

        for (int i = 0; i < V; i++) 
        { 
            dist[i] = Integer.MAX_VALUE; 
            tf[i] = false; 
        } 

        dist[src] = 0; 

        for (int count = 0; count < V-1; count++) 
        { 
            int min = min(dist, tf); 

            tf[min] = true; 
 
            for (int k = 0; k < V; k++) 

                if (!tf[k] && data[min][k]!=0 && 
                        dist[min] != Integer.MAX_VALUE && 
                        dist[min]+data[min][k] < dist[k]) 
                    dist[k] = dist[min] + data[min][k]; 
        } 

        print(dist, V); 
    } 

    public static void main (String[] args) 
    { 
       int graph[][] = new int[][] {{0, 9, 3, 0, 6}, 
                                    {9, 0, 0, 4, 5}, 
                                    {3, 0, 0, 0, 8}, 
                                    {0, 4, 0, 0, 0}, 
                                    {6, 5, 8, 0, 0}}; 
        Dijkstras dij = new Dijkstras(); 
        dij.dijkstra(graph, 0); 
    } 
} 
