package madn_ctrl;

import java.util.ArrayList;

public class Player 
{
	private String name;
	private int ID;
	private ArrayList<Token> tokens = new ArrayList<Token>();
	private boolean isHuman;
	private int[] startingPositions = {0,0,0,0};
	private int startField;
	
	public Player(String name, int ID, boolean isHuman)
	{
		this.setName(name);
		this.setID(ID);
		this.setHuman(isHuman);
		this.setStartingPositions();
		this.setStartField();
	}
	
	private void setStartField()
	{
		switch(ID)
		{
		case 0: startField = 0;
				break;
		case 1: startField = 10;
				break;	
		case 2: startField = 20;
				break;	
		case 3: startField = 30;
				break;	
		}
	}
	
	private void setStartingPositions() 
	{
		switch(ID)
		{
		case 0: startingPositions[0] = 56;
				startingPositions[1] = 57;
				startingPositions[2] = 58;
				startingPositions[3] = 59;
				break;
		case 1: startingPositions[0] = 60;
				startingPositions[1] = 61;
				startingPositions[2] = 62;
				startingPositions[3] = 63;
				break;	
		case 2: startingPositions[0] = 64;
				startingPositions[1] = 65;
				startingPositions[2] = 66;
				startingPositions[3] = 67;
				break;	
		case 3: startingPositions[0] = 68;
				startingPositions[1] = 69;
				startingPositions[2] = 70;
				startingPositions[3] = 71;
				break;	
		}
	}

	public void addToken(Token t)
	{
		tokens.add(t);
	}
	
	public ArrayList<Token> getTokens()
	{
		return tokens;
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

	public int[] getStartingPositions() 
	{
		return startingPositions;
	}
	
	public int getStartingPosition(int i)
	{
		return startingPositions[i];
	}

	public int getStartField() {
		return startField;
	}
}
