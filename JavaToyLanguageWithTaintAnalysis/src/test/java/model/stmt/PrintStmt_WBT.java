package model.stmt;

import MyException.*;
import model.PrgState;
import model.adt.*;
import model.exp.GetInput;
import model.exp.RelationalExp;
import model.exp.ValueExp;
import model.exp.VarExp;
import model.values.BoolValue;
import model.values.IntValue;
import model.values.StringValue;
import model.values.Value;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PrintStmt_WBT {

    @Test
    public void tc_AllValid() throws CustomException, VarNotDefined, DivByZero, TaintedAddress, VarIsDefined {

        IStmt ex = new NopStmt();
        MyIStack<IStmt> exeStack=new MyStack<IStmt>();
        MyIStack<IStmt> exeStack_executed=new MyStack<IStmt>();
        MyIDictionary<Integer,IStmt> exeDictionary=new MyDictionary<Integer,IStmt>(); //((HashMap<Integer, IStmt>) map);
        MyIDictionary<String, Value> symTable=new MyDictionary<String, Value>();
        MyIDictionary<String,Pair<Value,Value>> dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        MyIList<Value> out=new MyList<Value>();
        MyIDictionary<StringValue,BufferedReader> fTbl=new MyDictionary<StringValue,BufferedReader>();
        MyIHeap heap=new MyHeap();

        PrgState prg=new PrgState(exeStack,exeStack_executed,exeDictionary,symTable,dynaimcSymTable,out,fTbl,heap,ex);

        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        IStmt stmt2 = new PrintStmt(new ValueExp(new IntValue(4)),1);
        stmt2.execute(prg);


        assertEquals("4", outputStreamCaptor.toString()
                .trim());
        assertEquals(out.get(0),new IntValue(4));

        System.setOut(standardOut);


    }
}
