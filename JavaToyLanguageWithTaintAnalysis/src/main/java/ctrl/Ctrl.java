package ctrl;
import model.*;
import model.adt.*;
import model.stmt.*;
import model.values.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import MyException.*;
import repo.*;

public class Ctrl implements iCtrl{
	iRepo repo; 
	boolean flag=false;
	public Ctrl(iRepo r) {repo=r;}
	public Ctrl(iRepo r, boolean _flag) {repo=r;flag=_flag;}
//	int nextInstruction=1;
	
	Map<Integer,Value> unsafeGarbageCollector(List<Integer> symTableAddr, Map<Integer,Value> heap){
	return heap.entrySet().stream()
			.filter(e->(symTableAddr.contains(e.getKey()) ||  getAddrFromHeap(heap.values()).contains(e.getKey())))
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue) ) ;}
	
	List<Integer> getAddrFromSymTable(Collection<Value> symTableValues){
	return symTableValues.stream()
			.filter(v-> v instanceof RefValue)
			.map(v-> {RefValue v1 = (RefValue)v; return v1.getAddr();})
			.collect(Collectors.toList());
	}
	
	List<Integer> getAddrFromHeap(Collection<Value> HeapValues){
		return HeapValues.stream()
				.filter(v-> v instanceof RefValue)
				.map(v-> {RefValue v1 = (RefValue)v; return v1.getAddr();})
				.collect(Collectors.toList());
		}

	
//	public void parseTree() throws DivByZero, VarIsDefined, VarNotDefined, TaintedAddress, CustomException {
//		PrgState prg = repo.getCrtPrg();
//		MyIStack<IStmt> stk=prg.getStk();
//		boolean bool=false;
//		while(bool==false) {
//			bool=true;
//			for (int i = 0; i < stk.getSize(); i++) {
//				IStmt crtStmt = stk.get(i);
//					if(crtStmt instanceof  CompStmt){
//						bool=false;
//						stk.remove(i);
//						crtStmt.execute(prg);
//					}
//			}
//
//		}
//
//		MyIDictionary<Integer,IStmt> exeDictionary=prg.getExeDictionary();
//		for (int i = 0; i < stk.getSize(); i++) {
//			IStmt crtStmt = stk.get(i);
//			exeDictionary.add(crtStmt.getStatementNumber(),crtStmt);
//
//		}
//
//	}


	public void executeGoto(PrgState state, int jumpLine) throws Exception {

		PrgState prg = repo.getCrtPrg(); // repo is the controller field of type MyRepoInterface
		//System.out.println(prg);//here you can display the prg state
		repo.logPrgStateExec();
		MyIStack<IStmt> stk = new MyStack<IStmt>();
		state.setStk(stk);
		stk.push(state.getOriginalProgram());

		while (!stk.isEmpty()){
			IStmt crtStmt = stk.pop();
			if(crtStmt instanceof CompStmt){
				crtStmt.execute(state);
				//System.out.println("I reached here. stk is: "+stk);
			}
			else if((crtStmt instanceof AssignStmt) && ((AssignStmt)crtStmt).getLineNumber()==jumpLine ){
				stk.push(crtStmt);
				break;
			}
			else if ((crtStmt instanceof WhileStmt) && ((WhileStmt)crtStmt).getLineNumber()<=jumpLine && jumpLine<=((WhileStmt)crtStmt).getEndingLine()  ){ //(crtStmt instanceof IfStmt) ||
				crtStmt.execute(state);
				//System.out.println("crtStmt instanceof WhileStmt. stk is: "+stk);

			}

		}
	}



	public PrgState oneStep(PrgState state) throws ExeStackEmpty, VarNotDefined, DivByZero, VarIsDefined,Exception{
		 if(flag==true)
			 displayPrgState(state);
		 MyIStack<IStmt> stk=state.getStk();
		 MyIStack<IStmt> stk_executed=state.getStkExecuted();
		 if(stk.isEmpty()) 
			 throw new ExeStackEmpty("prgState stack is empty");
		 IStmt crtStmt = stk.pop();
		stk_executed.push(crtStmt);
//		 IStmt crtStmt = stk.lastElement();
		 //displayPrgState(state);
		 return crtStmt.execute(state);
		 }


	public PrgState oneStepUsingDictionary(PrgState state) throws ExeStackEmpty, VarNotDefined, DivByZero, VarIsDefined, TaintedAddress, CustomException {
		if(flag==true)
			displayPrgState(state);
//		MyIStack<IStmt> stk=state.getStk();
//		if(stk.isEmpty())
//			throw new ExeStackEmpty("prgState stack is empty");
//		IStmt crtStmt = stk.pop();
// 		 IStmt crtStmt = stk.lastElement();
		//displayPrgState(state);

		int nextInstruction=state.getNextInstruction();


		MyIDictionary<Integer,IStmt> exeDictionary=state.getExeDictionary();
		IStmt crtStmt = exeDictionary.getValue(nextInstruction);

		return crtStmt.execute(state);
	}
	public void allStep() throws Exception {

		 PrgState prg = repo.getCrtPrg(); // repo is the controller field of type MyRepoInterface
		 //System.out.println(prg);//here you can display the prg state
		 repo.logPrgStateExec();

//		 parseTree();
//
//		System.out.println(prg.getStk());
//		System.out.println(prg.getExeDictionary());
//
////		int nextInstruction=prg.getNextInstruction();
//
//		boolean end=false;
//
//		while(end==false){
//			oneStepUsingDictionary(prg);
//
////			nextInstruction+=1;
////			prg.setNextInstruction(nextInstruction);
//			if (prg.getNextInstruction()==1+prg.getExeDictionary().getSize()){
//				end=true;
//				prg.setNextInstruction(1);
//
//			}
//
//		}
		 while (!prg.getStk().isEmpty()){

//		 	 if(prg.getStk().lastElement() instanceof GotoStmt){
//				 executeGoto(prg,20);
//			 }
//		 	 else {
			 oneStep(prg);

			 //repo.logPrgStateExec();

			 repo.logPrgStateExec();

			 prg.getHeap().setContent(unsafeGarbageCollector(
					 getAddrFromSymTable(prg.getSymTable().getContent().values()),
					 prg.getHeap().getContent()));
			 //prg.getHeap().setContent(unsafeGarbageCollector(
			 //		 getAddrFromSymTable(prg.getSymTable().values()),
			 //		 prg.getHeap()));

//			 }
		 }
		 if(flag==true)
			 displayPrgState(prg);
		 }
	public void allStep(int b) throws ExeStackEmpty, VarNotDefined, DivByZero, VarIsDefined,Exception{
		 PrgState prg = repo.getCrtPrg(); // repo is the controller field of type MyRepoInterface
		 //System.out.println(prg);//here you can display the prg state
		 try {
				repo.logPrgStateExec();
			}
			catch(Exception e) {
				System.out.println(e);
			}
		 while (!prg.getStk().isEmpty() && b>0){
			 oneStep(prg);
			 b--;
			 try {
					repo.logPrgStateExec();
				 	prg.getHeap().setContent(unsafeGarbageCollector(
				 	getAddrFromSymTable(prg.getSymTable().getContent().values()),
					prg.getHeap().getContent()));
			 }
			 catch(Exception e) {
					System.out.println(e);
			 }
		 }
		 if(flag==true)
			 System.out.println(prg);	 //display last prg state
		 }
	public void displayPrgState (PrgState state) {
		System.out.println(state);
	}
	public void setFlag (boolean val) {
		flag=val;
	}
	public int getLength() {
		return repo.getLength();
	}
	
}
