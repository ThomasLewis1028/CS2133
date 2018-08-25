import javax.swing.*;
import java.awt.*;

/**
 * Thomas Lewis
 * Christopher Crick
 * Computer Science II
 * September 28, 2016
 * MessagePanel.java
 * 	Make the lines and stuff for a bottle shape
 */
public class MessagePanel extends JPanel {
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 17));
        g.drawString("Help, I'm trapped in a bottle!", 412, 500);
        g.drawArc(400, 800, 250, 100, 0, -180); //Bottom arc
        g.drawLine(400, 850, 400, 350); //Left line
        g.drawLine(650, 850, 650, 350); //Right line
        g.drawArc(525, 300, 125, 100, 90, -90); //Right Arc
        g.drawArc(400, 300, 125, 100, 90, 90);  //Left Arc
        g.drawLine(588, 300, 560, 100); //Right Neck Line
        g.drawLine(464, 300, 490, 100); //Left Neck Line
        g.drawOval(490  , 90, 70, 15);  //Bottle Opening
    }
}
