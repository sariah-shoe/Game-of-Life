package life6visitor;

// Command to kill cells
public class DieCommand extends LifeCommand {
	
	// Public initialization that uses the superclass
	public DieCommand(Cell theCell){
		super(theCell);
	}
	
	// When the command is executed, kill the cell
	public void execute() {
		this.theCell.die();
	}

}
