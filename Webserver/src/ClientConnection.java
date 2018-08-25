import java.io.*;
import java.net.*;
import java.util.regex.*;

/**
 * Thomas Lewis
 * Computer Science II - CS2133
 * Christopher Crick
 * ClientConnection.java
 * 	Handle all of the reading and displaying of content.
 */

public class ClientConnection implements Runnable {
	private Socket socket;
	private BufferedWriter writer;
	private File inFile;

	private final String RESPONSE_GOOD = "HTTP/1.1 200 OK\r\n";
	private final String RESPONSE_NOT_FOUND = "HTTP/1.1 404 Not Found\r\n\r\n";
	private final String INTERNAL_ERROR = "HTTP/1.1 500 Internal Server Error\r\n\r\n";

	private String indexHtml = "\\index.html";

	public ClientConnection(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		String input = "";
		String header = "";
		String fileName = "";

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			while ((input = in.readLine()) != null) {
				if (input.startsWith("GET")) {
					break;
				}
			}

			fileName = fileName(input);

			if (fileName != null) {
				header = RESPONSE_GOOD;
				System.out.println(RESPONSE_GOOD + "\n" + fileName);
			} else {
				header = RESPONSE_NOT_FOUND;
				System.out.println(RESPONSE_NOT_FOUND);
			}

			inFile = new File(fileName);
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			if (!inFile.exists()) {
				header = RESPONSE_NOT_FOUND;
				writer.write(header + "404, file not found");
				writer.flush();
				writer.close();

				return;
			} else {
				writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				writer.write(INTERNAL_ERROR);
			}
			if (header.equals(RESPONSE_GOOD)) {
				FileInputStream reader = new FileInputStream(inFile);
				byte[] array = new byte[(int) inFile.length()];
				reader.read(array);
				String output = new String(array, "UTF-8");
				writer.write(output);
				writer.flush();
				writer.close();
			}

		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public String fileName(String input) {
		if (input == null) {
			return indexHtml;
		}

		String file = "";

		Matcher fileGet = Pattern.compile("GET (.*?) HTTP\\/1.1", Pattern.DOTALL | Pattern.CASE_INSENSITIVE).matcher(input);

		try {
			while (fileGet.find()) {
				file = fileGet.group(1);
			}
		} catch (Exception e) {
			System.out.println("No file found in request");
			return null;
		}

		if (file.equals("/") || file.equals("") || file == null) {
			return indexHtml;
		} else {
			return file;
		}
	}
}