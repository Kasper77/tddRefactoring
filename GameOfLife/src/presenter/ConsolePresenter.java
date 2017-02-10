package presenter;

import domain.UniverseModel;
import ui.ConsoleGUI;

public class ConsolePresenter {

	private UniverseModel model = null;
	private ConsoleGUI gui;

	public ConsolePresenter(UniverseModel model, ConsoleGUI gui) {
		this.model = model;
		this.gui = gui;
	}

	public void evolve(){
		if ((model == null) || (gui == null)) {
			throw new IllegalArgumentException(""); // unchecked exception
		}
		model.evolve();
		gui.updateDisplay(model.getUniverse());
	}
}
