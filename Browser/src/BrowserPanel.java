import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Thomas Lewis
 * Computer Science II - CS2133
 * Christopher Crick
 * BrowserPanel.java
 * 	Set up the page for the actual browser
 */
public class BrowserPanel extends JPanel{
	JTextField url = new JTextField();
	JTextArea text = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(text);
	BrowserConnect browser = new BrowserConnect();

	public BrowserPanel(){
		this.setLayout(new BorderLayout());
		text.setText("Please enter a URL\nNote: HTTPS addresses will not work because " +
				"security is hard.");
		text.setEditable(false);
		add(url, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);

		url.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String newText = browser.BrowserConnect(url.getText());
				text.setText(newText);
				url.setText(browser.getURL());
			}
		});
	}
}
