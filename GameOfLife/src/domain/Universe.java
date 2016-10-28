package domain;

public class Universe {

	 boolean[][] universe = new boolean[5][5];
	// universe[2][2] = true;

	public void evolve() {
	}

	public boolean isCellDead(int i, int j) {
		return !universe[i][j];
	}

}
