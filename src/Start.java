import madn_app.Game;
import madn_gui.View;

public class Start 
{
	public static void main(String[] args) 
	{
		View view = new View();
        new Game(view);
	}
}