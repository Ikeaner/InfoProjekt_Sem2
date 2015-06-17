/*
 * @author JaceIsOverTheRainbow
 * @version 1.0
 * 
 * dice class
 * use dice.roll() to get a number between 1 and 6
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
