package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeMaker {

	private static int width;
	private static int height;

	private static Maze maze;

	private static Random randGen = new Random();
	private static Stack<MCell> uncheckedCells = new Stack<MCell>();

	public static Maze generateMaze(int w, int h) {
		width = w;
		height = h;
		maze = new Maze(width, height);

		// 4. select a random cell to start
		MCell c = maze.getCell(randGen.nextInt(width), randGen.nextInt(height));

		// 5. call selectNextPath method with the randomly selected cell
		selectNextPath(c);

		return maze;
	}

	// 6. Complete the selectNextPathMethod
	private static void selectNextPath(MCell currentCell) {
		// A. mark cell as visited
		currentCell.setBeenVisited(true);
		// B. check for unvisited neighbors using the cell

		ArrayList<MCell> neighborCells = getUnvisitedNeighbors(currentCell);

		// C. if has unvisited neighbors,
		Boolean hasUnvisitedN = false;
		for (int i = 0; i < neighborCells.size(); i++) {
			MCell checkForUncheck = neighborCells.get(i);
			if (checkForUncheck.hasBeenVisited() == false) {

				// C1. select one at random.
				MCell cCell = neighborCells.get(randGen.nextInt(neighborCells.size()));

				// C2. push it to the stack
				uncheckedCells.push(cCell);

				// C3. remove the wall between the two cells
				removeWalls(currentCell, cCell);
				// C4. make the new cell the current cell and mark it as visited
				currentCell = cCell;
				currentCell.setBeenVisited(true);
				hasUnvisitedN = true;
				selectNextPath(currentCell);

			}
		}

		// D. if all neighbors are visited
		if (hasUnvisitedN == false) {
			// D1. if the stack is not empty
			if (uncheckedCells.size() != 0) {
				// D1a. pop a cell from the stack
				currentCell = uncheckedCells.pop();
				// D1b. make that the current cell
				selectNextPath(currentCell);
			}
		}
	}

	// 7. Complete the remove walls method.
	// This method will check if c1 and c2 are adjacent.
	// If they are, the walls between them are removed.
	private static void removeWalls(MCell c1, MCell c2) {
		if (c1.getX() == c2.getX()) {
			// north
			if (c1.getY() > c2.getY()) {
				c1.setNorthWall(false);
				c2.setSouthWall(false);
			}
			// south
			if (c1.getY() < c2.getY()) {
				c1.setSouthWall(false);
				c2.setNorthWall(false);
			}
		}
		// east
		if (c1.getY() == c2.getY()) {
			if (c1.getX() < c2.getX()) {
				c1.setEastWall(false);
				c2.setWestWall(false);
			}
			// west
			if (c1.getX() > c2.getX()) {
				c1.setWestWall(false);
				c2.setEastWall(false);
			}
		}
	}

	// 8. Complete the getUnvisitedNeighbors method
	// Any unvisited neighbor of the passed in cell gets added
	// to the ArrayList
	private static ArrayList<MCell> getUnvisitedNeighbors(MCell c) {
		// checking for edge
		ArrayList<MCell> uN = new ArrayList<>();
		if (c.getX() != 0) {
			MCell west = maze.getCell(c.getX() - 1, c.getY());
			if (west.hasBeenVisited() == false) {
				uN.add(west);
			}
		}
		if (c.getX() != width - 1) {
			MCell east = maze.getCell(c.getX() + 1, c.getY());
			if (east.hasBeenVisited() == false) {
				uN.add(east);
			}
		}
		if (c.getY() != 0) {
			MCell north = maze.getCell(c.getX(), c.getY() - 1);
			if (north.hasBeenVisited() == false) {
				uN.add(north);
			}

		}
		if (c.getY() != height - 1) {
			MCell south = maze.getCell(c.getX(), c.getY() + 1);
			if (south.hasBeenVisited() == false) {
				uN.add(south);
			}
		}
		return uN;
	}
}