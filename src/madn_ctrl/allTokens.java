package madn_ctrl;

import java.util.ArrayList;

public class allTokens 
{
	public static ArrayList<Token> tokens = new ArrayList<Token>();
	private static boolean tokenMoved;
	
	public void addToken(Token t)
	{
		tokens.add(t);
	}
	
	public static ArrayList<Token> getAllTokens()
	{
		return tokens;
	}

	public static boolean wasTokenMoved() 
	{
		return tokenMoved;
	}

	public static void setTokenMoved(boolean tokenMoved) 
	{
		allTokens.tokenMoved = tokenMoved;
	}
}
