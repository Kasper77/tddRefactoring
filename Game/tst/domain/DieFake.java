package domain;

public class DieFake extends Die {
	public int faceValue = Die.MAX;

	@Override
	public int getFaceValue() {
		return faceValue;
	}

}
