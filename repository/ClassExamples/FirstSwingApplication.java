// Ctrl + Shift + O to import automatically in eclipse 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class FirstSwingApplication {

	public static void main(String[] args) {
		// JFrame: top level container
		JFrame frame = new JFrame("First swing application");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setSize(500, 400);
		frame.setVisible(true);
		
		// place a label at the top of the window
		JLabel label = new JLabel("Drawing panel");
		JPanel northPanel = new JPanel();
		northPanel.add(label);
		frame.add(northPanel, BorderLayout.NORTH);
		
		// place a button at the bottom of the window
		JButton button = new JButton("Draw");
		JPanel southPanel = new JPanel();
		southPanel.add(button);
		frame.add(southPanel, BorderLayout.SOUTH);
		
		// place a panel (MyPanel object) in the center
		MyPanel p = new MyPanel();
		frame.add(p, BorderLayout.CENTER); // same as frame.add(p);
		
		// Create a listener to listen to the button clicks
//		ButtonListener listener = new ButtonListener(p);
//		button.addActionListener(listener);
		
		// Another approach: use an anonymous class
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				p.repaint();
			}
		});
	}

}








