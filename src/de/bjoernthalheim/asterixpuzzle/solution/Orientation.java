package de.bjoernthalheim.asterixpuzzle.solution;

/**
 * Enum with all four geographic directions. 
 * Is used to characterize the rotation of a card.
 * 
 * @author bjoern
 */
public enum Orientation {

	NORTH, EAST, SOUTH, WEST;

	public Orientation rotate(Orientation rotation) {
		Orientation[] values = Orientation.values();
		int length = values.length;
		int myOrdinal = this.ordinal();
		int rotationOrdinal = rotation.ordinal();
		int sum = (length+myOrdinal-rotationOrdinal)%length;
		Orientation result = values[sum];
		return result;
	}
}
