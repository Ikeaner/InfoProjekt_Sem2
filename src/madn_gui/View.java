package madn_gui;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import madn_app.Game;

public class View 
{
	private Dice d;
	private Board b;
	
	public View()
	{
		JFrame mainframe = new JFrame("Mensch Ärgere Dich Nicht");
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainframe.setSize(1024, 780);
		mainframe.setLayout(new FlowLayout());
		d = new Dice();
		b = new Board();
		mainframe.add(d);
		mainframe.add(b);
		
		mainframe.setVisible(true);
	}
	
	public void update(final Game game)
	{
		System.out.println("update");
		d.update();
	}
}
