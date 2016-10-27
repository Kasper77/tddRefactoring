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
				{ SetUtils.asSet(3), 3 }
//				TODO
//				{ SetUtils.asSet(2,2), 4 }
		});
	}

	@Test
	public void getPrimeFactors() {
//		assertEquals(expectedPrimeFactors, MathUtils.getPrimeFactors(numberToFactorize));
	}
}
