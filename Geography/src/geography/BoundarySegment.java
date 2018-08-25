package geography;

/**
 * Thomas Lewis
 * Christopher Crick
 * Computer Science II
 * November 16, 2016
 * BoundarySegment.java
 * 	A boundary segment class to set up the boundaries
 * 	for cities, countries, states, or anything that has
 * 	a boundary.
 */
public class BoundarySegment {
	private double x;
	private double y;

	/**
	 * Constructor for BoundarySegment to receive two doubles
	 * and set them as x and y
	 *
	 * @param x double
	 * @param y double
	 */
	public BoundarySegment(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Return the x value of this Boundary Segment
	 *
	 * @return x
	 */
	public double getX() {
		return x;
	}

	/**
	 * Receive a double x and set this.x to x
	 *
	 * @param x double
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Return the y value of this Boudnary Segment
	 *
	 * @return y
	 */
	public double getY() {
		return y;
	}

	/**
	 * Receive a double y and set this.y to y
	 *
	 * @param y double
	 */
	public void setY(double y) {
		this.y = y;
	}
}
