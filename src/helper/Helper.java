package helper;
import lexer.Lexer ; 
import lexer.LexerException ; 
import node.EOF ;
import node.Token ;

public final class Helper 
{
	private static void imprimeToken(Token token)
	{
		if(token.getClass().getSimpleName().equals("TEspaco")) {
			System.out.print(' ');
		} else if(token.getClass().getSimpleName().equals("TQuebra")) {
			System.out.print('\n');
		} else {
			System.out.print(token.getClass().getSimpleName());
		}
	}
	
	public static void buscarTokens(Lexer lexer) 
	{
		Token token = null;
		
		try
		{
			token = lexer.next();
			imprimeToken(token);
			while (!((token = lexer.next()) instanceof EOF)) 
			{
				imprimeToken(token);
		
			}
		} catch(LexerException e) {
			System.out.print(e.getMessage().substring(0, e.getMessage().length()) + " ");
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
