
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package analyser;

import model.stmt.*;
import model.exp.*;
import model.types.*;
import model.values.*;
import java.util.*;
import java.io.*;
import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ScannerBuffer;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\026\000\002\002\004\000\002\002\004\000\002\003" +
    "\004\000\002\003\002\000\002\005\006\000\002\007\005" +
    "\000\002\007\002\000\002\004\004\000\002\004\002\000" +
    "\002\006\003\000\002\006\006\000\002\006\011\000\002" +
    "\006\007\000\002\006\003\000\002\011\005\000\002\012" +
    "\003\000\002\010\003\000\002\010\003\000\002\010\005" +
    "\000\002\010\005\000\002\010\003\000\002\010\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\055\000\020\002\ufffe\003\ufffe\004\ufffe\014\ufffe\024" +
    "\ufffe\030\007\035\ufffe\001\002\000\020\002\ufffe\003\ufffe" +
    "\004\ufffe\014\ufffe\024\ufffe\030\007\035\ufffe\001\002\000" +
    "\004\002\056\001\002\000\016\002\ufff9\003\021\004\017" +
    "\014\024\024\020\035\023\001\002\000\004\035\010\001" +
    "\002\000\006\004\ufffb\005\011\001\002\000\004\035\014" +
    "\001\002\000\004\004\013\001\002\000\020\002\ufffd\003" +
    "\ufffd\004\ufffd\014\ufffd\024\ufffd\030\ufffd\035\ufffd\001\002" +
    "\000\006\004\ufffb\005\011\001\002\000\004\004\ufffc\001" +
    "\002\000\004\002\001\001\002\000\020\002\ufff8\003\ufff8" +
    "\004\ufff8\011\ufff8\014\ufff8\024\ufff8\035\ufff8\001\002\000" +
    "\004\006\052\001\002\000\020\002\ufff4\003\ufff4\004\ufff4" +
    "\011\ufff4\014\ufff4\024\ufff4\035\ufff4\001\002\000\020\002" +
    "\ufff9\003\021\004\017\011\ufff9\014\024\024\020\035\023" +
    "\001\002\000\004\026\046\001\002\000\004\006\025\001" +
    "\002\000\010\034\026\035\032\036\030\001\002\000\014" +
    "\004\ufff1\007\ufff1\037\ufff1\040\ufff1\041\ufff1\001\002\000" +
    "\014\004\uffed\007\uffed\037\uffed\040\uffed\041\uffed\001\002" +
    "\000\014\004\ufff2\007\ufff2\037\ufff2\040\ufff2\041\ufff2\001" +
    "\002\000\014\004\uffec\007\uffec\037\uffec\040\uffec\041\uffec" +
    "\001\002\000\014\004\ufff0\007\ufff0\037\ufff0\040\ufff0\041" +
    "\ufff0\001\002\000\012\007\037\037\035\040\036\041\034" +
    "\001\002\000\010\034\026\035\032\036\030\001\002\000" +
    "\010\034\026\035\032\036\030\001\002\000\010\034\026" +
    "\035\032\036\030\001\002\000\004\010\040\001\002\000" +
    "\016\003\021\004\017\011\ufff9\014\024\024\020\035\023" +
    "\001\002\000\004\011\042\001\002\000\020\002\ufff6\003" +
    "\ufff6\004\ufff6\011\ufff6\014\ufff6\024\ufff6\035\ufff6\001\002" +
    "\000\014\004\uffef\007\uffef\037\uffef\040\uffef\041\uffef\001" +
    "\002\000\014\004\ufff3\007\ufff3\037\ufff3\040\036\041\034" +
    "\001\002\000\014\004\uffee\007\uffee\037\uffee\040\036\041" +
    "\uffee\001\002\000\010\034\026\035\032\036\030\001\002" +
    "\000\012\004\050\037\035\040\036\041\034\001\002\000" +
    "\020\002\ufff7\003\ufff7\004\ufff7\011\ufff7\014\ufff7\024\ufff7" +
    "\035\ufff7\001\002\000\006\002\ufffa\011\ufffa\001\002\000" +
    "\010\034\026\035\032\036\030\001\002\000\012\007\054" +
    "\037\035\040\036\041\034\001\002\000\004\004\055\001" +
    "\002\000\020\002\ufff5\003\ufff5\004\ufff5\011\ufff5\014\ufff5" +
    "\024\ufff5\035\ufff5\001\002\000\004\002\000\001\002\000" +
    "\016\002\uffff\003\uffff\004\uffff\014\uffff\024\uffff\035\uffff" +
    "\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\055\000\010\002\004\003\005\005\003\001\001\000" +
    "\006\003\056\005\003\001\001\000\002\001\001\000\006" +
    "\004\015\006\021\001\001\000\002\001\001\000\004\007" +
    "\011\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\007\014\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\006\004\050\006\021\001\001\000\002\001" +
    "\001\000\002\001\001\000\010\010\032\011\026\012\030" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\010\010\044\011\026\012\030\001\001\000\010\010" +
    "\043\011\026\012\030\001\001\000\010\010\042\011\026" +
    "\012\030\001\001\000\002\001\001\000\006\004\040\006" +
    "\021\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\010\010" +
    "\046\011\026\012\030\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\010\010\052\011\026\012" +
    "\030\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




  public boolean syntaxErrors;


  Lexer lexer;

  public Parser(Lexer lex, ComplexSymbolFactory sf) {
    super(lex,sf);
    lexer = lex;
  }

  public static void main(String[] args) throws Exception {
        // initialize the symbol factory
        ComplexSymbolFactory csf = new ComplexSymbolFactory();
        // create a buffering scanner wrapper
        ScannerBuffer lexer = new ScannerBuffer(new Lexer(new BufferedReader(new FileReader(args[0])),csf));
        // start parsing
        Parser p = new Parser(lexer,csf);

        //XMLElement e = (XMLElement)p.parse().value;
        System.out.println("aici");
        System.out.println(p.parse().value);
    }


    public synchronized static Object parse(String arg) throws Exception {
        // initialize the symbol factory
        ComplexSymbolFactory csf = new ComplexSymbolFactory();
        // create a buffering scanner wrapper
        ScannerBuffer lexer = new ScannerBuffer(new Lexer(new BufferedReader(new FileReader(arg)),csf));
        // start parsing
        Parser p = new Parser(lexer,csf);

        //XMLElement e = (XMLElement)p.parse().value;
        System.out.println("aici");
        Object res=p.parse().value;
        System.out.println("res:"+res+"res_printed");
        return res;

    }




