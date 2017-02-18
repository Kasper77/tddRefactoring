package presenter;

import java.util.Observable;
import java.util.Observer;

import domain.Universe;
import ui.ConsoleView;

public class ConsolePresenter implements Observer {

	private Universe model = null;
	private ConsoleView gui;

	public ConsolePresenter(Universe model, ConsoleView gui) {
		this.model = model;
		this.gui = gui;
	}

	@Override
	public void update(Observable o, Object arg) {
		gui.updateDisplay(model.getUniverse());
	}
}
