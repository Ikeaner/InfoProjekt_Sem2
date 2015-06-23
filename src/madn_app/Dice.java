/*
 * Die Dice Klasse in madn_app gibt durch die roll() Methode eine zufällige Nummer zwischen 1 und 6 zurück
 * @author JaceIsOverTheRainbow
 * @version 1.0
 */
package madn_app;

//returns a random number between 1 and 6
public class Dice 
{	
	public static void roll()
	{
		int zahl = (int)(6*Math.random()+1);
		madn_ctrl.Dice.setNumberRolled(zahl);
		madn_ctrl.Dice.setDiceRolled(true);
	}
}
