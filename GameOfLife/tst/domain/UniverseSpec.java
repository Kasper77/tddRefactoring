package domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniverseSpec {

	@Test
	public void evolve_whenAliveAndUnderPopulated() {
		Universe unit = new Universe();
		unit.evolve();

		assertTrue(unit.isCellDead(2, 2));
	}

	@Test
	public void evolve_whenAliveAndNormalPopulated() {
		Universe unit = new Universe();
		unit.evolve();

		assertFalse(unit.isCellDead(2, 2));
	}

	
}
