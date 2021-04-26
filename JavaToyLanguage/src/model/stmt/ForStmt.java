package model.stmt;

import MyException.CustomException;
import MyException.DivByZero;
import MyException.VarNotDefined;
import model.PrgState;
import model.adt.MyIDictionary;
import model.adt.MyIHeap;
import model.adt.MyIStack;
import model.exp.Exp;
import model.types.BoolType;
import model.values.BoolValue;
import model.values.Value;

public class ForStmt {
    Exp exp;
    IStmt s1,s3,s;
    int startingLine, endingLine;

    public ForStmt(Exp e,IStmt s1,int _startingLine,int _endingLine) {exp=e;s=s1;startingLine = _startingLine; endingLine = _endingLine;}
    public String toString() { return "FOR("+s1.toString()+";"+exp.toString()+";"+s3.toString()+") "+s.toString();}
    public PrgState execute(PrgState state) throws VarNotDefined, DivByZero, CustomException {
        MyIStack<IStmt> stk=state.getStk();
        MyIDictionary<String, Value> symTbl= state.getSymTable();
        MyIHeap hp= state.getHeap();

        Value val=exp.eval(symTbl,hp);
        if(val.getType().equals(new BoolType())){
            if( ((BoolValue)val).getVal()==true ) {
                stk.push(new WhileStmt(exp,s,startingLine,endingLine));
                stk.push(s);
            }
            else
                ;//do nothing
        }
        else throw new VarNotDefined("while  condition is not a boolena value");


        return state;
    }
    public int getStatementNumber(){return 1;}
    public int  getLineNumber(){return startingLine;}
    public int getEndingLine() {return endingLine;}
}
