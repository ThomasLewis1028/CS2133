package geography;

import java.util.List;

/**
 * Thomas Lewis
 * Christopher Crick
 * Computer Science II
 * November 16, 2016
 * Geography.java
 * 	Interface for the BaseGeo to implement
 */
public interface Geography {
	double getArea();

	void setArea(double area);

	List<BaseGeo> getNeighbors();

	void setNeighbors(List<BaseGeo> neighbors);

	void setName(String name);

	String getName();

	void addNeighbors(BaseGeo neighbor);

}

