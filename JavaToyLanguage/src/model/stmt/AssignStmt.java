package model.stmt;
import model.PrgState;
import model.adt.*;
import model.exp.*;
import model.values.*;
import model.types.*;
import MyException.*;

public class AssignStmt implements IStmt{
	 String id;
	 Exp exp;
	 int instructionNumber;
	 
	 public AssignStmt(String i,Exp e,int _instructionNumber) {id=i;exp=e;instructionNumber=_instructionNumber;}
	 public String toString() { return id+"="+ exp.toString();}
	 public PrgState execute(PrgState state) throws VarNotDefined, DivByZero{
//		 state.setNextInstruction(getStatementNumber()+1);
		 state.getNextInstructions().push(getStatementNumber()+1);
		 MyIStack<IStmt> stk=state.getStk();
		 MyIDictionary<String,Value> symTbl= state.getSymTable();
		 MyIHeap hp= state.getHeap();
		 if(symTbl.isDefined(id)){
			 Value val = exp.eval(symTbl,hp);
			 Type typId= (symTbl.lookup(id)).getType();
			 if( (val.getType()).equals(typId) ) {
				 symTbl.update(id, val);
				 state.getNextInstructions().push(instructionNumber + 1);
			 }
		 	 else throw new VarNotDefined("declared type of variable"+id+" and type of the assigned expression do not match");}
		 else throw new VarNotDefined("the used variable" +id + " was not declared before");
		 return state;
	 }
	public int getStatementNumber(){return instructionNumber;}
}


