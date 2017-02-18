package main;

import Util.Time;
import domain.Universe;
import presenter.ConsolePresenter;
import ui.ConsoleView;

public class GameOfLifeApplication {
	Universe universe = null;
	ConsoleView view = null;
	private ConsolePresenter presenter = null;

	public GameOfLifeApplication(Universe u, ConsoleView v) {
		universe = u;
		view = v;
		presenter = new ConsolePresenter(universe, view);
		universe.addObserver(presenter);
	}

	/**
	 * @param duration 
	 *			duration of the game in seconds
	 */
	public void runFor(int duration) {
		long end = System.currentTimeMillis() + (duration*1000);
		while(System.currentTimeMillis() < end) {
			universe.evolve();
			Time.waitFor(500);
		}
	}

	/**
	 * Run forever
	 */
	public void run() {

		while(true) {
			universe.evolve();
			Time.waitFor(500);
		}
	}
}
