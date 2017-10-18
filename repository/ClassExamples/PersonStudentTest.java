import static org.junit.Assert.*;

import org.junit.Test;


/**
 * A test of the Person and Student classes
 * @author CSC 143
 *
 */
public class PersonStudentTest {

	public static void main(String[] args) {
		// static type = given by the type on the line that 
		// declares a variable
		// e.g. Person p -> the static type of p is Person
		// the static type never changes
		// dynamic type = the type of the object that p is pointing to
		// p = new Person(...) -> p has dynamic type Person
		// p = new Student(...) -> p has dynamic type Student
		Person p = new Person("Michelle", 29);
		p.speak(); // -> call speak in Person
		p = new Student("Joe", 32, 3.7);
		p.speak(); // -> call speak in Student
	}
	
	@Test
	public void testSpeak() {
		Student s = new Student("Joe", 32, 3.7);
		assertTrue(s.toString().contains("Joe"));
		assertTrue(s.toString().contains("3.7"));
	}

}







