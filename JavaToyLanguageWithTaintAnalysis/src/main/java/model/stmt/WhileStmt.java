package model.stmt;

import MyException.*;
import model.*;
import model.adt.*;
import model.exp.*;
import model.types.*;
import model.values.*;

public class WhileStmt implements IStmt{
	 Exp exp;
	 IStmt s;
	 int startingLine, endingLine;
	 
	 public WhileStmt(Exp e,IStmt s1,int _startingLine,int _endingLine) {exp=e;s=s1;startingLine = _startingLine; endingLine = _endingLine;}
	 public String toString() { return "WHILE("+exp.toString()+") "+s.toString();}
	 public PrgState execute(PrgState state) throws VarNotDefined, DivByZero, CustomException {
		 MyIStack<IStmt> stk=state.getStk();
		 MyIDictionary<String,Value> symTbl= state.getSymTable();
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
	public PrgState simulateExecution(PrgState state) throws VarNotDefined, DivByZero, CustomException {
		MyIStack<IStmt> stk=state.getStk();
		stk.push(new WhileStmt(exp,s,startingLine,endingLine));
		stk.push(s);

		return state;
	}

	public int getStatementNumber(){return 1;}
	public int  getLineNumber(){return startingLine;}
	public int getEndingLine() {return endingLine;}
}
