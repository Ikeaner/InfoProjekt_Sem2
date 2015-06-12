package madn_app;

import madn_ctrl.Player;
import madn_ctrl.PlayerList;
import madn_ctrl.Token;
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
		
		currentPlayer = players.getPlayers().get(startPlayerInt);
		System.out.println("Starting Player is: " + currentPlayer.getName());
		
		//Game Loop
		while (gameOver == false)
		{
			System.out.println("The Current Players is: " + currentPlayer.getName());
			
			boolean isValid = false;
			while (isValid == false)
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
				
				//if gewürfelte Zahl bringt ergebnisse
					isValid = true;	
				//else
					//3mal?
			}
			//enable Felder auf die man Ziehen kann
			
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
}
