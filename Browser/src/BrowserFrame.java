import javax.swing.*;
import java.awt.*;

/**
 * Thomas Lewis
 * Computer Science II - CS2133
 * Christopher Crick
 * BrowserFrame.java
 * 	Hold the information to display the rest of the browser.
 */
public class BrowserFrame extends JFrame {
	public BrowserFrame(){
		BrowserPanel panel = new BrowserPanel();
		setSize(new Dimension(500, 500));
		setTitle("Browser.java");
		add(panel);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
