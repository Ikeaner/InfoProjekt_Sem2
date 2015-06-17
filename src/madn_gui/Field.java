package madn_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Field extends JButton
{
	private int ID;
	
	public Field(int i)
	{
		ID = i;
		setSize(50, 50);
		this.setMinimumSize(this.getSize());
		this.setText(Integer.toString(ID));
		this.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println("The clicked button is: " + ID);
			}
		});
	}

	public int getID() 
	{
		return ID;
	}

	public void setID(int iD) 
	{
		ID = iD;
	}
}
