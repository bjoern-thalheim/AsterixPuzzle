package de.bjoernthalheim.asterixpuzzle.deck;

import java.util.HashMap;
import java.util.Map;

import de.bjoernthalheim.asterixpuzzle.solution.Orientation;

public class CardImpl implements Card {
	
	Map<Orientation, FigureAndHalf> edges;

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
	 * Init the edge according to the given String.
	 * 
	 * @param spec The spec containing two chars for Figure/Half.
	 * @param orientation The side of the card where the given figure and half shall be in.
	 */
	private void initEdge(String spec, Orientation orientation) {
		Figure figure = Figure.fromChar(spec.charAt(0));
		Half half = Half.fromChar(spec.charAt(1));
		FigureAndHalf figureAndHalf = new FigureAndHalf(figure, half);
		edges.put(orientation , figureAndHalf);
	}

	@Override
	public FigureAndHalf getEdge(Orientation orientation) {
		return this.edges.get(orientation);
	}

}
