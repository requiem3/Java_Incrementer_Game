package test_es;

import java.awt.Container;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

import systems.*;

//TODO:
//TODO: Handle multiple level clicks
//TODO:

public class Game implements Runnable {
	//Game variables
	private int FPS = 60;
	
	//Systems
	private NumberSystem numSys;
	private ArmySystem armSys;
	private ZoneSystem zonSys;
	private AchievementSystem achSys;
	
	//GUI Variables
	private Board mBoard;
	private JLabel levelLabel;
	private JLabel expLabel;
	private JLabel cashLabel;
	private JLabel chickCostLabel;
	private JLabel chickCountLabel;
	private JProgressBar pBar;
	
	//Threading
    private BlockingQueue<Integer> queueZoneNum = new LinkedBlockingQueue<Integer>();
    private BlockingQueue<Integer> queueLevelNum = new LinkedBlockingQueue<Integer>();
    private BlockingQueue<Integer> queueBuyNum = new LinkedBlockingQueue<Integer>();
	
	public Game(Board board, BlockingQueue<Integer> qZoneNum, BlockingQueue<Integer> qLevelNum, BlockingQueue<Integer> qBuyNum) {
		mBoard = board;
		queueBuyNum = qBuyNum;
		queueZoneNum = qZoneNum;
		queueLevelNum = qLevelNum;
		armSys = new ArmySystem();
		zonSys = new ZoneSystem();
		numSys = new NumberSystem();
		
		levelLabel = board.getLevelLabel();
		expLabel = board.getExpLabel();
		cashLabel = board.getCashLabel();
		chickCostLabel = board.getChickenCostLabel();
		chickCountLabel = board.getChickenCountLabel();
		pBar = board.getProgressBar();
		
		updateGUI();
	}
	
	public void run() {
		int zoneNum = 0; 
		int levelNum = 0;
		int pHP, pDPS;
		while(true) {
			checkBuy();
			if(queueLevelNum.size() != 0) {
				try {
					zoneNum = queueZoneNum.take();
					levelNum = queueLevelNum.take();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				pDPS = armSys.calculateDPS();
				pHP = zonSys.zones[zoneNum-1][0];
				pBar.setMaximum(pHP);
				
				while(pHP >= 0) {
					if(queueLevelNum.size() != 0) {
						if(queueLevelNum.poll() == levelNum) {
							queueLevelNum.clear();
						}
					}
					checkBuy();
					System.out.println(pHP);
					pBar.setValue(pBar.getMaximum() - pHP);
					try {
						Thread.sleep(200); //THIS IS UGLY AS FUCK HOLY SHIT
						checkBuy();
						Thread.sleep(200);
						checkBuy();
						Thread.sleep(200);
						checkBuy();
						Thread.sleep(200);
						checkBuy();
						Thread.sleep(200);
						checkBuy();
					} catch (InterruptedException e) {e.printStackTrace();}
					pHP -= pDPS;
				}
				numSys.addExp(zonSys.zones[zoneNum-1][2]);
				numSys.addCash(zonSys.zones[zoneNum-1][1]);
				updateGUI();
			}
		}
	}
	
	public void updateGUI() {
		levelLabel.setText("Level: " + Integer.toString(numSys.getLevel()));
		expLabel.setText("Exp: " + Integer.toString(numSys.getExp()) + "/" + Integer.toString(numSys.getExpReq()));
		cashLabel.setText("Cash: " + Integer.toString(numSys.getCash()));
		chickCostLabel.setText("Count: " + Integer.toString(armSys.army[0][0]));
		chickCountLabel.setText("Cost: " + Integer.toString(armSys.army[0][2]));
	}
	
	public void checkBuy() {
		if(queueBuyNum.size() != 0) {
			try {
				armSys.army[queueBuyNum.take() - 1][0] ++;
			} catch (InterruptedException e) {e.printStackTrace();}
			updateGUI();
		}
	}
}
