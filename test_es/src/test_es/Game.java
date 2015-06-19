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
	}
	
	public void run() {
		return(0);
	}
}
