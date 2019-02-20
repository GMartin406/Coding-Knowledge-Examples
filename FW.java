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
public class FW {

	static int[][] path;
	static final int N = 5;


	public static int[][] floyd(int[][] data) {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (data[i][k] + data[k][j] < data[i][j]) {
						data[i][j] = data[i][k] + data[k][j];
						path[i][j] = k;
					}
				}
			}
		}
		return data;
	}

	public static int min(int i, int j) {
		if (i > j) {
			return j;
		}
		return i;
	}

	public static void print(int[][] set) {
		System.out.print("\n\t");
		for (int j = 0; j < N; j++) {
			System.out.print(j + "\t");
		}
		System.out.println();
		for (int j = 0; j < 45; j++) {
			System.out.print("-");
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			System.out.print(i + " |\t");
			for (int j = 0; j < N; j++) {
				System.out.print(set[i][j]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}
		System.out.println("\n");
	}
         
	public static void main(String[] args) {
		int[][] data = { { 0, 9, 3, 999, 6 }, { 9, 0, 999, 4, 5 }, { 3, 999, 0, 999, 8 },
				{ 999, 4, 999, 0, 999 }, {6, 5, 8, 999, 0} };
		path = new int[N][N];
		System.out.println("Matrix to find the shortest path of.");
		print(data);
		System.out.println("Shortest Path Matrix.");
		print(floyd(data));
		System.out.println("Path Matrix");
		print(path);
	}

}
