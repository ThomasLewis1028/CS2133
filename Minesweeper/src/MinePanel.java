import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 * Thomas Lewis
 * Christopher Crick
 * Computer Science II
 * September 28, 2016
 * MinePanel.java
 * Here's the big one, this guy does all the cool stuff.  He sets
 * up your values and does.
 *
 * UPDATE:  I couldn't quite get it to clear all tiles, it seems
 * to miss a few here and there, but it's mostly cool.  I also
 * changed setupSize and setupGame to have specific rules for
 * when creating a new game or loading an old one.  Let's me
 * reuse a lot of code.
 */
public class MinePanel extends JPanel {
	private int rows;
	private int columns;
	private int numTiles = rows * columns;
	private int numBombs = (int) (numTiles * .1);
	private int[][][] tileArray;
	private int bombsLeft = numBombs;
	private int tilesLeft = numTiles - numBombs;
	private JLabel minesLabel;
	private JLabel smileyFace;
	private JPanel mineField = new JPanel();
	private JPanel infoBar = new JPanel();

	public MinePanel() {
		setupSize(true);
		setupGame(true);

		add(infoBar, BorderLayout.PAGE_START);
		add(mineField, BorderLayout.CENTER);
	}

	public void makeMines() {
		int totalBombs = 0;
		while (totalBombs < numBombs) {
			int bombX = (int) Math.floor(Math.random() * rows);
			int bombY = (int) Math.floor(Math.random() * columns);

			if (tileArray[bombX][bombY][0] != -1) {
				tileArray[bombX][bombY][0] = -1;
				totalBombs++;
			}
		}
	}

