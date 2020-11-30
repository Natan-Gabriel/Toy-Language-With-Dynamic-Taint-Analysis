package model.stmt;
import model.PrgState;
import model.exp.*;
import model.adt.*;
import MyException.*;

public class CompStmt1 implements IStmt{
    IStmt first;
    IStmt snd;
    public CompStmt1(IStmt f,IStmt s) {first=f;snd=s;}
    public String toString() { return "("+first.toString() + ";" + snd.toString()+")";}
    public PrgState execute(PrgState state) {

        MyIStack<IStmt> stk=state.getStk();
        stk.push(snd);
        stk.push(first);
        return state;
    }
    public int getStatementNumber(){return 1;}
}
