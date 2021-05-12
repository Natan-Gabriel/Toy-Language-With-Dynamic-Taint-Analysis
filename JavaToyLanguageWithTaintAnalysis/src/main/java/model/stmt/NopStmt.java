package model.stmt;

import model.PrgState;
import model.adt.MyIStack;

public class NopStmt implements IStmt{
	public String toString() {return "nop";}
	public PrgState execute(PrgState state) {
//		MyIStack<IStmt> stk=state.getStk();
//		stk.pop();
		return state;
		}
	 //..........................
	 public int getStatementNumber(){return 1;}
	public void setStatementNumber(int number){;}
	public int getNumberOfNestedStatements(){return 0;}
	 }
