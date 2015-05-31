package madn_gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Startmenu extends JPanel
{
	private JButton startButton = new JButton("Start");
	private JButton optionsButton = new JButton("Optionen");
	private JButton tutorialButton = new JButton("Tutorial");
	private Dice dice;
	
	public Startmenu(madn_app.Dice d)
	{
		this.setLayout(new FlowLayout());
		dice = new Dice(d);
		
		initializeButtons();
		
		this.add(startButton);
		this.add(optionsButton);
		this.add(tutorialButton);
		this.add(dice);
	}
	
	private void initializeButtons()
	{
		startButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				callGame();
			}
		});
	}
	
	private void callGame()
	{
		Container mframe = this.getParent();
		mframe.removeAll();
		
		mframe.add(new GameField());
		
		mframe.repaint();
	}
}
