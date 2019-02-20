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
public class Floyds {
         private Graph graph;
        
        private void setGraph(){
                 graph = new Graph(5);
                 graph.addVertex('0');
                 graph.addVertex('1');
                 graph.addVertex('2');
                 graph.addVertex('3');
                 graph.addVertex('4');
                 
                 graph.addEdge(0, 1); 
                graph.addEdge(1,0);
                graph.addEdge(0, 2); 
                graph.addEdge(2,0);
                graph.addEdge(0,4);
                graph.addEdge(4,0);
                graph.addEdge(1, 4);
                graph.addEdge(4,1);
                graph.addEdge(1,3);
                graph.addEdge(3,1);
                graph.addEdge(2, 4); 
                graph.addEdge(4,2);
         }
        
         private void warshall(){
                 int numV = graph.numV;       
                 for (int k = 0; k < numV; k++) {
                         for (int i = 0; i < numV; i++) {
                                 if(graph.adjM[i][k]==0){
                                         continue;
                                 }
                                 for (int j = 0; j < numV; j++) {
                                        if(graph.adjM[k][j]==1){
                                                 graph.adjM[i][j] = 1;
                                        }
                                 }
                         }
                 }
         }
 
         public static void main(String[] args) {
                 Floyds flo = new Floyds();
                 flo.setGraph();
                 //System.out.println("Adjacency matrix of Graph is:");
                 //flo.graph.displayMatrx(flo.graph.adjM);
                System.out.println();
                 flo.warshall();
                System.out.println("Nodes that can be reached:");
                 flo.graph.displayMatrx(flo.graph.adjM);
        }
 }
 
 
 class Graph{
      int max;
          int numV;
          Vertex [] vertex;
          int [][] adjM;
         
         public Graph(int maxVerts){
                 max = maxVerts;
                 numV = 0;
                 vertex = new Vertex[max];
                 adjM = new int[max][max];
                //Initializing all entries to zero.
                 for (int i = 0; i < max; i++) {
                         for (int j = 0; j < max; j++) {
                                 adjM[i][j] = 0;
                        }
                 }
         }
         
         public void displayMatrx(int [][] data){
                 System.out.print("  ");
                for (int i = 0; i < numV; i++) {
                         System.out.print(vertex[i].label+" ");
                 }
                 System.out.println();
                 for (int i = 0; i < numV; i++) {
                         System.out.print(vertex[i].label+" ");
                        for (int j = 0; j < numV; j++) {
                                 System.out.print(data[i][j]+" ");
                        }
                        System.out.println();
                 }
         }
         public void display(int n){
                 System.out.print(vertex[n].label);
         }
         public void addEdge(int st, int end){
         if(st < numV && end < numV){
              adjM[st][end] = 1;
         }
         }
         public void addVertex(char label){
                 if(numV < max){
                         vertex[numV++] = new Vertex(label);
                 }
        }


       
 }

 class Vertex{
         char label;
        
        public Vertex(char label){
                this.label = label;
         }
 }
