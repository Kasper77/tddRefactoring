package domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import mockit.Expectations;
import mockit.Mocked;

public class CupSpec {
	@Mocked Die mockDie;

	@Test
	public void ctor_whenTypical() {
		int numberOfDice = 3;
		Cup unit = new Cup(numberOfDice);

		assertEquals(numberOfDice, unit.dice.size());
	}

	@Test
	public void getTotalOfFaceValues_whenFakeDice() {
		int arbitraryFaceValue = 5;
		int arbitraryNumberOfDice = 2;
		Cup unit = DomainObjectFactory.createCupWithFakeDice(arbitraryFaceValue, arbitraryNumberOfDice);

		int total = arbitraryNumberOfDice * arbitraryFaceValue;
		assertEquals(total, unit.getTotalOfFaceValues());
	}
	
//	@Test
//	public void getTotalOfFaceValues_whenFakeDiceFromJMockit() {
//		new DieFakeFromJMockit();
//		Cup unit = new Cup(3);
//		
//		assertEquals(9, unit.getTotalOfFaceValues());
//	}

	@Test
	public void getTotalOfFaceValues_whenxx() {
		Cup unit = new Cup(3);

		new Expectations() {{
		      mockDie.getFaceValue(); result = 3;
		   }};

		assertEquals(9, unit.getTotalOfFaceValues());
	}
	
}
