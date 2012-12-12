package de.bjoernthalheim.asterixpuzzle.solution;

/**
 * A solution is merely a full grid.
 * 
 * @author bjoern
 */
public class SolutionImpl implements Solution {

	private CardGrid solutionGrid;

	public SolutionImpl(CardGrid grid) {
		solutionGrid = grid;
	}

	@Override
	public String toString() {
		return solutionGrid.toString();
	}
}
