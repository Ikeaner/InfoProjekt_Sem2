package madn_gui;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Mainframe extends JFrame
{
	
	public Mainframe(madn_app.Dice d)
	{
		this.setTitle("Mensch Ärgere Dich Nicht");
		
		setSize(1024, 780);
		setVisible(true);
	}
	
	public void callGame()
	{
		this.removeAll();
		this.repaint();
	}
}
