package madn_ctrl;

public class Token 
{
	private int tokenID;
	private int playerID;
	private int position;
	private boolean enabled;
	
	private int[] allStartingPositions = {56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71};
	private int[] allHousePositions = {40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55};
	
	public Token(int tokenID, int playerID)
	{
		this.setTokenID(tokenID);
		this.setPlayerID(playerID);
	}
	
	public boolean isInHouse()
	{
		boolean b = false;
		
		for(int i:allHousePositions)
		{
			if (this.position == i)
			{
				b = true;
			}
		}
		return b;
	}
	
	public String getStringToOutput()
	{
		return "TID" + tokenID + "/PID" + playerID; 
	}

	public int getTokenID() {
		return tokenID;
	}

	public void setTokenID(int tokenID) {
		this.tokenID = tokenID;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		for (Token t:allTokens.getAllTokens())
		{
			if (t.getPosition() == position)
			{
				switch(t.getPlayerID())
				{
				case 0:
					for (int i = 56; i < 59; i++)
					{
						if(madn_ctrl.Board.getFieldAt(i).containsToken() == false)
						{
							t.setPosition(i);
							break;
						}
					}
					break;
				case 1:
					for (int i = 60; i < 63; i++)
					{
						if(madn_ctrl.Board.getFieldAt(i).containsToken() == false)
						{
							t.setPosition(i);
							break;
						}
					}
					break;
				case 2:
					for (int i = 64; i < 67; i++)
					{
						if(madn_ctrl.Board.getFieldAt(i).containsToken() == false)
						{
							t.setPosition(i);
							break;
						}
					}
					break;
				case 3:
					for (int i = 68; i < 71; i++)
					{
						if(madn_ctrl.Board.getFieldAt(i).containsToken() == false)
						{
							t.setPosition(i);
							break;
						}
					}
					break;
					
				}
			}
		}
		this.position = position;
	}

	public void disableToken() 
	{
		enabled = false;
		
	}

	public void enableToken() 
	{
		enabled = true;
		
	}
	
	public int getPlayerStart()
	{
		int playerStart = 0;
		
		switch(playerID)
		{
		case 0: playerStart = 0;
				break;
		case 1: playerStart = 10;
				break;
		case 2: playerStart = 20;
				break;
		case 3: playerStart = 30;
				break;	
		}
		return playerStart;
	}

	public boolean isOutOfStart() 
	{
		boolean b = true;
		
		for(int i:allStartingPositions)
		{
			if (this.position == i)
			{
				b = false;
			}
		}
		return b;
	}

	public boolean isEnabled() {
		return enabled;
	}
}
