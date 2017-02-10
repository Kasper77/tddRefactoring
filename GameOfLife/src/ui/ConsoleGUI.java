package ui;

import domain.Universe;

public class ConsoleGUI {

	public void updateDisplay(Universe universe) {
		System.out.print("------------------------------");
		System.out.println();
		for (int i = 0; i < universe.getWIDTH(); i++) {
			for (int j = 0; j < universe.getLENGTH(); j++) {
				if (universe.getCell(i, j) == true) {
					System.out.print("X");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.print("------------------------------");
	}

}
