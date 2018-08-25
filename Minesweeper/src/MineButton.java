import javax.swing.*;
import java.awt.*;

/**
 * Thomas Lewis
 * Christopher Crick
 * Computer Science II
 * September 28, 2016
 * MineButton.java
 * 	Hold the information for each button so that I can get
 * 	and set the data for each of them here.
 */
public class MineButton extends JButton {
	private int col;
	private int row;
	private int bombsTouching;

	//An Enum for pressed states rather than using integers
	public enum State {
		FLAG, QUESTION, PRESSED, NONE
	}

	private State state;

	public MineButton(int x, int y, int b) {
		super("");
		state = State.NONE;
		this.row = x;
		this.col = y;

		setBackground(new Color(193, 193, 193));
		setFont(new Font("Times New Romans", Font.BOLD, 25));

		bombsTouching = b;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public boolean isBomb() {
		return bombsTouching == -1;
	}

	public int getBombsTouching() {
		return bombsTouching;
	}

	public int getCol() {
		return this.col;
	}

	public int getRow() {
		return this.row;
	}
}
