package de.bjoernthalheim.asterixpuzzle.elements;

/**
 * Enum with all four geographic directions. Is used to characterize the rotation of a card.
 * 
 * @author bjoern
 */
public enum Orientation {

	NORTH, EAST, SOUTH, WEST;

	public Orientation opposite() {
		return plus(SOUTH);
	}

	public Orientation plus(Orientation rotation) {
		Orientation[] values = Orientation.values();
		int length = values.length;
		int myOrdinal = this.ordinal();
		int rotationOrdinal = rotation.ordinal();
		int sum = (myOrdinal + rotationOrdinal) % length;
		Orientation result = values[sum];
		return result;
	}
}
