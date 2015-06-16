package test_es;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Scrollable;
import javax.swing.SwingUtilities;

public class Board {
    public static void addComponentsToPane(Container pane) {
        pane.setLayout(new GridLayout(1, 0));

        JPanel left = new JPanel();
        pane.add(left);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));

        JPanel leftTop = new JPanel(new GridBagLayout());
		leftTop.setBackground(Color.black);
		
		JScrollPane scrollPane = new JScrollPane(leftTop);
		scrollPane.setPreferredSize(new Dimension(266,300));
		left.add(scrollPane);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.insets = new Insets(5, 10, 5, 10);
		JButton jb = new JButton();
		jb.setPreferredSize(new Dimension(250, 50));
		leftTop.add(jb, gbc);
		
		JButton jb1 = new JButton();
		jb1.setPreferredSize(new Dimension(250, 50));
		leftTop.add(jb1, gbc);
		
		JButton jb2 = new JButton();
		jb2.setPreferredSize(new Dimension(250, 50));
		leftTop.add(jb2, gbc);
		
		JButton jb3 = new JButton();
		jb3.setPreferredSize(new Dimension(250, 50));
		leftTop.add(jb3, gbc);
		
		JButton jb4 = new JButton();
		jb4.setPreferredSize(new Dimension(250, 50));
		leftTop.add(jb4, gbc);
		
		JButton jb5 = new JButton();
		jb5.setPreferredSize(new Dimension(250, 50));
		leftTop.add(jb5, gbc);
		
		JButton jb6 = new JButton();
		jb6.setPreferredSize(new Dimension(250, 50));
		leftTop.add(jb6, gbc);

	    JPanel leftBottom = new JPanel();
	    leftBottom.setPreferredSize(new Dimension(266, 300));
	    leftBottom.setBackground(Color.red);
	    left.add(leftBottom);
	
	    JPanel middle = new JPanel();
	    pane.add(middle);
	    middle.setLayout(new BoxLayout(middle, BoxLayout.Y_AXIS));
	
	    JPanel middleTop = new JPanel();
	    middleTop.setPreferredSize(new Dimension(266, 200));
	    middleTop.setBackground(Color.green);
	    middle.add(middleTop);
	
	    JPanel middleBottom = new JPanel();
	    middleBottom.setPreferredSize(new Dimension(266, 400));
	    middleBottom.setBackground(Color.yellow);
	    middle.add(middleBottom);
	
	    JPanel right = new JPanel();
	    right.setPreferredSize(new Dimension(266, 600));
	    right.setBackground(Color.blue);
	
	    pane.add(right);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("GridBagLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponentsToPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}