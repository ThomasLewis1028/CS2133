package geography;

import java.util.ArrayList;
import java.util.List;

/**
 * Thomas Lewis
 * Christopher Crick
 * Computer Science II
 * November 16, 2016
 * StateProvince.java
 * 	StateProvince class for holding cities and being tied to countries
 */
public class StateProvince extends BaseGeo {
	private ArrayList<City> cities;
	private Country country;

	/**
	 * Receive a String name and call the super class
	 * to set the name of the object
	 *
	 * @param name String
	 */
	public StateProvince(String name) {
		super(name);
	}

	/**
	 * Return the ArrayList of cities
	 *
	 * @return cities ArrayList
	 */
	public ArrayList<City> getCities() {
		return cities;
	}

	/**
	 * Receive an ArrayList of cities and set
	 * this.cities to the ArrayList provided
	 *
	 * @param cities ArrayList
	 */
	public void setCities(ArrayList<City> cities) {
		this.cities = cities;
	}

	/**
	 * Go through the list of cities that a state has and
	 * return if it's the capital city based on a boolean
	 *
	 * @return city
	 */
	public City getCapital() {
		for (City city : cities) {
			if (city.isCapital()) {
				return city;
			}
		}

		return null;
	}

	/**
	 * Return the country a particular city belongs to
	 *
	 * @return Country country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * Receive a Country country and set this.country to the
	 * country provided
	 *
	 * @param country Country
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/**
	 * Add each individual city to the list of cities
	 * that a state/province has
	 *
	 * @param city City
	 */
	public void addCity(City city) {
		if (cities == null) {
			cities = new ArrayList<>();
		}

		if (!cities.contains(city)) {
			cities.add(city);
			city.setState(this);
		}
	}

	/**
	 * Take a list of cities and call addCity on each
	 * individual city to add it to the list of cities
	 *
	 * @param cities List
	 */
	public void addCity(List<City> cities) {
		for (City city : cities) {
			addCity(city);
		}
	}
}
