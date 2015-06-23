//Die Klasse fügt die erstellten Figuren einer ArrayList hinzu
/*
 * @author Tom Quinders 
 * @version 1.0
 */ 
package madn_ctrl;

import java.util.ArrayList;

public class allTokens 
{
	public static ArrayList<Token> tokens = new ArrayList<Token>();
	private static boolean tokenMoved;
	
	public static void addToken(Token t)
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
