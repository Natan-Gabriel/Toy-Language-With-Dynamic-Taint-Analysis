package model.exp;

import MyException.CustomException;
import model.adt.MyIDictionary;
import model.adt.MyIHeap;
import model.types.IntType;
import model.types.Type;
import model.values.IntValue;
import model.values.StringValue;
import model.values.Value;

import java.util.Scanner;

public class readFromConsole implements Exp{

    public readFromConsole() {}
    public  String toString() {return "readFromConsole()";}
    public Value eval(MyIDictionary<String,Value> tbl, MyIHeap hp) throws CustomException {
        Scanner console = new Scanner(System.in);

        String s = console.next();
        return new StringValue(s,true,true);


    }
    public Type getType(MyIDictionary<String,Value> tbl, MyIHeap hp) {
        return new IntType();
    }
}
