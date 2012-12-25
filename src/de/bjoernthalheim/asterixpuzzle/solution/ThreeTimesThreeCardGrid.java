package de.bjoernthalheim.asterixpuzzle.solution;

import java.util.Arrays;
import java.util.List;

import de.bjoernthalheim.asterixpuzzle.deck.BlankCard;
import de.bjoernthalheim.asterixpuzzle.deck.Card;
import de.bjoernthalheim.asterixpuzzle.deck.FigureAndHalf;
import de.bjoernthalheim.asterixpuzzle.strategy.DisplayableCard;

/**
 * A Grid consisting of three times three cards.
 * 
 * @author bjoern
 */
public class ThreeTimesThreeCardGrid implements DisplayableCardGrid {

	private static final int EDGELENGTH = 3;

	private DisplayableCard[][] cardsInGrid;

	private int positionCounter;

	public ThreeTimesThreeCardGrid() {
		positionCounter = 0;
		this.cardsInGrid = new DisplayableCard[EDGELENGTH][EDGELENGTH];
		for (int i = 0; i < cardsInGrid.length; i++) {
			Card[] line = cardsInGrid[i];
			for (int j = 0; j < line.length; j++) {
				line[j] = new BlankCard();
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
	public <T extends Card> boolean putOntoNextFreePositionSuccessful(T card, Orientation orientation) {
		// use div/mod positioncounter to determine next field.
		DisplayableCard Card = new DisplayableCardImpl(card, orientation);
		int x = getXPosition(positionCounter);
		int y = getYPosition(positionCounter);
		// Find all four neighbors and check for conflicts.
		if (!conflictsWithNeighbors(y, x, Card)) {
			// if no conflict, add the Card into the grid and return true,.
			this.cardsInGrid[y][x] = Card;
			positionCounter++;
			return true;
		}
		// otherwise, return false
		return false;
	}

	private boolean conflictsWithNeighbors(int y, int x, Card Card) {
		Orientation[] orientations = Orientation.values();
		for (Orientation orientation : orientations) {
			if (conflictWithNeighbor(y, x, Card, orientation)) {
				return true;
			}
		}
		// no conflict found.
		return false;
	}

	private boolean conflictWithNeighbor(int y, int x, Card Card, Orientation orientation) {
		FigureAndHalf other = findNeighbor(y, x, orientation);
		FigureAndHalf self = Card.getEdge(orientation);
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

	private Card getCardInIndex(int counter) {
		int x = getXPosition(counter);
		int y = getYPosition(counter);
		Card cell = cardsInGrid[y][x];
		return cell;
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
		for (Card[] line : this.cardsInGrid) {
			result.append("[");
			for (Card Card : line) {
				result.append(Card + ", ");
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
	public boolean isIsomorphic(CardGrid otherGrid) {
		for (Orientation orientation : Orientation.values()) {
			ThreeTimesThreeCardGrid rotatedGrid = this.rotate(orientation);
			if (rotatedGrid.equals(otherGrid)) {
				return true;
			}
		}
		return false;
	}

	private ThreeTimesThreeCardGrid rotate(Orientation orientation) {
		ThreeTimesThreeCardGrid result = new ThreeTimesThreeCardGrid();
		List<Integer> rotationMatrix = createRotationMatrix(orientation);
		for (Integer integer : rotationMatrix) {
			Card originalCard = this.getCardInIndex(integer);
			result.putOntoNextFreePositionSuccessful(originalCard, orientation);
		}
		return result;
	}

	List<Integer> createRotationMatrix(Orientation orientation) {
		switch (orientation) {
		case NORTH:
			// 0 1 2
			// 3 4 5
			// 6 7 8
			return Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8);
		case EAST:
			// 6 3 0
			// 7 4 1
			// 8 5 2
			return Arrays.asList(6, 3, 0, 7, 4, 1, 8, 5, 2);
		case SOUTH:
			// 8 7 6
			// 5 4 3
			// 2 1 0
			return Arrays.asList(8, 7, 6, 5, 4, 3, 2, 1, 0);
		case WEST:
			// 2 5 8
			// 1 4 7
			// 0 3 6
			return Arrays.asList(2, 5, 8, 1, 4, 7, 0, 3, 6);
		}
		throw new RuntimeException(orientation + " has not been anticipated here.");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(cardsInGrid);
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
		ThreeTimesThreeCardGrid other = (ThreeTimesThreeCardGrid) obj;
		for (int i = 0; i < EDGELENGTH; i++) {
			for (int j = 0; j < EDGELENGTH; j++) {
				DisplayableCard myCard = this.cardsInGrid[j][i];
				DisplayableCard otherCard = other.cardsInGrid[j][i];
				if (!myCard.equals(otherCard)) {
					return false;
				}
			}
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.bjoernthalheim.asterixpuzzle.solution.CardGrid#getCardAt(int, int)
	 */
	@Override
	public DisplayableCard getCardAt(int x, int y) {
		return this.cardsInGrid[y][x];
	}

	@SuppressWarnings("unchecked")
	@Override
	public DisplayableCardGrid defensiveCopy() {
		ThreeTimesThreeCardGrid result = new ThreeTimesThreeCardGrid();
		for (int counter = 0; counter < EDGELENGTH * EDGELENGTH; counter++) {
			Card cell = getCardInIndex(counter);
			if (!result.putOntoNextFreePositionSuccessful(cell, Orientation.NORTH)) {
				// This is a sanity check and cannot happen, unless some error is somewhere else.
				throw new RuntimeException("Totally unexpected: yould not put card from a valid grid into a new grid.");
			}
		}
		result.positionCounter = this.positionCounter;
		return result;
	}
}
