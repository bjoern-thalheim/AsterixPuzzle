package de.bjoernthalheim.asterixpuzzle.elements;

/**
 * Enum of all four figures used in the puzzle.
 * 
 * @author bjoern
 */
public enum Figure {

	/**
	 * Normal values.
	 */
	ASTERIX, OBELIX, MIRACULIX, LEGIONAIRE,

	/**
	 * Null value to represent no card.
	 */
	NOTHING;

	/**
	 * To enable shortcut instantiation, this method was created.
	 * 
	 * @param spec
	 *            Spec char, either a, o, m, or l.
	 * @return The corresponding {@link Figure}.
	 */
	public static Figure fromChar(char spec) {
		switch (spec) {
		case 'a':
		case 'A':
			return ASTERIX;
		case 'o':
		case 'O':
			return OBELIX;
		case 'm':
		case 'M':
			return MIRACULIX;
		case 'l':
		case 'L':
			return LEGIONAIRE;

		default:
			throw new RuntimeException("Unknown spec: " + spec);
		}
	}

	public String toShortString() {
		return this.toString().substring(0, 1);
	}
}
