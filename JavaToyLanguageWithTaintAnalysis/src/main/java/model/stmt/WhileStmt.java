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
	int totalLength;
	int numberOfNestedStatements=0;
	 
	 public WhileStmt(Exp e, List<IStmt> s1,int _instructionNumber,int _totalLength ) {
	 	 exp=e;s=s1;instructionNumber=_instructionNumber; totalLength=_totalLength;
		 for(IStmt istmt:s){
			 numberOfNestedStatements = numberOfNestedStatements + istmt.getNumberOfNestedStatements() + 1 ;
		 }
		 System.out.println("numberOfNestedStatements in "+ this + " is"+numberOfNestedStatements);
	 }
	 public String toString() { return "WHILE("+exp.toString()+") "+s.toString();}
	 public PrgState execute(PrgState state) throws VarNotDefined, DivByZero, CustomException {
		 MyIStack<IStmt> stk=state.getStk();
		 MyIDictionary<String,Value> symTbl= state.getSymTable();
		 MyIHeap hp= state.getHeap();
		 //System.out.println("WHILE");
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
					 //System.out.println("s.get(i).getStatementNumber()"+s.get(i).getStatementNumber());
				 }


			 }
			 else{
				 if (nextInstructions.getSize()==0 || nextInstructions.lastElement()!=instructionNumber+totalLength+1) {// to avoid adding of same if ending instruction (in case of nested if's)
					System.out.println("instructionNumber "+instructionNumber+" totalLength "+totalLength+" numberOfNestedStatements "+numberOfNestedStatements);
				 	nextInstructions.push(instructionNumber + numberOfNestedStatements + 1);
				 }
				 //System.out.println("nextInstructions:"+nextInstructions);
			 }

		 }
		 else throw new VarNotDefined("while  condition is not a boolena value");

		
		 return state;
	 }
	 public List<IStmt> getStatements() {return s;}
	public int getStatementNumber(){return instructionNumber;}
	public void setStatementNumber(int number){instructionNumber=number;}
	public int getTotalLength(){return totalLength;}
	public int getNumberOfNestedStatements(){return numberOfNestedStatements;}
}
