package model.stmt;
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
	 public PrintStmt(Exp e) {exp=e;}
	 public String toString(){ return "print(" +exp.toString()+")";}
	 public PrgState execute(PrgState state) throws DivByZero, VarNotDefined
	 {
		 //try {
		 MyIList<Value> lst=state.getOut();
		 MyIDictionary<String,Value> symTbl= state.getSymTable();
		 MyIHeap hp= state.getHeap();
		 Value val = exp.eval(symTbl,hp);
		 lst.add(val);
		 return state;
		 //}
		// catch(DivByZero e) {
		//	throw e;
		// } 
		// catch(VarNotDefined e) {
		//		throw e;
		//	 } 

	 }
	
}
