/* Create an AST, then invoke our interpreter. */ 
import lexer.Lexer ; 
import helper.Helper;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

public class Main 
{
	
	public static void main(String[] args) throws IOException 
	{
		if (args.length > 0)
		{
			Lexer lexer = new Lexer(new PushbackReader(new FileReader(args[0]), 1024));
			Helper.buscarTokens(lexer);
		} else {
			System.out.println("Nenhum arquivo para leitura.");
		}
	}
}
