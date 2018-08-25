package geography;

import java.util.ArrayList;
import java.util.List;

/**
 * Thomas Lewis
 * Christopher Crick
 * Computer Science II
 * November 16, 2016
 * BodyOfWater.java
 * Because Rivers were too simple, I made an entire body of water
 * class for any and all bodies of water, including the type.
 */
public class BodyOfWater {
	private ArrayList<City> cities;
	private ArrayList<StateProvince> stateProvinces;
	private ArrayList<Country> countries;
	private ArrayList<Continent> continents;
	private Planet planet;
	private String name;
	private double area;
	private typeOfWater typeOfWater;
	private double avgWidth;
	private double length;

	/**
	 * Constructor to set the name of the body of water
	 *
	 * @param name String
	 */
	public BodyOfWater(String name) {
		this.name = name;
	}

	/**
	 * Return the name of the body of water
	 *
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set this.name to a string name
	 *
	 * @param name String
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Return the average width double
	 *
	 * @return avgWidth double
	 */
	public double getAvgWidth() {
		return avgWidth;
	}

	/**
	 * Set this.avgWidth to a double
	 *
	 * @param avgWidth double
	 */
	public void setAvgWidth(double avgWidth) {
		this.avgWidth = avgWidth;
	}

	/**
	 * Return the length of a body of water
	 *
	 * @return length
	 */
	public double getLength() {
		return length;
	}

	/**
	 * Set the length of the object
	 *
	 * @param length double
	 */
	public void setLength(double length) {
		this.length = length;
	}

	/**
	 * Return an arrayList of cities the water belongs to
	 *
	 * @return cities ArrayList
	 */
	public ArrayList<City> getCities() {
		return cities;
	}

	/**
	 * Set the arrayList of cities the object belongs to
	 *
	 * @param cities ArrayList
	 */
	public void setCities(ArrayList<City> cities) {
		this.cities = cities;
	}

	/**
	 * Return the arrayList of stateProvinces the object belongs to
	 *
	 * @return stateProvinces
	 */
	public ArrayList<StateProvince> getStateProvinces() {
		return stateProvinces;
	}

	/**
	 * Set the arrayList of stateProvinces the object belongs to
	 *
	 * @param stateProvinces ArrayList
	 */
	public void setStateProvinces(ArrayList<StateProvince> stateProvinces) {
		this.stateProvinces = stateProvinces;
	}

	/**
	 * Return the arrayList of countries the object belongs to
	 *
	 * @return countries
	 */
	public ArrayList<Country> getCountries() {
		return countries;
	}

	/**
	 * Set the arrayList of countries the object belongs to
	 *
	 * @param countries ArrayList
	 */
	public void setCountries(ArrayList<Country> countries) {
		this.countries = countries;
	}

	/**
	 * Return the ArrayList continents the object belongs to
	 *
	 * @return continents
	 */
	public ArrayList<Continent> getContinents() {
		return continents;
	}

	/**
	 * Set the ArrayList continents that the object belongs to
	 *
	 * @param continents ArrayList
	 */
	public void setContinents(ArrayList<Continent> continents) {
		this.continents = continents;
	}

	/**
	 * Return the type of water that the object is
	 *
	 * @return typeOfWater
	 */
	public BodyOfWater.typeOfWater getTypeOfWater() {
		return typeOfWater;
	}

	/**
	 * Set the type of water that it is based on an ENUM
	 *
	 * @param typeOfWater typeOfWater
	 */
	public void setTypeOfWater(BodyOfWater.typeOfWater typeOfWater) {
		this.typeOfWater = typeOfWater;
	}

	/**
	 * Return the planet that the object belongs to
	 *
	 * @return planet
	 */
	public Planet getPlanet() {
		return planet;
	}

	/**
	 * Just in case we find water on Mars, set a planet that water belongs to
	 *
	 * @param planet Planet
	 */
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}

	/**
	 * Return the area of the object
	 *
	 * @return area
	 */
	public double getArea() {
		return area;
	}

	/**
	 * Set the double area of the object
	 *
	 * @param area double
	 */
	public void setArea(double area) {
		this.area = area;
	}

	/**
	 * Add a city if it doesn't already exist
	 *
	 * @param city City
	 */
	public void addCity(City city) {
		if (cities == null) {
			cities = new ArrayList<>();
		}

		cities.add(city);
		city.addBodyOfWater(this);
	}

	/**
	 * Add multiple cities by calling addCity individually
	 *
	 * @param cities ArrayList
	 */
	public void addCity(List<City> cities) {
		for (City city : cities) {
			addCity(city);
		}
	}

	/**
	 * Add a country if it's not already there
	 *
	 * @param country Country
	 */
	public void addCountry(Country country) {
		if (countries == null) {
			countries = new ArrayList<>();
		}

		countries.add(country);
		country.addBodyOfWater(this);
	}

	/**
	 * Add multiple countries and call addCountry indivudually
	 *
	 * @param countries ArrayList
	 */
	public void addCountry(List<Country> countries) {
		for (Country country : countries) {
			addCountry(country);
		}
	}

	/**
	 * Set up an enum that allows me to set the type
	 * of water something may be
	 */
	public enum typeOfWater {
		RIVER, LAKE, OCEAN, SEA
	}
}
