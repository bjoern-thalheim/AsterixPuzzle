package de.bjoernthalheim.asterixpuzzle.strategy;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.bjoernthalheim.asterixpuzzle.deck.Card;
import de.bjoernthalheim.asterixpuzzle.deck.CardImpl;
import de.bjoernthalheim.asterixpuzzle.deck.Deck;
import de.bjoernthalheim.asterixpuzzle.deck.DeckImpl;
import de.bjoernthalheim.asterixpuzzle.deck.FigureAndHalf;
import de.bjoernthalheim.asterixpuzzle.solution.CardGrid;
import de.bjoernthalheim.asterixpuzzle.solution.Orientation;

public class BrutForceSolutionFinderImplTest {

	public class Test2By1Grid implements CardGrid {

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

		private BrutForceSolutionFinderImplTest getOuterType() {
			return BrutForceSolutionFinderImplTest.this;
		}

		@Override
		public boolean isIsomorphic(CardGrid otherGrid) {
			return equals(otherGrid) || mirrorEquals((Test2By1Grid) otherGrid);
		}

		private boolean mirrorEquals(Test2By1Grid otherGrid) {
			for (Orientation orientation : Orientation.values()) {
				FigureAndHalf myFirstCardEdge = firstCard.getEdge(orientation);
				FigureAndHalf otherFirstCardOppositeEdge = otherGrid.firstCard.getEdge(orientation.opposite());
				FigureAndHalf mySecondCardEdge = secondCard.getEdge(orientation);
				FigureAndHalf otherSecondCardOppositeEdge = otherGrid.secondCard.getEdge(orientation.opposite());
				if (!myFirstCardEdge.equals(otherFirstCardOppositeEdge)) {
					return false;
				}
				if (!mySecondCardEdge.equals(otherSecondCardOppositeEdge)) {
					return false;
				}
			}
			return true;
		}

		@SuppressWarnings("unchecked")
		@Override
		public CardGrid defensiveCopy() {
			CardGrid result = new Test2By1Grid();
			if (null != firstCard)
				result.putOntoNextFreePositionSuccessful(firstCard, Orientation.NORTH);
			if (null != secondCard)
				result.putOntoNextFreePositionSuccessful(secondCard, Orientation.NORTH);
			return result;
		}
	}

	/**
	 * Class under Test.
	 */
	private BrutForceSolutionFinderImpl strategy;

	@Before
	public void setup() {
		this.strategy = new BrutForceSolutionFinderImpl();
	}

	@Test
	public void testFindAllSolutionsVerySimple() {
		CardGrid grid = new Test2By1Grid();
		Deck deck = new DeckImpl();
		deck.addCard(new CardImpl("atatatat"));
		deck.addCard(new CardImpl("abababab"));
		List<CardGrid> solutions = new ArrayList<CardGrid>(1);
		strategy.findAllSolutions(solutions, deck, grid);
		solutions = strategy.removeIsomorphicSolutions(solutions);
		// cards fit 2(first/second Position)*4x4(per position two times all orientations) times, as long as isomorphic
		// solutions are not filtered out.
		assertEquals(grid.toString(), 2, solutions.size());
	}

	@Test
	public void testFindAllSolutionsNotSoSimple() {
		CardGrid grid = new Test2By1Grid();
		Deck deck = new DeckImpl();
		deck.addCard(new CardImpl("atmtmtmt"));
		deck.addCard(new CardImpl("abmtmtmt"));
		List<CardGrid> solutions = new ArrayList<CardGrid>(1);
		strategy.findAllSolutions(solutions, deck, grid);
		solutions = strategy.removeIsomorphicSolutions(solutions);
		assertEquals(solutions.toString(), 2, solutions.size());
	}
}