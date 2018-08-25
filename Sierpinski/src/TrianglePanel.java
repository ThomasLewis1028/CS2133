import javax.swing.*;
import java.awt.*;

/**
 * Thomas Lewis
 * Christopher Crick
 * Computer Science II
 * September 28, 2016
 * TrianglePanel.java
 * 	Draw the triangles and stuff, in reality this guy does all the work
 * 	but receives none of the credit because he doesn't have a "Main"
 * 	method and isn't "cool enough" to be out front.  But this creates
 * 	3 squares in a triangle and makes more and more of them as your
 * 	screen gets larger and larger.  I also messed around with different
 * 	variations, like changing size/4 to size/2 makes a right triangle,
 * 	making each dot RGB gives some weird effect, especially with rectangle
 * 	sizes of 3 or 5 to give it a nice 3D effect.
 */
public class TrianglePanel extends JPanel {
	public void createTriangle(Graphics g, int x, int y, int size) {
		//Draw a single square when you get too small to see any difference
		if (size <= 1) {
			g.drawRect(x, y, 1, 1);

		} else {    //Do stuff while you're not super small
			//Draw new triangles with the new points
			createTriangle(g, x, y + (size / 2), size / 2);    //Left triangle point
			createTriangle(g, x + (size / 4), y, size / 2);    //Mid triangle point
			createTriangle(g, x + (size / 2), y + (size / 2), size / 2);    //Right triangle point
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x = getWidth();
		int y = getHeight();
		int size;

		if (y < x) {
			size = y;
		} else {
			size = x;
		}

		createTriangle(g, 1, 1, size);
	}
}
