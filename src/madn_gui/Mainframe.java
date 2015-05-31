package madn_gui;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Mainframe extends JFrame
{
	private madn_app.Dice dice;
	
	public Mainframe(madn_app.Dice d)
	{
		dice = d;
		this.setTitle("Mensch Ärgere Dich Nicht");
		
		setSize(1024, 780);
		setVisible(true);
		
		add(new Startmenu(dice));
	}
	
	public void callGame()
	{
		this.removeAll();
		this.repaint();
	}
}
