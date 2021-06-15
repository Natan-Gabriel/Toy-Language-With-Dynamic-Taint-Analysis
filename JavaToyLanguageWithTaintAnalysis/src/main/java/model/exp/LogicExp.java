package model.exp;
import model.values.*;
import model.adt.*;
import model.types.*;
import MyException.*;

public class LogicExp implements Exp{
	Exp e1;
	Exp e2;
	int op;
	//....
	public LogicExp(String a,Exp m,Exp n) {e1=m;e2=n;if (a=="and") op=1;
		if (a=="or") op=2;}
	public  String toString() {return "Exp1 "+e1.toString()+" Exp2 "+e2.toString()+"Operation"+Integer.toString(op);}
	public Value eval(MyIDictionary<String,Value> tbl,MyIHeap hp) throws VarNotDefined, DivByZero, CustomException {
		 Value v1,v2;
		 v1= e1.eval(tbl,hp);
		 if (v1.getType().equals(new BoolType())) {
			 v2 = e2.eval(tbl,hp);
			 if (v2.getType().equals(new BoolType())) {
				 BoolValue i1 = (BoolValue)v1;
				 BoolValue i2 = (BoolValue)v2;
				 boolean n1,n2;
				 n1= i1.getVal();
				 n2 = i2.getVal();
				 if (op==1) return new BoolValue(n1 && n2,i1.getTaint() || i2.getTaint(),false);
				 if (op ==2) return new BoolValue(n1||n2,i1.getTaint() || i2.getTaint(),false);
				 throw new CustomException("is an invalid operator");
				 
			 }else
				 throw new VarNotDefined("second operand is not a boolean");
		 }else
			 throw new VarNotDefined("first operand is not a boolean");

	}
	public Type getType(MyIDictionary<String,Value> tbl,MyIHeap hp) throws VarNotDefined, DivByZero, CustomException {
		 return eval(tbl,hp).getType();
	 }
}
