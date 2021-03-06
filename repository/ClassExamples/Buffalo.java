// Definition of the Buffalo class

public class Buffalo extends Bovine implements Sellable{
	// Constructor
	public Buffalo() {
		super("A buffalo is a bovine that finds work in westerns.");
	}

	// We need to override speak if we want to be able to
	// instantiate a Buffalo
	public void speak() {
		System.out.println(
				"Wake me up when we get to the stampede scene.");
	}

	public double getPrice() {
		return 3000;
	}
}
