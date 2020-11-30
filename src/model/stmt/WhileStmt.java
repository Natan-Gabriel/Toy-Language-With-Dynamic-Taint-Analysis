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
	 
	 public WhileStmt(Exp e,IStmt s1) {exp=e;s=s1;}
	 public String toString() { return "WHILE("+exp.toString()+") "+s.toString();}
	 public PrgState execute(PrgState state) throws VarNotDefined, DivByZero{
		 MyIStack<IStmt> stk=state.getStk();
		 MyIDictionary<String,Value> symTbl= state.getSymTable();
		 MyIHeap hp= state.getHeap();
		 
		 Value val=exp.eval(symTbl,hp);
		 if(val.getType().equals(new BoolType())){
			 if( ((BoolValue)val).getVal()==true ) {
				 stk.push(new WhileStmt(exp,s));
				 stk.push(s);
			 }
			 else
				 ;//do nothing
		 }
		 else throw new VarNotDefined("while  condition is not a boolena value");

		
		 return state;
	 }
}
