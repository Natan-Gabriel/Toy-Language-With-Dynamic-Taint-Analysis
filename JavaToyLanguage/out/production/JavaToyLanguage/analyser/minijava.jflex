// Technische Universitaet Muenchen 
// Fakultaet fuer Informatik 

package analyser;
import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;

%%

%public
%class Lexer
%cup
%implements sym
%char
%line
%column

%{
    StringBuffer string = new StringBuffer();
    public Lexer(java.io.Reader in, ComplexSymbolFactory sf){
	this(in);
	symbolFactory = sf;
    }
    ComplexSymbolFactory symbolFactory;

  private Symbol symbol(String name, int sym) {
        return symbolFactory.newSymbol(name, sym, new Location(yyline+1,yycolumn+1,(int)yychar), new Location(yyline+1,yycolumn+yylength(),(int)(yychar+yylength())));
    }

    private Symbol symbol(String name, int sym, Object val) {
        Location left = new Location(yyline+1,yycolumn+1,(int)yychar);
        Location right= new Location(yyline+1,yycolumn+yylength(), (int)(yychar+yylength()));
        return symbolFactory.newSymbol(name, sym, left, right,val);
    }
    private Symbol symbol(String name, int sym, Object val,int buflength) {
        Location left = new Location(yyline+1,yycolumn+yylength()-buflength,(int)(yychar+yylength()-buflength));
        Location right= new Location(yyline+1,yycolumn+yylength(), (int)(yychar+yylength()));
        return symbolFactory.newSymbol(name, sym, left, right,val);
    }
    private void error(String message) {
      System.out.println("Error at line "+(yyline+1)+", column "+(yycolumn+1)+" : "+message);
    }
%} 

%eofval{
    return symbolFactory.newSymbol("EOF", EOF, new Location(yyline+1,yycolumn+1,(int)yychar), new Location(yyline+1,yycolumn+1,(int)(yychar+1)));
%eofval}

BoolLiteral = true | false

Ident = [a-zA-Z$_] [a-zA-Z0-9$_]*

IntLiteral = 0 | [1-9][0-9]*

new_line = \r|\n|\r\n;

white_space = {new_line} | [ \t\f]

%state STRING

%%

<YYINITIAL>{
/* keywords */
"int"             { return symbol("int",TYPE, "INT" ); }
"if"              { return symbol("if",IF); }
"else"            { return symbol("else",ELSE); }
"while"           { return symbol("while",WHILE); }
"for"           { return symbol("for",FOR); }
"goto"            { return symbol("goto",GOTO); }
"read_integer()"            { return symbol("read_integer",READ_INTEGER); }
"read_heap()"            { return symbol("read_heap",READ_HEAP); }
"open_file"            { return symbol("read_file",OPEN_FILE); }
"read_file"            { return symbol("read_file",READ_FILE); }
"close_file"            { return symbol("read_file",CLOSE_FILE); }
"write"           { return symbol("write",WRITE); }
"print"           { return symbol("print",PRINT); }


/* names */
{Ident}           { return symbol("Identifier",IDENT, yytext()); }
  
/* string literals */

/* char literal */

/* bool literal */
{BoolLiteral} { return symbol("Boolconst",BOOLCONST, new Boolean(Boolean.parseBool(yytext()))); }

/* literals */
{IntLiteral} { return symbol("Intconst",INTCONST, new Integer(Integer.parseInt(yytext()))); }



/* separators */
  \"              { string.setLength(0); yybegin(STRING); }
";"               { return symbol("semicolon",SEMICOLON); }
","               { return symbol("comma",COMMA); }
"("               { return symbol("(",LPAR); }
")"               { return symbol(")",RPAR); }
"{"               { return symbol("{",BEGIN); }
"}"               { return symbol("}",END); }
"="               { return symbol("=",ASSIGN); }
"+"               { return symbol("plus",BINOPPRIORITY2,'+'  ); }
"-"               { return symbol("minus",BINOPPRIORITY2, '-'  ); }
"*"               { return symbol("mul",BINOPPRIORITY1, '*'  ); }
"/"               { return symbol("div",BINOPPRIORITY1, '/'  ); }

"<="              { return symbol("leq",COMP,  "<="  ); }
">="              { return symbol("geq",COMP,  ">="  ); }
"=="              { return symbol("eq",COMP,  "=="   ); }
"!="              { return symbol("neq",COMP,  "!="  ); }
"<"               { return symbol("less",COMP,  "<"   ); }
">"               { return symbol("gt",COMP,  ">"   ); }
"&&"              { return symbol("and",BBINOP,"and"  ); }
"||"              { return symbol("or",BBINOP,"or"   ); }
"!"               { return symbol("not",BUNOP,"NOT"); }



{white_space}     { /* ignore */ }

}

<STRING> {
  \"                             { yybegin(YYINITIAL); 
      return symbol("StringConst",STRINGCONST,string.toString(),string.length()); }
  [^\n\r\"\\]+                   { string.append( yytext() ); }
  \\t                            { string.append('\t'); }
  \\n                            { string.append('\n'); }

  \\r                            { string.append('\r'); }
  \\\"                           { string.append('\"'); }
  \\                             { string.append('\\'); }
}


/* error fallback */
.|\n              {  /* throw new Error("Illegal character <"+ yytext()+">");*/
		    error("Illegal character <"+ yytext()+">");
                  }