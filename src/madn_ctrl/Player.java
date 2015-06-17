package madn_ctrl;

import java.util.ArrayList;

public class Player 
{
	private String name;
	private int ID;
	private ArrayList<Token> tokens = new ArrayList<Token>();
	private boolean isHuman;
	private int[] startingPositions = {0,0,0,0};
	private Field startField;
	
	public Player(String name, int ID, boolean isHuman)
	{
		this.setName(name);
		this.setID(ID);
		this.setHuman(isHuman);
		this.setStartingPositions();
	}
	
	private void setStartingPositions() 
	{
		//TODO: Find out the actual numbers for the starting positions
		switch(ID)
		{
		case 0: startingPositions[0] = 41;
				startingPositions[1] = 42;
				startingPositions[2] = 43;
				startingPositions[3] = 44;
				break;
		case 1: startingPositions[0] = 45;
				startingPositions[1] = 46;
				startingPositions[2] = 47;
				startingPositions[3] = 48;
				break;	
		case 2: startingPositions[0] = 49;
				startingPositions[1] = 50;
				startingPositions[2] = 51;
				startingPositions[3] = 52;
				break;	
		case 3: startingPositions[0] = 53;
				startingPositions[1] = 54;
				startingPositions[2] = 55;
				startingPositions[3] = 56;
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

	public Field getStartField() {
		return startField;
	}
}
