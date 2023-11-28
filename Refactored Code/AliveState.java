package life6visitor;

//Alive state
public class AliveState implements ConcreteStates {
	// Initialize private variables, most importantly the instance
	private static ConcreteStates instance;
	private boolean isAlive;
	
	// Private initialization it with a true value because its an alive state
	private AliveState() {
		this.isAlive = true;
	}

	// Singleton create method
	public static ConcreteStates create() {
		// If there isn't an instance create one
		if(instance == null) {
			instance = new AliveState();
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
		// Accept a visitor to the cell I'm dealing with
		visitor.visitLiveCell(cell);
	}
	
	
	
}
