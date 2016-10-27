import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

public class DieSpec {

	@Test
	public void roll_whenTypical() {
		Die unit = new Die();
		unit.roll();
		assertThat(unit.getFaceValue(), allOf(
				greaterThanOrEqualTo(Die.MIN),
				lessThanOrEqualTo(Die.MAX)));
	}

	@Test
	public void roll_xxx() {
		Die unit = new Die();
		unit.roll();
		
		int delta = 100;
		int[] freqs = new int[6];
		for (int i = 0; i < 10000; i++) {
			
		}
		int firstFreq = freqs.get(0);
		for (int freq : freqs) {
			assertEquals(firstFreq,freq,delta);
		}
	}

}
