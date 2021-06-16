package model.stmt;
import MyException.*;
import model.PrgState;
import model.adt.*;
import model.types.*;
import model.values.*;
import model.PrgState;

public class VarDeclStmt implements IStmt{
	 String name;
	 Type typ;
	 int instructionNumber;
	 int lineNumber;

	 public VarDeclStmt(String n,Type v,int _lineNumber){name=n;typ=v;lineNumber=_lineNumber;}
	 public String toString() {
		 if(typ.defaultValue().equals(new IntValue(0)))
			 return name+" is of "+"IntType";
		 else if (typ.defaultValue().equals(new BoolValue(false)))
			 return name+" is of "+"BoolType";
		 else if (typ.defaultValue().equals(new StringValue("")))
			 return name+" is of "+"StringType";
		 //else if (typ.defaultValue().equals(new RefValue(0,new IntType())) ||
		//		 typ.defaultValue().equals(new RefValue(0,new BoolType())) ||
		//		 typ.defaultValue().equals(new RefValue(0,new StringType())))
		//	 return name+" is of "+"RefType";
		// else if (typ.equals(new RefType(new IntType())) ||
		//		 typ.equals(new RefType(new BoolType())) ||
		//		 typ.equals(new RefType(new StringType())))
		//	 return name+" is of "+"RefType2.0";
		 else if (typ instanceof RefType)
			 return name+" is of "+"RefType";
		 else
		 {
			 System.out.println(typ.defaultValue());
			 System.out.println(new RefValue(0,new IntType()));
			 return typ+"Eroare la declarare";}
		 }
	 public PrgState execute(PrgState state) throws VarIsDefined{
		 state.setNextInstruction(getStatementNumber()+1);
		 MyIDictionary<String,Value> sym=state.getSymTable();
		 MyIHeap heap= state.getHeap();
		 Value val;
		 if (sym.isDefined(name))
			 throw new VarIsDefined("variable is already declared");
		 if(typ.equals(new IntType()))
			 val=new IntValue();
		 else if(typ.equals(new BoolType()))
			 val=new BoolValue();
		 else if (typ.equals(new RefType(new IntType())) )
			 val=new RefValue();
		 else if (typ instanceof RefType ){
			 val=new RefValue(1,((RefType)typ).getInner());
//			 Type type = ((RefType)typ).getInner();
//			 int aux=0;
//			 while(type instanceof RefType){
//			 	aux++;
//			 	type = ((RefType)type).getInner();
//			 }
//			 val = new IntValue();
//			 while(aux>0){
//			 	aux--;
//			 	val =
//			 }

		 }

		 // else if (typ.equals(new RefType(new BoolType())) )
		//	 val=new RefValue(11,new BoolType());
		// else if ( typ.equals(new RefType(new StringType())))
		//	 val=new RefValue(12,new StringType());
		// else if (typ.equals(new RefType(new RefType(new IntType()))) )
		//	 val=new RefValue(1,new RefType(new IntType()));
		 else 
			 val=new StringValue();

//		 Value newVal=heap.add(val);
//		 sym.add(name,newVal);
		 sym.add(name,val);

//		 System.out.println("sym:"+sym);
		 state.setSymTable(sym);
		 
		 return state;
	 }

	public int getStatementNumber(){return instructionNumber;}
	public int  getLineNumber(){return lineNumber;}
	public int getEndingLine() {return lineNumber;}
}
