// A Poodle is a Critter that makes a noise of a Poodle

public class Poodle extends Critter implements Trainable, Sellable {
	// constructor
	public Poodle() {
		super("A poodle is a dog with a funny haircut.");
	}

	// We must override speak if we want Poodle to be instantiated
	public void speak() {
		System.out.println("Woof! Take me to the park.");
	}

	public double getPrice() {
		return 500;
	}

	public void fetch() {
		System.out.println("fetch");
	}

	public void rollOver() {
		System.out.println("roll over");
	}
}
