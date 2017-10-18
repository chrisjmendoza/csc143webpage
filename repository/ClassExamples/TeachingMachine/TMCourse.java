import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * A course is a list of questions and answers
 * 
 * @author CSC 143
 *
 */
public class TMCourse {
	private String title;
	// list of the questions
	SortedMap<Integer, TMQuestion> questions = new TreeMap<Integer, TMQuestion>();

	// private constructor (the client will use a factory method)
	private TMCourse() {
	}

	/**
	 * Reads a course file
	 */
	public static TMCourse readCourse(Scanner scan) {
		TMCourse course = new TMCourse();
		if (!scan.hasNextInt()) {
			course.title = scan.nextLine();
		}
		// questions
		while (scan.hasNextInt()) {
			TMQuestion q = TMQuestion.readTMQuestion(scan);
			course.questions.put(q.getNumber(), q);
		}
		return course;
	}

	/**
	 * Returns the full text of the course (title + questions)
	 */
	public String toString() {
		String s = "";
		if (title != null) {
			s += title + "\n";
		}
		for (Integer number : questions.keySet()) {
			s += questions.get(number) + "\n";
		}
		return s;
	}

	/**
	 * Runs the course
	 */
	public void run(Scanner scan) {
		if (title != null) {
			System.out.println("Welcome to " + title);
		}

		// display a question, get the answer, select the next
		// question
		TMQuestion current = questions.get(questions.firstKey());
		do {
			System.out.println(current.getText());
			System.out.print("> ");
			String answer = scan.nextLine();
			Integer next = current.getNextQuestion(answer);
			if (next == null) {
				System.out.println("I don't understand");
			} else if (next == 0) {
				return;
			} else {
				current = questions.get(next);
			}
		} while (true);
	}
}
