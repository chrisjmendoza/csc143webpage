import javax.swing.JFrame;

/**
 * Puts together the components of the MVC framework
 * 
 * @author CSC 143
 *
 *
 */
public class MainClass {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Polygon display");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 500);
		frame.setVisible(true);

		// the model
		int width = frame.getContentPane().getWidth();
		int height = frame.getContentPane().getHeight();
		PolygonModel model = new PolygonModel(width, height);

		// the view
		MyPanel panel = new MyPanel();
		frame.add(panel);
		model.addView(panel);

		// the controller
		PolygonController controller = new PolygonController(model);
		frame.addKeyListener(controller);
		panel.addComponentListener(controller);
		panel.addMouseListener(controller);
	}

}
