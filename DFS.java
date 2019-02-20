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
import java.io.*; 
import java.util.*; 

class DFS 
{ 
    private int verts;
    private LinkedList<Integer> adj[]; 
    
    int[][] matrix = {{0,1,1,0,1},
        {1,0,0,1,1},
        {1,0,0,0,1},
        {0,1,0,0,0},
        {1,1,1,0,0}};
  
    // Constructor 
    DFS (int v) 
    { 
        verts = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
  
    void addEdge(int v, int w) 
    { 
        adj[v].add(w);  
    } 
  
    void DFS(int iter,int[][] matrix,boolean visited[]) 
    { 

        visited[iter] = true; 
        System.out.print(iter+" "); 

        for(int j=0;j<visited.length;j++){
            if(matrix[iter][j] == 1 && !visited[j]){
                DFS(j, matrix, visited);
            }
        }
    } 
  
    void DFSCall(int v) 
    { 
        boolean visited[] = new boolean[verts]; 
        
        DFS(v, matrix, visited); 
    } 
  
    public static void main(String args[]) 
    { 
        DFS  g = new DFS(5); 
  
        g.addEdge(0, 1); 
        g.addEdge(1,0);
        g.addEdge(0, 2); 
        g.addEdge(2,0);
        g.addEdge(0,4);
        g.addEdge(4,0);
        g.addEdge(1, 4);
        g.addEdge(4,1);
        g.addEdge(1,3);
        g.addEdge(3,1);
        g.addEdge(2, 4); 
        g.addEdge(4,2);
  
        System.out.println("DFS: "); 
  
        g.DFSCall(0); 
    } 
}