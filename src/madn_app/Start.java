package madn_app;

import madn_gui.Mainframe;

public class Start 
{
	public static void main(String[] args) 
	{
		Dice d = new Dice();
		Mainframe mframe = new Mainframe(d);
		Game g = new Game(4,d);
	}
}
