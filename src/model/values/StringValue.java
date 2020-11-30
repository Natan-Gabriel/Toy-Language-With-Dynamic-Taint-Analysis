package model.values;

import model.types.*;

public class StringValue implements Value{
	String str;
	public StringValue(String s) {str=s;}
	public StringValue() {str="";}
	public boolean equals(Object another){
		 if (another instanceof StringValue)
			 return true;
		 else
			 return false;
	 }
	public Type getType() {return new StringType();}
	public String getVal() {return str;}
	public String toString() {return str;}
}
