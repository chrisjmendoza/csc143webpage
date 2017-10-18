import javax.swing.JLabel;

public class TextView extends JLabel implements FaceView {

	public void update(FaceModel m) {
		if (m.getHappy()) {
			setText("Happy");
		} else {
			setText("Sad");
		}
	}

}
