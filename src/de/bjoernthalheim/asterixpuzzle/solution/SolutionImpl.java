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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((solutionGrid == null) ? 0 : solutionGrid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SolutionImpl other = (SolutionImpl) obj;
		if (solutionGrid == null) {
			if (other.solutionGrid != null)
				return false;
		} else if (!solutionGrid.equals(other.solutionGrid))
			return false;
		return true;
	}
}
