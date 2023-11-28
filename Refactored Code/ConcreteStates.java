package life6visitor;

//Interface for concrete states
public interface ConcreteStates {
	// Each state has to be able to live, die, check if its alive, and accept a visitor from a cell
	void live(Cell cell);
	void die(Cell cell);
	boolean isAlive(Cell cell);
	void accept(LifeVisitor visitor, Cell cell);
}
