package model.stmt;

import java.io.BufferedReader;

import MyException.CustomException;
import MyException.DivByZero;
import MyException.VarIsDefined;
import MyException.VarNotDefined;
import model.PrgState;
import model.adt.MyIDictionary;
import model.adt.MyIHeap;
import model.adt.MyIStack;
import model.exp.Exp;
import model.types.IntType;
import model.types.StringType;
import model.types.Type;
import model.values.IntValue;
import model.values.StringValue;
import model.values.Value;

public class closeRFile implements IStmt{
	 Exp exp;
	 BufferedReader file;
	 String var_name;
	 String line="";
	 int instructionNumber;
	 
	 public closeRFile(Exp e,int _instructionNumber) {exp=e;instructionNumber=_instructionNumber;}
	 public String toString() { return "Close: "+exp.toString();}
	 public PrgState execute(PrgState state) throws VarNotDefined, DivByZero, VarIsDefined, CustomException {
		if(state.getNextInstructions().isEmpty())
		 	state.getNextInstructions().push(getStatementNumber()+1); 
		MyIStack<IStmt> stk=state.getStk();
		 MyIDictionary<String,Value> symTbl= state.getSymTable();
		 MyIHeap hp= state.getHeap();
		 
		 Value val = exp.eval(symTbl,hp);
		 Type typId= val.getType();
		 if( !(typId).equals(new StringType()) )
		 	 	throw new VarNotDefined("The var is not a string");
		 StringValue val1=(StringValue)val;
		 MyIDictionary<StringValue, BufferedReader> fTbl=state.getFileTable();
		 if(!fTbl.isDefined(val1))
			 throw new VarNotDefined("VarNotDefined");
			 
		 file=fTbl.getValue(val1);
		 
		 try {
		 file.close();
		 }
		 catch(Exception e){
			 return state;
		 }
		 //System.out.println("fTbl"+fTbl);
		 fTbl.remove(val1);
		 //System.out.println("fTbl"+fTbl);
		 
		 return state;
	 }
	public int getStatementNumber(){return instructionNumber;}
	public void setStatementNumber(int number){;}
}
