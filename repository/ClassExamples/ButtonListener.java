import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ButtonListener implements ActionListener {

	private JPanel panel;

	public ButtonListener(JPanel panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Never call paintComponent directly
		// -> might yield a bad display
		// Graphics g = panel.getGraphics();
		// ((MyPanel) panel).paintComponent(g);
		panel.repaint();
	}

}
