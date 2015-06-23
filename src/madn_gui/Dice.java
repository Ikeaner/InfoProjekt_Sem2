/*
 * @author Tom Quinders | Ikeaner
 * @version 0.3.1
 */

package madn_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Dice extends JButton
{
	ImageIcon i1 = new ImageIcon("src\\madn_images\\dice\\dice1.png");
	ImageIcon i2 = new ImageIcon("src\\madn_images\\dice\\dice2.png");
	ImageIcon i3 = new ImageIcon("src\\madn_images\\dice\\dice3.png");
	ImageIcon i4 = new ImageIcon("src\\madn_images\\dice\\dice4.png");
	ImageIcon i5 = new ImageIcon("src\\madn_images\\dice\\dice5.png");
	ImageIcon i6 = new ImageIcon("src\\madn_images\\dice\\dice6.png");
	
	public Dice()
	{
		setImage(1);
		this.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				madn_app.Dice.roll();
				setImage(madn_ctrl.Dice.getNumberRolled());
		
				update();
			}
		});
		
		setBorderPainted(false); 
        setContentAreaFilled(false); 
        setFocusPainted(false); 
        setOpaque(false);
        
        enableDice();
	}
	
	public void update()
	{
		if (madn_ctrl.Dice.isDiceRolled() == true)
		{
			disableDice();
		}
		else
		{
			enableDice();
		}
	}
	
	private void setImage(int i)
	{
		switch (i)
		{
		case 1: setIcon(i1);
				break;
		case 2: setIcon(i2);
				break;
		case 3: setIcon(i3);
				break;
		case 4: setIcon(i4);
				break;
		case 5: setIcon(i5);
				break;
		case 6: setIcon(i6);
				break;
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