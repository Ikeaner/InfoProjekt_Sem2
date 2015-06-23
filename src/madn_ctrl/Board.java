//Die Klasse erstellt Felder und fügt diese einer ArrayList hinzu
/*
 * @author Tom Quinders 
 * @version 1.0
 */
package madn_ctrl;

import java.util.ArrayList;

public class Board 
{
	private static ArrayList<Field> fields = new ArrayList<Field>();
	
	public Board()
	{
		//erstellt 72 Felder und fügt diese der Arraylist hinzu
		for (int i = 0; i < 72; i++)
		{
			fields.add(new Field(i));
		}
	}
	
	public static Field getFieldAt(int i)
	{
		return fields.get(i);
	}
}