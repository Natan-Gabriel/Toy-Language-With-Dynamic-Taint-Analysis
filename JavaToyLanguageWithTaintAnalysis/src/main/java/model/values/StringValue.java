package model.values;

import model.types.*;

import java.util.Objects;

public class StringValue implements Value{
	String str;
	boolean taint;
	boolean secret;
	public StringValue(String s) {str=s;}
	public StringValue() {str="";}
	public boolean equals(Object another){
		 if ((another instanceof StringValue) && ((StringValue) another).getVal().equals(str) )
			 return true;
		 else
			 return false;
	 }
	@Override
	public int hashCode() {
		return Objects.hash(str);
	}

	public Type getType() {return new StringType();}
	public String getVal() {return str;}
	public String toString() {return str;}
	public boolean getTaint(){return  taint;}
	public boolean getSecret(){return true;}
	public void setSecret(boolean s) { secret=s;}
}
