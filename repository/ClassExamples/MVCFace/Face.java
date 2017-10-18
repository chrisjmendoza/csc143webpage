import java.awt.*;
import javax.swing.*;

/**
 * A Smiley-face panel.
 */
public class Face extends JPanel implements FaceView {

	// Happy or sad
	private boolean happy = true;

	public Face() {
		setBackground(Color.WHITE);
	}

	/** Paint a smiley face centered in this Jpanel */
	public void paintComponent(Graphics gfx) {

		// paint background
		super.paintComponent(gfx);

		// Use Java 2D features
		Graphics2D g = (Graphics2D) gfx;
		// get width and height of drawing area, which is the
		// width and height of the JPanel
		int height = getHeight();
		int width = getWidth();
		// draw face that takes up 80% of the JPanel
		int faceTop = height / 10;
		int faceLeft = width / 10;
		int faceHeight = height - height / 5;
		int faceWidth = width - width / 5;

		// outline
		g.setColor(Color.yellow);
		g.fillOval(faceLeft, faceTop, faceWidth, faceHeight);

		// eyes
		g.setColor(Color.black);
		g.fillOval(faceLeft + (int) (width * 0.2), faceTop
				+ (int) (height * 0.2), width / 10, height / 10);
		g.fillOval(faceLeft + (int) (width * 0.5), faceTop
				+ (int) (height * 0.2), width / 10, height / 10);

		// nose
		Polygon nose = new Polygon();
		nose.addPoint(faceLeft + (int) (width * 0.40), faceTop
				+ (int) (height * 0.35));
		nose.addPoint(faceLeft + (int) (width * 0.45), faceTop
				+ (int) (height * 0.50));
		nose.addPoint(faceLeft + (int) (width * 0.35), faceTop
				+ (int) (height * 0.50));
		g.fillPolygon(nose);

		// mouth
		if (this.happy)
			g.fillArc(faceLeft + (int) (width * 0.25), faceTop
					+ (int) (height * 0.5), (int) (width * 0.3),
					(int) (height * 0.2), 0, -180);
		else
			g.fillArc(faceLeft + (int) (width * 0.25), faceTop
					+ (int) (height * 0.6), (int) (width * 0.3),
					(int) (height * 0.2), 0, 180);

		// never do this in paintComponent
		// repaint(); // why?
	}

	public void update(FaceModel m) {
		happy = m.getHappy();
		repaint();
	}

}
