package de.bjoernthalheim.asterixpuzzle.strategy;

import de.bjoernthalheim.asterixpuzzle.deck.Card;
import de.bjoernthalheim.asterixpuzzle.deck.CardImpl;
import de.bjoernthalheim.asterixpuzzle.deck.FigureAndHalf;
import de.bjoernthalheim.asterixpuzzle.solution.CardGrid;
import de.bjoernthalheim.asterixpuzzle.solution.Orientation;

public class Test2By1Grid implements CardGrid {

	/**
	 * 
	 */
	private final BruteForceSolutionFinderImplTest bruteForceSolutionFinderImplTest;

	/**
	 * @param bruteForceSolutionFinderImplTest
	 */
	Test2By1Grid(BruteForceSolutionFinderImplTest bruteForceSolutionFinderImplTest) {
		this.bruteForceSolutionFinderImplTest = bruteForceSolutionFinderImplTest;
	}

	private int counter = 0;

	private Card firstCard, secondCard;

	@Override
	public boolean putOntoNextFreePositionSuccessful(Card card, Orientation orientation) {
		Card cardAndOrientationToInsert = new CardImpl(card, orientation);
		if (this.counter == 0) {
			counter++;
			this.firstCard = cardAndOrientationToInsert;
			return true;
		}
		this.secondCard = cardAndOrientationToInsert;
		FigureAndHalf left = firstCard.getEdge(Orientation.EAST);
		FigureAndHalf right = secondCard.getEdge(Orientation.WEST);
		return left.fits(right);
	}

	@Override
	public boolean isFull() {
		return secondCard != null;
	}

	@Override
	public String toString() {
		String firstPart = firstCard == null ? "" : firstCard.toString();
		String secondPart = secondCard == null ? "" : ", " + secondCard.toString();
		return firstPart + secondPart;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getOuterType().hashCode();
		result = prime * result + ((firstCard == null) ? 0 : firstCard.hashCode());
		result = prime * result + ((secondCard == null) ? 0 : secondCard.hashCode());
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
		Test2By1Grid other = (Test2By1Grid) obj;
		if (!getOuterType().equals(other.getOuterType()))
			return false;
		if (firstCard == null) {
			if (other.firstCard != null)
				return false;
		} else if (!firstCard.equals(other.firstCard))
			return false;
		if (secondCard == null) {
			if (other.secondCard != null)
				return false;
		} else if (!secondCard.equals(other.secondCard))
			return false;
		return true;
	}

	private BruteForceSolutionFinderImplTest getOuterType() {
		return this.bruteForceSolutionFinderImplTest;
	}

	@Override
	public boolean isIsomorphic(CardGrid otherGrid) {
		return equals(otherGrid) || mirrorEquals((Test2By1Grid) otherGrid);
	}

	private boolean mirrorEquals(Test2By1Grid otherGrid) {
		Test2By1Grid rotatedCloneOfMyself = mirrorCopy();
		return otherGrid.equals(rotatedCloneOfMyself);
	}

	/**
	 * Create a mirrored copy of myself.
	 * 
	 * @return Exactly this Grid, only turned around once.
	 */
	private Test2By1Grid mirrorCopy() {
		Test2By1Grid rotatedCloneOfMyself = new Test2By1Grid(getOuterType());
		rotatedCloneOfMyself.putOntoNextFreePositionSuccessful(this.secondCard, Orientation.SOUTH);
		rotatedCloneOfMyself.putOntoNextFreePositionSuccessful(this.firstCard, Orientation.SOUTH);
		return rotatedCloneOfMyself;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CardGrid defensiveCopy() {
		CardGrid result = new Test2By1Grid(this.bruteForceSolutionFinderImplTest);
		if (null != firstCard)
			result.putOntoNextFreePositionSuccessful(firstCard, Orientation.NORTH);
		if (null != secondCard)
			result.putOntoNextFreePositionSuccessful(secondCard, Orientation.NORTH);
		return result;
	}
}