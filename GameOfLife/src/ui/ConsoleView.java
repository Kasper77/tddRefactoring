package ui;

import domain.Earth;

public class ConsoleView {

	public void updateDisplay(Earth e) {
		System.out.print("------------------------------");
		System.out.println();
		for (int i = 0; i < e.getWIDTH(); i++) {
			for (int j = 0; j < e.getLENGTH(); j++) {
				if (e.getCell(i, j) == true) {
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
