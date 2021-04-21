package model.stmt;
import model.PrgState;
import model.adt.MyIDictionary;
import model.adt.MyIHeap;
import model.adt.MyIStack;
import model.exp.*;
import model.types.*;
import model.values.*;
import MyException.*;

import java.util.List;

public class IfStmt implements IStmt{
	 Exp exp;
	 List<IStmt> thenS;
	 List<IStmt> elseS;
	 int instructionNumber;
	 
	 public IfStmt(Exp e, List<IStmt> t, List<IStmt> el, int _instructionNumber) {exp=e; thenS=t;elseS=el;instructionNumber=_instructionNumber;}
	 public String toString(){ return "IF("+ exp.toString()+") THEN(" +thenS.toString()+")ELSE("+elseS.toString()+") instructionNumber"+instructionNumber;}
	 public PrgState execute(PrgState state) throws VarNotDefined, DivByZero, CustomException {
		 MyIStack<IStmt> stk=state.getStk();
		 MyIDictionary<String,Value> symTbl= state.getSymTable();
		 MyIHeap hp= state.getHeap();
		 System.out.println("exp:"+exp);
		 Value val = exp.eval(symTbl,hp);
		 System.out.println("val:"+val);
		 MyIStack<Integer> nextInstructions=state.getNextInstructions();
		 if (val.getType().equals(new BoolType())) {
			 BoolValue v = (BoolValue) val;
			 System.out.println("instructionNumber+thenS.size()+elseS.size()+1:"+(instructionNumber+thenS.size()+elseS.size()+1));
			 nextInstructions.push(instructionNumber+thenS.size()+elseS.size()+1);
			 if (v.getVal()) {

			 	for(int i=thenS.size()-1;i>=0;i--) {

					System.out.println("thenS:"+thenS);
//				 	if(i==s.size()-1) {
//						nextInstructions.push(-1);
//					}
//					state.getNextInstructions().push(thenS.getStatementNumber()+2);

					 nextInstructions.push(thenS.get(i).getStatementNumber());
					 System.out.println("s.get(i).getStatementNumber()"+thenS.get(i)+"apoi"+thenS.get(i).getStatementNumber());


				 }
			 } else {
				 for(int i=elseS.size()-1;i>=0;i--) {
//				 state.setNextInstruction(elseS.getStatementNumber());
					 state.getNextInstructions().push(elseS.get(i).getStatementNumber());
				 }
			 }

		 }
		 else throw new VarNotDefined("type of expression"+exp.toString()+" is not a boolean");

		 return state;
	 }
	 //...
	 public int getStatementNumber(){return instructionNumber;}
	public void setStatementNumber(int number){instructionNumber=number;}
}

