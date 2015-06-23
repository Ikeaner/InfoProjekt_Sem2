/*
 * @author Tom Quinders, Jaqueline Timmermann
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
<<<<<<< HEAD
	//Bilder die beim Würfel angezeigt werden
	ImageIcon i1 = new ImageIcon("src\\madn_images\\dice\\dice1.png");
	ImageIcon i2 = new ImageIcon("src\\madn_images\\dice\\dice2.png");
	ImageIcon i3 = new ImageIcon("src\\madn_images\\dice\\dice3.png");
	ImageIcon i4 = new ImageIcon("src\\madn_images\\dice\\dice4.png");
	ImageIcon i5 = new ImageIcon("src\\madn_images\\dice\\dice5.png");
	ImageIcon i6 = new ImageIcon("src\\madn_images\\dice\\dice6.png");
=======
	ImageIcon i1 = new ImageIcon(getClass().getResource("/images/dice1.png"));
	ImageIcon i2 = new ImageIcon(getClass().getResource("/images/dice2.png"));
	ImageIcon i3 = new ImageIcon(getClass().getResource("/images/dice3.png"));
	ImageIcon i4 = new ImageIcon(getClass().getResource("/images/dice4.png"));
	ImageIcon i5 = new ImageIcon(getClass().getResource("/images/dice5.png"));
	ImageIcon i6 = new ImageIcon(getClass().getResource("/images/dice6.png"));
>>>>>>> f85fcfb0c1fbe5f4074c3929100d3815db6851b0
	
	public Dice()
	{
		//setzt als Anfangsbild das Bild mit der 1
		setImage(1);
		//wenn der Würfel Button geklickt ist wird die Methode .roll() aufgerufen und es wird gewürfelt
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
	
	//wenn gewürfelt wurde disable dice, sonst enable ihn
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
	
	//setzt als Bild die jeweils gewürfelte Zahl
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
	//macht es möglich zu würfeln
	public void enableDice()
	{
		setEnabled(true);
	}
	//macht es unmöglich zu würfeln
	private void disableDice()
	{
		setEnabled(false);
	}
}