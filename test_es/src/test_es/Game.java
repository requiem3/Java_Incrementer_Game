package test_es;

import java.awt.Container;

import javax.swing.JLabel;

import systems.*;

public class Game implements Runnable {
	//Game variables
	private int FPS = 60;
	
	//Systems
	private NumberSystem numSys;
	
	//GUI Variables
	private JLabel levelLabel;
	private JLabel expLabel;
	private JLabel cashLabel;
	
	public Game(Board board) {
		levelLabel = board.getLevelLabel();
		expLabel = board.getExpLabel();
		cashLabel = board.getCashLabel();

		numSys = new NumberSystem();
		levelLabel.setText("Level: " + Integer.toString(numSys.getLevel()));
		expLabel.setText("Exp: " + Integer.toString(numSys.getExp()) + "/" + Integer.toString(numSys.getExpReq()));
		cashLabel.setText("Cash: " + Integer.toString(numSys.getCash()));
	}
	
	public void run() {
		while(true) {
			
		}
	}
}
