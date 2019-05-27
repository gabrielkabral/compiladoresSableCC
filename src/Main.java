/* Create an AST, then invoke our interpreter. */ 
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

import helper.Helper;

public class Main 
{
	
	public static void main(String[] args) throws IOException 
	{
		if (args.length > 0)
		{
			ComentarioAninhado lexer = new ComentarioAninhado(new PushbackReader(new FileReader(args[0]), 1024));
			Helper.buscarTokens(lexer);
		} else {
			System.out.println("Nenhum arquivo para leitura.");
		}
	}
}
