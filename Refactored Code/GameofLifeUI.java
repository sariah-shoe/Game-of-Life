package life6visitor;

import java.awt.Color;

import edu.du.dudraw.Draw;
import edu.du.dudraw.DrawListener;

public class GameofLifeUI extends Observer implements DrawListener {
	private Draw window;
	
	public GameofLifeUI(GameOfLife subject, String title) {
		super(subject);
		
		// Setup the DuDraw board
		window = new Draw(title);
		window.setCanvasSize(theSubject.getWidth(), theSubject.getHeight());
		window.setXscale(0, theSubject.getWidth());
		window.setYscale(0, theSubject.getHeight());

		// Add the mouse/key listeners
		window.addListener(this);

		// Draw the initial board
		update();
	}
	
	private void drawGrid() {

		window.setPenColor(Color.black);

		int cellWidth = this.theSubject.getWidth() / this.theSubject.getCol();
		int cellHeight = this.theSubject.getHeight() / this.theSubject.getRow();

		for (int i = 0; i <= this.theSubject.getRow(); i++) {
			window.line(0, i * cellHeight, this.theSubject.getWidth(), i * cellHeight);
		}

		for (int i = 0; i <= this.theSubject.getCol(); i++) {
			window.line(i * cellWidth, 0, i * cellWidth, this.theSubject.getHeight());
		}
	}

	private void drawLives() {
		int cellWidth = this.theSubject.getWidth() / this.theSubject.getCol();
		int cellHeight = this.theSubject.getHeight() / this.theSubject.getRow();

		window.setPenColor(Color.red);
		for (int i = 0; i < this.theSubject.getRow(); i++) {
			for (int j = 0; j < this.theSubject.getCol(); j++) {
				if (this.theSubject.getLocAlive(i, j)) {
					// This is the center and half width/height
					window.filledRectangle((j * cellWidth)+(cellWidth/2), (i * cellHeight)+(cellHeight/2), cellWidth/2, cellHeight/2);
				}
			}
		}
	}
	
	// Below are the mouse/key listeners

	@Override
	public void keyPressed(int key) {
		// This is the advance button
		// Only advance for spacebar (ascii 32)
		if (key==32) {
			this.theSubject.advance();
		}
	}

	@Override
	public void keyReleased(int key) {
		// Do nothing
	}

	@Override
	public void keyTyped(char key) {
		// Do nothing
	}

	@Override
	public void mouseClicked(double arg0, double arg1) {
		// Do nothing
	}

	@Override
	public void mouseDragged(double x, double y) {
		// Do nothing
	}

	@Override
	public void mousePressed(double x, double y) {
		// This is the toggle of grid locations
		int cellWidth = theSubject.getWidth() / theSubject.getCol();
		int cellHeight = theSubject.getHeight() / theSubject.getRow();

		int cellLocRow = (int)(y / cellHeight);
		int cellLocCol = (int)(x / cellWidth);

		this.theSubject.makeAlive(cellLocRow, cellLocCol);      
	}

	@Override
	public void mouseReleased(double x, double y) {
		// Do nothing
	}

	@Override
	public void update() {
		// Redraw the entire board
		window.clear(Color.white);  // Clear in white
		drawGrid();
		drawLives();
	}


}