	public void calcBombs() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (tileArray[i][j][0] == -1) {
				} else {
					if (checkBomb(i - 1, j)) {
						tileArray[i][j][0]++;  //left
					}
					if (checkBomb(i - 1, j - 1)) {
						tileArray[i][j][0]++;  //top left
					}
					if (checkBomb(i, j - 1)) {
						tileArray[i][j][0]++;  //top
					}
					if (checkBomb(i + 1, j - 1)) {
						tileArray[i][j][0]++;  //top right
					}
					if (checkBomb(i + 1, j)) {
						tileArray[i][j][0]++;  //right
					}
					if (checkBomb(i + 1, j + 1)) {
						tileArray[i][j][0]++;  //bottom right
					}
					if (checkBomb(i, j + 1)) {
						tileArray[i][j][0]++;  //bottom
					}
					if (checkBomb(i - 1, j + 1)) {
						tileArray[i][j][0]++;  //bottom left
					}
				}
			}
		}
	}

	public void clearSpaces(int x, int y) {
		if (x < 0 || y < 0 || x >= rows || y >= columns) {
			setupGame(false);
		}

		if (checkEmpty(x - 1, y)) {
			tileArray[x][y][1] = 1;  //left
			clearSpaces(x - 1, y);
		}
		if (checkEmpty(x - 1, y - 1)) {
			tileArray[x][y][1] = 1; //top left
			clearSpaces(x - 1, y - 1);
		}
		if (checkEmpty(x, y - 1)) {
			tileArray[x][y][1] = 1;  //top
			clearSpaces(x, y - 1);
		}
		if (checkEmpty(x + 1, y - 1)) {
			tileArray[x][y][1] = 1;  //top right
			clearSpaces(x + 1, y - 1);
		}
		if (checkEmpty(x + 1, y)) {
			tileArray[x][y][1] = 1;  //right
			clearSpaces(x + 1, y);
		}
		if (checkEmpty(x + 1, y + 1)) {
			tileArray[x][y][1] = 1;  //bottom right
			clearSpaces(x + 1, y + 1);
		}
		if (checkEmpty(x, y + 1)) {
			tileArray[x][y][1] = 1;  //bottom
			clearSpaces(x, y + 1);
		}
		if (checkEmpty(x - 1, y + 1)) {
			tileArray[x][y][1] = 1;  //bottom left
			clearSpaces(x - 1, y + 1);
		}

		setupGame(false);
	}


	public void setupGame(boolean isNew) {
		mineField.removeAll();
		smileyFace.setText(":)");

		if (isNew) {
			tileArray = new int[rows][columns][2];
			makeMines();
			calcBombs();
		}

		setTileCount();

		for (int i = 0; i < numTiles; i++) {
			MineButton button;
			int col = i % rows;
			int row = i / rows;

			if (tileArray[col][row][0] == -1) {
				button = new MineButton(col, row, -1);
			} else {
				button = new MineButton(col, row, tileArray[col][row][0]);
			}

			if (tileArray[col][row][1] == 1) {
				if (button.getBombsTouching() == 0) {
					//Check if it's a 0, make it disappear
					button.setBackground(new Color(235, 235, 235));

				} else {
					//Set the text to be how many bombs are touching it
					button.setText(String.valueOf(button.getBombsTouching()));
					button.setBackground(new Color(235, 235, 235));
				}
				button.setState(MineButton.State.PRESSED);
			} else if (tileArray[col][row][1] == 2) {
				button.setText("F");
				button.setForeground(Color.RED);
				button.setState(MineButton.State.FLAG);
			} else if (tileArray[col][row][1] == 3) {
				button.setText("?");
				button.setForeground(Color.BLUE);
				button.setState(MineButton.State.QUESTION);
			} else {
				button.setForeground(Color.BLACK);
				button.setState(MineButton.State.NONE);
			}

			button.setName(col + " " + row);
			mineField.add(button);

			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					MineButton button = (MineButton) e.getSource();
					if (SwingUtilities.isRightMouseButton(e)) {
						if (button.getState() == MineButton.State.NONE) {
							button.setText("F");
							button.setForeground(Color.RED);
							button.setState(MineButton.State.FLAG);
							tileArray[button.getRow()][button.getCol()][1] = 2;
						} else if (button.getState() == MineButton.State.FLAG) {
							button.setText("?");
							button.setForeground(Color.BLUE);
							button.setState(MineButton.State.QUESTION);
							tileArray[button.getRow()][button.getCol()][1] = 3;
						} else if (button.getState() == MineButton.State.QUESTION) {
							button.setText("");
							button.setForeground(Color.BLACK);
							button.setState(MineButton.State.NONE);
							tileArray[button.getRow()][button.getCol()][1] = 0;
						}
					}
					setTileCount();
				}
			});
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					MineButton button = (MineButton) e.getSource();
					if (button.getState() == MineButton.State.NONE) {
						button.setState(MineButton.State.PRESSED);
						tileArray[button.getRow()][button.getCol()][1] = 1;
						//Check if it's a bomb
						if (button.getBombsTouching() == -1) {
							for (Component component : mineField.getComponents()) {
								if (component instanceof MineButton) {
									MineButton comp = (MineButton) component;
									if (comp.isBomb()) {
										comp.setText("X");
										comp.setForeground(Color.black);
										comp.setBackground(Color.RED);
									}
									smileyFace.setText(":(");
								}
							}
							int restart = JOptionPane.showConfirmDialog(null, "Restart Game?", "You Lost!",
									JOptionPane.YES_NO_OPTION);
							if (restart == JOptionPane.YES_OPTION) {
								setupGame(true);
							} else {
								System.exit(0);
							}
						} else if (button.getBombsTouching() == 0) {
							//Check if it's a 0, make it disappear
							button.setBackground(new Color(235, 235, 235));
							clearSpaces(button.getRow(), button.getCol());

						} else {
							//Set the text to be how many bombs are touching it
							button.setText(String.valueOf(button.getBombsTouching()));
							button.setBackground(new Color(235, 235, 235));
						}
					}
					setTileCount();
					if (tilesLeft == 0) {
						int restart = JOptionPane.showConfirmDialog(null, "Restart Game?", "You Won!",
								JOptionPane.YES_NO_OPTION);
						if (restart == JOptionPane.YES_OPTION) {
							setupGame(true);
						} else {
							System.exit(0);
						}
					}
					mineField.updateUI();
				}
			});
		}
	}

	private void setTileCount() {
		tilesLeft = numTiles - numBombs;
		bombsLeft = numBombs;
		for (Component component : mineField.getComponents()) {
			if (component instanceof MineButton) {
				MineButton comp = (MineButton) component;
				if (comp.getState() == MineButton.State.PRESSED) {
					tilesLeft--;
				} else if (comp.getState() == MineButton.State.FLAG) {
					bombsLeft--;
				}
			}
		}
		if (bombsLeft == 1) {
			minesLabel.setText("[" + bombsLeft + "] MINE");
		} else {
			minesLabel.setText("[" + bombsLeft + "] MINES");
		}
	}

	private boolean checkBomb(int x, int y) {
		if (x < 0 || y < 0) {
			return false;
		} else if (x >= rows || y >= columns) {
			return false;
		} else {
			if (tileArray[x][y][0] == -1) {
				return true;
			} else {
				return false;
			}
		}
	}

	private boolean checkEmpty(int x, int y) {
		if (x < 0 || y < 0) {
			return false;
		} else if (x >= rows || y >= columns) {
			return false;
		} else if (tileArray[x][y][1] > 0) {
			return false;
		} else if (tileArray[x][y][0] > 0) {
			tileArray[x][y][1] = 1;
			return false;
		} else if (tileArray[x][y][0] == 0) {
			return true;
		} else {
			return false;
		}
	}


	public void setupSize(boolean isNew) {
		mineField.removeAll();
		infoBar.removeAll();
		if (isNew) {
			columns = Integer.parseInt(JOptionPane.showInputDialog("Set size", JOptionPane.PLAIN_MESSAGE));
			rows = columns;
		}
		numTiles = rows * columns;
		numBombs = (int) (numTiles * .1);
		bombsLeft = numBombs;
		tilesLeft = numTiles - numBombs;

		this.setLayout(new BorderLayout());
		mineField.setLayout(new GridLayout(rows, columns, 5, 5));
		minesLabel = new JLabel("[" + bombsLeft + "] MINES");
		smileyFace = new JLabel(":)");
		minesLabel.setFont(new Font("Times New Romans", Font.BOLD, 50));
		smileyFace.setFont(new Font("Times New Romans", Font.BOLD, 50));
		infoBar.setLayout(new GridLayout(1, 2));

		infoBar.add(minesLabel);
		infoBar.add(smileyFace);
		updateUI();
	}

	public void saveFile(String fileName) {
		if (!fileName.endsWith(".txt")) {
			fileName += ".txt";
		}
		StringBuilder toFile = new StringBuilder("");

		toFile.append(rows + "\n");
		toFile.append(numBombs + "\n");
		toFile.append(tilesLeft + "\n");
		toFile.append(bombsLeft + "\n");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				toFile.append(tileArray[i][j][0] + " ");
				toFile.append(tileArray[i][j][1] + "\n");
			}
		}

		try {
			PrintWriter writer = new PrintWriter(fileName);
			writer.print(toFile);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void openFile(String fileName) {
		if (!fileName.endsWith(".txt")) {
			fileName += ".txt";
		}

		int count = 4;
		String line;
		String info = "";
		String[] infoArr;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));

			while ((line = reader.readLine()) != null) {
				info += line + "\n";
			}

			infoArr = info.split("\n");

			rows = columns = Integer.valueOf(infoArr[0]);
			numBombs = Integer.valueOf(infoArr[1]);
			tilesLeft = Integer.valueOf(infoArr[2]);
			bombsLeft = Integer.valueOf(infoArr[3]);
			tileArray = new int[rows][columns][2];
			numTiles = rows * columns;

			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					String[] inArr = infoArr[count].split(" ");
					String bombCount = inArr[0];
					String btnState = inArr[1];
					tileArray[i][j][0] = Integer.valueOf(bombCount);
					tileArray[i][j][1] = Integer.valueOf(btnState);
					count++;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(new JFrame(), fileName + " not found!");
			openFile(JOptionPane.showInputDialog("File Name", JOptionPane.PLAIN_MESSAGE));
		}
	}
}
