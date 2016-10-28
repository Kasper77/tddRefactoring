package domain;

import java.util.ArrayList;
import java.util.List;

public class Cup {

	public List<Die> dice = new ArrayList<Die>();

	public Cup(int numberOfDice) {
		for (int i = 0; i < numberOfDice; i++) {
			dice.add(new Die());
		}
	}

	public void shake() {

	}

	public int getTotalOfFaceValues() {
		int totalOfFaceValues = 0;
		for (Die die : dice) {
			totalOfFaceValues += die.getFaceValue();
		}

		return totalOfFaceValues;
	}

}
