package model.values;
import model.types.*;

public class IntValue implements Value{
	int val;
	boolean taint;
	public IntValue(int v,boolean t) {val=v;taint=t;}
	public IntValue(int v) {val=v;taint=false;}
	public IntValue() {val=0;taint=false;}
	public boolean equals(Object another){
		 if (another instanceof IntValue)
			 return true;
		 else
			 return false;
	 }
	public Type getType() {return new IntType();}
	public int getVal() {return val;}
	public boolean getTaint(){return  taint;}
	public String toString() {return Integer.toString(val);}
}
