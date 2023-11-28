package life6visitor;

// The main program used to invoke the game of life system.
 
public class Main {

    public static void main(String[] args) {
        // Create an subject of the game with a 20x20 life grid
    	//   shown in a 500x500 window
        GameOfLife theSubject = new GameOfLife(20, 20, 500, 500);
        
        // Create the observer and attach it to the subject
        GameofLifeUI theObserverer = new GameofLifeUI(theSubject, "The Game of Life");
        theSubject.attach(theObserverer);
    }
}

