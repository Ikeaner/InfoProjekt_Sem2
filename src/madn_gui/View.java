package madn_gui;

import javax.swing.JFrame;

import madn_app.Game;

public class View 
{
	private Dice d;
	
	public View()
	{
		JFrame mainframe = new JFrame("MADN");
		
		mainframe.setSize(500,500);
		d = new Dice();
		mainframe.add(d);
		
		mainframe.setVisible(true);
	}
	
	public void update(final Game game)
	{
		d.update();
	}
}
