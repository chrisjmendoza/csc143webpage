import static org.junit.Assert.*;

import org.junit.Test;

public class TestCritters implements CritterConstants {

	@Test
	public void testWolf() {
		// Create a set of animals around the wolf
		CritterInfoForTest ci = new CritterInfoForTest(
				new String[] {"L", "B"});
		Wolf w = new Wolf();
		
		assertTrue(w.getMove(ci) == WEST);
	}

	@Test
	public void testLion() {
		// moves the given number of steps in a random direction, then chooses a
		// new random direction and repeats
		int steps = (int) (Math.random() * 10) + 5;
		Lion lion = new Lion(steps);

		int[] dir = new int[4];

		int currentDir = 0; // irrelevant
		for (int i = 1; i <= 10000; i++) {
			int d = lion.getMove(null);
			if (i % steps == 1) {
				currentDir = d;
			} else {
				assertTrue(d == currentDir);
			}
			if (d == WEST) {
				dir[0]++;
			} // etc.
		}

		for (int val : dir) {
			assertTrue(Math.abs(val - 2500) / 2500.0 <= 0.1);
		}

	}
}
