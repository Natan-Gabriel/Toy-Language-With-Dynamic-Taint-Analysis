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
import model.types.BoolType;
import model.types.StringType;
import model.types.Type;
import model.values.BoolValue;
import model.values.StringValue;
import model.values.Value;

import java.io.BufferedReader;

public class changeStatus implements IStmt{
    Exp exp;
    Exp status;
    int lineNumber;
    public changeStatus(Exp e, Exp _status, int _lineNumber){exp=e;lineNumber=_lineNumber;status=_status;}

    public String toString() { return "changeStatus("+exp.toString()+")";}
    public PrgState execute(PrgState state) throws VarNotDefined, DivByZero, VarIsDefined, CustomException {
        MyIStack<IStmt> stk=state.getStk();
        MyIDictionary<String,Value> symTbl= state.getSymTable();
        MyIHeap hp= state.getHeap();
        MyIDictionary<StringValue, BufferedReader> fTbl=state.getFileTable();
        MyIDictionary<StringValue, Boolean> sTbl=state.getFileSecurity();

        Value status_evaluated = status.eval(symTbl,hp);
        if (!(status_evaluated.getType().equals(new BoolType())))
            throw new CustomException("status has to be a boolean");
        boolean bool = ((BoolValue)status_evaluated).getVal();

        Value val = exp.eval(symTbl,hp);
        Type typId= val.getType();

        if( !(typId.equals(new StringType())) )
            throw new CustomException("exp is not an identifier or file name");

        StringValue str_val = (StringValue)val;
        if(symTbl.isDefined(str_val.getVal())){
            String identifier = str_val.getVal();
            Value v = symTbl.lookup(identifier);
            v.setSecret(bool);
            symTbl.update(identifier,v);
        }

        // we will assume now that the given expression is a file name
        sTbl.add(str_val,bool);

        return state;
    }
    public int getStatementNumber(){return 1;}
    public int  getLineNumber(){return lineNumber;}
    public int getEndingLine() {return lineNumber;}




}
