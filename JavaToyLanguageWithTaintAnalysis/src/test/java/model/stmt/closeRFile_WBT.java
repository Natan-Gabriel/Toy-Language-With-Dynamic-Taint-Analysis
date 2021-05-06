package model.stmt;

import MyException.*;
import model.PrgState;
import model.adt.*;
import model.exp.ValueExp;
import model.exp.VarExp;
import model.types.IntType;
import model.values.BoolValue;
import model.values.IntValue;
import model.values.StringValue;
import model.values.Value;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.junit.Assert.*;

public class closeRFile_WBT {



    @Test
    public void tc_FileNameIsNotAString() throws CustomException, VarNotDefined, DivByZero, TaintedAddress, VarIsDefined {

        IStmt ex = new closeRFile(new ValueExp(new BoolValue(true)),1);
        MyIStack<IStmt> exeStack=new MyStack<IStmt>();
        MyIStack<IStmt> exeStack_executed=new MyStack<IStmt>();
        MyIDictionary<Integer,IStmt> exeDictionary=new MyDictionary<Integer,IStmt>(); //((HashMap<Integer, IStmt>) map);
        MyIDictionary<String, Value> symTable=new MyDictionary<String, Value>();
        MyIDictionary<String,Pair<Value,Value>> dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        MyIList<Value> out=new MyList<Value>();
        MyIDictionary<StringValue,BufferedReader> fTbl=new MyDictionary<StringValue,BufferedReader>();
        MyIHeap heap=new MyHeap();

        PrgState prg=new PrgState(exeStack,exeStack_executed,exeDictionary,symTable,dynaimcSymTable,out,fTbl,heap,ex);

        boolean aux=true;
        try {
            ex.execute(prg);
        }
        catch(VarNotDefined e){
            aux=false;
        }
        assertFalse(aux);


    }

    @Test
    public void tc_FileIsNotOpened() throws CustomException, VarNotDefined, DivByZero, TaintedAddress, VarIsDefined {

        IStmt ex = new closeRFile(new ValueExp(new StringValue("files/test_close.txt")),1);
        MyIStack<IStmt> exeStack=new MyStack<IStmt>();
        MyIStack<IStmt> exeStack_executed=new MyStack<IStmt>();
        MyIDictionary<Integer,IStmt> exeDictionary=new MyDictionary<Integer,IStmt>(); //((HashMap<Integer, IStmt>) map);
        MyIDictionary<String, Value> symTable=new MyDictionary<String, Value>();
        MyIDictionary<String,Pair<Value,Value>> dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        MyIList<Value> out=new MyList<Value>();
        MyIDictionary<StringValue,BufferedReader> fTbl=new MyDictionary<StringValue,BufferedReader>();
        MyIHeap heap=new MyHeap();

        PrgState prg=new PrgState(exeStack,exeStack_executed,exeDictionary,symTable,dynaimcSymTable,out,fTbl,heap,ex);

        boolean aux=true;
        try {
            ex.execute(prg);
        }
        catch(VarNotDefined e){
            aux=false;
        }
        assertFalse(aux);


    }


    @Test
    public void tc_FileNotRemovedFromFileTable() throws CustomException, VarNotDefined, DivByZero, TaintedAddress, VarIsDefined {

        IStmt ex = new closeRFile(new ValueExp(new StringValue("files/test_close3.txt")),1);
        MyIStack<IStmt> exeStack=new MyStack<IStmt>();
        MyIStack<IStmt> exeStack_executed=new MyStack<IStmt>();
        MyIDictionary<Integer,IStmt> exeDictionary=new MyDictionary<Integer,IStmt>(); //((HashMap<Integer, IStmt>) map);
        MyIDictionary<String, Value> symTable=new MyDictionary<String, Value>();
        MyIDictionary<String,Pair<Value,Value>> dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        MyIList<Value> out=new MyList<Value>();
        MyIDictionary<StringValue,BufferedReader> fTbl=new MyDictionary<StringValue,BufferedReader>();
        MyIHeap heap=new MyHeap();

        PrgState prg=new PrgState(exeStack,exeStack_executed,exeDictionary,symTable,dynaimcSymTable,out,fTbl,heap,ex);

        boolean aux=true;
        try {
            BufferedReader buffer = new BufferedReader(new FileReader("test_close3.txt"));
            fTbl.add(new StringValue("files/test_close3.txt"), buffer);
            buffer.close();
            ex.execute(prg);
            ex.execute(prg);
        }
        catch(Exception e){
            aux=false;
        }
        assertFalse(aux);


    }


    @Test
    public void tc_AllValid() throws CustomException, VarNotDefined, DivByZero, TaintedAddress, VarIsDefined {

        IStmt ex = new CompStmt(new OpenRFile(new ValueExp(new StringValue("files/test_close2.txt")),1),new closeRFile(new ValueExp(new StringValue("files/test_close2.txt")),1));
        MyIStack<IStmt> exeStack=new MyStack<IStmt>();
        MyIStack<IStmt> exeStack_executed=new MyStack<IStmt>();
        MyIDictionary<Integer,IStmt> exeDictionary=new MyDictionary<Integer,IStmt>(); //((HashMap<Integer, IStmt>) map);
        MyIDictionary<String, Value> symTable=new MyDictionary<String, Value>();
        MyIDictionary<String,Pair<Value,Value>> dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        MyIList<Value> out=new MyList<Value>();
        MyIDictionary<StringValue,BufferedReader> fTbl=new MyDictionary<StringValue,BufferedReader>();
        MyIHeap heap=new MyHeap();

        PrgState prg=new PrgState(exeStack,exeStack_executed,exeDictionary,symTable,dynaimcSymTable,out,fTbl,heap,ex);

        ex.execute(prg);
        assertFalse(fTbl.isDefined(new StringValue("files/test_open2.txt")));


    }
}
