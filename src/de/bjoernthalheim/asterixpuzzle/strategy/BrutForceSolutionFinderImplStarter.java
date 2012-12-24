package de.bjoernthalheim.asterixpuzzle.strategy;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import de.bjoernthalheim.asterixpuzzle.deck.Deck;
import de.bjoernthalheim.asterixpuzzle.solution.CardGrid;
import de.bjoernthalheim.asterixpuzzle.solution.IndexableCardGrid;
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
		BrutForceSolutionFinderImpl impl = new BrutForceSolutionFinderImpl();
		// init deck, grid and empty solution list.
		Deck deck = new DeckCreator().createNewDeck();
		IndexableCardGrid grid = new ThreeTimesThreeCardGrid();
		List<IndexableCardGrid> allSolutions = new ArrayList<IndexableCardGrid>();
		// recursion start.
		impl.findAllSolutions(allSolutions, deck, grid);
		// find really distinct solutions
		List<IndexableCardGrid> solutions = impl.removeIsomorphicSolutions(allSolutions);
		// Solution presentation.
		System.out.println(solutions.size() + " solutions found: ");
		// As long as we don't have a graphical representation, we need to output this stuff somehow
		for (IndexableCardGrid solution : solutions) {
			System.out.println(solution);
			// JavaFX stuff
			Scene scene = new SolutionJFXVisualizer(solution).createRootAndScene();
			primaryStage.setTitle("Asterix Puzzle Solution");
			primaryStage.setScene(scene);
			primaryStage.show();
		}
	}

}
