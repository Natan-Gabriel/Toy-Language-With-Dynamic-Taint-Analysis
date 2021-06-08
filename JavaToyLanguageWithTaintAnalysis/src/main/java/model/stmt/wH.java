package model.stmt;

import MyException.*;
import model.*;
import model.adt.*;
import model.exp.*;
import model.types.*;
import model.values.*;

public class wH implements IStmt{
	String var_name;
	 Exp exp;
	int lineNumber;

	 public wH(String v,Exp e,int _lineNumber) {var_name=v;exp=e;lineNumber=_lineNumber;}
	 public String toString() { return var_name+","+exp.toString();}
	 public PrgState execute(PrgState state) throws VarNotDefined, DivByZero, VarIsDefined, CustomException {
		 MyIStack<IStmt> stk=state.getStk();
		 MyIDictionary<String,Value> symTbl= state.getSymTable();
		 MyIHeap hp= state.getHeap();
		 
		 if(! symTbl.isDefined(var_name) )
		 	 	throw new VarNotDefined("The var is not defined");
		 if(! (symTbl.lookup(var_name).getType() instanceof RefType) )
		 	 	throw new VarNotDefined("The var does not have RefType");


		 Value val = exp.eval(symTbl,hp);
		 Type typId= val.getType();
		 Type locationType=((RefValue)symTbl.lookup(var_name)).getLocationType();
		 if(!typId.equals(locationType))
			 throw new VarNotDefined("Types don't match");

		 System.out.println("symTbl:"+symTbl);
		 System.out.println("heap:"+hp);
		 int key = ((RefValue) symTbl.lookup(var_name)).getAddr();
		 System.out.println("key:"+key);
		 System.out.println("hp.isDefined(val):"+hp.isDefined(key));
		 if(!hp.isDefined(key)){
			 Value newVal=hp.add(val);
			 symTbl.update(var_name,newVal);
		 }
		 else {
		 	 key = ((RefValue) symTbl.lookup(var_name)).getAddr();
			 if (!hp.isDefined(key))
				 throw new VarNotDefined("Given key is not defined in Heap");
			 hp.update(key, val);
		 }
		 
		 return state;
	 }
	public int getStatementNumber(){return 1;}
	public int  getLineNumber(){return lineNumber;}
	public int getEndingLine() {return lineNumber;}
}
