package geography;

import java.util.ArrayList;
import java.util.List;

/**
 * Thomas Lewis
 * Christopher Crick
 * Computer Science II
 * November 16, 2016
 * Country.java
 * 	Country class to store its capital, the continent(s) it belongs to,
 * 	the states within, and a total cityArea just in case.
 */
public class Country extends BaseGeo {
	private ArrayList<StateProvince> stateProvinces;
	private City capital;
	private ArrayList<Continent> continents;
	private double cityArea = 0;

	/**
	 * Receive a string and call the super class to set the name
	 *
	 * @param name String
	 */
	public Country(String name) {
		super(name);
	}

	/**
	 * Return the states and provinces of a country
	 *
	 * @return stateProvinces
	 */
	public ArrayList<StateProvince> getStateProvinces() {
		return stateProvinces;
	}

	/**
	 * Set the states or provinces that belong to a country
	 *
	 * @param stateProvinces StateProvince
	 */
	public void setStateProvinces(ArrayList<StateProvince> stateProvinces) {
		this.stateProvinces = stateProvinces;
	}

	/**
	 * Receive the capital city of a country
	 *
	 * @return capital
	 */
	public City getCapital() {
		return capital;
	}

	/**
	 * Set the capital city of a country
	 *
	 * @param capital City
	 */
	public void setCapital(City capital) {
		this.capital = capital;
	}

	/**
	 * Return the continents of the given object
	 *
	 * @return continents
	 */
	public ArrayList<Continent> getContinents() {
		return continents;
	}

	/**
	 * Receive an ArrayList of Continents and set it to this.continents
	 *
	 * @param continents ArrayList
	 */
	public void setContinents(ArrayList<Continent> continents) {
		this.continents = continents;
	}

	/**
	 * Add an individual state or province to the list that a
	 * country has
	 *
	 * @param stateProvince
	 */
	public void addStateProvince(StateProvince stateProvince) {
		if (stateProvinces == null) {
			stateProvinces = new ArrayList<StateProvince>();
		}

		if (!stateProvinces.contains(stateProvince)) {
			stateProvinces.add(stateProvince);
			stateProvince.setCountry(this);
		}
	}

	/**
	 * Take a list of states or provinces and then call
	 * addStateProvince on each individual item
	 *
	 * @param stateProvinces
	 */
	public void addStateProvince(List<StateProvince> stateProvinces) {
		for (StateProvince stateProvince : stateProvinces) {
			addStateProvince(stateProvince);
		}
	}

	/**
	 * Add a continent to the list of continents that a country has,
	 * really only useful for Russia
	 *
	 * @param continent
	 */
	public void addContinent(Continent continent) {
		if (continents == null) {
			continents = new ArrayList<Continent>();
		}

		if (!continents.contains(continent)) {
			continents.add(continent);
		}
	}

	/**
	 * Search through the states and provinces a country
	 * holds and then add the cities each state/province
	 * has to the list that the country has.
	 *
	 * @return Array list of cities
	 */
	public ArrayList<City> getCities() {
		ArrayList<City> cities = new ArrayList<>();

		if (getStateProvinces() != null) {
			for (StateProvince state : getStateProvinces()) {
				if (state.getCities() != null) {
					for (City city : state.getCities()) {
						cities.add(city);
					}
				}
			}
		}

		return cities;
	}

	/**
	 * Search through all the cities that lie within a country and
	 * add the areas from each to a total cityArea and return it
	 *
	 * @return total area of cities within country
	 */
	public double getCityArea() {
		if (getStateProvinces() != null) {
			for (StateProvince state : getStateProvinces()) {
				if (state.getCities() != null) {
					for (City city : state.getCities()) {
						cityArea += city.getArea();
					}
				}
			}
		}

		return cityArea;
	}
}
