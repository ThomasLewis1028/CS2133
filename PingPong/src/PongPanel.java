import org.w3c.dom.events.MouseEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

/**
 * Created by thoma on 9/26/2016.
 */
public class PongPanel extends JPanel{
    PongFrame frame;
    Toolkit kit;

    public PongPanel(PongFrame pf){
        frame = pf;
        kit = Toolkit.getDefaultToolkit();
        addMouseMotionListener(new MotionHandler());
        Timer t = new Timer(50, new ActionHandler);
        t.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        double x = frame.getModel().getBall_x();
        double y = frame.getModel().getBall_y();
        double paddle = frame.getModel().getPaddle();
        g.fillOval((int)(x*getWidth()), (int)(y*getHeight()), 10, 10);
        g.fillRect(10, ((int)(paddle*getHeight())), 10, 50);
    }

    private class ActionHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            frame.getModel().timeStep();
        }
    }

    private class MotionHandler extends MouseMotionAdapter{
        public void mouseMoved(MouseEvent e){
            int y = e.getY();
            double y_pct = (double)y/getHeight();
            frame.getModel().movePaddle(y_pct);
        }
    }

}
