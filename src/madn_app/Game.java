/*
 *	Die Game Klasse enthält den Spielablauf und Instanzen aller Klassen die das Spiel benötigt.
 * 
 * 	@author Tom Quinders
 * 	@version 0.8.1
 */
package madn_app;

import madn_ctrl.Board;
import madn_ctrl.Player;
import madn_ctrl.PlayerList;
import madn_ctrl.Token;
import madn_ctrl.allTokens;
import madn_gui.View;

public class Game 
{
	//Die übergebene view existiert, um view.update() aufzurufen und das GUI zu benachrichtigen,
	//dass sich Daten im Spiel geändert haben.
	private View view;
	
	private Player p1;
	private Player p2;
	private Player p3;
	private Player p4;
	private PlayerList players = new PlayerList();
	//currentPlayer existiert um den Zug an den nächsten Spieler übergeben zu können.
	private Player currentPlayer;
	private Board board = new Board();
	//rollAgain wird benötigt um zu überprüfen, ob man nach einem Zug nochmal würfeln darf.
	//gameOver kontrolliert die GameLoop. Während gameOver == false ist läuft das Spiel.
	private boolean rollAgain;
	private boolean gameOver = false;
	
	public Game(View view)
	{
		this.view = view;
		initGame4Players();
		initializeTokens();
		startGame();
	}
	
	//startet ein Spiel mit 4 menschlichen Spielern
	private void initGame4Players()
	{
		p1 = new Player("Spieler 1", 0, true);
		p2 = new Player("Spieler 2", 1, true);
		p3 = new Player("Spieler 3", 2, true);
		p4 = new Player("Spieler 4", 3, true);

		players.addPlayer(p1);
		players.addPlayer(p2);
		players.addPlayer(p3);
		players.addPlayer(p4);	
	}
	
	//initialisiert die Spielfiguren für alle Spieler
	private void initializeTokens()
	{
		//erstellt für jeden Spieler 4 Spielfiguren
		for (Player p : players.getPlayers())
		{
			for (int i = 0; i < 4; i++)
			{
				p.addToken(new Token(i, p.getID()));
			}
		}
		
		//setzt die Positionen der Figuren auf die Startpositionen des Spielers, fügt die Figuren zu allTokens hinzu
		for (Player p:players.getPlayers())
		{
			for (int i = 0; i < 4 ; i++)
			{
				p.getTokens().get(i).setPosition(p.getStartingPosition(i));
				allTokens.addToken(p.getTokens().get(i));
			}
		}
	}

