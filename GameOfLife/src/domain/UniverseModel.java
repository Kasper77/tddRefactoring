package domain;

import java.util.Random;

public class UniverseModel {
	private int WIDTH;
	private int LENGTH;

	Universe universe = null;
	Universe futureUniverse = null;

	public UniverseModel(int width, int length) {
		this.WIDTH = width;
		this.LENGTH = length;

		universe = new Universe(WIDTH, LENGTH);
		futureUniverse = new Universe(WIDTH, LENGTH);

		createNativePopulation();
	}

	private int aliveNeighbours(int i, int j) {
		int aliveNeighboursCount = 0;

		if ((i > 0 && j > 0) && universe.getCell(i - 1, j - 1))
			aliveNeighboursCount++;
		if ((i > 0) && universe.getCell(i - 1, j))
			aliveNeighboursCount++;
		if ((i > 0 && j < (universe.getRowOfCells(0).length - 1)) && universe.getCell(i - 1, j + 1))
			aliveNeighboursCount++;

		if ((j > 0) && universe.getCell(i, j - 1))
			aliveNeighboursCount++;
		if (j < (universe.getRowOfCells(0).length - 1) && (universe.getCell(i, j + 1)))
			aliveNeighboursCount++;

		if (i < (universe.getSize() - 1) && j > 0 && universe.getCell(i + 1, j - 1))
			aliveNeighboursCount++;
		if (i < (universe.getSize() - 1) && universe.getCell(i + 1, j))
			aliveNeighboursCount++;
		if (i < (universe.getSize() - 1) && j < (universe.getRowOfCells(0).length - 1) && universe.getCell(i + 1, j + 1))
			aliveNeighboursCount++;

		return aliveNeighboursCount;
	}

	private void createFutureUniverse() {
		for (int i = 0; i < universe.getSize(); ++i)
			futureUniverse.setRowOfCells(i, universe.getRowOfCells(i).clone());
	}

	public void die() {
		universe = new Universe(WIDTH, LENGTH);
	}

	public void evolve() {
		createFutureUniverse();

		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < LENGTH; j++) {
				if (isCellAlive(i, j) && isUnderPopulated(i, j))
					setCellDead(futureUniverse, i, j);
				if (isCellAlive(i, j) && isOverPopulated(i, j))
					setCellDead(futureUniverse, i, j);
				if (isCellDead(i, j) && isZombiePopulated(i, j))
					setCellAlive(futureUniverse, i, j);
			}
		}

		universe = futureUniverse;
	}

	public boolean isCellAlive(int i, int j) {
		return !isCellDead(i, j);
	}

	public boolean isCellDead(int i, int j) {
		return !universe.getCell(i, j);
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
			universe.setCell(i - 1, j, true);
			aliveNeighboursCount++;
		}
		if (j < universe.getRowOfCells(0).length) {
			universe.setCell(i, j + 1, true);
			aliveNeighboursCount++;
		}

		if (aliveNeighboursCount == numberOfNeighbours)
			return;

		if (i < LENGTH) {
			universe.setCell(i + 1, j, true);
			aliveNeighboursCount++;
		}

		if (aliveNeighboursCount == numberOfNeighbours)
			return;

		if (j > 0) {
			universe.setCell(i, j - 1, true);
			aliveNeighboursCount++;
		}

		if (aliveNeighboursCount == numberOfNeighbours)
			return;
	}

	private void setCellAlive(Universe u, int i, int j) {
		u.setCell(i, j, true);
	}

	public void setCellAlive(int i, int j) {
		setCellAlive(universe, i, j);
	}

    private void setCellDead(Universe u, int i, int j) {
		u.setCell(i, j, false);
	}

	public void setCellDead(int i, int j) {
		setCellDead(universe, i, j);
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

	public Universe getUniverse() {
		return universe;
	}
	
	private void createNativePopulation() {
		Random random = new Random();

		int cells = random.nextInt(LENGTH);
		for (int i = 0; i < cells*3; ++i) {
			universe.setCell(random.nextInt(WIDTH), random.nextInt(LENGTH), true); 
		}
	}

}
