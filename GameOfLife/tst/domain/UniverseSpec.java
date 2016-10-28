package domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniverseSpec {

	@Test
	public void evolve_whenAliveAndUnderPopulated() {
		Universe unit = new Universe();
		unit.die();
		unit.setCellAlive(2, 2);

		unit.evolve();

		assertTrue(unit.isCellDead(2, 2));
	}

	@Test
	public void evolve_whenAliveAndNormalPopulated() {
		Universe unit = new Universe();
		unit.die();
		unit.setCellAlive(2, 2);
		unit.populateNeighbourhood(2, 2);

		unit.evolve();

		assertTrue(unit.isCellAlive(2, 2));
	}

	@Test
	public void evolve_whenAliveAndOverPopulated() {
		Universe unit = new Universe();
		unit.die();
		unit.setCellAlive(2, 2);
		unit.overPopulateNeighbourhood(2, 2);

		unit.evolve();

		assertTrue(unit.isCellDead(2, 2));
	}

	@Test
	public void evolve_whenDeadAndZombiePopulation() {
		Universe unit = new Universe();
		unit.die();
		unit.zombifyNeighbourhood(2, 2);

		unit.evolve();

		assertTrue(unit.isCellAlive(2, 2));
	}
}
