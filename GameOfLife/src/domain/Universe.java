package domain;

public class Universe {
	private int WIDTH;
	private int LENGTH;

	private boolean[][] universe = null;

	public Universe(int width, int length) {
		this.WIDTH = width;
		this.LENGTH = length;
		universe = new boolean[this.WIDTH][this.LENGTH];
	}

	public boolean isUniverseValid() {
		if ((WIDTH > 0) && (LENGTH > 0))
			return true;
		return false;
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getLENGTH() {
		return LENGTH;
	}

	public boolean[][] getCells() {
		return universe;
	}

	public void setCell(int x, int y, boolean val) {
		universe[x][y] = val;
	}

	public boolean getCell(int x, int y) {
		return universe[x][y];
	}

	public boolean[] getRowOfCells(int x) {
		return universe[x];
	}

	public void setRowOfCells(int rowIndex, boolean[] row) {
		universe[rowIndex] = row;
	}

	public int getSize() {
		return universe.length;
	}

}
