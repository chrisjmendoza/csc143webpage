/**
 * A FancyCar is a Car with a top speed
 * 
 * @author CSC 143
 * 
 */
public class FancyCar extends Car {
	private double topSpeed;

	public FancyCar(String make, int weight, double topSpeed, 
			String ownerName,
			int ownerAge) {
		super(make, weight, ownerName, ownerAge);
		this.topSpeed = topSpeed;
	}

	// override of equals from Car
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == this.getClass()) {
			FancyCar that = (FancyCar) obj;
			return super.equals(obj) && this.topSpeed == that.topSpeed;
		} else {
			return false;
		}
	}

}
