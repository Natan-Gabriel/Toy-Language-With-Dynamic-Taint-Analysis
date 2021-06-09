package model.stmt;
import MyException.CustomException;
import MyException.DivByZero;
import MyException.VarNotDefined;
//import model.MyException;
import model.*;
import model.adt.MyIDictionary;
import model.adt.MyIHeap;
import model.adt.MyIList;
import model.adt.MyIStack;
import model.exp.*;
import model.types.*;
import model.values.Value;
import model.PrgState;

public class PrintStmt implements IStmt{
	 Exp exp;
	 int lineNumber;

	 public PrintStmt(Exp e,int _lineNumber) {exp=e;lineNumber=_lineNumber;}
	 public String toString(){ return "print(" +exp.toString()+")";}
	 public PrgState execute(PrgState state) throws DivByZero, VarNotDefined, CustomException {
		 //try {
		 MyIList<Value> lst=state.getOut();
		 MyIDictionary<String,Value> symTbl= state.getSymTable();
		 MyIHeap hp= state.getHeap();
		 Value val = exp.eval(symTbl,hp);
		 if(!val.getSecret()){
			 lst.add(val);
			 System.out.print(val);
		 }
		 else
		 	throw new CustomException("you cannot print a secret value");
		 //state.setNextInstruction(getStatementNumber()+1);
//		 if(state.getNextInstructions().isEmpty())
//			 state.getNextInstructions().push(getStatementNumber()+1);
		 return state;
		 //}
		// catch(DivByZero e) {
		//	throw e;
		// } 
		// catch(VarNotDefined e) {
		//		throw e;
		//	 } 

	 }
//	public int getStatementNumber(){return instructionNumber;}
	public int  getLineNumber(){return lineNumber;}
	public int getEndingLine() {return lineNumber;}
	
}
