package model.stmt;
import model.PrgState;
import model.exp.*;
import model.adt.*;
import MyException.*;

public class CompStmt implements IStmt{
	 IStmt first;
	 IStmt snd;
	 public CompStmt(IStmt f,IStmt s) {first=f;snd=s;}
	 public String toString() { return "("+first.toString() + ";" + snd.toString()+")";}
	 public PrgState execute(PrgState state) {
	 
		 MyIStack<IStmt> stk=state.getStk();
		 stk.push(snd);
		 stk.push(first);
//		 MyIDictionary<Integer,IStmt> exeDictionary=state.getExeDictionary();
//		 exeDictionary.add(first.getStatementNumber(),first);
//		 exeDictionary.add(snd.getStatementNumber(),snd);
		 return state;
	 }
	public int getStatementNumber(){return 1;}
	public void setStatementNumber(int number){;}
}
