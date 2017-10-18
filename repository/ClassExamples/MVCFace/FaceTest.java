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
		JFrame frame = new JFrame("Smiling face");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Add the face and a label
		Face face = new Face();
		frame.add(face, BorderLayout.CENTER);
		JPanel northPanel = new JPanel();
		northPanel.setBackground(Color.WHITE);
		TextView label = new TextView();
		northPanel.add(label);
		frame.add(northPanel, BorderLayout.NORTH);
		// Add two buttons
		JButton happy = new JButton("Be Happy");
		JButton sad = new JButton("Be Sad");
		JPanel southPanel = new JPanel();
		southPanel.setBackground(Color.WHITE);
		southPanel.add(happy);
		southPanel.add(sad);
		frame.add(southPanel, BorderLayout.SOUTH);

		// Model of the face
		final FaceModel model = new FaceModel();
		model.addView(face);
		model.addView(label);
		// Program the buttons' clicks
		// ButtonListener listener = new ButtonListener(face, label);
		// sad.addActionListener(listener);
		// happy.addActionListener(listener);
		// other way: create an anonymous class on the spot
		sad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.beSad();
			}
		});
		happy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.beHappy();
			}
		});
		// Set window size and display
		frame.setSize(500, 400);
		frame.setVisible(true);
	}
}
