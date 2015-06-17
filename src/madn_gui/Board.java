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
					c.gridx = 0;
					c.gridy = 0;
				case 1:
					c.gridx = 1;
					c.gridy = 1;
				case 2:
					c.gridx = 2;
					c.gridy = 2;
				case 38:
					c.gridx = 2;
					c.gridy = 4;
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
