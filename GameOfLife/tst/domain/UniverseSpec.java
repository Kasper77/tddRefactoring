package domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UniverseSpec {
	private final static int WIDTH = 5;
	private final static int LENGTH = 5;

	@Test
	public void isSurfaceValid_whenTipicalUniverse() {
		Universe unit = new Universe(WIDTH, LENGTH);

		assertTrue("Universe Surface is valid!", unit.isUniverseValid());
	}

	@Test
	public void isSurfaceValid_whenNullUniverse() {
		Universe unit = new Universe(0, 0);
		
		assertTrue("Universe Surface is valid!", !unit.isUniverseValid());
	}

	@Test
	public void getCells_whenTipicalUniverse() {
		Universe unit = new Universe(WIDTH, LENGTH);

		assertTrue(unit.getCells() != null);
		assertTrue(unit.getWIDTH() == WIDTH);
		assertTrue(unit.getLENGTH() == LENGTH);
	}
	
}
