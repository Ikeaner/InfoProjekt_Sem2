package madn_ctrl;

import java.util.ArrayList;

public class Player 
{
	private String name;
	private int ID;
	private ArrayList<Token> tokens = new ArrayList<Token>();
	private boolean isHuman;
	
	public Player(String name, int ID, boolean isHuman)
	{
		this.setName(name);
		this.setID(ID);
		this.setHuman(isHuman);
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

	public boolean isHuman() {
		return isHuman;
	}

	public void setHuman(boolean isHuman) {
		this.isHuman = isHuman;
	}
}
