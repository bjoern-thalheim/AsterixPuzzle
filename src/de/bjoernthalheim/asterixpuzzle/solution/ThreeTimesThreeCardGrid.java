package de.bjoernthalheim.asterixpuzzle.solution;

import de.bjoernthalheim.asterixpuzzle.deck.Card;
import de.bjoernthalheim.asterixpuzzle.deck.FigureAndHalf;

/**
 * A Grid consisting of three times three cards.
 * 
 * @author bjoern
 */
public class ThreeTimesThreeCardGrid implements CardGrid {

	private static final int EDGELENGTH = 3;

	private CardAndOrientation[][] cardsInGrid;

	private int positionCounter;

	public ThreeTimesThreeCardGrid() {
		positionCounter = 0;
		this.cardsInGrid = new CardAndOrientation[EDGELENGTH][EDGELENGTH];
		for (int i = 0; i < cardsInGrid.length; i++) {
			CardAndOrientation[] line = cardsInGrid[i];
			for (int j = 0; j < line.length; j++) {
				line[j] = CardAndOrientation.NOTHING;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.bjoernthalheim.asterixpuzzle.solution.CardGrid#put(de.bjoernthalheim.asterixpuzzle.deck.Card,
	 * de.bjoernthalheim.asterixpuzzle.solution.Orientation)
	 */
	@Override
	public boolean putOntoNextFreePositionSuccessful(Card card, Orientation orientation) {
		// use div/mod positioncounter to determine next field.
		CardAndOrientation cardAndOrientation = new CardAndOrientation(card, orientation);
		int x = positionCounter % EDGELENGTH;
		int y = positionCounter / EDGELENGTH;
		// Find all four neighbors and check for conflicts.
		if (!conflictsWithNeighbors(x, y, cardAndOrientation)) {
			// if no conflict, add the CardAndOrientation into the grid and return true,.
			this.cardsInGrid[x][y] = cardAndOrientation;
			positionCounter++;
			return true;
		}
		// otherwise, return false
		return false;
	}

	private boolean conflictsWithNeighbors(int x, int y, CardAndOrientation cardAndOrientation) {
		Orientation[] orientations = Orientation.values();
		for (Orientation orientation : orientations) {
			if (conflictWithNeighbor(x, y, cardAndOrientation, orientation)) {
				return true;
			}
		}
		// no conflict found.
		return false;
	}

	private boolean conflictWithNeighbor(int x, int y, CardAndOrientation cardAndOrientation, Orientation orientation) {
		FigureAndHalf other = findNeighbor(x, y, orientation);
		FigureAndHalf self = cardAndOrientation.getEdge(orientation);
		return !self.fits(other);
	}

	private FigureAndHalf findNeighbor(int x, int y, Orientation orientation) {
		int xn = x;
		int yn = y;
		switch (orientation) {
		case NORTH:
			yn--;
			break;
		case EAST:
			xn++;
			break;
		case SOUTH:
			yn++;
			break;
		case WEST:
			xn--;
			break;
		default:
			throw new IllegalArgumentException();
		}
		if (xn < 0 || xn >= EDGELENGTH) {
			return FigureAndHalf.NOTHING;
		}
		if (yn < 0 || yn >= EDGELENGTH) {
			return FigureAndHalf.NOTHING;
		}
		return this.cardsInGrid[xn][yn].getEdge(orientation.opposite());
	}

}
