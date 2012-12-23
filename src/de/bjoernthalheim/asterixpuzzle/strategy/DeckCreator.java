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
		addCardToDeck(result, "lbatotab"); // 1
		addCardToDeck(result, "lbobatmt"); // 2
		addCardToDeck(result, "lbmtotab"); // 3
		addCardToDeck(result, "atmbobmt"); // 4
		addCardToDeck(result, "oblbmtat"); // 5
		addCardToDeck(result, "mblbatlt"); // 6
		addCardToDeck(result, "obatltmb"); // 7
		addCardToDeck(result, "abobmtlt"); // 8
		addCardToDeck(result, "mtotobab"); // 9
		return result;
	}

	private void addCardToDeck(Deck result, String spec) {
		CardImpl card = new CardImpl(spec);
		result.addCard(card);
	}
}
