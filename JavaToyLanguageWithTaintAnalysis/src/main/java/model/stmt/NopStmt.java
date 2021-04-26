package model.stmt;

import model.PrgState;
import model.adt.MyIStack;
import model.exp.Exp;

public class NopStmt implements IStmt{
	int lineNumber;
//	public NopStmt(int _lineNumber) {lineNumber=_lineNumber;}
	public String toString() {return "nop";}
	public PrgState execute(PrgState state) {
		MyIStack<IStmt> stk=state.getStk();
//		stk.pop();
		return state;
		}
	 //..........................
	 public int getStatementNumber(){return 1;}
	public int  getLineNumber(){return -1;}
	 }
