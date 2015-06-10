package madn_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Dice extends JButton
{
	private int numberRolled;
	
	public Dice(madn_app.Dice d)
	{
		madn_app.Dice dice = d;
		this.setEnabled(true);
		this.setText("1");
		this.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				numberRolled = dice.roll();
				setText(Integer.toString(numberRolled));
				save();
				dice.setDiceRolled(true);
				disableDice();
			}
		});
	}
	
	private void disableDice()
	{
		setEnabled(false);
	}
	
	public void save()
	{
		madn_ctrl.Dice.setNumberRolled(numberRolled);
	}
}
