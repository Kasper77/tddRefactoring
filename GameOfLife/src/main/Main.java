package main;

public class Main {

	public static void main(String[] args) {
		GameOfLifeApplication app = GameOfLifeFactory.createApp();
		app.runFor(180);
	}
}
