package life6visitor;

import java.util.ArrayList;
import java.util.List;

public class Cell {
	// Create the private variables state, neighbors, and number of alive neighbors
	private ConcreteStates state;
	private List<Cell> neighbors;
	private int nbrAliveNeighbors;
	
	// Initialize a dead cell with a list of empty neighbors
	public Cell() {
		state = DeadState.create();
		neighbors = new ArrayList<Cell>();
	}
	
	// Tell the cell to tell the state to live
	public void live() {
		state.live(this);
	}
	
	// Tell the cell to tell the state to die
	public void die() {
		state.die(this);
	}
	
	// Tell the cell to tell the state to check if its alive
	public boolean isAlive() {
		return(state.isAlive(this));
	}
	
	// Tell the cell to change its state variable
	public void setState(ConcreteStates newState) {
		this.state = newState;
	}
	
	// Add neighbors to list
	public void addNeighbor(Cell neighborCell) {
		this.neighbors.add(neighborCell);
		this.nbrAliveNeighbors = this.neighbors.size();
	}
	
	// Sets the number of alive neighbors
	public void setNbrAliveNeighbors(int n) {
		this.nbrAliveNeighbors = n;
	}
	
	// Gets the number of alive neighbors
	public int getNbrAliveNeighbors() {
		return(this.nbrAliveNeighbors);
	}

	// Clear the list of neighbors
	public void clearNeighbors() {
		this.neighbors.clear();
	}
	
	// Accepts a visitor
	public void accept(LifeVisitor visitor) {
		this.state.accept(visitor, this);
	}
}
