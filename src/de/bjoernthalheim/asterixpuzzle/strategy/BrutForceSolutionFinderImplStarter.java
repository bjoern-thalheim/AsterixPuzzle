package de.bjoernthalheim.asterixpuzzle.strategy;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import de.bjoernthalheim.asterixpuzzle.deck.Deck;
import de.bjoernthalheim.asterixpuzzle.solution.DisplayableCardGrid;
import de.bjoernthalheim.asterixpuzzle.solution.ThreeTimesThreeCardGrid;

public class BrutForceSolutionFinderImplStarter extends Application {

	/**
	 * Recursion start. Take the full deck and an empty grid and pass that into the recursion.
	 * 
	 * @param args
	 *            ignored.
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BruteForceSolutionFinderImpl impl = new BruteForceSolutionFinderImpl();
		// init deck, grid and empty solution list.
		Deck deck = new DeckCreator().createNewDeck();
		DisplayableCardGrid grid = new ThreeTimesThreeCardGrid();
		List<DisplayableCardGrid> allSolutions = new ArrayList<DisplayableCardGrid>();
		// recursion start.
		impl.findAllSolutions(allSolutions, deck, grid);
		// find really distinct solutions
		List<DisplayableCardGrid> solutions = impl.removeIsomorphicSolutions(allSolutions);
		// Solution presentation.
		System.out.println(solutions.size() + " solutions found: ");
		// As long as we don't have a graphical representation, we need to output this stuff somehow
		for (DisplayableCardGrid solution : solutions) {
			System.out.println(solution);
			// JavaFX stuff
			Scene scene = new SolutionJFXVisualizer(solution).createRootAndScene();
			primaryStage.setTitle("Asterix Puzzle Solution");
			primaryStage.setScene(scene);
			primaryStage.show();
		}
	}

}
