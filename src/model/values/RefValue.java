package model.values;
import model.types.*;

public class RefValue implements Value{
	 int address;
	 Type locationType;
	 boolean taint;
	 public RefValue(int a,Type t) {address=a;locationType=t;taint=false;}
	 public RefValue() {address=1;locationType=new IntType();taint=false;}
	 public String toString() {return "("+Integer.toString(address)+","+locationType.toString()+")";}
	 public int getAddr() {return address;}
	 public Type getType() { return new RefType(locationType);}
	 public Type getLocationType() { return locationType;}
	 public boolean getTaint(){return  taint;}
	}

