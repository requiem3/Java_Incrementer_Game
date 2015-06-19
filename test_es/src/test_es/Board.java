package test_es;

import java.awt.Color;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Scrollable;
import javax.swing.SwingUtilities;

import test_es.Game;

public class Board {
	private ImageIcon ii;
	private Game game;
	private JLabel levelLabel;
	private JLabel expLabel;
	private JLabel cashLabel;
	private Thread gameThread;
	
	public Board() {
		createAndShowGUI();
	}
	
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Board b = new Board();
            }
        });
    }
    
    public void addComponentsToPane(Container pane) {
        pane.setLayout(new GridLayout(1, 0));
        pane.setPreferredSize(new Dimension(1000,600));

        JPanel left = new JPanel();
        pane.add(left);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));

        JPanel leftTop = new JPanel(new GridBagLayout());
		
		JScrollPane scrollPane = new JScrollPane(leftTop);
		scrollPane.setPreferredSize(new Dimension(333,300));
		left.add(scrollPane);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.insets = new Insets(5, 10, 5, 10);
		
		JLabel zoneLabel = new JLabel();
		zoneLabel.setText("Zones");
		leftTop.add(zoneLabel, gbc);
		
		JButton jb = new JButton();
		jb.setPreferredSize(new Dimension(200, 50));
		jb.setIcon(ii);
		leftTop.add(jb, gbc);
		
		JButton jb1 = new JButton();
		jb1.setPreferredSize(new Dimension(200, 50));
		jb1.setIcon(ii);
		leftTop.add(jb1, gbc);
		
		JButton jb2 = new JButton();
		jb2.setPreferredSize(new Dimension(200, 50));
		jb2.setIcon(ii);
		leftTop.add(jb2, gbc);
		
		JButton jb3 = new JButton();
		jb3.setPreferredSize(new Dimension(200, 50));
		jb3.setIcon(ii);
		leftTop.add(jb3, gbc);
		
		JButton jb4 = new JButton();
		jb4.setPreferredSize(new Dimension(200, 50));
		jb4.setIcon(ii);
		leftTop.add(jb4, gbc);
		
		JButton jb5 = new JButton();
		jb5.setPreferredSize(new Dimension(200, 50));
		jb5.setIcon(ii);
		leftTop.add(jb5, gbc);
		
		JButton jb6 = new JButton();
		jb6.setPreferredSize(new Dimension(200, 50));
		jb6.setIcon(ii);
		leftTop.add(jb6, gbc);

	    JPanel leftBottom = new JPanel(new GridBagLayout());
	    leftBottom.setPreferredSize(new Dimension(333, 300));
	    left.add(leftBottom);
	    
	    GridBagConstraints c = new GridBagConstraints();
	    c.anchor = GridBagConstraints.FIRST_LINE_START;
	    
	    JLabel jl1 = new JLabel();
	    jl1.setText("Levels");
	    c.gridx = 0;
	    c.gridy = 0;
	    leftBottom.add(jl1, c);
	    
		JButton jb7 = new JButton();
		jb7.setPreferredSize(new Dimension(50, 50));
		c.gridx = 0;
	    c.gridy = 1;
		leftBottom.add(jb7, c);
		
		JButton jb8 = new JButton();
		jb8.setPreferredSize(new Dimension(50, 50));
		c.gridx = 1;
	    c.gridy = 1;
		leftBottom.add(jb8, c);
	
	    JPanel middle = new JPanel();
	    pane.add(middle);
	    middle.setLayout(new BoxLayout(middle, BoxLayout.Y_AXIS));
	
	    JPanel middleTop = new JPanel();
	    middleTop.setPreferredSize(new Dimension(333, 200));
	    middleTop.setLayout(new BoxLayout(middleTop, BoxLayout.Y_AXIS));
	    middle.add(middleTop);
	    
	    JLabel jl2 = new JLabel();
	    jl2.setText("Scientist");
	    middleTop.add(jl2);
	    
	    levelLabel = new JLabel();
	    levelLabel.setText("Level: ");
	    middleTop.add(levelLabel);
	    
	    JLabel jl4 = new JLabel();
	    jl4.setText("Exp: ");
	    middleTop.add(jl4);
	    
	    JLabel jl5 = new JLabel();
	    jl5.setText("Cash: ");
	    middleTop.add(jl5);
	
	    JPanel middleBottom = new JPanel();
	    middleBottom.setPreferredSize(new Dimension(333, 400));
	    middleBottom.setBackground(Color.yellow);
	    middle.add(middleBottom);
	
	    JPanel right = new JPanel();
	    right.setPreferredSize(new Dimension(333,600));
	    right.setBackground(Color.blue);
	
	    pane.add(right);
	    
    }

    private void createAndShowGUI() {
    	loadImages();
        JFrame frame = new JFrame("GridBagLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponentsToPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        
        gameThread = new Thread(new Game(this));
    	gameThread.start();	
    }
	
	private void loadImages() {
		ii = new ImageIcon("nhButton.png");
	}
	
	public JLabel getLevelLabel() {
		return(levelLabel);
	}
	
	public JLabel getExpLabel() {
		return(expLabel);
	}
	
	public JLabel getCashLabel() {
		return(cashLabel);
	}
}
