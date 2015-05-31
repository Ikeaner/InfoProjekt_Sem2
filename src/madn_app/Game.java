package madn_app;

import java.util.ArrayList;

public class Game 
{
	private Dice dice;
	
	private Player p1;
	private Player p2;
	private Player p3;
	private Player p4;
	private ArrayList<Player> players = new ArrayList<Player>();
	
	private Player currentPlayer;
	
	private boolean gameOver = false;
	
	public Game(int i, Dice d)
	{
		dice = d;
		if (i == 4)
		{
			initGame4Players();
			initializeTokens();
			startGame();
		}
	}
	
	private void initGame4Players()
	{
		
		p1 = new Player("Hans", 1);
		p2 = new Player("Tam", 2);
		p3 = new Player("Leno", 3);
		p4 = new Player("Jaceu", 4);
		
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
		
	}
	
	private void initializeTokens()
	{
		for (Player p : players)
		{
			for (int i = 0; i < 4; i++)
			{
				p.addToken(new Token(i, p.getID()));
			}
		}
	}

	private void startGame()
	{	
		//Random Player TODO: Auswürfeln
		int startPlayerInt = (int) (Math.random()*4);
		
		currentPlayer = players.get(startPlayerInt);
		System.out.println("Starting Player is: " + currentPlayer.getName());
		
		while (gameOver == false)
		{
			//Zug übergeben
			if (currentPlayer.getID() == 4)
			{
				currentPlayer = players.get(1);
			}
			else
			{
				currentPlayer = players.get(currentPlayer.getID()+1);
			}
			
			//TODO: Rest des Spiels
		}
		
	}
}
