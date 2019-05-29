import lexer.Lexer;
import lexer.Lexer.State;
import lexer.LexerException;
import node.*;
import java.io.IOException;

public class ComentarioAninhado extends Lexer { 
    private int count;
    private TComentarioBloco comment;
    private StringBuffer text;
    
    public ComentarioAninhado(java.io.PushbackReader in) {
         super(in);
    }
    protected void filter() throws LexerException, IOException{
        if(state.equals(State.COMENTARIO)) {
            if(comment == null) {
                comment = (TComentarioBloco) token;
                text = new StringBuffer(comment.getText());
                count = 1;
                token = null;
                } else {
                text.append(token.getText());
                if(token instanceof TComentarioLinha);
                if(token instanceof TComentarioBloco)
                  count++;
                else if(token instanceof TComentarioFimBloco)
                  count--;
                if(count != 0) {
                    if(token instanceof EOF){
                        state = State.NORMAL;
                        throw new LexerException(null , "Token desconhecido ('" + comment + "') [Linha - " + comment.getLine() + ", Posicao - " + comment.getPos() + "]");
                    }
                    token = null;
                } else {
                    token = comment;
                    state = State.NORMAL;
                    comment = null;
                }
            }
        }
    }
}
