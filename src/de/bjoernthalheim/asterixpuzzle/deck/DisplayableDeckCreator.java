package de.bjoernthalheim.asterixpuzzle.deck;

import de.bjoernthalheim.asterixpuzzle.deck.Deck;

/**
 * Create the normal puzzle deck.
 * 
 * @author bjoern
 */
public class DisplayableDeckCreator {

	/**
	 * Creates the deck depicted in allCards.jpg.
	 * 
	 * @return The Deck of cards.
	 */
	public Deck createNewDeck() {
		Deck result = new DeckImpl();
		addCardToDeck(result, "lbatotab", "1.jpg"); // 1
		addCardToDeck(result, "lbobatmt", "2.jpg"); // 2
		addCardToDeck(result, "lbmtotab", "3.jpg"); // 3
		addCardToDeck(result, "atmbobmt", "4.jpg"); // 4
		addCardToDeck(result, "oblbmtat", "5.jpg"); // 5
		addCardToDeck(result, "mblbatlt", "6.jpg"); // 6
		addCardToDeck(result, "obatltmb", "7.jpg"); // 7
		addCardToDeck(result, "abobmtlt", "8.jpg"); // 8
		addCardToDeck(result, "mtotobab", "9.jpg"); // 9
		return result;
	}

	private void addCardToDeck(Deck result, String spec, String imageLocation) {
		DisplayableCardImpl card = new DisplayableCardImpl(spec);
		card.setImagePath(imageLocation);
		result.addCard(card);
	}
}
