import java.util.ArrayList;
import java.util.List;

public class FaceModel {
	private boolean happy = true;
	private List<FaceView> views = new ArrayList<FaceView>();

	/** adds a view */
	public void addView(FaceView v) {
		views.add(v);
		v.update(this);
	}

	/** Make a sad face */
	public void beSad() {
		happy = false;
		// update the views
		for (FaceView v : views) {
			v.update(this);
		}
	}

	/** Make a smiley face */
	public void beHappy() {
		happy = true;
		// update the views
		for (FaceView v : views) {
			v.update(this);
		}
	}

	public boolean getHappy() {
		return happy;
	}

}
