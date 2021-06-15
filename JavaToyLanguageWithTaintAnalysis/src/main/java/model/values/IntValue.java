package model.values;
import model.types.*;

public class IntValue implements Value{
	int val;
	boolean taint;
	boolean secret;
	public IntValue(int v,boolean t,boolean s) {val=v;taint=t;secret=s;}
	public IntValue(int v) {val=v;taint=false;secret=false;}
	public IntValue() {val=0;taint=false;secret=false;}
	public boolean equals(Object another){
		 if ((another instanceof IntValue) && ((IntValue) another).getVal()==val)
			 return true;
		 else
			 return false;
	 }
	public Type getType() {return new IntType();}
	public int getVal() {return val;}
	public boolean getTaint(){return  taint;}
	public String toString() {return Integer.toString(val);}
	public boolean getSecret(){return secret;}
	public void setSecret(boolean s) { secret=s;}
	public void setTaint(boolean s){ taint=s;}
}
