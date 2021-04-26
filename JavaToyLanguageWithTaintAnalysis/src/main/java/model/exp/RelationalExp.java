package model.exp;

import MyException.*;
import model.adt.*;
import model.types.*;
import model.values.*;

public class RelationalExp implements Exp{
	 Exp e1;
	 Exp e2;
	 //int op; //1-plus, 2-minus, 3-star, 4-divide
	 String op="<";
	 //....
	 //public ArithExp(Exp m,Exp n) {e1=m;e2=n;}
	 public RelationalExp(String a,Exp m,Exp n) {e1=m;e2=n;op=a;}
	 public String toString() {return e1.toString()+op+e2.toString();}
	 public Value eval(MyIDictionary<String,Value> tbl,MyIHeap hp) throws VarNotDefined, DivByZero, CustomException {
		 Value v1,v2;
		 v1= e1.eval(tbl,hp);
		 if (v1.getType().equals(new IntType())) {
			 v2 = e2.eval(tbl,hp);
			 if (v2.getType().equals(new IntType())) {
				 IntValue i1 = (IntValue)v1;
				 IntValue i2 = (IntValue)v2;
				 int n1,n2;
				 n1= i1.getVal();
				 n2 = i2.getVal();
				 if (op=="<") return new BoolValue(n1<n2);
				 if (op=="<=") return new BoolValue(n1<=n2);
				 if (op=="==") return new BoolValue(n1==n2);
				 if (op=="!=") return new BoolValue(n1!=n2);
				 if (op==">") return new BoolValue(n1>n2);
				 if (op==">=") return new BoolValue(n1>=n2);
				 throw new CustomException("invalid operator");
			 }else
				 throw new VarNotDefined("second operand is not an integer");
		 }else
			 throw new VarNotDefined("first operand is not an integer");

	 }
	 public Type getType(MyIDictionary<String,Value> tbl,MyIHeap hp) throws VarNotDefined,DivByZero, CustomException {
		 return eval(tbl,hp).getType();
	 }
}
