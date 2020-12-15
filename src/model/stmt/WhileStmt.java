package model.stmt;

import MyException.*;
import model.*;
import model.adt.*;
import model.exp.*;
import model.types.*;
import model.values.*;

import java.util.List;

public class WhileStmt implements IStmt{
	 Exp exp;
	List<IStmt> s;
	int instructionNumber;
	 
	 public WhileStmt(Exp e, List<IStmt> s1,int _instructionNumber ) {exp=e;s=s1;instructionNumber=_instructionNumber;}
	 public String toString() { return "WHILE("+exp.toString()+") "+s.toString();}
	 public PrgState execute(PrgState state) throws VarNotDefined, DivByZero{
		 MyIStack<IStmt> stk=state.getStk();
		 MyIDictionary<String,Value> symTbl= state.getSymTable();
		 MyIHeap hp= state.getHeap();

		 MyIStack<Integer> nextInstructions=state.getNextInstructions();

		 Value val=exp.eval(symTbl,hp);

		 if(val.getType().equals(new BoolType())){
			 if( ((BoolValue)val).getVal() ) {

				 nextInstructions.push(instructionNumber);

				 for(int i=s.size()-1;i>=0;i--) {

//				 	if(i==s.size()-1) {
//						nextInstructions.push(-1);
//					}

					 nextInstructions.push(s.get(i).getStatementNumber());
					 System.out.println("s.get(i).getStatementNumber()"+s.get(i).getStatementNumber());
				 }


			 }
			 else
				 nextInstructions.push(instructionNumber+s.size()+2);//do nothing
		 }
		 else throw new VarNotDefined("while  condition is not a boolena value");

		
		 return state;
	 }
	public int getStatementNumber(){return instructionNumber;}
}
