package madn_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import madn_ctrl.Token;
import madn_ctrl.allTokens;

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
				
				Token t = madn_ctrl.Board.getFieldAt(ID).getTokenOnField();
				if (t.isOutOfStart())
				{
					switch (t.getPlayerID())
					{
					case 0:
						if(t.getPosition() + madn_ctrl.Dice.getNumberRolled() >= 40)
						{
							switch(t.getPosition() + madn_ctrl.Dice.getNumberRolled())
							{
							case 40:
								t.setPosition(40);
								break;
							case 41:
								t.setPosition(41);
								break;
							case 42:
								t.setPosition(42);
								break;
							case 43:
								t.setPosition(43);
								break;
							}
						}
						else
						{
							t.setPosition(t.getPosition() + madn_ctrl.Dice.getNumberRolled());
						}		
						break;
					///////////////////////////////////////////////////	
					case 1:
						if(t.getPosition() < 10)
						{
							if(t.getPosition() + madn_ctrl.Dice.getNumberRolled() >= 10)
							{
								switch(t.getPosition() + madn_ctrl.Dice.getNumberRolled())
								{
								case 10:
									t.setPosition(44);
									break;
								case 11:
									t.setPosition(45);
									break;
								case 12:
									t.setPosition(46);
									break;
								case 13:
									t.setPosition(47);
									break;
								}
							}
							else
							{
								t.setPosition(t.getPosition() + madn_ctrl.Dice.getNumberRolled());
							}
						}
						else
						{
							if(t.getPosition() + madn_ctrl.Dice.getNumberRolled() >= 40)
							{
								t.setPosition(t.getPosition() + madn_ctrl.Dice.getNumberRolled() - 40);
							}
							else
							{
								t.setPosition(t.getPosition() + madn_ctrl.Dice.getNumberRolled());
							}
						}
						break;
						////////////////////////////////////////////////////////////////////////
					case 2:
						if(t.getPosition() < 20)
						{
							if(t.getPosition() + madn_ctrl.Dice.getNumberRolled() >= 20)
							{
								switch(t.getPosition() + madn_ctrl.Dice.getNumberRolled())
								{
								case 20:
									t.setPosition(48);
									break;
								case 21:
									t.setPosition(49);
									break;
								case 22:
									t.setPosition(50);
									break;
								case 23:
									t.setPosition(51);
									break;
								}
							}
							else
							{
								t.setPosition(t.getPosition() + madn_ctrl.Dice.getNumberRolled());
							}
						}
						else
						{
							if(t.getPosition() + madn_ctrl.Dice.getNumberRolled() >= 40)
							{
								t.setPosition(t.getPosition() + madn_ctrl.Dice.getNumberRolled() - 40);
							}
							else
							{
								t.setPosition(t.getPosition() + madn_ctrl.Dice.getNumberRolled());
							}
						}
						break;
						////////////////////////////////////////////////////////
					case 3:
						if(t.getPosition() < 30)
						{
							if(t.getPosition() + madn_ctrl.Dice.getNumberRolled() >= 30)
							{
								switch(t.getPosition() + madn_ctrl.Dice.getNumberRolled())
								{
								case 30:
									t.setPosition(52);
									break;
								case 31:
									t.setPosition(53);
									break;
								case 32:
									t.setPosition(54);
									break;
								case 33:
									t.setPosition(55);
									break;
								}
							}
							else
							{
								t.setPosition(t.getPosition() + madn_ctrl.Dice.getNumberRolled());
							}
						}
						else
						{
							if(t.getPosition() + madn_ctrl.Dice.getNumberRolled() >= 40)
							{
								t.setPosition(t.getPosition() + madn_ctrl.Dice.getNumberRolled() - 40);
							}
							else
							{
								t.setPosition(t.getPosition() + madn_ctrl.Dice.getNumberRolled());
							}
						}
						break;
					}
				}
				else
				{
					t.setPosition(t.getPlayerStart());
				}
				
				for (Token tk:allTokens.getAllTokens())
				{
					tk.disableToken();
				}
				allTokens.setTokenMoved(true);
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
	
	public void update()
	{
		
	}
}
