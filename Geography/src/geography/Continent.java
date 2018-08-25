package geography;

import java.util.ArrayList;
import java.util.List;

/**
 * Thomas Lewis
 * Christopher Crick
 * Computer Science II
 * November 16, 2016
 * Continent.java
 * 	Continent class for holding all of the countries and
 * 	being tied to a planet.
 */
public class Continent extends BaseGeo {
	private ArrayList<Country> countries;
	private Planet planet;

	/**
	 * Take a String name and call the super class to set
	 * the name for the Country
	 *
	 * @param name name provided
	 */
	public Continent(String name) {
		super(name);
	}

	/**
	 * Return the ArrayList of countries
	 *
	 * @return countries ArrayList
	 */
	public ArrayList<Country> getCountries() {
		return countries;
	}

	/**
	 * Set the ArrayList of Countries from an ArrayList provided
	 *
	 * @param countries ArrayList of Countries
	 */
	public void setCountries(ArrayList<Country> countries) {
		this.countries = countries;
	}

	/**
	 * Return the planet the Continent lies on
	 *
	 * @return planet
	 */
	public Planet getPlanet() {
		return planet;
	}

	/**
	 * Receive a Planet and set this.planet to the provided planet
	 *
	 * @param planet Planet
	 */
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}

	/**
	 * Add a single country to the country list
	 *
	 * @param country Country
	 */
	public void addCountry(Country country) {
		if (countries == null) {
			countries = new ArrayList<>();
		}

		if (!countries.contains(country)) {
			countries.add(country);
			country.addContinent(this);
		}
	}

	/**
	 * Add multiple countries to a continent and then
	 * call addCountry for each individual country
	 *
	 * @param countries List
	 */
	public void addCountry(List<Country> countries) {
		for (Country country : countries) {
			addCountry(country);
		}
	}
}
