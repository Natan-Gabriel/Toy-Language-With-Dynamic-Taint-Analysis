package model.values;
import model.types.*;

public class RefValue implements Value{
	 int address;
	 Type locationType;
	 boolean secret;
	 boolean taint=false;
	 public RefValue(int a,Type t) {address=a;locationType=t;}
	 public RefValue() {address=1;locationType=new IntType();}
	 public String toString() {return "("+Integer.toString(address)+","+locationType.toString()+")";}
	 public int getAddr() {return address;}
	 public Type getType() { return new RefType(locationType);}
	 public Type getLocationType() { return locationType;}
	 public boolean getTaint(){return  taint;}
	 public boolean getSecret(){return secret;}
	 public void setSecret(boolean s) { secret=s;}
	public void setTaint(boolean s){ taint=s;}
	}

