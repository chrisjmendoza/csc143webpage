import java.util.ArrayList;

public class TestCritter {
	// Write description of and sound produced by Critter c.
	public static void writeInfo(Critter c) {
		System.out.println("Dynamic type = " + c.getClass());
		System.out.println(c);
		c.speak();
		// if a trainable, make it fetch and roll over
		if (c instanceof Trainable) {
			Trainable t = (Trainable) c;
			t.fetch();
			t.rollOver();
		}
		if (c instanceof Sellable) {
			Sellable s = (Sellable) c;
			System.out.println("price = " + s.getPrice());
		}
	}

	// Test critter classes
	public static void main(String[] args) {
		// Create a poodle, a buffalo, and a cow
		// Could use an array. Use an ArrayList to do something
		// different from what we did in the Person/Student example
		ArrayList<Critter> list = new ArrayList<Critter>();
		list.add(new Poodle());
		list.add(new Cow());
		list.add(new Buffalo());
		// Call writeInfo for each critter
		for (Critter c : list) {
			writeInfo(c);
			System.out.println();
		}
	}
}
