package de.bjoernthalheim.asterixpuzzle.starter;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
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

	private static final int GAP_WIDTH = 100;
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
		HBox hbox = new HBox();
		addNoSolutionGridToHBox(hbox);
		List<DisplayableCardGrid> solutions = calculatePuzzleResult();
		createAndShowScene(primaryStage, hbox, solutions.size());
		for (DisplayableCardGrid solution : solutions) {
			Node solutionRoot = createRootAndScene(solution);
			addToChildren(hbox, createGap());
			addToChildren(hbox, solutionRoot);
		}
	}

	private Node createGap() {
		return new Rectangle(GAP_WIDTH, CARD_DISPLAY_WIDTH * SolutionJFXVisualizer.GRID_EDGE_LENGTH);
	}

	private void addToChildren(HBox hbox, Node solutionRoot) {
		hbox.getChildren().add(solutionRoot);
	}

	private void addNoSolutionGridToHBox(HBox hbox) {
		DisplayableCardGrid nosolution = new UnorderedDisplayableCardGrid(new DisplayableDeckCreator().createNewDeck());
		StackPane noSolutionRoot = createRootAndScene(nosolution);
		addToChildren(hbox, noSolutionRoot);
	}

	private void createAndShowScene(Stage primaryStage, HBox hbox, int numberofsolutions) {
		StackPane root = new StackPane();
		root.getChildren().add(hbox);
		// @formatter:off
		Scene scene = new Scene(
				root, 
				calculateWindowWidth(numberofsolutions), 
				SolutionJFXVisualizer.GRID_EDGE_LENGTH * CARD_DISPLAY_WIDTH
		);
		// @formatter:on
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private int calculateWindowWidth(int numberofsolutions) {
		// @formatter:off
		int result = 
				(numberofsolutions + 1) // +1 because we display the unordered cards and all solutions
				* SolutionJFXVisualizer.GRID_EDGE_LENGTH * CARD_DISPLAY_WIDTH // single grid width
				+ (numberofsolutions * GAP_WIDTH); // gaps in front of each solution.
		// @formatter:on
		return result;
	}

	public StackPane createRootAndScene(DisplayableCardGrid solution) {
		StackPane root = new SolutionJFXVisualizer(solution).getCardsToDisplay();
		return root;
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
