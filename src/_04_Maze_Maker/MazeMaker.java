package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import _03_Conways_Game_of_Life.Cell;


public class MazeMaker{
	
	private static int width;
	private static int height;
	
	private static Maze maze;
	
	private static Random randGen = new Random();
	private static Stack<MCell> uncheckedCells = new Stack<MCell>();
	
	
	public static Maze generateMaze(int w, int h){
		width = w;
		height = h;
		maze = new Maze(width, height);
		
		//4. select a random cell to start
		MCell c = maze.getCell(randGen.nextInt(width), randGen.nextInt(height));
		
		
		//5. call selectNextPath method with the randomly selected cell
		selectNextPath(c);
		
		return maze;
	}

	int countN(MCell[][] c, int x, int y){
		ArrayList<Cell> nCells = new ArrayList<>;
		int row = x-1;
		int col = y-1;
		int n = 0;
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				if(row + i < 0 || row + i >= 5) {
					continue;
				}else if(col + j < 0 || col + j >= 5) {
					continue;
				}else if(row +i == x || col + j == y){
					continue;
				}else {
					//work on this
					nCells.add()
					
				}
			
			}
		}
		return nCells[][];
	}
	
	//6. Complete the selectNextPathMethod
	private static void selectNextPath(MCell currentCell) {
		//A. mark cell as visited
		currentCell.setBeenVisited(true);
		//B. check for unvisited neighbors using the cell
		
		int countN(MCell[][] c, int x, int y){
			int row = x-1;
			int col = y-1;
			int n = 0;
			for(int i = 0; i<3; i++) {
				for(int j = 0; j<3; j++) {
					if(row + i < 0 || row + i >= 5) {
						continue;
					}else if(col + j < 0 || col + j >= 5) {
						continue;
					}else if(row +i == x || col + j == y){
						continue;
					}else {
						
						
					}
				
				}
			}
			return;
		}
		//C. if has unvisited neighbors,
		
			//C1. select one at random.
			
			//C2. push it to the stack
		
			//C3. remove the wall between the two cells

			//C4. make the new cell the current cell and mark it as visited
			
			
		//D. if all neighbors are visited
		
			//D1. if the stack is not empty
			
				// D1a. pop a cell from the stack
		
				// D1b. make that the current cell
				
			
		
	}

	//7. Complete the remove walls method.
	//   This method will check if c1 and c2 are adjacent.
	//   If they are, the walls between them are removed.
	private static void removeWalls(MCell c1, MCell c2) {
		
	}
	
	//8. Complete the getUnvisitedNeighbors method
	//   Any unvisited neighbor of the passed in cell gets added
	//   to the ArrayList
	private static ArrayList<MCell> getUnvisitedNeighbors(MCell c) {
		return null;
	}
}