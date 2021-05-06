package model.stmt;

import MyException.*;
import model.PrgState;
import model.adt.*;
import model.exp.ValueExp;
import model.types.IntType;
import model.types.StringType;
import model.values.BoolValue;
import model.values.IntValue;
import model.values.StringValue;
import model.values.Value;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class readFile_WBT {


    @Test
    public void tc_InvalidVariable() throws CustomException, VarNotDefined, DivByZero, TaintedAddress, VarIsDefined {

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

        boolean aux=true;
        try {
            IStmt stmt1 = new OpenRFile(new ValueExp(new StringValue("files/test_read4.txt")),1);
            IStmt stmt2 = new readFile(new ValueExp(new StringValue("files/test_read4.txt")),"x",1);
            stmt1.execute(prg);
            stmt2.execute(prg);

        }
        catch(VarNotDefined e){
            aux=false;
            IStmt stmt3 = new closeRFile(new ValueExp(new StringValue("files/test_read4.txt")),1);
            stmt3.execute(prg);
        }
        assertFalse(aux);

    }


    @Test
    public void tc_InvalidTypeOfVariable() throws CustomException, VarNotDefined, DivByZero, TaintedAddress, VarIsDefined {

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

        boolean aux=true;
        try {
            IStmt stmt1 = new VarDeclStmt("x",new StringType(),1);
            IStmt stmt2 = new OpenRFile(new ValueExp(new StringValue("files/test_read5.txt")),1);
            IStmt stmt3 = new readFile(new ValueExp(new StringValue("files/test_read5.txt")),"x",1);
            stmt1.execute(prg);
            stmt2.execute(prg);
            stmt3.execute(prg);

        }
        catch(VarNotDefined e){
            aux=false;
            IStmt stmt4 = new closeRFile(new ValueExp(new StringValue("files/test_read5.txt")),1);
            stmt4.execute(prg);
        }
        assertFalse(aux);

    }


    @Test
    public void tc_FileNameIsNotAString() throws CustomException, VarNotDefined, DivByZero, TaintedAddress, VarIsDefined {

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

        boolean aux=true;
        try {
            IStmt stmt1 = new readFile(new ValueExp(new BoolValue(true)),"x",1);
            stmt1.execute(prg);
        }
        catch(VarNotDefined e){
            aux=false;
        }
        assertFalse(aux);


    }

    @Test
    public void tc_FileDoesNotExist() throws CustomException, VarNotDefined, DivByZero, TaintedAddress, VarIsDefined {

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

        boolean aux=true;
        try {
            IStmt stmt1 = new readFile(new ValueExp(new StringValue("files/inexistent_file.txt")),"x",1);stmt1.execute(prg);
            stmt1.execute(prg);
        }
        catch(VarNotDefined e){
            aux=false;
        }
        assertFalse(aux);


    }

    @Test
    public void tc_FileIOError() throws CustomException, VarNotDefined, DivByZero, TaintedAddress, VarIsDefined {


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

        boolean aux=true;
        try {
            BufferedReader buffer = new BufferedReader(new FileReader("files/test_read3.txt"));
            fTbl.add(new StringValue("files/test_read3.txt"), buffer);
            buffer.close();
            IStmt stmt1 = new readFile(new ValueExp(new StringValue("files/test_read3.txt")),"x",1);stmt1.execute(prg);
            stmt1.execute(prg);
        }
        catch(Exception e){
            aux=false;
        }
        assertFalse(aux);


    }

    @Test
    public void tc_FileDoesNotContainOnlyNumbers() throws CustomException, VarNotDefined, DivByZero, TaintedAddress, VarIsDefined {

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

        boolean aux=true;
        try {
            IStmt stmt1 = new VarDeclStmt("x",new IntType(),1);
            IStmt stmt2 = new OpenRFile(new ValueExp(new StringValue("files/test_read6.txt")),1);
            IStmt stmt3 = new readFile(new ValueExp(new StringValue("files/test_read6.txt")),"x",1);
            stmt1.execute(prg);
            stmt2.execute(prg);
            stmt3.execute(prg);

        }
        catch(CustomException e){
            aux=false;
            IStmt stmt4 = new closeRFile(new ValueExp(new StringValue("files/test_read6.txt")),1);
            stmt4.execute(prg);

        }
        assertFalse(aux);


    }

    @Test
    public void tc_FileDoesNotContainAnyCharachter() throws CustomException, VarNotDefined, DivByZero, TaintedAddress, VarIsDefined {

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

        IStmt stmt1 = new VarDeclStmt("x",new IntType(),1);
        IStmt stmt2 = new OpenRFile(new ValueExp(new StringValue("files/test_read.txt")),1);
        IStmt stmt3 = new readFile(new ValueExp(new StringValue("files/test_read.txt")),"x",1);
        IStmt stmt4 = new closeRFile(new ValueExp(new StringValue("files/test_read.txt")),1);
        stmt1.execute(prg);
        stmt2.execute(prg);
        stmt3.execute(prg);
        stmt4.execute(prg);
        assertEquals(symTable.lookup("x"),new IntValue(0));


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

        IStmt stmt1 = new VarDeclStmt("x",new IntType(),1);
        IStmt stmt2 = new OpenRFile(new ValueExp(new StringValue("files/test_read2.txt")),1);
        IStmt stmt3 = new readFile(new ValueExp(new StringValue("files/test_read2.txt")),"x",1);
        IStmt stmt4 = new closeRFile(new ValueExp(new StringValue("files/test_read2.txt")),1);
        stmt1.execute(prg);
        stmt2.execute(prg);
        stmt3.execute(prg);
        stmt4.execute(prg);
        assertEquals(symTable.lookup("x"),new IntValue(4));


    }
}
