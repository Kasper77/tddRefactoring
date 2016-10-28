package primefactors;

import java.util.Set;

import utils.SetUtils;

public class MathUtils {

	public static Set getPrimeFactors(int n) {
		if (n < 2)
			return SetUtils.emptySet();
		for (int i = 2; i < (n - 1); i++) {
			if (isMultipleOf(n, i))
				return SetUtils.union(SetUtils.asSet(i), getPrimeFactors(n / i));
		}
		return SetUtils.asSet(n);
	}

	public static boolean isMultipleOf(int n, int i) {
		return (n % i) == 0;
	}

}
