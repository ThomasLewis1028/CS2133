import javax.swing.*;
import java.awt.*;

/**
 * Created by thoma on 9/26/2016.
 */
public class PongFrame extends JFrame {
    private PongModel model;
    private PongPanel panel;

    public PongFrame() {
        setTitle("Pong!");
        setSize(new Dimension(500, 500));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        model = new PongModel();
        panel = new PongPanel(new PongFrame());
        add(panel);
    }
}
