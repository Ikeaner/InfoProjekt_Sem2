package madn_app;

import java.util.ArrayList;

public class Player 
{
	private String name;
	private int ID;
	private ArrayList<Token> tokens = new ArrayList<Token>();
	
	public Player(String name, int ID)
	{
		this.setName(name);
		this.setID(ID);
	}
	
	public void addToken(Token t)
	{
		tokens.add(t);
	}

	public int getID() 
	{
		return ID;
	}

	public void setID(int iD) 
	{
		ID = iD;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
}
