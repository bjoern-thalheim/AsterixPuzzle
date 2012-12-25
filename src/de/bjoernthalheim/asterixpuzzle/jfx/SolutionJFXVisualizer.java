package de.bjoernthalheim.asterixpuzzle.jfx;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import de.bjoernthalheim.asterixpuzzle.deck.DisplayableCard;
import de.bjoernthalheim.asterixpuzzle.elements.Orientation;
import de.bjoernthalheim.asterixpuzzle.grids.DisplayableCardGrid;

public class SolutionJFXVisualizer {

	private static final int GRID_EDGE_LENGTH = 3;
	private static final int CARD_DISPLAY_WIDTH = 150;
	private DisplayableCardGrid solution;

	public SolutionJFXVisualizer(DisplayableCardGrid solution) {
		this.solution = solution;
	}

	public Scene createRootAndScene() {
		StackPane root = createRootWithChildren();
		// @formatter:off
		Scene scene = new Scene(
				root, 
				GRID_EDGE_LENGTH * CARD_DISPLAY_WIDTH, 
				GRID_EDGE_LENGTH * CARD_DISPLAY_WIDTH
		);
		// @formatter:on
		return scene;
	}

	private StackPane createRootWithChildren() {
		StackPane root = new StackPane();
		ObservableList<Node> children = root.getChildren();
		VBox box = createBox();
		children.add(box);
		return root;
	}

	private VBox createBox() {
		VBox result = new VBox();
		includeImages(result);
		return result;
	}

	private void includeImages(VBox result) {
		for (int i = 0; i < GRID_EDGE_LENGTH; i++) {
			HBox hBox = new HBox();
			result.getChildren().add(hBox);
			for (int j = 0; j < GRID_EDGE_LENGTH; j++) {
				DisplayableCard card = solution.getCardAt(j, i);
				String imagePath = card.getImagePath();
				Orientation orientation = card.getOrientation();
				hBox.getChildren().add(createImageView(imagePath, calculateRotation(orientation)));
			}
		}
	}

	long calculateRotation(Orientation orientation) {
		switch (orientation) {
		case NORTH:
			return 0;
		case EAST:
			return 90;
		case SOUTH:
			return 180;
		case WEST:
			return 270;
		default:
			return 0;
		}
	}

	private Node createImageView(String imagePath, long rotation) {
		// @formatter:off
		return new ImageViewCreator()
			.setFileName(imagePath)
			.setHeight(150)
			.setRotate(rotation)
			.createImageView();
		// @formatter:on
	}

}
