package model.stmt;

import MyException.*;
import model.PrgState;
import model.adt.*;
import model.exp.ValueExp;
import model.exp.VarExp;
import model.types.IntType;
import model.types.StringType;
import model.values.BoolValue;
import model.values.IntValue;
import model.values.StringValue;
import model.values.Value;
import org.junit.Test;

import java.io.BufferedReader;

import static org.junit.Assert.*;

public class OpenRFile_WBT {


    @Test
    public void tc_FileNameIsNotAString() throws CustomException, VarNotDefined, DivByZero, TaintedAddress, VarIsDefined {

        IStmt ex = new OpenRFile(new ValueExp(new BoolValue(true)),1);
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
    public void tc_FileIsOpened() throws CustomException, VarNotDefined, DivByZero, TaintedAddress, VarIsDefined {

        IStmt ex =  new OpenRFile(new ValueExp(new StringValue("files/test_open.txt")),1);
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
            ex.execute(prg);


        }
        catch(VarIsDefined e){
            aux=false;
            IStmt stmt2 = new closeRFile(new ValueExp(new StringValue("files/test_open.txt")),1);
            stmt2.execute(prg);
        }
        assertFalse(aux);


    }


    @Test
    public void tc_FileDoesNotExist() throws CustomException, VarNotDefined, DivByZero, TaintedAddress, VarIsDefined {

        IStmt ex = new OpenRFile(new ValueExp(new StringValue("files/inexistent_file.txt")),1);
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
            ex.execute(prg);
        }
        catch(Exception e){
            aux=false;
        }
        assertFalse(aux);


    }


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

        IStmt stmt1 = new OpenRFile(new ValueExp(new StringValue("files/test_open2.txt")),1);
        IStmt stmt2 = new closeRFile(new ValueExp(new StringValue("files/test_open2.txt")),1);
        stmt1.execute(prg);
        assertTrue(fTbl.isDefined(new StringValue("files/test_open2.txt")));
        stmt2.execute(prg);

    }
}
