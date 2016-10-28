package domain;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DieSpec {

	@Test
	public void roll_whenTypical() {
		Die unit = new Die();
		unit.roll();
		assertThat(unit.getFaceValue(), allOf(greaterThanOrEqualTo(Die.MIN), lessThanOrEqualTo(Die.MAX)));
	}

	@Test
	public void roll_whenProbabilityMatches() {
		
		Die unit = new Die();
		int[] freqs = new int[Die.NUM_OF_FACES];
		int maxRolls = 10000;
		int delta = maxRolls / 50;
		
		generateFrequencies(unit, freqs, maxRolls);
		
		checkFrequencies(freqs, delta);
	}

	private void checkFrequencies(int[] freqs, int delta) {
		for (int freq : freqs) {
			assertEquals(freqs[0], freq, delta);
		}
	}

	private void generateFrequencies(Die unit, int[] freqs, int maxRolls) {
		for (int i = 0; i < maxRolls; i++) {
			unit.roll();
			freqs[unit.getFaceValue() - Die.MIN]++;
		}
	}

}
