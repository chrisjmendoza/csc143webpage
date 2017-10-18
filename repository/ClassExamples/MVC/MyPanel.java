import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

/**
 * A graphical display of the polygon kept by the model
 * 
 * @author CSC 143
 *
 */
public class MyPanel extends JPanel implements View {
	// the model connected to this view
	private PolygonModel model;

	@Override
	public void update(PolygonModel m) {
		this.model = m;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2D = (Graphics2D) g;
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		if (model != null) {
			g2D.setColor(model.getColor());
			g2D.fillPolygon(model.getPolygon());
		}
	}

}
