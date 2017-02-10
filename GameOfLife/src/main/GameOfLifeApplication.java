package main;

import Util.Time;
import domain.UniverseModel;
import presenter.ConsolePresenter;
import ui.ConsoleGUI;

public class GameOfLifeApplication {

	/**
	 * @param duration 
	 *			duration of the game in seconds
	 */
	public void start(int duration) {
		UniverseModel universe = new UniverseModel(20, 75);
		ConsoleGUI ui = new ConsoleGUI();

		ConsolePresenter presenter = new ConsolePresenter(universe, ui);
		
		long end = System.currentTimeMillis() + (duration*1000);
		while(System.currentTimeMillis() < end) {
			presenter.evolve();
			Time.waitFor(500);
		}
	}
}
