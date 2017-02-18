package domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EarthSpec {
	private final static int WIDTH = 5;
	private final static int LENGTH = 5;

	@Test
	public void isEarthValid_TipicalUniverse() {
		Earth unit = new Earth(WIDTH, LENGTH);

		assertTrue(unit.isEarthValid());
	}

	@Test
	public void isEarthValid_whenNullUniverse() {
		Earth unit = new Earth(0, 0);

		assertTrue(!unit.isEarthValid());
	}

	@Test
	public void getCells_whenTipicalUniverse() {
		Earth unit = new Earth(WIDTH, LENGTH);

		assertTrue(unit.getCells() != null);
		assertTrue(unit.getWIDTH() == WIDTH);
		assertTrue(unit.getLENGTH() == LENGTH);
	}
	
}
