package madn_ctrl;

import java.util.ArrayList;

public class Board 
{
	private static ArrayList<Field> fields = new ArrayList<Field>();
	
	public Board()
	{
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