/*
 * Class: CMSC203 22502 
 * Instructor: Dr. Kuijt
 * Description: Plot class of Project 4
 * Due: 11/03/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Alex Kim
*/

public class Plot {
	private int x,
				y,
				width,
				depth;
	
	public Plot() {
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}
	
	public Plot (int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	public Plot (Plot otherPlot) {
		
		//Check for null error condition
		if (otherPlot != null) {
			this.x = otherPlot.x;
			this.y = otherPlot.y;
			this.width = otherPlot.width;
			this.depth = otherPlot.depth;	
		}

	}
	
    public boolean overlaps(Plot plot) {
		//Check for null error condition
    	if (plot == null) {
            return false;
        }
        
    	//Check if plot instance overlaps
        if (x >= plot.x + plot.width || 
        	plot.x >= x + width ||
            y >= plot.y + plot.depth || 
            plot.y >= y + depth) {
            return false;
        }
        return true;
    }

    public boolean encompasses(Plot plot) {
		//Check for null error condition
    	if (plot == null) {
            return false;
        }
        
    	//Check if plot instance encompasses
        if (x <= plot.x && 
        	y <= plot.y &&
            x + width >= plot.x + plot.width &&
            y + depth >= plot.y + plot.depth) {
        	return true;
        }
        return false;
    }
	
	public void setX (int x) {
		this.x = x;
	}
	
	public void setY (int y) {
		this.y = y;
	}
	
	public void setWidth (int width) {
		this.width = width;
	}
	
	public void setDepth (int depth) {
		this.depth = depth;
	}
	
	public int getX () {
		return x;
	}
	
	public int getY () {
		return y;
	}
	
	public int getWidth () {
		return width;
	}
	
	public int getDepth () {
		return depth;
	}
	
    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}