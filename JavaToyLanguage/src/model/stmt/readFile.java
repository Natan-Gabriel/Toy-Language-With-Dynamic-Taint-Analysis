package model.stmt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import MyException.*;
import model.*;
import model.adt.*;
import model.exp.Exp;
import model.exp.ValueExp;
import model.types.* ;
import model.values.*;

public class readFile implements IStmt{
	 Exp exp;
	 BufferedReader file;
	 String var_name;
	 String line="";
	 int instructionNumber;
	 
	 public readFile(Exp e,String v,int _instructionNumber) {exp=e;var_name=v;instructionNumber=_instructionNumber;}
	 public String toString() { return "Read "+exp.toString();}
	 public PrgState execute(PrgState state) throws VarNotDefined, DivByZero, VarIsDefined, CustomException {
		if(state.getNextInstructions().isEmpty())
		 	state.getNextInstructions().push(getStatementNumber()+1); 
		MyIStack<IStmt> stk=state.getStk();
		 MyIDictionary<String,Value> symTbl= state.getSymTable();
		 MyIHeap hp= state.getHeap();
		 
		 if(!symTbl.isDefined(var_name))
			 throw new VarNotDefined("var_name is not defined");
		 if(!symTbl.lookup(var_name).getType().equals(new IntType()))
			 throw new VarNotDefined("var_name is not int");
		 
		 Value val = exp.eval(symTbl,hp);
		 if( !(val.getType()).equals(new StringType()) )
		 	 	throw new VarNotDefined("The var is not a string");
		 StringValue val1=(StringValue)val;
		 MyIDictionary<StringValue, BufferedReader> fTbl=state.getFileTable();
		//  System.out.println("fTbl"+fTbl);
		//  System.out.println("val1"+val1);
		//  System.out.println("fTbl.isDefined(val1)"+fTbl.isDefined(val1));
		//  System.out.println("fTbl.keySet()"+fTbl.keySet());
		//  System.out.println("fTbl.isDefined(integer.txt)"+fTbl.isDefined(new StringValue("integer.txt")));
		//  System.out.println("new StringValue(\"integer.txt\") instanceof StringValue"+(new StringValue("integer.txt") instanceof StringValue));
		 
		 if(!fTbl.isDefined(val1))
			 throw new VarNotDefined("File "+val1+" does not exist");
			 
		 file=fTbl.getValue(val1);
		 try {
		 line=file.readLine();
		 System.out.println(line);
		 }
		 catch(Exception e){
			 return state;
		 }
		 int comp;
		 if(line==null)
			 comp=0;
		 else
			 comp=Integer.parseInt(line);
		 symTbl.update(var_name,new IntValue(comp));

		 
		 return state;
	 }
	public int getStatementNumber(){return instructionNumber;}
	public void setStatementNumber(int number){;}
}
