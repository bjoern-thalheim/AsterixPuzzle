package de.bjoernthalheim.asterixpuzzle.starter;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import de.bjoernthalheim.asterixpuzzle.deck.Deck;
import de.bjoernthalheim.asterixpuzzle.deck.DisplayableDeckCreator;
import de.bjoernthalheim.asterixpuzzle.deck.UnorderedDisplayableCardGrid;
import de.bjoernthalheim.asterixpuzzle.grids.DisplayableCardGrid;
import de.bjoernthalheim.asterixpuzzle.grids.ThreeTimesThreeCardGrid;
import de.bjoernthalheim.asterixpuzzle.jfx.SolutionJFXVisualizer;
import de.bjoernthalheim.asterixpuzzle.strategy.BruteForceSolutionFinderImpl;

/**
 * Simple class to start a JavaFX {@link Application} which then starts the recursion algorithm as well as the graphical
 * representation of the result.
 * 
 * @author bjoern
 */
public class BrutForceSolutionFinderImplStarter extends Application {

	private static final int CARD_DISPLAY_WIDTH = 150;

	/**
	 * Start of the JavaFX application as it is shown in the tutorials.
	 * 
	 * @param args
	 *            ignored.
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Recursion start. Take the full deck and an empty grid and pass that into the recursion.
	 * 
	 * @param args
	 *            ignored.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Graphical output
		primaryStage.setTitle("Asterix Puzzle Solution");
		StackPane root = new StackPane();
		Text temporaryText = new Text();
		temporaryText.setText("Calculating Solution");
		root.getChildren().add(temporaryText);
		Scene emptyScene = new Scene(root);
		primaryStage.setScene(emptyScene);
		DisplayableCardGrid nosolution = new UnorderedDisplayableCardGrid(new DisplayableDeckCreator().createNewDeck());
		showSolutionGraphically(primaryStage, nosolution);
		primaryStage.show();
		List<DisplayableCardGrid> solutions = calculatePuzzleResult();
		for (DisplayableCardGrid solution : solutions) {
			showSolutionGraphically(primaryStage, solution);
		}
	}

	public Scene createRootAndScene(DisplayableCardGrid solution) {
		StackPane root = new SolutionJFXVisualizer(solution).getCardsToDisplay();
		// @formatter:off
		Scene scene = new Scene(
				root, 
				SolutionJFXVisualizer.GRID_EDGE_LENGTH * CARD_DISPLAY_WIDTH, 
				SolutionJFXVisualizer.GRID_EDGE_LENGTH * CARD_DISPLAY_WIDTH
		);
		// @formatter:on
		return scene;
	}

	private void showSolutionGraphically(Stage primaryStage, DisplayableCardGrid solution) {
		Scene scene = createRootAndScene(solution);
		primaryStage.setScene(scene);
	}

	private List<DisplayableCardGrid> calculatePuzzleResult() {
		BruteForceSolutionFinderImpl impl = new BruteForceSolutionFinderImpl();
		// init deck, grid and empty solution list.
		Deck deck = new DisplayableDeckCreator().createNewDeck();
		DisplayableCardGrid grid = new ThreeTimesThreeCardGrid();
		List<DisplayableCardGrid> allSolutions = new ArrayList<DisplayableCardGrid>();
		// recursion start.
		impl.findAllSolutions(allSolutions, deck, grid);
		// find really distinct solutions
		List<DisplayableCardGrid> solutions = impl.removeIsomorphicSolutions(allSolutions);
		return solutions;
	}

}
