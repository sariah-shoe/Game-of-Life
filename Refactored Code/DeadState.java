package life6visitor;

public class DeadState implements ConcreteStates {
	// Private variable for instance and isAlive
	private static ConcreteStates instance;
	private boolean isAlive;
	
	// Private initialization it with a false value because its an dead state
	private DeadState() {
		this.isAlive = false;
	}
	
	// Singleton create method
	public static ConcreteStates create() {
		// If there isn't an instance create one
		if(instance == null) {
			instance = new DeadState();
		}
		// Return the one instance of alive state
		return(instance);
	}
	
	@Override
	public void live(Cell cell) {
		// In order to live, set the cell to an alive state
		cell.setState(AliveState.create());
	}

	@Override
	public void die(Cell cell) {
		// In order to die, set the cell to a dead state
		cell.setState(DeadState.create());
	}

	@Override
	public boolean isAlive(Cell cell) {
		// Return whether or not the cell is alive
		return(isAlive);
	}

	@Override
	public void accept(LifeVisitor visitor, Cell cell) {
		// Accept a visitor for a cell
		visitor.visitDeadCell(cell);
	}
	

}
