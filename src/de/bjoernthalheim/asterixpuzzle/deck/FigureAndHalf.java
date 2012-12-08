package de.bjoernthalheim.asterixpuzzle.deck;

import java.io.Serializable;

/**
 * Compound enum representing the edge of a card.
 * 
 * @author bjoern
 */
public class FigureAndHalf implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final FigureAndHalf NOTHING = new FigureAndHalf(Figure.NOTHING, Half.NOTHING);

	private final Figure figure;
	private final Half half;

	public FigureAndHalf(Figure theFigure, Half theHalf) {
		this.figure = theFigure;
		this.half = theHalf;
	}

	public Figure getFigure() {
		return this.figure;
	}

	public Half getHalf() {
		return this.half;
	}

	/**
	 * Check whether this {@link FigureAndHalf} fits onto the {@link FigureAndHalf} given.
	 * 
	 * @param other
	 *            The Neighbor.
	 * @return <code>true</code> if these two {@link FigureAndHalf} can be fitted this way.
	 */
	public boolean fits(FigureAndHalf other) {
		if (isNothing(this) || isNothing(other)) {
			return true;
		}
		boolean differentHalf = !this.getHalf().equals(other.getHalf());
		boolean sameFigure = this.getFigure().equals(other.getFigure());
		return sameFigure && differentHalf;
	}

	private boolean isNothing(FigureAndHalf figureAndHalf) {
		return FigureAndHalf.NOTHING.equals(figureAndHalf);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((figure == null) ? 0 : figure.hashCode());
		result = prime * result + ((half == null) ? 0 : half.hashCode());
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
		FigureAndHalf other = (FigureAndHalf) obj;
		if (figure != other.figure)
			return false;
		if (half != other.half)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FigureAndHalf [figure=" + figure + ", half=" + half + "]";
	}
}