	//startet das Spiel
	private void startGame()
	{	
		//Bestimmt den Startspieler zufällig
		int startPlayerInt = (int) (Math.random()*4);
		//currentPlayer wird auf den Startspieler gesetzt
		currentPlayer = players.getPlayers().get(startPlayerInt);
		System.out.println("Starting Player is: " + currentPlayer.getName());
		//das Spiel ist nun vorbereitet, die view kann zum ersten Mal erneuert werden
		view.update(this);
		//Spiel Loop
		while (gameOver == false)
		{
			
			//DEBUG: Konsolenausgabe
			System.out.println("The Current Players is: " + currentPlayer.getName());
			
			//rollAgain wird benötigt um zu sehen ob nach dem momentanen noch ein Zug ausgeführt werden soll
			//failureCounter wird benötigt um zu sehen, wie oft schon gewürfelt wurde wenn noch keine Figur draußen ist
			rollAgain = true;
			int failureCounter = 0;
			//Zug Loop
			while (rollAgain == true)
			{
				madn_ctrl.Dice.setDiceRolled(false);
				view.update(this);
				
				//Warte auf den Würfelwurf
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
				//DEBUG: Konsolenausgabe
				System.out.println("Die gewürfelte Zahl ist " + madn_ctrl.Dice.getNumberRolled());
				//Wenn die Nummer nicht 6 ist...
				if (madn_ctrl.Dice.getNumberRolled() != 6)
				{
					//sind Figuren außerhalb des Starts des Spielers?
					if (areThereTokensAvailable() == true)
					{
						//prüfe, ober der Zug gültig ist
						checkTurn();
						//wenn die Zahl nicht 6 ist, soll nicht noch ein Zug ausgeführt werden
						rollAgain = false;
					}
					else 
					{
						failureCounter++;
					}
				}
				else if (madn_ctrl.Dice.getNumberRolled() == 6)
				{
					if(areThereTokensAvailable())
					{
						checkTurn();
						if(Board.getFieldAt(currentPlayer.getStartField()).containsFriendlyToken(currentPlayer) == false)
						{
							for (int i:currentPlayer.getStartingPositions())
							{
								if (Board.getFieldAt(i).containsToken())
								{
									Board.getFieldAt(i).getTokenOnField().enableToken();
								}
							}
						}
					}
					else
					{
						if (Board.getFieldAt(currentPlayer.getStartField()).isEmpty())
						{
						//erzwinge Bewegung aus der Startposition
							for (int i:currentPlayer.getStartingPositions())
							{
								if (Board.getFieldAt(i).containsToken())
								{
									Board.getFieldAt(i).getTokenOnField().enableToken();
								}
							}
						}
						else
						{
							if(Board.getFieldAt(currentPlayer.getStartField() + 6).containsFriendlyToken(currentPlayer))
							{
								//DO NOTHING AND ROLL AGAIN
							}
							else
							{
								//Force Move to Field
								Board.getFieldAt(currentPlayer.getStartField()).getTokenOnField().enableToken();
							}
						}
					}
				}
				
					if (failureCounter > 2)
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
					view.update(this);
			}
			if (isHouseFull())
			{
				gameOver = true;
			}
			else
			{
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
		}
		System.out.println("GAME OVER");
		//zeige Endscreen
	}
	
	private boolean isHouseFull() 
	{
		boolean b = true;
		
		for (Token t:currentPlayer.getTokens())
		{
			if(t.isInHouse() == false)
			{
				b = false;
			}
		}
		
		return b;
	}

	private boolean areThereTokensAvailable() 
	{
		boolean b = false;
		
		for (Token t:currentPlayer.getTokens())
		{
			if (t.isOutOfStart())
			{
				if (t.isInHouse() == false)
				{
					b = true;
				}
			}
		}
		return b;
	}

	//checkTurn() überprüft, ob ein gültiger Zug möglich ist.	
	private void checkTurn()
	{
		System.out.println("CheckTurn");
		for (Token t:currentPlayer.getTokens())
		{
			if (t.isInHouse() == false) 
			{
				System.out.println("isInHouse");
				if (t.isOutOfStart()) 
				{
					System.out.println("isOutOfStart");
					switch (t.getPlayerID()) 
					{
					case 0:
						if (t.getPosition() + madn_ctrl.Dice.getNumberRolled() >= 40) 
						{
							switch (t.getPosition() + madn_ctrl.Dice.getNumberRolled()) 
							{
							case 40:
								checkForFriendlyToken(t, 40);
								break;
							case 41:
								checkForFriendlyToken(t, 41);
								break;
							case 42:
								checkForFriendlyToken(t, 42);
								break;
							case 43:
								checkForFriendlyToken(t, 43);
								break;
							case 44:
							case 45:
								t.disableToken();
								break;
							}
						} 
						else 
						{
							checkForFriendlyToken(t, t.getPosition() + madn_ctrl.Dice.getNumberRolled());
						}
						break;
					///////////////////////////////////////////////////	
					case 1:
						if (t.getPosition() < 10) 
						{
							if (t.getPosition() + madn_ctrl.Dice.getNumberRolled() >= 10) 
							{
								switch (t.getPosition() + madn_ctrl.Dice.getNumberRolled()) 
								{
								case 10:
									checkForFriendlyToken(t, 44);
									break;
								case 11:
									checkForFriendlyToken(t, 45);
									break;
								case 12:
									checkForFriendlyToken(t, 46);
									break;
								case 13:
									checkForFriendlyToken(t, 47);
									break;
								case 14:
								case 15:
									t.disableToken();
									break;
								}
							} 
							else 
							{
								checkForFriendlyToken(t, t.getPosition()+madn_ctrl.Dice.getNumberRolled());
							}
						} 
						else 
						{
							checkForFriendlyToken(t, t.getPosition()+madn_ctrl.Dice.getNumberRolled());
						}
						break;
						///////////////////////////////////////////////////	
					case 2:
						if (t.getPosition() < 20) 
						{
							if (t.getPosition() + madn_ctrl.Dice.getNumberRolled() >= 20) 
							{
								switch (t.getPosition() + madn_ctrl.Dice.getNumberRolled()) 
								{
								case 20:
									checkForFriendlyToken(t, 48);
									break;
								case 21:
									checkForFriendlyToken(t, 49);
									break;
								case 22:
									checkForFriendlyToken(t, 50);
									break;
								case 23:
									checkForFriendlyToken(t, 51);
									break;
								case 24:
								case 25:
									t.disableToken();
									break;
								}
							} 
							else 
							{
								checkForFriendlyToken(t, t.getPosition()+madn_ctrl.Dice.getNumberRolled());
							}
						} 
						else 
						{
							checkForFriendlyToken(t, t.getPosition()+madn_ctrl.Dice.getNumberRolled());
						}
						break;
						///////////////////////////////////////////////////	
					case 3:
						if (t.getPosition() < 30) 
						{
							if (t.getPosition() + madn_ctrl.Dice.getNumberRolled() >= 30) 
							{
								switch (t.getPosition() + madn_ctrl.Dice.getNumberRolled()) 
								{
								case 30:
									checkForFriendlyToken(t, 52);
									break;
								case 31:
									checkForFriendlyToken(t, 53);
									break;
								case 32:
									checkForFriendlyToken(t, 54);
									break;
								case 33:
									checkForFriendlyToken(t, 55);
									break;
								case 34:
								case 35:
									t.disableToken();
									break;
								}
							} 
							else 
							{
								checkForFriendlyToken(t, t.getPosition()+madn_ctrl.Dice.getNumberRolled());
							}
						} 
						else 
						{
							checkForFriendlyToken(t, t.getPosition()+madn_ctrl.Dice.getNumberRolled());
						}
					break;
					}	
				} 
				else 
				{
					t.disableToken();
				}
			}
			else
			{
				t.disableToken();
			}
		}
	}

	private void checkForFriendlyToken(Token t, int i) 
	{
		if (t.getPlayerID() == 0)
		{
			if (Board.getFieldAt(i).containsFriendlyToken(currentPlayer))
			{
				t.disableToken();
			}
			else
			{
				t.enableToken();
			}
		}
		else
		{
			if (t.getPosition() > 30)
			{
				if(i >= 40)
				{
					switch(i)
					{
					case 40: 
						i = 0;
					break;
					case 41: 
						i = 1;
					break;
					case 42:
						i = 2;
					break;
					case 43:
						i = 3;
					break;
					case 44:
						i = 4;
					break;
					case 45:
						i = 5;
					break;
					}
					if (Board.getFieldAt(i).containsFriendlyToken(currentPlayer))
					{
						t.disableToken();
					}
					else
					{
						t.enableToken();
					}
				}
				else
				{
					if (Board.getFieldAt(i).containsFriendlyToken(currentPlayer))
					{
						t.disableToken();
					}
					else
					{
						t.enableToken();
					}
				}
			}
			else
			{
				if (Board.getFieldAt(i).containsFriendlyToken(currentPlayer))
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

	public Board getBoard() {
		return board;
		
	}

	public Player getCurrentPlayer() 
	{
		return currentPlayer; 
	}
	
	public boolean getGameOver()
	{
		return gameOver;
	}
}
