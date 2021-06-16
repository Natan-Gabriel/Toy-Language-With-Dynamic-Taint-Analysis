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
	int count;

	 public wH(String v,Exp e,int c,int _lineNumber) {var_name=v;exp=e;count=c;lineNumber=_lineNumber;}
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
//		 if(!typId.equals(locationType))
//			 throw new VarNotDefined("Types don't match");

//		 System.out.println("symTbl:"+symTbl);
//		 System.out.println("heap:"+hp);
		 int key = ((RefValue) symTbl.lookup(var_name)).getAddr();
//		 System.out.println("key:"+key);
//		 System.out.println("hp.isDefined(val):"+hp.isDefined(key));
		 //System.out.println("count:"+count);
		 while(count>1) {
		 	 count--;
			 if (!hp.isDefined(key))
				 throw new VarNotDefined("The key is not defined in Heap(dangling reference)");

			 if(! (locationType instanceof RefType) )
				 throw new VarNotDefined("Types don't match");
			 locationType = ((RefType)locationType).getInner();
		 	 Value v = hp.getValue(key);
		 	 key = ((RefValue)v).getAddr();

		 }

		 if(!typId.equals(locationType))
			 throw new VarNotDefined("Types don't match");
		 if (key == 1) {
			 Value newVal = hp.add(val);
			 symTbl.update(var_name, newVal);
		 } else {
			 if (!hp.isDefined(key))
				 throw new VarNotDefined("Given key is not defined in Heap(dangling reference)");

			 if(val.getSecret())
				 throw new CustomException("you cannot write into heap a secret value");

			 hp.update(key, val);
		 }
		 
		 return state;
	}
	public int getStatementNumber(){return 1;}
	public int  getLineNumber(){return lineNumber;}
	public int getEndingLine() {return lineNumber;}
}
