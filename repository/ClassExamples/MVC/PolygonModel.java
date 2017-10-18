import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The model holds the data of the polygon
 * 
 * @author CSC 143
 *
 */
public class PolygonModel {
	// data of the polygon
	private int[] xp, yp; // coordinates of the vertices of the polygon
	private Color color; // color of the polygon
	private int width, height; // size of the area where the polygon is created

	// views connected to this model
	List<View> views = new ArrayList<View>();

	// A random number generator (used to create the polygon)
	// static to be more efficient
	// just in case there are several instances of the model
	// (though it will not happen in this application)
	private static Random rand = new Random();

	/**
	 * Creates a model that contains a random polygon in a given area
	 * 
	 * @param width
	 *            the width of the polygon area
	 * @param height
	 *            the height of the polygon area
	 */
	public PolygonModel(int width, int height) {
		setArea(width, height);
	}

	/**
	 * Sets the area of the polygon
	 */
	public void setArea(int width, int height) {
		this.width = width;
		this.height = height;
		createPolygon();
		updateAll();
	}

	/**
	 * Adds a point to the current polygon
	 */
	public void addPoint(int x, int y) {
		int[] xTemp = new int[xp.length + 1];
		System.arraycopy(xp, 0, xTemp, 0, xp.length);
		xTemp[xTemp.length - 1] = x;
		xp = xTemp;
		int[] yTemp = new int[yp.length + 1];
		System.arraycopy(yp, 0, yTemp, 0, yp.length);
		yTemp[yTemp.length - 1] = y;
		yp = yTemp;
		updateAll();
	}

	/**
	 * Creates a new polygon
	 */
	public void changePolygon() {
		createPolygon();
		updateAll();
	}

	/**
	 * Adds a view to the current list of views
	 */
	public void addView(View v) {
		views.add(v);
		v.update(this);
	}

	/**
	 * Updates all of the views
	 */
	public void updateAll() {
		for (View view : views) {
			view.update(this);
		}
	}

	/**
	 * Returns the points of the model as one polygon
	 */
	public Polygon getPolygon() {
		return new Polygon(xp, yp, xp.length);
	}

	/**
	 * Returns the color of the polygon
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Creates a random polygon = arrays xp, yp and the color
	 */
	private void createPolygon() {
		// number of vertices (between 3 and 20)
		int np = 3 + rand.nextInt(18);

		// vertices
		xp = new int[np];
		yp = new int[np];

		for (int i = 0; i < np; i++) {
			xp[i] = rand.nextInt(width);
			yp[i] = rand.nextInt(height);
		}

		// color
		int rgba = rand.nextInt();
		color = new Color(rgba, true);
	}
}
