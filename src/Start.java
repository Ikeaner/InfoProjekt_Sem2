/*	
 * 	Die Start-Klasse startet das Spiel. Sie erstellt ein Instanz der view und
 * 	übergibt diese einer neuen Instanz des Games.
 * 
 * 	@author Tom Quinders
 *  @version 1.0.0
 */
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