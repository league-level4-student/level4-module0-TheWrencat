package _03_Conways_Game_of_Life;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class WorldPanel extends JPanel implements MouseListener, ActionListener {
	private static final long serialVersionUID = 1L;
	private int cellsPerRow;
	private int cellSize;
	
	private Timer timer;
	
	//1. Create a 2D array of Cells. Do not initialize it.
	Cell[][] Cells;
	
	
	public WorldPanel(int w, int h, int cpr) {
		setPreferredSize(new Dimension(w, h));
		addMouseListener(this);
		timer = new Timer(500, this);
		this.cellsPerRow = cpr;
	
		//2. Calculate the cell size.
		int cellSize = w / cpr;
		System.out.println("Cellsize" +cellSize+ " Cells per row: " +cellsPerRow);
		//3. Initialize the cell array to the appropriate size.
		Cells = new Cell[cpr][cpr];
		//3. Iterate through the array and initialize each cell.
		//   Don't forget to consider the cell's dimensions when 
		//   passing in the location.
		int x = 0;
		int y = 0;
		for(int i = 0; i < Cells.length; i++) {
			for(int j = 0; j < Cells[i].length; j++) {
				Cells[i][j] = new Cell(x, y, cellSize);
				x += cellSize;				
			}
			y += cellSize;
			x = 0;
			
		}
		
	}
	
	public void randomizeCells() {
		//4. Iterate through each cell and randomly set each
		//   cell's isAlive memeber to true of false
		for(int i = 0; i < Cells.length; i++) {
			for(int j = 0; j < Cells[i].length; j++) {
				int r = new Random().nextInt(2);

				if(r == 0) {
					Cells[i][j].isAlive = false;
				}else {
					Cells[i][j].isAlive = true;
				}
				
			}
			
		}
		
		repaint();
	}
	
	public void clearCells() {
		//5. Iterated through the cells and set them all to dead.
		for(int i = 0; i < Cells.length; i++) {
			for(int j = 0; j < Cells[i].length; j++) {
				Cells[i][j].isAlive = false;
				
			}
			
		}
		repaint();
	}
	
	public void startAnimation() {
		timer.start();
	}
	
	public void stopAnimation() {
		timer.stop();
	}
	
	public void setAnimationDelay(int sp) {
		timer.setDelay(sp);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		System.out.println("paint");
		//6. Iterate through the cells and draw them all
		for(int i = 0; i < Cells.length; i++) {
			for(int j = 0; j < Cells[i].length; j++) {
				Cells[i][j].draw(g);
				
			}
			
		}
		
		
		// draws grid
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
	}
	
	//advances world one step
	
	int countN(Cell[][] c, int x, int y){
		int row = x-1;
		int col = y-1;
		int n = 0;
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				if(row + i < 0 || row + i >= cellsPerRow) {
					continue;
				}else if(col + j < 0 || col + j >= cellsPerRow) {
					continue;
				}else if(row +i == x || col + j == y){
					continue;
				}else if( c[row+i][col+j].isAlive) {
					n++;
					
				}
			
			}
		}
		if(n == 3) {
		}
		return n;
	}
	public void step() {
		//7. iterate through cells and get their neighbors
		for(int i = 0; i < Cells.length; i++){
			for(int j = 0; j < Cells[i].length; j++) {
				int nCount = countN(Cells, i, j);
				
				Cells[i][j].liveOrDie(nCount);
			}
		}
		//8. check if each cell should live or die
	
		
		
		
		repaint();
	}
	
	//9. Complete the method.
	//   It returns an array list of the  8 or less neighbors of the 
	//   cell identified by x and y
	public int getLivingNeighbors(int x, int y){
		return 0;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//10. Use e.getX() and e.getY() to determine
		//    which cell is clicked. Then toggle
		//    the isAlive variable for that cell.
		
		
		
		
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		step();		
	}
}
