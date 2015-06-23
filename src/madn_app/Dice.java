/*
 * Die Dice Klasse in madn_app gibt durch die roll() Methode eine zufällige Nummer zwischen 1 und 6 zurück
 * @author Jaqueline Timmermann
 * @version 1.0
 */
package madn_app;

//gibt eine zufällige Zahl zwischen 1 und 6 zurück
public class Dice 
{	
	public static void roll()
	{
		int zahl = (int)(6*Math.random()+1);
		madn_ctrl.Dice.setNumberRolled(zahl);
		madn_ctrl.Dice.setDiceRolled(true);
	}
}
