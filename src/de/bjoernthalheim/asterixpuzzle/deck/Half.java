package de.bjoernthalheim.asterixpuzzle.deck;

/**
 * One side of a card shows either a bottom or a top half of a figure.
 * 
 * @author bjoern
 */
public enum Half {
	
	TOP, BOTTOM;


	/**
	 * To enable shortcut instantiation, this method was created.
	 * 
	 * @param spec
	 *            Spec char, either b, or t.
	 * @return The corresponding {@link Half}.
	 */
	public static Half fromChar(char spec) {
		switch (spec) {
		case 't':
		case 'T':
			return TOP;
		case 'b':
		case 'B':
			return BOTTOM;
		default:
			throw new RuntimeException("Unknown spec: " + spec);
		}
	}
}
