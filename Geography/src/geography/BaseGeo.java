package geography;

import java.util.ArrayList;
import java.util.List;

/**
 * Thomas Lewis
 * Christopher Crick
 * Computer Science II
 * November 16, 2016
 * BaseGeo.java
 * The main class for most all other classes to implement
 * and includes names, neighbors, area, bodies of water,
 * and boundary segments.
 */

public abstract class BaseGeo implements Geography {
	private String name;
	private List<BaseGeo> neighbors;    //List of neighbors of type BaseGeo
	private double area;    //Area listed in square miles
	private ArrayList<BodyOfWater> bodiesOfWater;
	private ArrayList<BoundarySegment> boundarySegments;

	/**
	 * Base constructor that receives a name and sets up a list of neighbors
	 * to be used later
	 *
	 * @param name String
	 */
	public BaseGeo(String name) {
		neighbors = new ArrayList<>();
		this.name = name;
	}

	/**
	 * Return the area of whatever object calls for it
	 *
	 * @return area
	 */
	public double getArea() {
		return area;
	}

	/**
	 * Receive an area and set this.area to area
	 *
	 * @param area double
	 */
	public void setArea(double area) {
		this.area = area;
	}

	/**
	 * Return the list of neighbors
	 *
	 * @return neighbors
	 */
	public List<BaseGeo> getNeighbors() {
		return neighbors;
	}

	/**
	 * Receive a List of type BaseGeo so that I can check if any
	 * two objects are considered neighbors, and then set
	 * this.neighbors to the List of neighbors.
	 *
	 * @param neighbors List
	 */
	public void setNeighbors(List<BaseGeo> neighbors) {
		this.neighbors = neighbors;
	}

	/**
	 * Return the name of whatever object might extend this class
	 *
	 * @return name String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Receive a String name, probably from an extended class,
	 * and set this.name to name
	 *
	 * @param name String
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Take this and add neighbor as a neighbor, then add this
	 * as a neighbor to the neighbor
	 *
	 * @param neighbor BaseGeo neighbor
	 */
	public void addNeighbors(BaseGeo neighbor) {
		if (!this.getNeighbors().contains(neighbor)) {
			this.getNeighbors().add(neighbor);
		}

		if (!neighbor.getNeighbors().contains(this)) {
			neighbor.addNeighbors(this);
		}
	}

	/**
	 * Receive a BodyOfWater bodyOfWater and add it to the list
	 * of bodiesOfWater unless it's already listed
	 *
	 * @param bodyOfWater BodyOfWater
	 */
	public void addBodyOfWater(BodyOfWater bodyOfWater) {
		if (bodiesOfWater == null) {
			bodiesOfWater = new ArrayList<>();
		}

		if (!bodiesOfWater.contains(bodyOfWater)) {
			bodiesOfWater.add(bodyOfWater);
		}
	}

	/**
	 * Receive an ArrayList of bodiesOfWater and call addBodyOfWater on each
	 * individually to add it to the list.
	 *
	 * @param bodiesOfWater Arraylist
	 */
	public void addBodyOfWater(List<BodyOfWater> bodiesOfWater) {
		for (BodyOfWater bodyOfWater : bodiesOfWater) {
			addBodyOfWater(bodyOfWater);
		}
	}

	/**
	 * Return the bodies of water that belong to this city
	 *
	 * @return bodiesOfWater ArrayList
	 */
	public ArrayList<BodyOfWater> getBodiesOfWater() {
		return bodiesOfWater;
	}

	/**
	 * Receive an ArrayList of BodyOfWater type and set
	 * this.bodiesOfWater to the provided ArrayList
	 *
	 * @param bodiesOfWater ArrayList
	 */
	public void setBodiesOfWater(ArrayList<BodyOfWater> bodiesOfWater) {
		this.bodiesOfWater = bodiesOfWater;
	}

	/**
	 * Return the boundary segments for a any object that extends this
	 *
	 * @return boundarySegments
	 */
	public ArrayList<BoundarySegment> getBoundarySegments() {
		return boundarySegments;
	}

	/**
	 * Receive an array list of boundary segments and set this.boundarySegments
	 *
	 * @param boundarySegments ArrayList
	 */
	public void setBoundarySegments(ArrayList<BoundarySegment> boundarySegments) {
		this.boundarySegments = boundarySegments;
	}

	/**
	 * Receive a boundarySegment and add it to the list of Boundary Segments if
	 * it doesn't exist already
	 *
	 * @param boundarySegment BoundarySegment
	 */
	public void addBoundarySegment(BoundarySegment boundarySegment) {
		if (boundarySegments == null) {
			boundarySegments = new ArrayList<>();
		}

		if (!boundarySegments.contains(boundarySegment)) {
			boundarySegments.add(boundarySegment);
		}
	}

	/**
	 * Receive an arrayList of boundarySegments and call addBoundarySegment for each
	 * one to add it to the list
	 *
	 * @param boundarySegments ArrayList
	 */
	public void addBoundarySegment(List<BoundarySegment> boundarySegments) {
		for (BoundarySegment boundarySegment : boundarySegments) {
			addBoundarySegment(boundarySegment);
		}
	}
}
