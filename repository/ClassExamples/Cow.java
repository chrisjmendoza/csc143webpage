// Definition of the Cow class
// A Cow is a Bovine that makes specific noises

public class Cow extends Bovine implements Sellable{
	// Constructor
	public Cow() {
		super(
         "A cow is a bovine who is jealous of" + 
		 " the movie star status of buffalos.");
	}

	// We need to override speak if we want to be able to
	// instantiate a Buffalo
	public void speak() {
		System.out.println("Help me! Some kid just tipped me!");
	}

	public double getPrice() {
		return 2000;
	}
}
