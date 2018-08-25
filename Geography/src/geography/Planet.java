package geography;

import java.util.ArrayList;
import java.util.List;

/**
 * Thomas Lewis
 * Christopher Crick
 * Computer Science II
 * November 16, 2016
 * Planet.java
 * 	Planet class to store continents, whether it's hospitable or not, and any
 * 	satellites that might orbit it.
 */
public class Planet extends BaseGeo {
	private ArrayList<Continent> continents;
	private ArrayList<Satellite> satellites;
	private boolean isHabitable;

	/**
	 * Receive a name and a boolean for isHabitable and set the
	 * values accordingly.
	 *
	 * @param name        String provided
	 * @param isHabitable Boolean provided
	 */
	public Planet(String name, boolean isHabitable) {
		super(name);
		this.isHabitable = isHabitable;
	}

	/**
	 * Return the continents on a given planet
	 *
	 * @return continents
	 */
	public ArrayList<Continent> getContinents() {
		return continents;
	}

	/**
	 * Receive an arrayList of continents and set the continents to
	 * to this.continents
	 *
	 * @param continents ArrayList provided
	 */
	public void setContinents(ArrayList<Continent> continents) {
		this.continents = continents;
	}

	/**
	 * Return if a planet is habitable or not
	 *
	 * @return isHabitable
	 */
	public boolean isHabitable() {
		return isHabitable;
	}

	/**
	 * Set the habitable status of a planet
	 *
	 * @param habitable true or false
	 */
	public void setHabitable(boolean habitable) {
		isHabitable = habitable;
	}

	/**
	 * Return the ArrayList of satellites
	 *
	 * @return satellites ArrayList
	 */
	public ArrayList<Satellite> getSatellites() {
		return satellites;
	}

	/**
	 * Receive an ArrayList of satellites and set this.setellites
	 * to the provided list
	 *
	 * @param satellites ArrayList
	 */
	public void setSatellites(ArrayList<Satellite> satellites) {
		this.satellites = satellites;
	}

	/**
	 * Add a single continent to the list of continents that
	 * the planet holds
	 *
	 * @param continent
	 */
	public void addContinent(Continent continent) {
		if (continents == null) {
			continents = new ArrayList<>();
		}

		continents.add(continent);
		continent.setPlanet(this);
	}

	/**
	 * Add multiple continents to a planet at once and then call
	 * addContinent with each individual continent.
	 *
	 * @param continents
	 */
	public void addContinent(List<Continent> continents) {
		for (Continent continent : continents) {
			addContinent(continent);
		}
	}

	/**
	 * Add a single satellite to the list of satellites orbiting a planet
	 *
	 * @param satellite Add a single satellite to the ArrayList
	 */
	public void addSatellite(Satellite satellite) {
		if (satellites == null) {
			satellites = new ArrayList<>();
		}

		if (!satellites.contains(satellite)) {
			satellites.add(satellite);
			satellite.setPlanet(this);
		}
	}

	/**
	 * Take a list of satellites at once and call add satellite and call
	 * addSatellite with an individual satellite.
	 *
	 * @param satellites ArrayList of satellites
	 */
	public void addSatellite(List<Satellite> satellites) {
		for (Satellite satellite : satellites) {
			addSatellite(satellite);
		}
	}
}
