package primefactors;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import utils.SetUtils;

@RunWith(Parameterized.class)
public class MathUtilsSpec {

	@Parameter(value = 0)
	public Set expectedPrimeFactors;

	@Parameter(value = 1)
	public int numberToFactorize;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ SetUtils.emptySet(), 0 },
				{ SetUtils.emptySet(), 1 },
				{ SetUtils.asSet(2), 2 },
				{ SetUtils.asSet(3), 3 },
				{ SetUtils.asSet(2,2), 4 },
				{ SetUtils.asSet(5), 5 },
				{ SetUtils.asSet(2,3), 6 },
				{ SetUtils.asSet(7), 7 },
				{ SetUtils.asSet(2,2,2), 8 },
				{ SetUtils.asSet(3,3), 9 },
				{ SetUtils.asSet(2,5), 10 },
				{ SetUtils.asSet(11), 11 },
				{ SetUtils.asSet(2,2,3), 12 },
				{ SetUtils.asSet(5,5), 25 },
				
		});
	}

	@Test
	public void getPrimeFactors() {
		assertEquals(expectedPrimeFactors, MathUtils.getPrimeFactors(numberToFactorize));
		System.out.println(MathUtils.getPrimeFactors(1000124045));
	}
}