/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action_part00000000(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // program ::= decllist stmtlist 
            {
              IStmt RESULT =null;
		Location dxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location dxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		IStmt d = (IStmt)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		Location sxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xleft;
		Location sxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xright;
		IStmt s = (IStmt)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new CompStmt(d,s); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("program",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= program EOF 
            {
              Object RESULT =null;
		Location start_valxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location start_valxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		IStmt start_val = (IStmt)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // decllist ::= decl decllist 
            {
              IStmt RESULT =null;
		Location dxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location dxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		IStmt d = (IStmt)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		Location dlxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xleft;
		Location dlxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xright;
		IStmt dl = (IStmt)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
    dl=new CompStmt(d,dl); RESULT = dl;
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("decllist",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // decllist ::= 
            {
              IStmt RESULT =null;
		 RESULT = new NopStmt(); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("decllist",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // decl ::= TYPE IDENT identlist SEMICOLON 
            {
              IStmt RESULT =null;
		Location ixleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).xleft;
		Location ixright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).xright;
		String i = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		Location ilxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location ilxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		List<String> il = (List<String>)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 System.out.println(i) ;
    IStmt res=new NopStmt();
    for(String elem : il){
        res=new CompStmt(new VarDeclStmt(elem,new IntType(),ixleft.getLine()),res);
    }
    res=new CompStmt(new VarDeclStmt(i,new IntType(),ixleft.getLine()), res);
    RESULT = res; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("decl",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // identlist ::= COMMA IDENT identlist 
            {
              List<String> RESULT =null;
		Location ixleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location ixright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		String i = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		Location ilxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xleft;
		Location ilxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xright;
		List<String> il = (List<String>)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 il.add(i); RESULT = il; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("identlist",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // identlist ::= 
            {
              List<String> RESULT =null;
		 RESULT = new ArrayList<String>(); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("identlist",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // stmtlist ::= stmt stmtlist 
            {
              IStmt RESULT =null;
		Location sxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location sxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		IStmt s = (IStmt)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		Location slxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xleft;
		Location slxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xright;
		IStmt sl = (IStmt)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 sl=new CompStmt(sl,s); RESULT = sl; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmtlist",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // stmtlist ::= 
            {
              IStmt RESULT =null;
		 RESULT = new NopStmt(); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmtlist",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // stmt ::= SEMICOLON 
            {
              IStmt RESULT =null;
		 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmt",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // stmt ::= IDENT ASSIGN expr SEMICOLON 
            {
              IStmt RESULT =null;
		Location ixleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).xleft;
		Location ixright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).xright;
		String i = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		Location exleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location exright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 //System.out.println("new AssignStmt(\""+i+"\","+ e +","+ixleft.getLine()+")");
     RESULT = new AssignStmt(i,e,ixleft.getLine()); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmt",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // stmt ::= WHILE LPAR expr RPAR BEGIN stmtlist END 
            {
              IStmt RESULT =null;
		Location exleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).xleft;
		Location exright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).xright;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-4)).value;
		Location slxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location slxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		IStmt sl = (IStmt)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		
        RESULT = new WhileStmt(e,sl);
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmt",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // stmt ::= PRINT LPAR expr RPAR SEMICOLON 
            {
              IStmt RESULT =null;
		Location exleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).xleft;
		Location exright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).xright;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		
       RESULT = new PrintStmt((Exp)e,new Integer(1));
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmt",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // stmt ::= error 
            {
              IStmt RESULT =null;
		Location exleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xleft;
		Location exright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xright;
		Object e = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 parser.report_error("Syntax error, skipped nonsense",e); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmt",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // logicexpr ::= expr COMP expr 
            {
              Exp RESULT =null;
		Location e1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).xleft;
		Location e1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).xright;
		Exp e1 = (Exp)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		Location opxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location opxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		String op = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		Location e2xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xleft;
		Location e2xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xright;
		Exp e2 = (Exp)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 System.out.println("COMP");
        RESULT = new RelationalExp(op,e1,e2); //RelationalExp
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("logicexpr",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // stringexp ::= STRINGCONST 
            {
              Exp RESULT =null;
		Location scxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xleft;
		Location scxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xright;
		String sc = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 System.out.println("STRINGCONST");
      RESULT = new ValueExp(new StringValue(sc));  
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stringexp",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // expr ::= INTCONST 
            {
              Exp RESULT =null;
		Location cxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xleft;
		Location cxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xright;
		Integer c = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 //System.out.println("new ValueExp(new IntValue("+c+")");
      RESULT = new ValueExp(new IntValue(c)); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // expr ::= IDENT 
            {
              Exp RESULT =null;
		Location ixleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xleft;
		Location ixright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xright;
		String i = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new VarExp(i); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // expr ::= expr BINOPPRIORITY1 expr 
            {
              Exp RESULT =null;
		Location e1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).xleft;
		Location e1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).xright;
		Exp e1 = (Exp)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		Location opxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location opxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		char op = (char)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		Location e2xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xleft;
		Location e2xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xright;
		Exp e2 = (Exp)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		  System.out.println("BINOP:op"+op);
        RESULT = new ArithExp(op,e1, e2);
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // expr ::= expr BINOPPRIORITY2 expr 
            {
              Exp RESULT =null;
		Location e1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).xleft;
		Location e1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).xright;
		Exp e1 = (Exp)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		Location opxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location opxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		char op = (char)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		Location e2xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xleft;
		Location e2xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xright;
		Exp e2 = (Exp)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		  System.out.println("new ArithExp("+op+","+e1+","+ e2+")");
        RESULT = new ArithExp(op,e1, e2);
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // expr ::= logicexpr 
            {
              Exp RESULT =null;
		Location lxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xleft;
		Location lxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xright;
		Exp l = (Exp)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		      //System.out.println("BOOLCONST");
         RESULT = l;
       
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // expr ::= stringexp 
            {
              Exp RESULT =null;
		Location sxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xleft;
		Location sxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xright;
		Exp s = (Exp)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 //System.out.println("stringexp");
        RESULT = s;
     
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
              return CUP$Parser$do_action_part00000000(
                               CUP$Parser$act_num,
                               CUP$Parser$parser,
                               CUP$Parser$stack,
                               CUP$Parser$top);
    }
}

}
