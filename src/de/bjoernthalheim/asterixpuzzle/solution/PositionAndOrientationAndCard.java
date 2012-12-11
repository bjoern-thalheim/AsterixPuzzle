package de.bjoernthalheim.asterixpuzzle.solution;

public class PositionAndOrientationAndCard {
	
	final int position;
	
	final CardAndOrientation cardAndOrientation;

	public PositionAndOrientationAndCard(int thePosition, CardAndOrientation theCardAndOrientation) {
		this.cardAndOrientation = theCardAndOrientation;
		this.position = thePosition;
	}

	@Override
	public String toString() {
		return "PositionAndOrientationAndCard [position=" + position + ", cardAndOrientation=" + cardAndOrientation
				+ "]";
	}

	public int getPosition() {
		return position;
	}

	public CardAndOrientation getCardAndOrientation() {
		return cardAndOrientation;
	}
}
