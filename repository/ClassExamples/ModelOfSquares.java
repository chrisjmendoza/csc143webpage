import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/**
 * The class that holds the data -> the model in the MVC framework
 * 
 * @author CSC 143
 * 
 */
public class ModelOfSquares {
	private ArrayList<MyRectangle> squareList = 
			                     new ArrayList<MyRectangle>();
	private ArrayList<View> viewList = new ArrayList<View>();
	
	// length of the side of the squares
	private int side = 20;
	// to create random coordinates
	private Random rand = new Random();


	/**
	 * Adds a view to the list of views in the model
	 */
	public void addView(View v) {
		viewList.add(v);
		v.update(this);
	}

	/**
	 * Updates all of the views following a change in the model
	 */
	public void updateAll() {
		for (View v : viewList) {
			v.update(this);
		}
	}
	
	/**
	 * Adds a square to the list of squares
	 */
	public void addSquare(int width, int height) {
		// upper left corner of the square
		int x = rand.nextInt(width - side);
		int y = rand.nextInt(height - side);
		// Color of the square (random)
		Color c = new Color(rand.nextInt(), true);
		// Create the square
		Rectangle r = new Rectangle(x, y, side, side);
		squareList.add(new MyRectangle(r, c));
		// Show it
		updateAll();
	}
	
	/**
	 * Deletes the top square at position (x,y) if any
	 */
	public void deleteSquare(int x, int y) {
		boolean changed = false;
		ListIterator<MyRectangle> it = squareList
				.listIterator(squareList.size());
		while (it.hasPrevious()) {
			MyRectangle r = it.previous();
			if (r.getRectangle().contains(x,y)) {
				it.remove();
				changed = true;
				break;
			}
		}
		if (changed) {
			updateAll();
		}
	}
	
	/**
	 * Returns the list of squares
	 */
	public List<MyRectangle> getSquares() {
		return squareList;
	}

}












