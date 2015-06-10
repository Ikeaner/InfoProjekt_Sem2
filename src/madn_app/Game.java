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
	private PlayerList players;
	
	private Player currentPlayer;
	
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
		p1 = new Player("Spieler", 1, true);
		p2 = new Player("CPU Tam", 2, false);
		p3 = new Player("CPU Leno", 3, false);
		p4 = new Player("CPU Jaceu", 4, false);
		
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
		//Random Player TODO: Ausw�rfeln
		int startPlayerInt = (int) (Math.random()*4);
		
		currentPlayer = players.getPlayers().get(startPlayerInt);
		System.out.println("Starting Player is: " + currentPlayer.getName());
		
		while (gameOver == false)
		{
			//Zug �bergeben
			if (currentPlayer.getID() == 4)
			{
				currentPlayer = players.getPlayers().get(1);
			}
			else
			{
				currentPlayer = players.getPlayers().get(currentPlayer.getID()+1);
			}
			
			view.update(this);
			//TODO: Rest des Spiels
		}
		
	}
}
