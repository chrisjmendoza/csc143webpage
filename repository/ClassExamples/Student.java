public class Student extends Person {
	private double gpa;

	/**
	 * Creates a student given a name, age and gpa
	 */
	public Student(String name, int age, double gpa) {
		// the super call must be the first line in the
		// constructor of the derived class
		super(name, age);
		this.gpa = gpa;
	}

	// override speak from Person so that the student says
	// his/her name, age and gpa
	@Override
	public void speak() {
		super.speak(); // print the name and the age
		System.out.println("gpa = " + gpa);
	}
	
	@Override
	public String toString() {
		return super.toString() + ", gpa = " + gpa;
	}
}




