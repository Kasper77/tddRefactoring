package domain;

import java.util.Random;

public class Die {

	public static final int MIN = 1;
	public static final int MAX = 6;
	public static final int NUM_OF_FACES = MAX - MIN + 1;
	
	private int faceValue = MIN;
	
	public void roll() {
		Random r = new Random();
		faceValue = r.nextInt(MAX) + 1;
	}

	public int getFaceValue() {
		return faceValue;
	}

}
