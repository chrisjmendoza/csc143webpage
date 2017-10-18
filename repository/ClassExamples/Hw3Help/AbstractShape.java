
public abstract class AbstractShape implements Shape {
	
	protected Shape west, east, north, south, parent;
	
	// to add a level
	@Override
	public boolean addLevel() {
		boolean bNorth = false, bSouth = false, bEast = false, bWest = false;
		// base case: no children
		if(north == null){
			// create a north shape
			north = createChildShape();
			north.setParent(this);
			bNorth = (north != null);
		} else if (north != parent){
			bNorth = north.addLevel();
		} 
		
		// same with south, west, and east
		
		
		
		
		return bNorth && bSouth && bEast && bWest;
	}

}
