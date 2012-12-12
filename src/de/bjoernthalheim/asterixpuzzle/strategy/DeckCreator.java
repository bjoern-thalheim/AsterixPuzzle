package de.bjoernthalheim.asterixpuzzle.strategy;

import de.bjoernthalheim.asterixpuzzle.deck.CardImpl;
import de.bjoernthalheim.asterixpuzzle.deck.Deck;
import de.bjoernthalheim.asterixpuzzle.deck.DeckImpl;

/**
 * Create the normal puzzle deck.
 * 
 * @author bjoern
 */
public class DeckCreator {

	/**
	 * Creates the deck depicted in allCards.jpg.
	 * 
	 * @return The Deck of cards.
	 */
	public Deck createNewDeck() {
		Deck result = new DeckImpl();
		addCardToDeck(result, "abmtotob"); // 1
		addCardToDeck(result, "lbatltmb"); // 2
		addCardToDeck(result, "obmtltab"); // 3
		addCardToDeck(result, "obatmtlb"); // 4
		addCardToDeck(result, "lbatotab"); // 5
		addCardToDeck(result, "lbmtotab"); // 6
		addCardToDeck(result, "lbmtatob"); // 7
		addCardToDeck(result, "obmtatmb"); // 8
		addCardToDeck(result, "obatltmb"); // 9
		return result;
	}

	private void addCardToDeck(Deck result, String spec) {
		CardImpl card = new CardImpl(spec);
		result.addCard(card);
	}
}
