import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Created by Thomas on 10/30/2016.
 */
public class ClientExample {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean sendMsg = true;
		try {
			InetAddress local = InetAddress.getLocalHost();
			Socket socket = new Socket(local, 8080);
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			while (sendMsg == true) {
				String msg = scanner.next();
				if (msg == "kill") {
					sendMsg = false;
				} else {
					out.println(msg);
					out.flush();
				}
			}
//			out.println("Hi there, server!");
//			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
