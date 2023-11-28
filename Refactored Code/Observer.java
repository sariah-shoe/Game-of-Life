package life6visitor;

// Observer abstract class
public abstract class Observer {
	// Protected instance variable the subject
	protected GameOfLife theSubject;

	// Initialize the subject with the observer
	public Observer(GameOfLife subject){
		this.theSubject = subject;
	}
	
	// Update the observer
	public abstract void update();
}
