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

        IStmt ex=new NopStmt();
        MyIStack<IStmt> exeStack=new MyStack<IStmt>();
        MyIDictionary<Integer,IStmt> exeDictionary=new MyDictionary<Integer,IStmt>();
        MyIDictionary<String, Value> symTable=new MyDictionary<String, Value>();
        MyIDictionary<String, Pair<Value,Value>> dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        MyIList<Value> out=new MyList<Value>();
        MyIDictionary<StringValue, BufferedReader> fTbl=new MyDictionary<StringValue,BufferedReader>();
        MyIHeap heap=new MyHeap();

        PrgState prg=new PrgState(exeStack,exeDictionary,symTable,dynaimcSymTable,out,fTbl,heap,ex);

        boolean aux=true;
        try {
            IStmt stmt1 = new closeRFile(new ValueExp(new BoolValue(true)),1);
            stmt1.execute(prg);
        }
        catch(VarNotDefined e){
            aux=false;
        }
        assertFalse(aux);


    }

    @Test
    public void tc_FileIsNotOpened() throws CustomException, VarNotDefined, DivByZero, TaintedAddress, VarIsDefined {

        IStmt ex=new NopStmt();
        MyIStack<IStmt> exeStack=new MyStack<IStmt>();
        MyIDictionary<Integer,IStmt> exeDictionary=new MyDictionary<Integer,IStmt>();
        MyIDictionary<String, Value> symTable=new MyDictionary<String, Value>();
        MyIDictionary<String, Pair<Value,Value>> dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        MyIList<Value> out=new MyList<Value>();
        MyIDictionary<StringValue, BufferedReader> fTbl=new MyDictionary<StringValue,BufferedReader>();
        MyIHeap heap=new MyHeap();

        PrgState prg=new PrgState(exeStack,exeDictionary,symTable,dynaimcSymTable,out,fTbl,heap,ex);

        boolean aux=true;
        try {
            IStmt stmt1 = new closeRFile(new ValueExp(new StringValue("files/test_close.txt")),1);
            stmt1.execute(prg);
        }
        catch(VarNotDefined e){
            aux=false;
        }
        assertFalse(aux);


    }


    @Test
    public void tc_FileNotRemovedFromFileTable() throws CustomException, VarNotDefined, DivByZero, TaintedAddress, VarIsDefined {

        IStmt ex=new NopStmt();
        MyIStack<IStmt> exeStack=new MyStack<IStmt>();
        MyIDictionary<Integer,IStmt> exeDictionary=new MyDictionary<Integer,IStmt>();
        MyIDictionary<String, Value> symTable=new MyDictionary<String, Value>();
        MyIDictionary<String, Pair<Value,Value>> dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        MyIList<Value> out=new MyList<Value>();
        MyIDictionary<StringValue, BufferedReader> fTbl=new MyDictionary<StringValue,BufferedReader>();
        MyIHeap heap=new MyHeap();

        PrgState prg=new PrgState(exeStack,exeDictionary,symTable,dynaimcSymTable,out,fTbl,heap,ex);

        boolean aux=true;
        try {
            BufferedReader buffer = new BufferedReader(new FileReader("test_close3.txt"));
            fTbl.add(new StringValue("files/test_close3.txt"), buffer);
            buffer.close();
            IStmt stmt1 = new closeRFile(new ValueExp(new StringValue("files/test_close3.txt")),1);stmt1.execute(prg);
            stmt1.execute(prg);
        }
        catch(Exception e){
            aux=false;
        }
        assertFalse(aux);


    }


    @Test
    public void tc_AllValid() throws CustomException, VarNotDefined, DivByZero, TaintedAddress, VarIsDefined {

        IStmt ex=new NopStmt();
        MyIStack<IStmt> exeStack=new MyStack<IStmt>();
        MyIDictionary<Integer,IStmt> exeDictionary=new MyDictionary<Integer,IStmt>();
        MyIDictionary<String, Value> symTable=new MyDictionary<String, Value>();
        MyIDictionary<String, Pair<Value,Value>> dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        MyIList<Value> out=new MyList<Value>();
        MyIDictionary<StringValue, BufferedReader> fTbl=new MyDictionary<StringValue,BufferedReader>();
        MyIHeap heap=new MyHeap();

        PrgState prg=new PrgState(exeStack,exeDictionary,symTable,dynaimcSymTable,out,fTbl,heap,ex);

        IStmt stmt1 = new OpenRFile(new ValueExp(new StringValue("files/test_close2.txt")),1);
        IStmt stmt2 = new closeRFile(new ValueExp(new StringValue("files/test_close2.txt")),1);
        stmt1.execute(prg);
        stmt2.execute(prg);
        assertFalse(fTbl.isDefined(new StringValue("files/test_open2.txt")));


    }
}
