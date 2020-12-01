package model.exp;

import model.adt.MyIDictionary;
import model.adt.MyIHeap;
import model.types.IntType;
import model.types.Type;
import model.values.IntValue;
import model.values.Value;

import java.util.Scanner;

public class GetInput implements Exp{
    Value val;
    //....
    public GetInput() {}
//    public  String toString() {return val.toString();}
    public Value eval(MyIDictionary<String,Value> tbl, MyIHeap hp) {
        Scanner console = new Scanner(System.in);

        int val = console.nextInt();
        return new IntValue(val,true);
    }
    public Type getType(MyIDictionary<String,Value> tbl, MyIHeap hp) {
        return new IntType();
    }
}
