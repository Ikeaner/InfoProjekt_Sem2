package madn_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Dice extends JButton
{
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
				int numberRolled = dice.roll();
				setText(Integer.toString(numberRolled));
				dice.setDiceRolled(true);
				disableDice();
			}
		});
	}
	
	private void disableDice()
	{
		setEnabled(false);
	}
}
