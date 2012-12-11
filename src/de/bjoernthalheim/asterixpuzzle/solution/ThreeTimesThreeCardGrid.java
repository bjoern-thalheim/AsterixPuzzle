package de.bjoernthalheim.asterixpuzzle.solution;

import java.util.ArrayList;
import java.util.List;

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
		int x = getXPosition(positionCounter);
		int y = getYPosition(positionCounter);
		// Find all four neighbors and check for conflicts.
		if (!conflictsWithNeighbors(y, x, cardAndOrientation)) {
			// if no conflict, add the CardAndOrientation into the grid and return true,.
			this.cardsInGrid[y][x] = cardAndOrientation;
			positionCounter++;
			return true;
		}
		// otherwise, return false
		return false;
	}

	private boolean conflictsWithNeighbors(int y, int x, CardAndOrientation cardAndOrientation) {
		Orientation[] orientations = Orientation.values();
		for (Orientation orientation : orientations) {
			if (conflictWithNeighbor(y, x, cardAndOrientation, orientation)) {
				return true;
			}
		}
		// no conflict found.
		return false;
	}

	private boolean conflictWithNeighbor(int y, int x, CardAndOrientation cardAndOrientation, Orientation orientation) {
		FigureAndHalf other = findNeighbor(y, x, orientation);
		FigureAndHalf self = cardAndOrientation.getEdge(orientation);
		return !self.fits(other);
	}

	private FigureAndHalf findNeighbor(int y, int x, Orientation orientation) {
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
		return this.cardsInGrid[yn][xn].getEdge(orientation.opposite());
	}

	@Override
	public CardGrid defensiveCopy() {
		ThreeTimesThreeCardGrid result = new ThreeTimesThreeCardGrid();
		for (int counter = 0; counter < EDGELENGTH*EDGELENGTH; counter++) {
			int x = getXPosition(counter);
			int y = getYPosition(counter);
			CardAndOrientation cell = cardsInGrid[y][x];
			if (!result.putOntoNextFreePositionSuccessful(cell.getCard(), cell.getOrientation())) {
				throw new RuntimeException(
						"Totally unexpected: yould not put card from a valid grid into a new grid.");
			}
		}
		result.positionCounter = this.positionCounter;
		return result;
	}

	private int getYPosition(int counter) {
		return counter / EDGELENGTH;
	}

	private int getXPosition(int counter) {
		return counter % EDGELENGTH;
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("Position: " + positionCounter + "\n");
		for (CardAndOrientation[] line : this.cardsInGrid) {
			result.append("[");
			for (CardAndOrientation cardAndOrientation : line) {
				result.append(cardAndOrientation + ", ");
			}
			result.append("]\n");
		}
		return result.toString();
	}
	
	@Override
	public boolean isFull() {
		return this.positionCounter == 9;
	}

	@Override
	public List<PositionAndOrientationAndCard> getCards() {
		int positions = EDGELENGTH*EDGELENGTH;
		ArrayList<PositionAndOrientationAndCard> result = new ArrayList<PositionAndOrientationAndCard>(positions);
		for (int i = 0; i < positions; i++) {
			int x = getXPosition(i);
			int y = getYPosition(i);
			CardAndOrientation card = this.cardsInGrid[y][x];
			PositionAndOrientationAndCard item = new PositionAndOrientationAndCard(i, card);
			result.add(item);
		}
		return result;
	}
}
