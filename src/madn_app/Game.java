package madn_app;

import madn_ctrl.Board;
import madn_ctrl.Player;
import madn_ctrl.PlayerList;
import madn_ctrl.Token;
import madn_ctrl.allTokens;
import madn_gui.View;

public class Game 
{
	private View view;
	
	private Player p1;
	private Player p2;
	private Player p3;
	private Player p4;
	private PlayerList players = new PlayerList();
	
	private Player currentPlayer;
	private Board board = new Board();
	
	private boolean rollAgain;
	
	Dice d = new Dice();
	
	private boolean gameOver = false;
	
	public Game(View view)
	{
		this.view = view;
		initGame4Players();
		initializeTokens();
		startGame();
	}
	
	private void initGame4Players()
	{
		p1 = new Player("Spieler", 0, true);
		p2 = new Player("CPU Tam", 1, false);
		p3 = new Player("CPU Leno",2, false);
		p4 = new Player("CPU Jaceu", 3, false);

		players.addPlayer(p1);
		players.addPlayer(p2);
		players.addPlayer(p3);
		players.addPlayer(p4);	
	}
	
	private void initializeTokens()
	{
		for (Player p : players.getPlayers())
		{
			for (int i = 0; i < 4; i++)
			{
				p.addToken(new Token(i, p.getID()));
			}
		}
	}

	private void startGame()
	{	
		//Random Player KANN TODO: Auswürfeln
		int startPlayerInt = (int) (Math.random()*4);
		//set current Player to the Starting Player
		currentPlayer = players.getPlayers().get(startPlayerInt);
		System.out.println("Starting Player is: " + currentPlayer.getName());
		
		//Game Loop
		while (gameOver == false)
		{
			System.out.println("The Current Players is: " + currentPlayer.getName());
			
			//Turn Loop
			rollAgain = true;
			int failureCounter = 0;
			while (rollAgain == true)
			{
				madn_ctrl.Dice.setDiceRolled(false);
				view.update(this);
				
				//Wait for Diceroll
				while (madn_ctrl.Dice.isDiceRolled() == false)
				{
					try 
					{
				       Thread.sleep(200);
					} 
					catch(InterruptedException e) 
					{
						e.printStackTrace();
					}
				}				
				System.out.println("Die gewürfelte Zahl ist " + madn_ctrl.Dice.getNumberRolled());
				
					if (madn_ctrl.Dice.getNumberRolled() != 6)
					{
						if (areThereTokensOutOfStart() == true)
						{
							checkTurn();
							rollAgain = false;
						}
						else 
						{
							failureCounter++;
							//roll again
						}
					}
					else if (madn_ctrl.Dice.getNumberRolled() == 6)
					{
						if(areThereTokensOutOfStart())
						{
							checkTurn();
						}
						else
						{
							if (currentPlayer.getStartField().isEmpty())
							{
								//force Move out of Starting Position
								for (int i:currentPlayer.getStartingPositions())
								{
									if (board.getFieldAt(i).containsToken())
									{
										board.getFieldAt(i).getTokenOnField().enableToken();
									}
								}
							}
							else
							{
								if(board.getFieldAt(currentPlayer.getStartField().getID() + 6).containsFriendlyToken(currentPlayer))
								{
									//DO NOTHING AND ROLL AGAIN
								}
								else
								{
									//Force Move to Field
									currentPlayer.getStartField().getTokenOnField().enableToken();
								}
							}
						}
					}
				
					if (failureCounter < 2)
					{
						rollAgain = false;
					}
					//if out of all tokens any are enabled wait for Token to be moved else end turn
					if(isAnyTokenEnabled())
					{
						allTokens.setTokenMoved(false);
						view.update(this);
						//Wait for Token to be moved
						while (madn_ctrl.allTokens.wasTokenMoved() == false)
						{
							try 
							{
						       Thread.sleep(200);
							} 
							catch(InterruptedException e) 
							{
								e.printStackTrace();
							}
						}	
					}	
			}
			//if irgendein Haus = voll
				//gameOver = true;
			//else
			//Zug übergeben
			if (currentPlayer.getID() == 3)
			{
				currentPlayer = players.getPlayers().get(0);
			}
			else
			{
				currentPlayer = players.getPlayers().get(currentPlayer.getID()+1);
			}
			view.update(this);
		}
		
		//zeige Endscreen
	}
	
	private void checkTurn()
	{
		for (Token t:currentPlayer.getTokens())
		{
			for (int i:currentPlayer.getStartingPositions())
			{
				if (t.getPosition() != i)
		  		{
		  			if (board.getFieldAt(t.getPosition() + madn_ctrl.Dice.getNumberRolled()).containsFriendlyToken(currentPlayer))
		  			{
		  				t.disableToken();
		 			}
		  			else
		 			{
		  				t.enableToken();
		   			}
		 		}
			}
		}
	}

	private boolean areThereTokensOutOfStart()
	{
		boolean anyOutOfStart = false;
		
		for (Token t:currentPlayer.getTokens())
		{
			if (t.isOutOfStart(currentPlayer))
			{
				anyOutOfStart = true;
			}
		}
		
		return anyOutOfStart;
	}
	
	private boolean isAnyTokenEnabled()
	{
		boolean b = false;
		
		for(Token t: currentPlayer.getTokens())
		{
			if (t.isEnabled())
			{
				b = true;
			}
		}
		return b;
	}
}
