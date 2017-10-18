import javax.swing.JFrame;

public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// the model to store the data (= the list of the squares)
		ModelOfSquares model = new ModelOfSquares();
		// graphical display
		JFrame frame = new JFrame("Squares with MVC");
		frame.setSize(500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// views
		PanelOfSquares panel = new PanelOfSquares();
		frame.add(panel);
		ConsoleView console = new ConsoleView();
		model.addView(panel);
		model.addView(console);
		// controller
		SquaresController controller = new SquaresController(model);
		frame.addKeyListener(controller);
		panel.addMouseListener(controller);
		// Show it all
		frame.setVisible(true);
	}

}
