import javax.swing.*;
import java.awt.*;

/**
 * Thomas Lewis
 * Christopher Crick
 * Computer Science II
 * September 28, 2016
 * TriangleFrame.java
 * 	Another mostly empty class, just here to make sure TrianglePanel actually
 * 	shows up to the thing he was supposed to be at and make sure his suit is
 * 	fitted nicely.
 */
public class TriangleFrame extends JFrame {
	public TriangleFrame() {
		TrianglePanel triangle = new TrianglePanel();
		setSize(new Dimension(500, 500));
		setTitle("Sierpinski's Triangle");
		add(triangle);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
