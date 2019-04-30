import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class MainWindow extends JFrame {
	Puzzle puzzle = new Puzzle();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		getContentPane().setLayout(null);
		MainWindow view = this;
		
		JPanel panel = new PuzzleSpace(puzzle);
		panel.setBounds(50, 50, 500, 500);
		getContentPane().add(panel);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel.addMouseListener(new MouseListener() {
			@Override
		    public void mouseClicked(MouseEvent event) {
				new SelectBlockController(puzzle, view).select(event);
		    }

		    @Override
		    public void mouseEntered(MouseEvent arg0) {}

		    @Override
		    public void mouseExited(MouseEvent arg0) {}

		    @Override
		    public void mousePressed(MouseEvent arg0) {}

		    @Override
		    public void mouseReleased(MouseEvent arg0) {}
		});
	}
}
