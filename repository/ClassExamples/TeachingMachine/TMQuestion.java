import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * One question for the teaching machine
 * 
 * @author CSC 143
 *
 */
public class TMQuestion {
	// a question is defined by a number, the text of the
	// question and the list of possible answers
	private int number;
	private List<String> text;
	private Map<String, Integer> answers;

	public static String SEPARATOR = "-----";
	public static String ANSWER_DELIMITER1 = ":";
	public static String ANSWER_DELIMITER2 = "";

	private TMQuestion() {
		// just for internal use
		answers = new HashMap<String, Integer>();
		text = new ArrayList<String>();
	}

	// to create a question, a client will call the
	// following static method (sometimes called a factory method)
	public static TMQuestion readTMQuestion(Scanner scan) {
		TMQuestion q = new TMQuestion();
		q.number = scan.nextInt();
		// skip the new line after the number
		scan.nextLine();
		// text of the question
		String line;
		while (!(line = scan.nextLine()).equals(SEPARATOR)) {
			q.text.add(line);
		}
		// answers
		while (scan.hasNext() && (line = scan.nextLine()).trim().length() > 0) {
			String[] parts = line.split(ANSWER_DELIMITER1);
			if (ANSWER_DELIMITER2.length() == 0) {
				System.out.println(Arrays.toString(parts));
				q.answers.put(parts[0].trim(),
						Integer.parseInt(parts[parts.length - 1].trim()));
			} else {
				String[] parts2 = parts[parts.length - 1]
						.split(ANSWER_DELIMITER2);
				q.answers.put(parts[0].trim(),
						Integer.parseInt(parts2[0].trim()));
			}
		}

		return q;
	}

	/**
	 * Returns the question number, the text of the question and the answers
	 */
	public String toString() {
		String s = number + "\n";
		s += getText() + "\n";
		s += SEPARATOR + "\n";
		for (String key : answers.keySet()) {
			s += key + ANSWER_DELIMITER1 + " " + answers.get(key) + "\n";
		}
		return s;
	}

	/**
	 * Returns the question number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Returns the text of the question
	 */
	public String getText() {
		String t = text.get(0);
		for (int i = 1; i < text.size(); i++) {
			t += "\n" + text.get(i);
		}
		return t;
	}

	/**
	 * Given an answer, returns the number of the next question (or null if
	 * none)
	 */
	public Integer getNextQuestion(String answer) {
		return answers.get(answer);
	}
}
