import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Thomas Lewis
 * Computer Science II - CS2133
 * Christopher Crick
 * BrowserConnect.java
 * 	This holds all the information for setting up, connecting to,
 * 	and reading from any non HTTPS page.
 */
public class BrowserConnect {
	URL url;
	String file;
	String host;
	String rawTextArea = "";
	String cleanedTextArea = "";
	String title = "";

	public String BrowserConnect(String entry) {
		String line;
		try {
			formatURL(entry);
			Socket socket = new Socket(host, 80);
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			out.print("GET " + file + " HTTP:?1.1\r\n");
			out.print("host: " + host + "\r\n\r\n");
			out.flush();
			BufferedReader in =
					new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while ((line = in.readLine()) != null) {
				rawTextArea += line + "\n";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		getPage();
		pullTitle();
		return title + "\n\n" + cleanedTextArea;
	}

	public void formatURL(String entry) {
		try {
			if (!entry.startsWith("http://")) {
				entry = "http://" + entry;
			}
			url = new URL(entry);
			host = url.getHost();
			file = ((file = url.getFile().trim()).equals("")) ? "/" : file;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getPage() {
		//Use the Matcher and Pattern tools to find anything between the body tags
		Matcher matcher = Pattern.compile("<body[^>]*>(.*?)</body>", Pattern.DOTALL | Pattern.CASE_INSENSITIVE).matcher(rawTextArea);
		try {
			while (matcher.find()) {
				cleanedTextArea = matcher.group(1);
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}


		//Remove the HTML tags to make it look ugly but less ugly than raw html
		cleanedTextArea = cleanedTextArea.replaceAll("<script[^>]*>(.*?)</script>", "");
		cleanedTextArea = cleanedTextArea.replaceAll("<select[^>]*>(.*?)</select>", "");
		cleanedTextArea = cleanedTextArea.replaceAll("<input[^>]*>(.*?)</input>", "");
		cleanedTextArea = cleanedTextArea.replaceAll("<[^>]*>", "");
		cleanedTextArea = cleanedTextArea.replaceAll("&nbsp;", " ");
		cleanedTextArea = cleanedTextArea.replaceAll("-[^>]*>", "");
		cleanedTextArea = cleanedTextArea.replaceAll("  +", "\n");
		cleanedTextArea = cleanedTextArea.trim();
	}

	public void pullTitle() {
		String title = "Untitled";
		//Use the Matcher and Pattern tools to find anything between the title tags
		Matcher matcher = Pattern.compile("<title[^>]*>(.*?)</title>", Pattern.DOTALL | Pattern.CASE_INSENSITIVE).matcher(rawTextArea);

		try {
			while (matcher.find()) {
				title = matcher.group(1);
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		this.title = title;
	}

	public String getURL(){
		return url.toString();
	}
}
