package window;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GUI extends JPanel
{
	private JButton next, previous, play, pause, stop;
	
	public GUI()
	{
		setLayout(null);
		setPreferredSize(new Dimension(300,200));
		
		next = new JButton("Next");
		previous = new JButton("Previous");
		play = new JButton("Play");
		
		next.setBounds(25,25,100,50);
		add(next);
		
		previous.setBounds(175,25,100,50);
		add(previous);
		
		play.setBounds(25, 100, 100, 50);
		add(play);
	}
}
