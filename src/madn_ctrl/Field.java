package madn_ctrl;

public class Field 
{
	private int ID;
	
	public Field(int iD)
	{
		ID = iD;
	}
	
	public boolean containsToken()
	{
		boolean b = false;
		for (Token t:allTokens.getAllTokens())
		{
			if (t.getPosition() == this.ID)
			{
				b = true;
			}
		}
		return b;
	}
	
	public boolean containsFriendlyToken(Player p)
	{
		boolean b = false;
		for (Token t:p.getTokens())
		{
			if (t.getPosition() == this.ID)
			{
				b = true;
			}
		}
		return b;
	}
	
	public Token getTokenOnField()
	{
		Token wantedToken = null;
		for (Token t:allTokens.getAllTokens())
		{
			if (t.getPosition() == this.ID)
			{
				wantedToken = t;
			}
		}
		
		return wantedToken;
	}
	
	public boolean isEmpty()
	{
		boolean b = true;
		for (Token t:allTokens.getAllTokens())
		{
			if (t.getPosition() == this.ID)
			{
				b = false;
			}
		}
		return b;
	}
	
	public int getID()
	{
		return ID;
	}
}
