import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TMMain {

	public static void main(String[] args) {
		// read a course file
		String fileName = "CrowtherRooms.txt"; //"JavaReview.txt";
		if (!fileName.equals("JavaReview.txt")) {
			TMQuestion.ANSWER_DELIMITER1 = " ";
			TMQuestion.ANSWER_DELIMITER2 = "/";
		}
		try {
			Scanner scan = new Scanner(new File(fileName));
			TMCourse course = TMCourse.readCourse(scan);
			// System.out.println(course);
			course.run(new Scanner(System.in));
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't find " + fileName);
		}
	}

}
