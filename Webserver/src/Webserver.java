import java.io.*;
import java.net.*;

/**
 * Thomas Lewis
 * Computer Science II - CS2133
 * Christopher Crick
 * Webserver.java
 * 	Open connections on port 8080 and start the thread with the client connection
 */
public class Webserver {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8080);

			while (true) {
				Thread conn = new Thread(new ClientConnection(ss.accept()));
				conn.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
