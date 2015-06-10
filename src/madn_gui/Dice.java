package madn_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Dice extends JButton
{
	private int numberRolled;
	
	public Dice()
	{
		enableDice();
		this.setText("NULL");
		this.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				numberRolled = madn_app.Dice.roll();
				setText(Integer.toString(numberRolled));
				save();
				update();
			}
		});
	}
	
	public void save()
	{
		madn_ctrl.Dice.setNumberRolled(numberRolled);
		madn_ctrl.Dice.setDiceRolled(true);
	}
	
	public void update()
	{
		if (madn_ctrl.Dice.isDiceRolled())
		{
			disableDice();
		}
		else
		{
			enableDice();
		}
	}
	
	public void enableDice()
	{
		setEnabled(true);
	}
	
	private void disableDice()
	{
		setEnabled(false);
	}
}
