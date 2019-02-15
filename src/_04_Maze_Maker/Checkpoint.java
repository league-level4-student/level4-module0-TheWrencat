package _04_Maze_Maker;

import java.util.Random;

public class Checkpoint {
//	2.  Add a main method to the class
//	 
//	3.  Create and initialize a 2D integer array of 5 rows and 5 columns.
//
//	4.  Use a nested for loop to initialize each int in the 2D array to a random number.
//	  
//	5.  Use a separate nested for loop to print the contents of the array in row major order.
	
	public static void main(String[] args) {
		int [][] d2 = new int[5][5];
		for(int i = 0; i < d2.length; i++) {
			for(int j = 0; j < d2.length; j++) {
				Random r = new Random();
				d2[i][j] = r.nextInt(10);
				System.out.print(d2[i][j]);
			}
			System.out.println();
		}
	}
	
}
