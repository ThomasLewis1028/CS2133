package geography;

/**
 * Thomas Lewis
 * Christopher Crick
 * Computer Science II
 * November 16, 2016
 * Satellite.java
 * 	A satellite class for any object orbiting a planet
 */

public class Satellite extends BaseGeo {
	private Planet planet;

	/**
	 * Receive a String name and call the super class
	 * to set the name of the object
	 *
	 * @param name String
	 */
	public Satellite(String name) {
		super(name);
	}

	/**
	 * Return the planet the satellite orbits
	 *
	 * @return Planet planet
	 */
	public Planet getPlanet() {
		return planet;
	}

	/**
	 * Receive a Planet planet and set this.planet to
	 * the planet provided
	 *
	 * @param planet Planet
	 */
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
}
