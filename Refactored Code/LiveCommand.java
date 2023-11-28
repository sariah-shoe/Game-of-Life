package life6visitor;

//Command to live
public class LiveCommand extends LifeCommand {
	
	// Initializes using super constructor
	public LiveCommand(Cell currentCell) {
		super(currentCell);
	}
	
	// Executes by making the cell live
	public void execute() {
		this.theCell.live();
	}
	
}
