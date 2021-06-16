package model.stmt;

import MyException.CustomException;
import MyException.DivByZero;
import MyException.VarIsDefined;
import MyException.VarNotDefined;
import model.PrgState;
import model.adt.MyIDictionary;
import model.adt.MyIHeap;
import model.adt.MyIStack;
import model.exp.Exp;
import model.types.IntType;
import model.types.StringType;
import model.values.IntValue;
import model.values.StringValue;
import model.values.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class writeFile implements IStmt{
    Exp exp;
    BufferedReader file;
    Exp text;
    String line="";
    int lineNumber;

    public writeFile(Exp e,Exp t,int _lineNumber) {exp=e;text=t;lineNumber=_lineNumber;}
    public String toString() { return exp.toString();}
    public PrgState execute(PrgState state) throws VarNotDefined, DivByZero, VarIsDefined, CustomException {
        MyIStack<IStmt> stk=state.getStk();
        MyIDictionary<String, Value> symTbl= state.getSymTable();
        MyIHeap hp= state.getHeap();

        Value val = exp.eval(symTbl,hp);

        if(val.getSecret())
            throw new CustomException("you cannot write to  a file a secret value");

        if( !(val.getType()).equals(new StringType()) )
            throw new VarNotDefined("The var is not a string");
        StringValue val1=(StringValue)val;



        Value text_value = text.eval(symTbl,hp);
        if( !(text_value.getType()).equals(new StringType()) )
            throw new VarNotDefined("The text is not a string");
        StringValue text_string=(StringValue)text_value;

        try {
            Files.write(Paths.get(val1.getVal()), text_string.getVal().getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            //System.out.println("e.toString()\n\n: "+e.toString());
            throw new CustomException(e.toString());
        }

        MyIDictionary<StringValue, Boolean> sTbl=state.getFileSecurity();

        sTbl.update(val1,text_value.getSecret());


        return state;
    }
    public int getStatementNumber(){return 1;}
    public int  getLineNumber(){return lineNumber;}
    public int getEndingLine() {return lineNumber;}
}
