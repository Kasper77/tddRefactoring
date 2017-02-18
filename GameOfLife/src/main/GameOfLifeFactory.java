package main;

import domain.Universe;
import ui.ConsoleView;

public class GameOfLifeFactory {

	public static GameOfLifeApplication createApp() {
		Universe universe = new Universe(20, 75);
		ConsoleView view = new ConsoleView();

		return new GameOfLifeApplication(universe, view);
	}

}
