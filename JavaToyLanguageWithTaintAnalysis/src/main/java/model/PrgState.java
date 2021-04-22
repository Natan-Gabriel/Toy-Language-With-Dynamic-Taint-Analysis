package model;
import model.stmt.*;
import model.adt.*;
import model.values.*;
import model.types.*;
import java.io.*;
import java.util.List;

public class PrgState{
	 MyIStack<IStmt> exeStack; // kind of sigma
	 MyIDictionary<Integer,IStmt> exeDictionary;//this is sigma
	 int nextInstruction=1;
	 MyIStack<Integer> nextInstructions=new MyStack<Integer>();
	 MyIDictionary<String, Value> symTable; //miu
	 MyIDictionary<String,Pair<Value,Value>> dynaimcSymTable; //miu
	 MyIDictionary<StringValue,BufferedReader> FileTable;
	 MyIList<Value> out;
	 MyIHeap heap; //delta
	 IStmt originalProgram; //optional field, but good to have
	 @Override
	 public String toString() {return "Execution stack is "+exeStack.toString()+ "Execution dictionary is "+exeDictionary.toString()
			 +"Next instructions are: "+nextInstructions+"Next instruction is: "+nextInstructions.lastElement()+", Symbol table is "+symTable.toString()+", Out table is"+out.toString()+", Heap is"+heap.toString()+"\n";}
	 public PrgState(MyIStack<IStmt> stk,MyIDictionary<Integer,IStmt> _exeDictionary, MyIDictionary<String,Value> symtbl,MyIDictionary<String,Pair<Value,Value>> _dynaimcSymTable,MyIList<Value> ot,MyIDictionary<StringValue, BufferedReader >fTbl, MyIHeap heap1,IStmt prg){
		 exeStack=stk;
		 symTable=symtbl;
		 dynaimcSymTable=_dynaimcSymTable;
		 out = ot;
		 originalProgram=prg;
		 FileTable=fTbl;
		 heap=heap1;
		 exeDictionary=_exeDictionary;
		 //IStmt originalProgram=(IStmt)Object.clone(prg);
		 //IStmt originalProgram=(IStmt)deepCopy(prg);//recreate the entire original prg
		 stk.push(prg);

		 nextInstructions.push(1);
	 }
//	public PrgState(MyIStack<IStmt> stk,MyIDictionary<Integer,IStmt> _exeDictionary, MyIDictionary<String,Value> symtbl,MyIDictionary<String,Pair<Value,Value>> _dynaimcSymTable,MyIList<Value> ot,MyIDictionary<StringValue, BufferedReader >fTbl, MyIHeap heap1,List<IStmt> prg){
//		exeStack=stk;
//		symTable=symtbl;
//		dynaimcSymTable=_dynaimcSymTable;
//		out = ot;
//		originalProgram=prg;
//		FileTable=fTbl;
//		heap=heap1;
//		exeDictionary=_exeDictionary;
//		//IStmt originalProgram=(IStmt)Object.clone(prg);
//		//IStmt originalProgram=(IStmt)deepCopy(prg);//recreate the entire original prg
//		stk.push(prg);
//	}




	 public MyIStack<IStmt> getStk() {return exeStack;}
	 public int getNextInstruction(){return  nextInstruction;}
	 public MyIStack<Integer> getNextInstructions(){return  nextInstructions;}
	 public MyIDictionary<String,Value> getSymTable(){return symTable;}

	public MyIDictionary<Integer,IStmt> getExeDictionary() {return exeDictionary;}

	 public MyIList<Value> getOut() {return out;}
	 public MyIDictionary<StringValue, BufferedReader > getFileTable() {return FileTable;}
	 public MyIHeap getHeap() {return heap;}
	 
	 public void setStk(MyIStack<IStmt> e) {exeStack=e;}
	 public void setExeDictionary(MyIDictionary<Integer,IStmt> e) {exeDictionary=e;}
	 public void setNextInstruction(int val){nextInstruction=val;}
	 public void setNextInstructions(MyIStack<Integer> l){nextInstructions=l;}
	 public void setSymTable(MyIDictionary<String,Value> e){symTable=e;}
	 public void setOut(MyIList<Value> e) {out=e;}
	 public void setFileTable(MyIDictionary<StringValue,BufferedReader> e) {FileTable=e;}
	 public void setHeap(MyIHeap heap1) {heap=heap1;}
	 //.....
	 }
