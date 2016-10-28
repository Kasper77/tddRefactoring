package domain;

public class DomainObjectFactory {

	protected static Cup createCupWithFakeDice(int faceValue, int numberOfDice) {
		Cup cup = new Cup(0);

		for (int i = 0; i < numberOfDice; i++) {
			DieFake fake = new DieFake();
			fake.faceValue = faceValue;
			cup.dice.add(fake);
		}

		return cup;
	}

}
