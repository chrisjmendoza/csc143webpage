import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */

public class BoxViewer extends JPanel {

	// The box viewed by this viewer
	private Box box;

	/**
	 * Creates a box viewer within a frame
	 */
	public BoxViewer() {
		setBackground(Color.WHITE);
		// The box
		box = new Box(300, 250, 600, 500, Color.BLUE);
		// Create a frame for this panel
		JFrame frame = new JFrame("Box viewer");
		frame.setVisible(true);
		Insets in = frame.getInsets();
		frame.setSize(600 + in.left + in.right, 500 + in.top + in.bottom);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		// A click on the frame adds an inner box to the box
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// right click of the mouse
				// if (e.isMetaDown()) {
				// if (e.getButton() == MouseEvent.BUTTON3) {
				if (SwingUtilities.isRightMouseButton(e)) {
					boolean success = box.removeInnerBox();
					if (!success) {
						JOptionPane.showMessageDialog(BoxViewer.this,
								"Can't remove an inner box", "Box viewer",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						repaint();
					}
				} else {
					boolean success = box.addInnerBox();
					if (!success) {
						// BoxViewer.this refers to the BoxViewer instance
						// currently constructed
						// this only would refer to the instance of MouseAdapter
						JOptionPane.showMessageDialog(BoxViewer.this,
								"Can't add another box", "Box viewer",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						repaint();
					}
				}
			}
		});
	}

	/**
	 * Paints the contents of this viewer
	 * 
	 * @param g
	 *            the graphics context to use.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		box.draw(g);
	}

	/**
	 * Starts the application.
	 * 
	 * @param args
	 *            the list of the command line parameters.
	 */
	public static void main(String[] args) {
		new BoxViewer();
	}
}
