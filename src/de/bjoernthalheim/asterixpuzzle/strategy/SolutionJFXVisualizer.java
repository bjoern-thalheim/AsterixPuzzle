package de.bjoernthalheim.asterixpuzzle.strategy;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import de.bjoernthalheim.asterixpuzzle.deck.Card;
import de.bjoernthalheim.asterixpuzzle.solution.CardGrid;
import de.bjoernthalheim.asterixpuzzle.solution.IndexableCardGrid;

public class SolutionJFXVisualizer {

	private static final int GRID_EDGE_LENGTH = 3;
	private static final int CARD_DISPLAY_WIDTH = 150;
	private IndexableCardGrid solution;

	public SolutionJFXVisualizer(IndexableCardGrid solution) {
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
				Card card = solution.getCardAt(j, i);
				// hBox.getChildren().add(createImageView(card.getImagePath()));
			}
		}
	}

}
