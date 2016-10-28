package utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetUtils {

	public static HashSet<Object> emptySet() {
		return new HashSet<>();
	}

	public static Set asSet(Object... elements) {
		return new HashSet<>(Arrays.asList(elements));
	}

	public static Set union(Set... sets) {
		Set union = emptySet();
		for (Set set : sets) {
			union.addAll(set);
		}
		return union;
	}

}
