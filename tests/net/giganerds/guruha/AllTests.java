package net.giganerds.guruha;

import junit.framework.TestSuite;
import junit.textui.TestRunner;
import net.giganerds.guruha.commons.tests.DicePoolTest;
//import net.giganerds.guruha.rolls.tests.SuccessTest;

public class AllTests extends TestSuite {
	{
//		addTestSuite(DicePoolTest.class); TODO: Tests should extend TestCase for this scenario
//		addTestSuite(SuccessTest.class);
	}

	public static void main(String[] args) {
		TestRunner.run(new AllTests());
	}
}
