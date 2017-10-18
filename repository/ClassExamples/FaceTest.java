import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Demonstrate basic Java Swing graphics.
 */
public class FaceTest {

	/** Create a window with a smiley face inside it */
	public static void main(String[] args) {

		// create frame and give it a name
		JFrame frame = new JFrame("Sad or happy?");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Add the face and a label
		final Face face = new Face();
		frame.add(face);
		final JLabel label = new JLabel("I am feeling happy");
		label.setFont(new Font("Courier", Font.BOLD, 25));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		frame.add(label, BorderLayout.NORTH);
		// Add two buttons
		JButton sad = new JButton("Be sad");
		JButton happy = new JButton("Be happy");
		JPanel south = new JPanel();
		south.add(sad);
		south.add(happy);
		frame.add(south, BorderLayout.SOUTH);
		// Program the buttons' clicks
		sad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				face.beSad();
				label.setText("I am feeling sad");
			}
		});
		happy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				face.beHappy();
				label.setText("I am feeling happy");
			}
		});
		// Display
		frame.setVisible(true);
	}
}
