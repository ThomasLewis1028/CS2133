package geography;

import java.util.ArrayList;

/**
 * Thomas Lewis
 * Christopher Crick
 * Computer Science II
 * November 16, 2016
 * City.java
 *	City class to keep track of streets, the state it belongs to,
 *	its location, and whether it's a capital or not.
 */
public class City extends BaseGeo {
	private ArrayList<String> streets;
	private boolean isCapital;
	private StateProvince state;
	private double x;
	private double y;

	/**
	 * Receive a String name and call the super class to set
	 * the name of the City
	 *
	 * @param name String provided
	 */
	public City(String name) {
		super(name);
	}

	/**
	 * Return the string list of streets of the city
	 *
	 * @return streets
	 */
	public ArrayList<String> getStreets() {
		return streets;
	}

	/**
	 * Receive an ArrayList of type String that (should) be a list of
	 * streets and set this.streets to that value
	 *
	 * @param streets ArrayList of Strings
	 */
	public void setStreets(ArrayList<String> streets) {
		this.streets = streets;
	}

	/**
	 * Check if the city is a capital city and return true or false
	 *
	 * @return Boolean isCapital
	 */
	public boolean isCapital() {
		return isCapital;
	}

	/**
	 * Set whether a given city is a capital city or not
	 *
	 * @param capital Boolean isCapital;
	 */
	public void setCapital(boolean capital) {
		isCapital = capital;
	}

	/**
	 * Return the state that the city is listed under
	 *
	 * @return State state
	 */
	public StateProvince getState() {
		return state;
	}

	/**
	 * Receive a StateProvince state and set this.state to state
	 *
	 * @param state StateProvince provided
	 */
	public void setState(StateProvince state) {
		this.state = state;
	}

	/**
	 * Return the x value of a city
	 *
	 * @return double x
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
	 * Return the y value of a city
	 *
	 * @return double y
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

	/**
	 * Receive a double x and a double y and call setX() and setY()
	 * because I'm efficient like that
	 *
	 * @param x double
	 * @param y double
	 */
	public void setXY(double x, double y) {
		setY(y);
		setX(x);
	}

	/**
	 * Calculate the distance a this city and another provided city
	 * if they both have provided x and y values.  Otherwise note
	 * the lack of values.  it returns the distance*69 because I used
	 * lat and long coordinates in my locations, and each degree is
	 * roughly 69 miles.  The value can only be so accurate as
	 * different places define different city centers, so it's
	 * mostly guess work.  It was within 6 miles of the actual distance
	 * from Mustang to Stillwater, so close enough right?  Though please
	 * don't try the distance between Stillwater and Vatican City, it may
	 * or may not be 2100miles difference.
	 *
	 * @param city Any city with a given x and y
	 * @return dist*69
	 */
	public double getDistance(City city) {
		if (this.getX() == 0 || this.getY() == 0 || city.getX() == 0 || city.getY() == 0) {
			System.out.println("No values provided for one city");
			return 0;
		}
		double distX = this.getX() - city.getX();
		double distY = this.getY() - city.getY();
		distX = Math.pow(distX, 2);
		distY = Math.pow(distY, 2);

		double dist = distX + distY;
		dist = Math.pow(dist, .5);

		return dist * 69;    //1 degree is roughly 69 miles, so this returns miles(ish)
	}
}
