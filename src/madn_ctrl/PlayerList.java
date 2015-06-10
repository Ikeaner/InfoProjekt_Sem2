package madn_ctrl;

import java.util.ArrayList;

public class PlayerList 
{
	private ArrayList<Player> players;
	
	public PlayerList()
	{
		players = new ArrayList<Player>();
	}

	public ArrayList<Player> getPlayers() 
	{
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public void addPlayer(Player p)
	{
		players.add(p);
	}
}
