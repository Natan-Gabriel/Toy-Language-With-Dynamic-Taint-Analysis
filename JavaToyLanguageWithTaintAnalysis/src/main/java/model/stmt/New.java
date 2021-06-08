package model.stmt;

import MyException.*;
import model.PrgState;
import model.adt.*;
import model.exp.*;
import model.types.*;
import model.values.*;
import model.types.*;

public class New implements IStmt{
	String var_name;
	Exp exp;
	int lineNumber;
	public New(String s,Exp e,int _lineNumber) {var_name=s;exp=e;lineNumber=_lineNumber;}
	public String toString() { return var_name+"="+exp.toString();}
	@Override
	public PrgState execute(PrgState state) throws VarNotDefined, DivByZero, VarIsDefined, CustomException {
		 MyIStack<IStmt> stk=state.getStk();
		 MyIDictionary<String,Value> symTbl= state.getSymTable();
		 MyIHeap heap= state.getHeap();

		 if(!symTbl.isDefined(var_name))
			 throw new VarNotDefined("Var_name is not defined");
		 if( !(symTbl.getValue(var_name).getType() instanceof RefType))
			 throw new VarNotDefined("The var has not RefType");


		 Value val = exp.eval(symTbl,heap);
		 Type typId= val.getType();
		 Type locationType= ((RefValue)symTbl.getValue(var_name)).getLocationType();
		 if( !typId.equals(locationType) )
		 	 	throw new VarNotDefined("The var_name and exp doesn't have same type");

		 Value newVal=heap.add(val);
		 symTbl.update(var_name,newVal);

		 return state;
	 }
	public int getStatementNumber(){return 1;}
	public int  getLineNumber(){return lineNumber;}
	public int getEndingLine() {return lineNumber;}

}
