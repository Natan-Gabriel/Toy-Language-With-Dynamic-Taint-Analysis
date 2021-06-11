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
	 int lineNumber;
	 
	 public AssignStmt(String i,Exp e,int _lineNumber) {id=i;exp=e;lineNumber=_lineNumber;}
	 public String toString() { return id+"="+ exp.toString();}
	 public PrgState execute(PrgState state) throws VarNotDefined, DivByZero, CustomException {
		 //state.setNextInstruction(getStatementNumber()+1);
		 MyIStack<IStmt> stk=state.getStk();
		 MyIDictionary<String,Value> symTbl= state.getSymTable();
		 MyIHeap hp= state.getHeap();


		 if(symTbl.isDefined(id)){
			 Value val = exp.eval(symTbl,hp);
			 Type typId= (symTbl.lookup(id)).getType();

			 if( typId.equals(new IntType()) && (val.getType()).equals(new StringType()) ) {
			 	 String str = ((StringValue)val).getVal();
				 int new_integer=0;
			 	 try {
					 new_integer = Integer.parseInt(str);
				 }
				 catch(Exception e)
				 {
					 throw new CustomException("the given string cannot be converted to an integer");
				 }
				 symTbl.update(id, new IntValue(new_integer));
			 }

			 else if( typId.equals(new StringType()) && (val.getType()).equals(new IntType()) ) {
				 int integer = ((IntValue)val).getVal();
				 String new_string="";
				 new_string = String.valueOf(integer);
				 symTbl.update(id, new StringValue(new_string));
			 }
			 else if( (val.getType()).equals(typId) )
				 symTbl.update(id, val);
			 else
			 	throw new VarNotDefined("declared type of variable"+id+" and type of the assigned expression do not match");
		 }
		 else throw new VarNotDefined("the used variable" +id + " was not declared before");


		 return state;
	 }
	//public int getStatementNumber(){return instructionNumber;}
	public int getLineNumber() {return lineNumber;}
	public int getEndingLine() {return lineNumber;}
}


