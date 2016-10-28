package utils;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;

import org.junit.Test;

public class SetUtilsSpec {

	@Test
	public void emptySet() {
		assertEquals(new HashSet<>(), SetUtils.emptySet());
	}

	@Test
	public void asSet_whenOneElement() {
		HashSet set = SetUtils.emptySet();
		int arbitraryElement = 1;
		set.add(arbitraryElement);
		assertEquals(set, SetUtils.asSet(arbitraryElement));
	}

	@Test
	public void asSet_whenTwoElements() {
		HashSet set = SetUtils.emptySet();
		int arbitraryElement = 1;
		int arbitraryElement2 = 2;
		set.add(arbitraryElement);
		set.add(arbitraryElement2);

		assertEquals(set, SetUtils.asSet(arbitraryElement, arbitraryElement2));
	}

	@Test
	public void union_whenTypical() {
		assertEquals(SetUtils.asSet(1, 2, 3, 4), SetUtils.union(SetUtils.asSet(1, 2), SetUtils.asSet(3, 4)));
	}
}
