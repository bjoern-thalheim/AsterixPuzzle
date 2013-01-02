package de.bjoernthalheim.asterixpuzzle.deck;

import de.bjoernthalheim.asterixpuzzle.elements.Orientation;
import de.bjoernthalheim.asterixpuzzle.grids.CardGrid;
import de.bjoernthalheim.asterixpuzzle.grids.DisplayableCardGrid;

public class UnorderedDisplayableCardGrid implements DisplayableCardGrid {

	private Deck deck;

	public UnorderedDisplayableCardGrid(Deck createNewDeck) {
		this.deck = createNewDeck;
	}

	@Override
	public <T extends Card> boolean putOntoNextFreePositionSuccessful(T card, Orientation orientation) {
		throw new IllegalStateException("On this objct, this call is not possible");
	}

	@Override
	public <T extends CardGrid> T defensiveCopy() {
		throw new IllegalStateException("On this objct, this call is not possible");
	}

	@Override
	public boolean isFull() {
		throw new IllegalStateException("On this objct, this call is not possible");
	}

	@Override
	public boolean isIsomorphic(CardGrid otherGrid) {
		throw new IllegalStateException("On this objct, this call is not possible");
	}

	@Override
	public DisplayableCard getCardAt(int x, int y) {
		return (DisplayableCard) deck.getCards().get(x);
	}

}
