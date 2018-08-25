import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Thomas Lewis
 * Computer Science II - CS2133
 * Christopher Crick
 * Robot.java
 * 	A robot controller designed for the ARDrone robot, specifically
 * 	designed to connect to the robot_sim file created by Professor
 * 	Crick.  Could technically work on a real drone too.
 */
public class Robot {
	public static void main(String[] args) {
		try {
			InetAddress url = InetAddress.getByName("lear.cs.okstate.edu");
			Socket socket = new Socket(url, 9095);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			new RobotFrame(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}