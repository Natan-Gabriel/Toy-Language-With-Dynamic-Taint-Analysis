package model.exp;
import MyException.CustomException;
import model.values.*;
import model.types.*;
import model.adt.*;

public class VarExp implements Exp{
	String id;
	//....
	public VarExp(String s) {id=s;}
	public String toString() {return id;}
	public Value eval(MyIDictionary<String,Value> tbl,MyIHeap hp) throws CustomException {
		Value res=tbl.lookup(id);
		if(res==null)
			throw new CustomException("the given variable is not defined");
		else
			return res;
	}
	public Type getType(MyIDictionary<String,Value> tbl,MyIHeap hp) throws CustomException {
			return eval(tbl,hp).getType();
	}
}
 