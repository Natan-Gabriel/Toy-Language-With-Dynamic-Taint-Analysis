package model.values;
import model.types.*;

public class BoolValue implements Value{
	boolean val;
	boolean taint;
	boolean secret;
	public BoolValue(boolean v,boolean t,boolean s) {val=v;taint=t;}
	public BoolValue(boolean v){val=v;taint=false;secret=false;}
	public BoolValue() {val=false;taint=false;secret=false;}
	public boolean equals(Object another){
		 if ((another instanceof BoolValue) && ((BoolValue) another).getVal()==val)
			 return true;
		 else
			 return false;
	 }
	public boolean getVal() {return val;}
	public String toString() {return Boolean.toString(val);}
	public Type getType() { return new BoolType();}
	public boolean getTaint(){return  taint;}
	public boolean getSecret(){return secret;}
	public void setSecret(boolean s) { secret=s;}
}
