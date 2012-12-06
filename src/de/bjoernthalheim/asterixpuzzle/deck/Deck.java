package de.bjoernthalheim.asterixpuzzle.deck;

import java.util.List;

public interface Deck {

	public List<Card> getCards();

	public void addCard(Card card1);
}
