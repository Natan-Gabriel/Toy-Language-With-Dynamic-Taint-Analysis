package model.stmt;

import model.PrgState;
import model.adt.MyIStack;

public class NopStmt implements IStmt{
	int lineNumber=-1;
	public NopStmt(){}
	public NopStmt(int _lineNumber) {lineNumber=_lineNumber;}

	public String toString() {return "nop";}
	public PrgState execute(PrgState state) {
		return state;
		}
	 //..........................
	 public int getStatementNumber(){return 1;}
	public void setStatementNumber(int number){;}
	public int getNumberOfNestedStatements(){return 0;}
	 }
