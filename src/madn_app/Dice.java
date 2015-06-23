/*
 * Die Dice Klasse in madn_app gibt durch die roll() Methode eine zuf�llige Nummer zwischen 1 und 6 zur�ck
 * @author Jaqueline Timmermann
 * @version 1.0
 */
package madn_app;

//gibt eine zuf�llige Zahl zwischen 1 und 6 zur�ck
public class Dice 
{	
	public static void roll()
	{
		int zahl = (int)(6*Math.random()+1);
		madn_ctrl.Dice.setNumberRolled(zahl);
		madn_ctrl.Dice.setDiceRolled(true);
	}
}
