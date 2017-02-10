package presenter;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import domain.UniverseModel;
import ui.ConsoleGUI;

public class ConsolePersenterSpec {

	@Test
	public void start_WhenTipical() {
		boolean presenterUpAndRunning = true;

		try {
			UniverseModel model = new UniverseModel(20, 75);
			ConsoleGUI gui = new ConsoleGUI();
			ConsolePresenter unit = new ConsolePresenter(model, gui);

			unit.evolve();
		} catch (IllegalArgumentException e) {
			presenterUpAndRunning = false;
		}

		assertTrue("Presenter fully up!", presenterUpAndRunning);
	}

	@Test
	public void start_WhenUniverseMissing() {
		try {
			ConsoleGUI gui = new ConsoleGUI();
			ConsolePresenter unit = new ConsolePresenter(null, gui);
			unit.evolve();
		} catch (IllegalArgumentException e) {
			assertTrue("Presenter correctly not initialized, model missing!", true);
			return;
		}
		assertTrue("ops ... presente is not supposed to be up and running!!", false);
	}

	@Test
	public void start_WhenUiMissing() {
		try {
			UniverseModel model = new UniverseModel(20, 75);
			ConsolePresenter unit = new ConsolePresenter(model, null);
			unit.evolve();
		} catch (IllegalArgumentException e) {
			assertTrue("Presenter correctly not initialized, model missing!", true);
			return;
		}
		assertTrue("ops ... presente is not supposed to be up and running!!", false);
	}
}
