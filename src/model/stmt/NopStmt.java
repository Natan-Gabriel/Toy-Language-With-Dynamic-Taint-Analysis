package model.stmt;

import model.PrgState;
import model.adt.MyIStack;

class NopStmt implements IStmt{
	public String toString() {return "nop";}
	public PrgState execute(PrgState state) {
		MyIStack<IStmt> stk=state.getStk();
		stk.pop();
		return state;
		}
	 //..........................
	 }
