package domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UniverseModelSpec {
	private final static int WIDTH = 5;
	private final static int LENGTH = 5;

	@Test
	public void evolve_whenAliveAndUnderPopulated() {
		UniverseModel unit = new UniverseModel(WIDTH, LENGTH);
		unit.die();
		unit.setCellAlive(2, 2);

		unit.evolve();

		assertTrue(unit.isCellDead(2, 2));
	}

	@Test
	public void evolve_whenAliveAndNormalPopulated() {
		UniverseModel unit = new UniverseModel(WIDTH, LENGTH);
		unit.die();
		unit.setCellAlive(2, 2);
		unit.populateNeighbourhood(2, 2);

		unit.evolve();

		assertTrue(unit.isCellAlive(2, 2));
	}

	@Test
	public void evolve_whenAliveAndOverPopulated() {
		UniverseModel unit = new UniverseModel(WIDTH, LENGTH);
		unit.die();
		unit.setCellAlive(2, 2);
		unit.overPopulateNeighbourhood(2, 2);

		unit.evolve();

		assertTrue(unit.isCellDead(2, 2));
	}

	@Test
	public void evolve_whenDeadAndZombiePopulation() {
		UniverseModel unit = new UniverseModel(WIDTH, LENGTH);
		unit.die();
		unit.zombifyNeighbourhood(2, 2);

		unit.evolve();

		assertTrue(unit.isCellAlive(2, 2));
	}
}
