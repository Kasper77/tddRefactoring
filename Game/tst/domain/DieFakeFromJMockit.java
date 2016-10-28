package domain;

import mockit.Mock;
import mockit.MockUp;

public class DieFakeFromJMockit extends MockUp<Die> {

	@Mock
	public int getFaceValue() {
		return 3;
	}

}
