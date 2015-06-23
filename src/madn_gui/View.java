/*
 * @author Tom Quinders, Anna-Lena Graevingholt
 * @version 1.0
 */
package madn_gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import madn_app.Game;

public class View 
{
	private JFrame mainframe;
	
	private Dice d;
	private Board b;
	private JLabel l;
	
	public View()
	{
		mainframe = new JFrame("Mensch Ärgere Dich Nicht");
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.setLayout(new GridBagLayout());
		d = new Dice();
		b = new Board();
		l = new JLabel("NULL");
		l.setSize(50,100);
		l.setPreferredSize(l.getSize());
		addComp(d, 0, 0);
		addComp(b, 1, 0, 2, 2);
		addComp(l, 0, 1);
		mainframe.pack();
		mainframe.setResizable(false);
		
		mainframe.setVisible(true);
	}
	
	public void update (Game game)
	{
		System.out.println("update");
		d.update();
		b.update(game);
		if(game.getGameOver() == true)
		{
			l.setText(game.getCurrentPlayer().getName() + " hat gewonnen!");
		}
		else
		{
			l.setText(game.getCurrentPlayer().getName());
		}
		switch(game.getCurrentPlayer().getID())
		{
		case 0: 
			l.setForeground(Color.GREEN);
			break;
		case 1:
			l.setForeground(Color.RED);
			break;
		case 2:
			l.setForeground(Color.YELLOW);
			break;
		case 3:
			l.setForeground(new Color(255,0,255));
			break;
		}
	}
	
	private void addComp(Component comp, int x, int y)
	{
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = x;
		c.gridy = y;
		mainframe.add(comp,c);
	}
	
	private void addComp(Component comp, int x, int y, int h, int w)
	{
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = x;
		c.gridy = y;
		c.gridwidth = w;
		c.gridheight = h;
		mainframe.add(comp,c);
	}
}
