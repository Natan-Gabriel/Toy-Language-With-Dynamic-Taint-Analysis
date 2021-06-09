package model.exp;

import MyException.CustomException;
import model.adt.MyIDictionary;
import model.adt.MyIHeap;
import model.types.IntType;
import model.types.Type;
import model.values.IntValue;
import model.values.Value;

import java.util.Scanner;

public class readInteger implements Exp{

    public readInteger() {}
    public  String toString() {return "readInteger()";}
    public Value eval(MyIDictionary<String,Value> tbl, MyIHeap hp) throws CustomException {
        Scanner console = new Scanner(System.in);

        try {
            int val = console.nextInt();
            return new IntValue(val,true,false);
        }
        catch(Exception e) {
            throw new CustomException("You did not provide an integer");
        }
    }
    public Type getType(MyIDictionary<String,Value> tbl, MyIHeap hp) {
        return new IntType();
    }
}
