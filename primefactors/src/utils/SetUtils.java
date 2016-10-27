package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetUtils {

	public static HashSet<Object> emptySet() {
		return new HashSet<>();
	}

//	public static Set asSet(int i) {
//		Set set = emptySet();
//		set.add(i);
//		return set;
//	}
	
	public static Set asSet(Object... elements) {
		return new HashSet<>(Arrays.asList(elements));
	}

//	public static Object asSet(int element1, int element2) {
//		Set set = emptySet();
//		set.add(element1);
//		set.add(element2); 
//
//		return set;
//	}

}
