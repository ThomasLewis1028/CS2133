import javax.swing.*;
import java.awt.*;
import java.io.PrintWriter;

/**
 * Thomas Lewis
 * Computer Science II - CS2133
 * Christopher Crick
 * RobotFrame.java
 *	Display the RobotPanel
 */
public class RobotFrame extends JFrame{
	public RobotFrame(PrintWriter out){
		RobotPanel panel = new RobotPanel(out);
		setSize(new Dimension(500, 500));
		add(panel);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}
}