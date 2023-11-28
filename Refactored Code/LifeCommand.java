package life6visitor;

//Abstract for command implementation
public abstract class LifeCommand {
	// Private variable for the cell it is controlling
	protected Cell theCell;
	
	// Initialize the class
	public LifeCommand(Cell newCell) {
		this.theCell = newCell;
	}
	
	// Abstract for execution
	public abstract void execute();
}
