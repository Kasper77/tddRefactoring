package domain;

import java.util.Observable;
import java.util.Random;

public class Universe extends Observable {
	private int WIDTH;
	private int LENGTH;

	Earth earth = null;
	Earth futureEarth = null;

	public Universe(int width, int length) {
		this.WIDTH = width;
		this.LENGTH = length;

		earth = new Earth(WIDTH, LENGTH);
		futureEarth = new Earth(WIDTH, LENGTH);

		createNativePopulation();
	}

	private int aliveNeighbours(int i, int j) {
		int aliveNeighboursCount = 0;

		if ((i > 0 && j > 0) && earth.getCell(i - 1, j - 1))
			aliveNeighboursCount++;
		if ((i > 0) && earth.getCell(i - 1, j))
			aliveNeighboursCount++;
		if ((i > 0 && j < (earth.getRowOfCells(0).length - 1)) && earth.getCell(i - 1, j + 1))
			aliveNeighboursCount++;

		if ((j > 0) && earth.getCell(i, j - 1))
			aliveNeighboursCount++;
		if (j < (earth.getRowOfCells(0).length - 1) && (earth.getCell(i, j + 1)))
			aliveNeighboursCount++;

		if (i < (earth.getSize() - 1) && j > 0 && earth.getCell(i + 1, j - 1))
			aliveNeighboursCount++;
		if (i < (earth.getSize() - 1) && earth.getCell(i + 1, j))
			aliveNeighboursCount++;
		if (i < (earth.getSize() - 1) && j < (earth.getRowOfCells(0).length - 1) && earth.getCell(i + 1, j + 1))
			aliveNeighboursCount++;

		return aliveNeighboursCount;
	}

	private void createFutureUniverse() {
		for (int i = 0; i < earth.getSize(); ++i)
			futureEarth.setRowOfCells(i, earth.getRowOfCells(i).clone());
	}

	public void die() {
		earth = new Earth(WIDTH, LENGTH);
	}

	public void evolve() {
		createFutureUniverse();

		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < LENGTH; j++) {
				if (isCellAlive(i, j) && isUnderPopulated(i, j))
					setCellDead(futureEarth, i, j);
				if (isCellAlive(i, j) && isOverPopulated(i, j))
					setCellDead(futureEarth, i, j);
				if (isCellDead(i, j) && isZombiePopulated(i, j))
					setCellAlive(futureEarth, i, j);
			}
		}

		earth = futureEarth;

		setChanged();
		notifyObservers();
	}

	public boolean isCellAlive(int i, int j) {
		return !isCellDead(i, j);
	}

	public boolean isCellDead(int i, int j) {
		return !earth.getCell(i, j);
	}

	private boolean isUnderPopulated(int i, int j) {
		return aliveNeighbours(i, j) < 2;
	}

	private boolean isOverPopulated(int i, int j) {
		return aliveNeighbours(i, j) > 3;
	}
	
	private boolean isZombiePopulated(int i, int j) {
		return aliveNeighbours(i, j) == 3;
	}

	private void populateNeighbourhood(int i, int j, int numberOfNeighbours) {
		int aliveNeighboursCount = 0;
		if (i > 0) {
			earth.setCell(i - 1, j, true);
			aliveNeighboursCount++;
		}
		if (j < earth.getRowOfCells(0).length) {
			earth.setCell(i, j + 1, true);
			aliveNeighboursCount++;
		}

		if (aliveNeighboursCount == numberOfNeighbours)
			return;

		if (i < LENGTH) {
			earth.setCell(i + 1, j, true);
			aliveNeighboursCount++;
		}

		if (aliveNeighboursCount == numberOfNeighbours)
			return;

		if (j > 0) {
			earth.setCell(i, j - 1, true);
			aliveNeighboursCount++;
		}

		if (aliveNeighboursCount == numberOfNeighbours)
			return;
	}

	private void setCellAlive(Earth u, int i, int j) {
		u.setCell(i, j, true);
	}

	public void setCellAlive(int i, int j) {
		setCellAlive(earth, i, j);
	}

    private void setCellDead(Earth u, int i, int j) {
		u.setCell(i, j, false);
	}

	public void setCellDead(int i, int j) {
		setCellDead(earth, i, j);
	}

	public void overPopulateNeighbourhood(int i, int j) {
		populateNeighbourhood(i, j, 4);
	}

	public void populateNeighbourhood(int i, int j) {
		populateNeighbourhood(i, j, 2);
	}

	public void zombifyNeighbourhood(int i, int j) {
		populateNeighbourhood(i, j, 3);
	}

	public Earth getUniverse() {
		return earth;
	}
	
	private void createNativePopulation() {
		Random random = new Random();

		int cells = random.nextInt(LENGTH);
		for (int i = 0; i < cells*4; ++i) {
			earth.setCell(random.nextInt(WIDTH), random.nextInt(LENGTH), true); 
		}
	}

}
