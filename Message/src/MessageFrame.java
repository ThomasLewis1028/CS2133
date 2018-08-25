import javax.swing.*;

/**
 * Thomas Lewis
 * Christopher Crick
 * Computer Science II
 * September 28, 2016
 * MessageFrame.java
 * 	Make the frame for the bottle
 */
public class MessageFrame extends JFrame {

    public MessageFrame(){
        setTitle("Bottle Frame");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MessagePanel panel = new MessagePanel();
        add(panel);
        setVisible(true);
    }
}
