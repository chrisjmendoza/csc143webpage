import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

public class MyPanel extends JPanel {

	private Random rand = new Random();

	@Override
	protected void paintComponent(Graphics g) {
		// always write the super call as the first instruction
		// -> if not, the display might not be what you want!
		super.paintComponent(g);
		
		// sometimes, it is useful to use the Graphics2D class
		// (available with Swing classes)
		// Graphics2D g2D = (Graphics2D) g;

		// create a random polygon with a random color
		int n = 10 + rand.nextInt(10); // between 10 and 19 points
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = rand.nextInt(getWidth());
			y[i] = rand.nextInt(getHeight());
		}
		Color c = new Color(rand.nextInt(256), rand.nextInt(256),
				rand.nextInt(256), rand.nextInt(256));
		
		g.setColor(c);
		g.fillPolygon(x, y, n);
		// never call repaint in paintComponent
		// -> infinite recursion
//		repaint();
	}
}





