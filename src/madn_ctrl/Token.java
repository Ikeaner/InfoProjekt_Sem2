package madn_ctrl;

public class Token 
{
	private int tokenID;
	private int playerID;
	
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
}
