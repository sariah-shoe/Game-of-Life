package life6visitor;

import java.util.ArrayList;
import java.util.List;

// Visitor for various implementations of game of life rules
public abstract class LifeVisitor {
	// Create a list of commands to return
	protected List<LifeCommand> returnCommands;
	
	// Initialize visitor with an empty set of commands
	public LifeVisitor() {
		this.returnCommands = new ArrayList<LifeCommand>();
	}
	
	// Visit a cell and see if it will accept it
	public void visit(Cell cell) {
		cell.accept(this);
	}
	
	// Return the list of return commands
	public List<LifeCommand> getReturnCommands(){
		return(this.returnCommands);
	}
	
	// Abstracts for rules for live and dead cells
	public abstract void visitLiveCell(Cell cell);
	public abstract void visitDeadCell(Cell cell);
	
}
