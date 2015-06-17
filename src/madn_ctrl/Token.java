package madn_ctrl;

public class Token 
{
	private int tokenID;
	private int playerID;
	private int position;
	private boolean enabled;
	
	public Token(int tokenID, int playerID)
	{
		this.setTokenID(tokenID);
		this.setPlayerID(playerID);
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

	public boolean isOutOfStart(Player p) 
	{
		boolean b = true;
		
		for(int i:p.getStartingPositions())
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
