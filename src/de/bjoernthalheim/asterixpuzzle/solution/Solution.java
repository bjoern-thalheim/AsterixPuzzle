package de.bjoernthalheim.asterixpuzzle.solution;

import java.util.List;

/**
 * If you have an empty deck and a conflict-free grid, this would be a solution.
 * Here, we take that grid configuration and translate it into the solution form.
 * 
 * @author bjoern
 */
public interface Solution {

	public List<PositionAndOrientationAndCard> getItems();
}
