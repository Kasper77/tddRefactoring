package primefactors;

import java.util.Set;

import utils.SetUtils;

public class MathUtils {

	public static Set getPrimeFactors(int n) {
		if (n < 2)
			return SetUtils.emptySet();
		else
			return SetUtils.asSet(n);
	}

}
