package life6visitor;

import java.util.ArrayList;
import java.util.List;

public class GameOfLife {
	private List<Observer> Observers;
	
	// width and height in pixels
	private int width;
	private int height;

	// rows and cols for the game
	private int rows;
	private int cols;
	private Cell grid[][];
	
	public GameOfLife(int rows, int cols, int width, int height) {

		// Save the instance variables
		this.rows = rows;
		this.cols = cols;
		this.width = width;
		this.height = height;
		grid = new Cell[rows][cols];
		Observers = new ArrayList<Observer>();
		setUpGrid();
	}
	
	private void setUpGrid() {
		// If there is no grid already set up, make a new one
		if (grid[0][0] == null) {
			// Setup the grid
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < cols; j++) {
					grid[i][j] = new Cell();
				}
			}        	
		}
	}
	
	// Returns the number of alive neighbors for the cell at position r,c. The
    //   grid is finite but unbound, meaning that the neighbor relation wraps
    //   around the grid boundaries.  This is a helper method
   	private int nbrOfNeighbors(int r, int c) {
        int n = 0;
        int x = 0;
        int y = r - 1;
        if (y < 0) {
            y = rows - 1;
        }
        for (int rCt = 1; rCt <= 3; rCt++) {
            x = c - 1;
            if (x < 0) {
                x = cols - 1;
            }
            for (int cCt = 1; cCt <= 3; cCt++) {
                if (x != c || y != r) {
                    if (grid[y][x].isAlive()) {
                        n++;
                    }
                }
                x = (x + 1) % cols;
            }
            y = (y + 1) % rows;
        }
        return n;
    }

	// This method implements the rules of the Game of Life. For each cell,
	//   we simple find the number of neighbors and then bring the cell to life
	//   if appropriate.
	public void advance() {
		// Get my number of alive neighbors
		for (int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				grid[i][j].setNbrAliveNeighbors(nbrOfNeighbors(i, j));
			}
		}
		
		// Create grid command list and my n for neighbors
		List<LifeCommand> gridCommands = new ArrayList<LifeCommand>();
		LifeVisitor currentVisitor = new StandardLifeVisitor();
		
		// Have the visitor visit everyone in the grid
		for (int i = 0; i < rows; i++) {
			for(int j = 0; j < rows; j ++) {
				currentVisitor.visit(grid[i][j]);
			}
		}
		
		// Get all the commands from the visitor
		gridCommands = currentVisitor.getReturnCommands();
		
		// Execute all the commands
		for(LifeCommand command: gridCommands) {
			command.execute();
		}
		
		// Update the observers
		updateObservers();
	}
	
	// Let the observers get the width
	public int getWidth() {
		return(this.width);
	}
	
	// Let the observers get the height
	public int getHeight() {
		return(this.height);
	}
	
	// Let the observers get the columns
	public int getCol() {
		return(this.cols);
	}
	
	// Let the observers get the rows
	public int getRow() {
		return(this.rows);
	}

	// Make a cell alive
	public void makeAlive(int cellLocRow, int cellLocCol) {
		grid[cellLocRow][cellLocCol].live();
		updateObservers();
	}
	
	// Get the state of a cell at a location
	public boolean getLocAlive(int x, int y) {
		return(grid[x][y].isAlive());
	}
	
	// Attach an observer
	public void attach(GameofLifeUI theObserver) {
		this.Observers.add(theObserver);
	}
	
	// Detach an observer
	public void detach(GameofLifeUI theObserver) {
		int removalIndex = this.Observers.indexOf(theObserver);
		this.Observers.remove(removalIndex);
	}
	
	// Update all the observers
	public void updateObservers() {
		for(Observer theObserver: Observers) {
			theObserver.update();
		}
	}

}
