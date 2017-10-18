/**
 * A simple model of a person
 * 
 * @author CSC 142
 * 
 */
public class Person {
	// a person is defined by a name and an age
	private String name;
	private int age;

	/**
	 * Constructs a Person object given the name and age
	 * 
	 * @param n
	 *            the name of the person
	 * @param a
	 *            the age of the person
	 */
	public Person(String n, int a) {
		name = n;
		age = a;
	}

	/**
	 * Prints the name and age of the person
	 */
	public void speak() {
		System.out.println("My name is " + name + ". I am " + age
				+ " years old.");
	}

	// an override of toString() from the Object class
	public String toString() {
		return "name = " + name + ", age = " + age;
	}
}













