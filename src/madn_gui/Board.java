package madn_gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Board extends JPanel
{
	private ArrayList<Field> fields = new ArrayList<Field>();
	
	public Board()
	{
		this.setSize(1024, 780);
		this.setLayout(new GridBagLayout());
		initFields();
		
		orderFields();
		
	}
	
	private void orderFields() 
	{
		for (Field f:fields)
		{
			GridBagConstraints c = new GridBagConstraints();			
			
			switch (f.getID())
			{
				case 0:
					c.gridx = 4;
					c.gridy = 10;
					break;
				case 1:
					c.gridx = 4;
					c.gridy = 9;
					break;
				case 2:
					c.gridx = 4;
					c.gridy = 8;
					break;
				case 3:
					c.gridx = 4;
					c.gridy = 7;
					break;
				case 4:
					c.gridx = 4;
					c.gridy = 6;
					break;
				case 5:
					c.gridx = 3;
					c.gridy = 6;
					break;
				case 6:
					c.gridx = 2;
					c.gridy = 6;
					break;
				case 7:
					c.gridx = 1;
					c.gridy = 6;
					break;
				case 8:
					c.gridx = 0;
					c.gridy = 6;
					break;
				case 9:
					c.gridx = 0;
					c.gridy = 5;
					break;
				case 10:
					c.gridx = 0;
					c.gridy = 4;
					break;
				case 11:
					c.gridx = 1;
					c.gridy = 4;
					break;
				case 12:
					c.gridx = 2;
					c.gridy = 4;
					break;
				case 13:
					c.gridx = 3;
					c.gridy = 4;
					break;
				case 14:
					c.gridx = 4;
					c.gridy = 4;
					break;
				case 15:
					c.gridx = 4;
					c.gridy = 3;
					break;
				case 16:
					c.gridx = 4;
					c.gridy = 2;
					break;
				case 17:
					c.gridx = 4;
					c.gridy = 1;
					break;
				case 18:
					c.gridx = 4;
					c.gridy = 0;
					break;
				case 19:
					c.gridx = 5;
					c.gridy = 0;
					break;
				case 20:
					c.gridx = 6;
					c.gridy = 0;
					break;
				case 21:
					c.gridx = 6;
					c.gridy = 1;
					break;
				case 22:
					c.gridx = 6;
					c.gridy = 2;
					break;
				case 23:
					c.gridx = 6;
					c.gridy = 3;
					break;
				case 24:
					c.gridx = 6;
					c.gridy = 4;
					break;
				case 25:
					c.gridx = 7;
					c.gridy = 4;
					break;
				case 26:
					c.gridx = 8;
					c.gridy = 4;
					break;
				case 27:
					c.gridx = 9;
					c.gridy = 4;
					break;
				case 28:
					c.gridx = 10;
					c.gridy = 4;
					break;
				case 29:
					c.gridx = 10;
					c.gridy = 5;
					break;
				case 30:
					c.gridx = 10;
					c.gridy = 6;
					break;
				case 31:
					c.gridx = 9;
					c.gridy = 6;
					break;
				case 32:
					c.gridx = 8;
					c.gridy = 6;
					break;
				case 33:
					c.gridx = 7;
					c.gridy = 6;
					break;
				case 34:
					c.gridx = 6;
					c.gridy = 6;
					break;
				case 35:
					c.gridx = 6;
					c.gridy = 7;
					break;
				case 36:
					c.gridx = 6;
					c.gridy = 8;
					break;
				case 37:
					c.gridx = 6;
					c.gridy = 9;
					break;
				case 38:
					c.gridx = 6;
					c.gridy = 10;
					break;
				case 39:
					c.gridx = 5;
					c.gridy = 10;
					break;
				case 40:
					c.gridx = 5;
					c.gridy = 9;
					break;
				case 41:
					c.gridx = 5;
					c.gridy = 8;
					break;
				case 42:
					c.gridx = 5;
					c.gridy = 7;
					break;
				case 43:
					c.gridx = 5;
					c.gridy = 6;
					break;
				case 44:
					c.gridx = 1;
					c.gridy = 5;
					break;
				case 45:
					c.gridx = 2;
					c.gridy = 5;
					break;
				case 46:
					c.gridx = 3;
					c.gridy = 5;
					break;
				case 47:
					c.gridx = 4;
					c.gridy = 5;
					break;
				case 48:
					c.gridx = 5;
					c.gridy = 1;
					break;
				case 49:
					c.gridx = 5;
					c.gridy = 2;
					break;
				case 50:
					c.gridx = 5;
					c.gridy = 3;
					break;
				case 51:
					c.gridx = 5;
					c.gridy = 4;
					break;
				case 52:
					c.gridx = 9;
					c.gridy = 5;
					break;
				case 53:
					c.gridx = 8;
					c.gridy = 5;
					break;
				case 54:
					c.gridx = 7;
					c.gridy = 5;
					break;
				case 55:
					c.gridx = 6;
					c.gridy = 5;
					break;
				case 56:
					c.gridx = 2;
					c.gridy = 9;
					break;
				case 57:
					c.gridx = 1;
					c.gridy = 9;
					break;
				case 58:
					c.gridx = 1;
					c.gridy = 8;
					break;
				case 59:
					c.gridx = 2;
					c.gridy = 8;
					break;
				case 60:
					c.gridx = 2;
					c.gridy = 2;
					break;
				case 61:
					c.gridx = 1;
					c.gridy = 2;
					break;
				case 62:
					c.gridx = 1;
					c.gridy = 1;
					break;
				case 63:
					c.gridx = 2;
					c.gridy = 1;
					break;
				case 64:
					c.gridx = 9;
					c.gridy = 2;
					break;
				case 65:
					c.gridx = 8;
					c.gridy = 2;
					break;
				case 66:
					c.gridx = 8;
					c.gridy = 1;
					break;
				case 67:
					c.gridx = 9;
					c.gridy = 1;
					break;
				case 68:
					c.gridx = 9;
					c.gridy = 9;
					break;
				case 69:
					c.gridx = 8;
					c.gridy = 9;
					break;
				case 70:
					c.gridx = 8;
					c.gridy = 8;
					break;
				case 71:
					c.gridx = 9;
					c.gridy = 8;
					break;
					
					
			}
			
			add(f,c);
		}
	}

	public void update()
	{
		
	}
	
	public void initFields()
	{
		for (int i = 0; i < 72; i++)		
		{
			fields.add(new Field(i));
		}
	}
}
