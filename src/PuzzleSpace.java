

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class PuzzleSpace extends JPanel {
	Puzzle puzzle;
	/**
	 * Create the panel.
	 */
	JLabel tile[][] = new JLabel[5][5];
	Icon[] icon = new Icon[25];
	public PuzzleSpace(Puzzle puzzle) {
		this.puzzle = puzzle;
		setSize(500, 500);
        setVisible(true);
		setBackground(Color.gray);
		setLayout(new GridLayout(5, 5, 0, 0));
		for(int i = 0; i<25; i++) {
			int n = i+1;
			icon[i] = new ImageIcon(getClass().getResource("/"+n+".png"));
		}

		for(int i = 0; i<5; i++) {
			for(int j = 0; j<5; j++) {
				tile[i][j] = new JLabel(icon[puzzle.board[i][j] - 1]);
				add(tile[i][j]);
			}
		}
	}
	
    @Override
    public void paint(Graphics g) 
    {
    	//puzzle = new Puzzle();
    	System.out.println("updating view");
		for(int i = 0; i<5; i++) {
			for(int j = 0; j<5; j++) {
				tile[i][j].setIcon(icon[puzzle.board[i][j] - 1]); //= new JLabel(icon[puzzle.board[i][j] - 1]);
		    	//System.out.println("updating view " + i*5+j);
				//add(tile[i][j]);
			}
		}
    	super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
		if(puzzle.selectX != -1) {
			g2.setColor(new Color(0,0,0));
			g2.drawRect(puzzle.selectX*100, puzzle.selectY*100, 100, 100);
			g2.setColor(new Color(255,255,255));
			g2.drawRect(puzzle.selectX*100 - 3, puzzle.selectY*100 -3, 106, 106);
		}
    	
    	//System.out.println("updating view done");
    }


}
