package life6visitor;

import java.util.ArrayList;
import java.util.List;

// A standard set of rules for a visitor
public class StandardLifeVisitor extends LifeVisitor {

	// When a live cell is visited, do that logic and add the command to the list
	@Override
	public void visitLiveCell(Cell cell) {
		int n = cell.getNbrAliveNeighbors();
		if (n == 2 || n == 3) {
			returnCommands.add(new LiveCommand(cell));
		} else {
			returnCommands.add(new DieCommand(cell));
		}
	}

	// When a dead cell is visited, do that logic and add the command to the list
	@Override
	public void visitDeadCell(Cell cell) {
		int n = cell.getNbrAliveNeighbors();
		
		if (n == 3) {
			returnCommands.add(new LiveCommand(cell));
		} else {
			returnCommands.add(new DieCommand(cell));
		}
	}
	
	

}
