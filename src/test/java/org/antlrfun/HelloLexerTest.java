package org.antlrfun;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Assert;
import org.junit.Test;

public class HelloLexerTest {

    @Test
    public void testHello() {
        ANTLRInputStream antlrInputStream = new ANTLRInputStream("hello world");

        HelloLexer lexer = new HelloLexer(antlrInputStream);

        CommonTokenStream tokens = new CommonTokenStream( lexer );
        HelloParser parser = new HelloParser( tokens );
        parser.addErrorListener(failOnSyntaxError);
        ParseTree tree = parser.r();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk( new HelloWalker(), tree );
    }

    @Test
    public void testHell() {
        ANTLRInputStream antlrInputStream = new ANTLRInputStream("hell world");

        HelloLexer lexer = new HelloLexer(antlrInputStream);

        CommonTokenStream tokens = new CommonTokenStream( lexer );
        HelloParser parser = new HelloParser( tokens );
        parser.addErrorListener(failOnSyntaxError);
        ParseTree tree = parser.r();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk( new HelloWalker(), tree );
    }

    private static ANTLRErrorListener failOnSyntaxError = new DiagnosticErrorListener(){
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
            Assert.fail();
        }
    };

}
