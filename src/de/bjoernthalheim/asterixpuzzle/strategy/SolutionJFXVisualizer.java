package de.bjoernthalheim.asterixpuzzle.strategy;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import de.bjoernthalheim.asterixpuzzle.deck.Card;
import de.bjoernthalheim.asterixpuzzle.solution.CardGrid;

public class SolutionJFXVisualizer {

	private CardGrid solution;

	public SolutionJFXVisualizer(CardGrid solution) {
		this.solution = solution;
	}

	public Scene createRootAndScene() {
		StackPane root = createRootWithChildren();
		// @formatter:off
		Scene scene = new Scene(
				root, 
				3 * 150, 
				3 * 150
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
		for (int i = 0; i < 3; i++) {
			HBox hBox = new HBox();
			result.getChildren().add(hBox);
			for (int j = 0; j < 3; j++) {
				Card card = solution.getCardAt(j,i);
//				hBox.getChildren().add(createImageView(card.getImagePath()));
			}
		}
	}

}
