package de.bjoernthalheim.asterixpuzzle.solution;

/**
 * @author bjoern
 */
public class SolutionImpl implements Solution {

	private CardGrid solutionCopy;

	public SolutionImpl(CardGrid grid) {
		solutionCopy = grid.defensiveCopy();
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		for (PositionAndOrientationAndCard item : solutionCopy.getCards()) {
			result.append(item.getPosition() + ": " + item.getCardAndOrientation().toString() + ", ");
		}
		return result.toString();
	}
}
