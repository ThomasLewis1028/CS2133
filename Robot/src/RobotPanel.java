import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.PrintWriter;

/**
 * Thomas Lewis
 * Computer Science II - CS2133
 * Christopher Crick
 * RobotPanel.java
 *	Hold the content and do a decent bit of the leg work.  Includes some
 *	deprecated code I didn't finish with the speed control, may revisit
 *	later when I have more time.
 */
public class RobotPanel extends JPanel {
	private JPanel landTakeoff = new JPanel();
	private JPanel upDown = new JPanel();
	private JPanel grid = new JPanel();
//	private JPanel speedControl = new JPanel();
//	private JLabel speedLabel = new JLabel();
	private double speed = .25;

	PrintWriter out;

	public RobotPanel(PrintWriter out) {
		this.out = out;
		this.setLayout(new BorderLayout(5, 0));
		grid.setLayout(new GridLayout(4, 3, 5, 5));
//		speedControl.setLayout(new GridLayout(3, 1, 0, 5));
		landTakeoff.setLayout(new GridLayout(2, 1, 0, 5));
		upDown.setLayout(new GridLayout(2, 1, 0, 5));

		landTakeoff.add(createCmdButton("Takeoff", new Commands("/ardrone/takeoff")));
		landTakeoff.add(createCmdButton("Land", new Commands("/ardrone/land")));
		upDown.add(createCmdButton("Up", new Commands(0, 0, speed)));
		upDown.add(createCmdButton("Down", new Commands(0, 0, -speed)));

		grid.add(createCmdButton("Spin Left", new Commands(speed * 4)));
		grid.add(landTakeoff);
		grid.add(createCmdButton("Spin Right", new Commands(-speed * 4)));
		grid.add(createCmdButton("Forward Left", new Commands(speed, speed, 0)));
		grid.add(createCmdButton("Forward", new Commands(speed, 0, 0)));
		grid.add(createCmdButton("Forward Right", new Commands(speed, -speed, 0)));
		grid.add(createCmdButton("Left", new Commands(0, speed, 0)));
		grid.add(upDown);
		grid.add(createCmdButton("Right", new Commands(0, -speed, 0)));
		grid.add(createCmdButton("Backward Left", new Commands(-speed, speed, 0)));
		grid.add(createCmdButton("Backward", new Commands(-speed, 0, 0)));
		grid.add(createCmdButton("Backward Right", new Commands(-speed, -speed, 0)));

//		speedLabel.setText(String.valueOf(speed));

//		speedControl.add(createSpeedButton("Speed Up", .05));
//		speedControl.add(speedLabel);
//		speedControl.add(createSpeedButton("Speed Down", -.05));

		add(grid, BorderLayout.CENTER);
//		add(speedControl, BorderLayout.EAST);
	}

	//This is the JPanel that creates the
	private JPanel createCmdButton(String title, final Commands cmd) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 1));
		JButton button = new JButton(title);

		//A mouse listener event to check when the button is pressed or released
		button.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				sendCommand(cmd, 0);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				sendCommand(new Commands(0, 0, 0, 0), 0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});

		panel.add(button);
		return panel;
	}

	//Send the commands to the robot via the Commands.toJSON function
	public void sendCommand(Commands cmd, long wait) {
		try {
			out.println(cmd.toJSON());
			out.flush();
			System.out.println(cmd.toJSON());
//			Thread.sleep(wait);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	private JPanel createSpeedButton(String title, double set) {
//		JPanel panel = new JPanel();
//		panel.setLayout(new GridLayout(1, 1));
//		JButton button = new JButton(title);
//
//		button.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (set < 0) {
//					if (speed > 0) {
//						speed += set;
//						speedLabel.setText(String.valueOf(""+speed));
//						grid.updateUI();
//					}
//				} else if (set > 0) {
//					if (speed < 2) {
//						speed += set;
//						speedLabel.setText(""+speed);
//						grid.updateUI();
//					}
//				}
//			}
//		});
//
//		panel.add(button);
//		return panel;
//	}
}