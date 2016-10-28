package domain;

public class Universe {

	private static final int WIDTH = 5;
	private static final int LENGTH = 5;

	boolean[][] universe = new boolean[LENGTH][WIDTH];
	boolean[][] futureUniverse = new boolean[LENGTH][WIDTH];

	private int aliveNeighbours(int i, int j) {
		int aliveNeighboursCount = 0;

		if ((i > 0 && j > 0) && universe[i - 1][j - 1])
			aliveNeighboursCount++;
		if ((i > 0) && universe[i - 1][j])
			aliveNeighboursCount++;
		if ((i > 0 && j < (universe[0].length - 1)) && universe[i - 1][j + 1])
			aliveNeighboursCount++;

		if ((j > 0) && universe[i][j - 1])
			aliveNeighboursCount++;
		if (j < (universe[0].length - 1) && (universe[i][j + 1]))
			aliveNeighboursCount++;

		if (i < (universe.length - 1) && j > 0 && universe[i + 1][j - 1])
			aliveNeighboursCount++;
		if (i < (universe.length - 1) && universe[i + 1][j])
			aliveNeighboursCount++;
		if (i < (universe.length - 1) && j < (universe[0].length - 1) && universe[i + 1][j + 1])
			aliveNeighboursCount++;

		return aliveNeighboursCount;
	}

	private void createFutureUniverse() {
		for (int i = 0; i < universe.length; i++)
			futureUniverse[i] = universe[i].clone();
	}

	public void die() {
		universe = new boolean[5][5];
	}

	public void evolve() {
		createFutureUniverse();

		for (int i = 0; i < LENGTH; i++) {
			for (int j = 0; j < WIDTH; j++) {
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
		return !universe[i][j];
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
			universe[i - 1][j] = true;
			aliveNeighboursCount++;
		}
		if (j < universe[0].length) {
			universe[i][j + 1] = true;
			aliveNeighboursCount++;
		}

		if (aliveNeighboursCount == numberOfNeighbours)
			return;

		if (i < LENGTH) {
			universe[i + 1][j] = true;
			aliveNeighboursCount++;
		}

		if (aliveNeighboursCount == numberOfNeighbours)
			return;

		if (j > 0) {
			universe[i][j - 1] = true;
			aliveNeighboursCount++;
		}

		if (aliveNeighboursCount == numberOfNeighbours)
			return;
	}

	private void setCellAlive(boolean[][] matrix, int i, int j) {
		matrix[i][j] = true;
	}

	public void setCellAlive(int i, int j) {
		setCellAlive(universe, i, j);
	}

	private void setCellDead(boolean[][] matrix, int i, int j) {
		matrix[i][j] = false;
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
}
