import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Thomas Lewis
 * Christopher Crick
 * Computer Science II
 * September 28, 2016
 * MineFrame.java
 * 	Set up the size of the frame and whatnot, add a reset button,
 * 	and the rest is handled elswhere.
 *
 * 	UPDATE:  Now including a menu!
 */
public class MineFrame extends JFrame {
	public MineFrame() {
		MinePanel field = new MinePanel();
		setSize(650, 700);
		setLayout(new BorderLayout());

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenuItem newGame = new JMenuItem("New");
		JMenuItem saveGame = new JMenuItem("Save");
		JMenuItem openGame = new JMenuItem("Open");
		JMenuItem quitGame = new JMenuItem("Quit");

		menu.add(newGame);
		menu.add(openGame);
		menu.add(saveGame);
		menu.add(quitGame);
		menuBar.add(menu);

		newGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				field.setupSize(true);
				field.setupGame(true);
				field.updateUI();
			}
		});

		quitGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		saveGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				field.saveFile(JOptionPane.showInputDialog("File Name", JOptionPane.PLAIN_MESSAGE));
			}
		});

		openGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				field.openFile(JOptionPane.showInputDialog("File Name", JOptionPane.PLAIN_MESSAGE));
				field.setupSize(false);
				field.setupGame(false);
				field.updateUI();
			}
		});

		add(menuBar, BorderLayout.NORTH);
		add(field, BorderLayout.CENTER);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
