package madn_gui;

import javax.swing.JFrame;

import madn_app.Game;

public class View 
{
	private Dice d;
	
	public View()
	{
		JFrame mainframe = new JFrame("Mensch Ärgere Dich Nicht");
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainframe.setSize(1024, 780);
		d = new Dice();
		mainframe.add(d);
		
		mainframe.setVisible(true);
	}
	
	public void update(final Game game)
	{
		System.out.println("update");
		d.update();
	}
}
