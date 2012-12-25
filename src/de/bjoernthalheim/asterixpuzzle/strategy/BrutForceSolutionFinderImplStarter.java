package de.bjoernthalheim.asterixpuzzle.strategy;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import de.bjoernthalheim.asterixpuzzle.deck.Deck;
import de.bjoernthalheim.asterixpuzzle.solution.DisplayableCardGrid;
import de.bjoernthalheim.asterixpuzzle.solution.ThreeTimesThreeCardGrid;

/**
 * Simple class to start a JavaFX {@link Application} which then starts the recursion algorithm as well as the graphical
 * representation of the result.
 * 
 * @author bjoern
 */
public class BrutForceSolutionFinderImplStarter extends Application {

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
		List<DisplayableCardGrid> solutions = calculatePuzzleResult();
		// Graphical output
		for (DisplayableCardGrid solution : solutions) {
			showSolutionGraphically(primaryStage, solution);
		}
	}

	private void showSolutionGraphically(Stage primaryStage, DisplayableCardGrid solution) {
		Scene scene = new SolutionJFXVisualizer(solution).createRootAndScene();
		primaryStage.setTitle("Asterix Puzzle Solution");
		primaryStage.setScene(scene);
		primaryStage.show();
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
