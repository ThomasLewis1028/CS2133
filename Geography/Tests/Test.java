import geography.*;
import junit.framework.TestCase;

import java.util.Arrays;

/**
 * Created by thoma on 11/6/2016.
 */
public class Test extends TestCase {

	@org.junit.Test
	public void testPlanet() {
		//Set up planets
		Planet earth = new Planet("Earth", true);
		Planet mars = new Planet("Mars", false);
		Planet jupiter = new Planet("Jupiter", false);

		//Set up satellites
		Satellite phobos = new Satellite("Phobos");
		Satellite deimos = new Satellite("Deimos");
		Satellite moon = new Satellite("Moon");

		//Set up continents
		Continent europe = new Continent("Europe");
		Continent northAmerica = new Continent("North America");
		Continent asia = new Continent("Asia");
		Continent southAmerica = new Continent("South America");

		//Country
		Country america = new Country("America");
		Country vaticanCityCountry = new Country("Vatican geography.City");
		Country canada = new Country("Canada");
		Country mexico = new Country("Mexico");
		Country russia = new Country("Russia");

		//States and provinces
		StateProvince oklahoma = new StateProvince("Oklahoma");
		StateProvince texas = new StateProvince("Texas");
		StateProvince california = new StateProvince("California");
		StateProvince districtOfColumbia = new StateProvince("District of Columbia");

		//Cities
		City vaticanCity = new City("Vatican geography.City");
		City stillwater = new City("Stillwater");
		City mustang = new City("Mustang");
		City dallas = new City("Dallas");
		City houston = new City("Houston");
		City losAngeles = new City("Los Angeles");
		City washingtonDC = new City("Washington D.C");
		City oklahomaCity = new City("Oklahoma City");

		//Bodies of water
		BodyOfWater pacificOcean = new BodyOfWater("Pacific Ocean");
		pacificOcean.setTypeOfWater(BodyOfWater.typeOfWater.OCEAN);
		BodyOfWater boomerLake = new BodyOfWater("Boomer Lake");
		boomerLake.setTypeOfWater(BodyOfWater.typeOfWater.LAKE);
		BodyOfWater rioGrande = new BodyOfWater("Rio Grande");
		rioGrande.setTypeOfWater(BodyOfWater.typeOfWater.RIVER);
		BodyOfWater fortCobbLake = new BodyOfWater("Fort Cobb Lake");
		fortCobbLake.setTypeOfWater(BodyOfWater.typeOfWater.LAKE);

		//Set capital cities
		vaticanCityCountry.setCapital(vaticanCity);
		america.setCapital(washingtonDC);

		//Set areas
		mars.setArea(144789500);
		america.setArea(9833517);
		oklahoma.setArea(68899);
		mustang.setArea(12);
		stillwater.setArea(28.3);
		dallas.setArea(385.8);
		houston.setArea(627.8);
		losAngeles.setArea(503);
		washingtonDC.setArea(63.8);
		moon.setArea(14600000);
		oklahomaCity.setArea(620.34);

		//Set x and y
		mustang.setXY(35.39, -97.72);
		stillwater.setXY(36.14, -97.07);
		vaticanCity.setXY(41.9, 12.45);
		oklahomaCity.setXY(35.48, -97.535);
		mustang.addBoundarySegment(new BoundarySegment(4, 5));

		//Add bodies of water
		pacificOcean.setPlanet(earth);
		boomerLake.addCity(stillwater);
		rioGrande.addCountry(Arrays.asList(mexico, america));
		oklahoma.addBodyOfWater(fortCobbLake);


		//Add satellites
		//Add phobos twice to make sure it doesn't add it twice
		mars.addSatellite(Arrays.asList(phobos, deimos, phobos));
		earth.addSatellite(moon);

		//Add neighbors
		mars.addNeighbors(earth);
		mars.addNeighbors(jupiter);
		oklahoma.addNeighbors(texas);
		northAmerica.addNeighbors(southAmerica);

		//Add cities
		districtOfColumbia.addCity(washingtonDC);
		//Add mustang twice to make sure it doesn't add twice
		oklahoma.addCity(Arrays.asList(stillwater, mustang, mustang));
		texas.addCity(Arrays.asList(dallas, houston));
		california.addCity(losAngeles);


		//Add provinces
		america.addStateProvince(Arrays.asList(oklahoma, texas, california, districtOfColumbia));

		//Add countries
		asia.addCountry(russia);
		europe.addCountry(russia);
		europe.addCountry(vaticanCityCountry);
		northAmerica.addCountry(Arrays.asList(america, canada, mexico));

		//Add continents
		earth.addContinent(Arrays.asList(europe, northAmerica, southAmerica, asia));

		/**
		 * UNIT TESTS FOR MAKING SURE ALL THE STUFF WORKS
		 */
		//Check if mars has earth and jupiter, and assure earth doesn't have jupiter
		assertTrue(mars.getNeighbors().contains(earth));
		assertTrue(mars.getNeighbors().contains(jupiter));
		assertFalse(earth.getNeighbors().contains(jupiter));

		//Make sure that oklahoma and texas are neighboring
		assertTrue(oklahoma.getNeighbors().contains(texas));
		assertTrue(texas.getNeighbors().contains(oklahoma));

		//Make sure that north america nad south america are neighboring
		assertTrue(northAmerica.getNeighbors().contains(southAmerica));

		//Make sure that I have 6 cities in America, and 2 in oklahoma
		assertEquals(6, america.getCities().size());
		assertEquals(2, oklahoma.getCities().size());

		assertTrue(russia.getContinents().contains(asia));
		assertTrue(russia.getContinents().contains(europe));

		assertEquals(2, mars.getSatellites().size());

		assertEquals(mars, phobos.getPlanet());
		assertEquals(earth, moon.getPlanet());

		mustang.getDistance(washingtonDC);
		System.out.println("\nMustang to Stillwater\n" + mustang.getDistance(stillwater));
		System.out.println("\nStillwater to Vatican City\n" + stillwater.getDistance(vaticanCity));
		System.out.println("\nOklahoma City to Stillwater\n" + stillwater.getDistance(oklahomaCity));
		System.out.println("\nArea of cities in America\n" + america.getCityArea());
		System.out.println("\nArea of America\n" + america.getArea());
	}
}
