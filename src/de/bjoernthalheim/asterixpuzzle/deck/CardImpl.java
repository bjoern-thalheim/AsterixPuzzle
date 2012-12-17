package de.bjoernthalheim.asterixpuzzle.deck;

import java.util.HashMap;
import java.util.Map;

import de.bjoernthalheim.asterixpuzzle.solution.Orientation;

/**
 * Implementation of a card.
 * 
 * @author bjoern
 */
public class CardImpl implements Card {

	public static final CardImpl NOTHING;

	static {
		NOTHING = new CardImpl();
		NOTHING.edges.put(Orientation.NORTH, FigureAndHalf.NOTHING);
		NOTHING.edges.put(Orientation.EAST, FigureAndHalf.NOTHING);
		NOTHING.edges.put(Orientation.SOUTH, FigureAndHalf.NOTHING);
		NOTHING.edges.put(Orientation.WEST, FigureAndHalf.NOTHING);
	}

	private final Map<Orientation, FigureAndHalf> edges;

	/**
	 * Create a card accoringto the given spec.
	 * 
	 * @param spec
	 *            A spec in the form (Figure/Orientation)^4, e.g. atOBMblT.
	 */
	public CardImpl(String spec) {
		edges = new HashMap<Orientation, FigureAndHalf>();
		String northSideSpec = spec.substring(0, 2);
		String eastSideSpec = spec.substring(2, 4);
		String southSideSpec = spec.substring(4, 6);
		String westSideSpec = spec.substring(6, 8);
		initEdge(northSideSpec, Orientation.NORTH);
		initEdge(eastSideSpec, Orientation.EAST);
		initEdge(southSideSpec, Orientation.SOUTH);
		initEdge(westSideSpec, Orientation.WEST);
	}

	/**
	 * Create a copy of the given card.
	 * 
	 * @param card
	 *            The card which shall be cloned.
	 */
	public CardImpl(Card card) {
		edges = new HashMap<Orientation, FigureAndHalf>();
		Orientation[] orientations = Orientation.values();
		for (Orientation orientation : orientations) {
			edges.put(orientation, card.getEdge(orientation));
		}
	}

	private CardImpl() {
		edges = new HashMap<Orientation, FigureAndHalf>();
	}

	public CardImpl(Card card, Orientation rotation) {
		// create a clone of the given Card with the given Orientation.
		edges = new HashMap<Orientation, FigureAndHalf>();
		Orientation[] orientations = Orientation.values();
		for (Orientation orientation : orientations) {
			edges.put(orientation.plus(rotation), card.getEdge(orientation));
		}
	}

	/**
	 * Init the edge according to the given String.
	 * 
	 * @param spec
	 *            The spec containing two chars for Figure/Half.
	 * @param orientation
	 *            The side of the card where the given figure and half shall be in.
	 */
	private void initEdge(String spec, Orientation orientation) {
		Figure figure = Figure.fromChar(spec.charAt(0));
		Half half = Half.fromChar(spec.charAt(1));
		FigureAndHalf figureAndHalf = new FigureAndHalf(figure, half);
		edges.put(orientation, figureAndHalf);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.bjoernthalheim.asterixpuzzle.deck.Card#getEdge(de.bjoernthalheim.asterixpuzzle.solution.Orientation)
	 */
	@Override
	public FigureAndHalf getEdge(Orientation orientation) {
		return this.edges.get(orientation);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		for (Orientation orientation : Orientation.values()) {
			FigureAndHalf edge = this.getEdge(orientation);
			result.append(edge.toShortString());
		}
		return result.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edges == null) ? 0 : edges.hashCode());
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
		CardImpl other = (CardImpl) obj;
		if (edges == null) {
			if (other.edges != null)
				return false;
		} else if (!edges.equals(other.edges))
			return false;
		return true;
	}

}
