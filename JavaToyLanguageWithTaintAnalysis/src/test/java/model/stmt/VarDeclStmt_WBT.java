package model.stmt;

import MyException.*;
import model.PrgState;
import model.adt.*;
import model.exp.ValueExp;
import model.types.BoolType;
import model.types.IntType;
import model.types.RefType;
import model.types.StringType;
import model.values.*;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class VarDeclStmt_WBT {


    @Test
    public void tc_Invalid_VariableAlreadyDefined() throws CustomException, VarNotDefined, DivByZero, TaintedAddress, VarIsDefined {

        IStmt ex=new NopStmt();
        MyIStack<IStmt> exeStack=new MyStack<IStmt>();
        MyIDictionary<Integer,IStmt> exeDictionary=new MyDictionary<Integer,IStmt>();
        MyIDictionary<String, Value> symTable=new MyDictionary<String, Value>();
        MyIDictionary<String, Pair<Value,Value>> dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        MyIList<Value> out=new MyList<Value>();
        MyIDictionary<StringValue, BufferedReader> fTbl=new MyDictionary<StringValue,BufferedReader>();
        MyIHeap heap=new MyHeap();

        PrgState prg=new PrgState(exeStack,exeDictionary,symTable,dynaimcSymTable,out,fTbl,heap,ex);


        IStmt stmt1 = new VarDeclStmt("a",new StringType(),1,1);
        stmt1.execute(prg);

        boolean aux=true;
        try {
            stmt1.execute(prg);
        }
        catch(VarIsDefined e){
            aux=false;
        }
        assertFalse(aux);

    }



    @Test
    public void tc_AllValid_String() throws CustomException, VarNotDefined, DivByZero, TaintedAddress, VarIsDefined {

        IStmt ex=new NopStmt();
        MyIStack<IStmt> exeStack=new MyStack<IStmt>();
        MyIDictionary<Integer,IStmt> exeDictionary=new MyDictionary<Integer,IStmt>();
        MyIDictionary<String, Value> symTable=new MyDictionary<String, Value>();
        MyIDictionary<String, Pair<Value,Value>> dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        MyIList<Value> out=new MyList<Value>();
        MyIDictionary<StringValue, BufferedReader> fTbl=new MyDictionary<StringValue,BufferedReader>();
        MyIHeap heap=new MyHeap();

        PrgState prg=new PrgState(exeStack,exeDictionary,symTable,dynaimcSymTable,out,fTbl,heap,ex);


        IStmt stmt1 = new VarDeclStmt("a",new StringType(),1,1);
        stmt1.execute(prg);

        assertEquals(symTable.lookup("a"),new StringValue());

    }

    @Test
    public void tc_AllValid_Boolean() throws CustomException, VarNotDefined, DivByZero, TaintedAddress, VarIsDefined {

        IStmt ex=new NopStmt();
        MyIStack<IStmt> exeStack=new MyStack<IStmt>();
        MyIDictionary<Integer,IStmt> exeDictionary=new MyDictionary<Integer,IStmt>();
        MyIDictionary<String, Value> symTable=new MyDictionary<String, Value>();
        MyIDictionary<String, Pair<Value,Value>> dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        MyIList<Value> out=new MyList<Value>();
        MyIDictionary<StringValue, BufferedReader> fTbl=new MyDictionary<StringValue,BufferedReader>();
        MyIHeap heap=new MyHeap();

        PrgState prg=new PrgState(exeStack,exeDictionary,symTable,dynaimcSymTable,out,fTbl,heap,ex);


        IStmt stmt1 = new VarDeclStmt("a",new BoolType(),1,1);
        stmt1.execute(prg);

        assertEquals(symTable.lookup("a"),new BoolValue());

    }



    @Test
    public void tc_AllValid_Integer() throws CustomException, VarNotDefined, DivByZero, TaintedAddress, VarIsDefined {

        IStmt ex=new NopStmt();
        MyIStack<IStmt> exeStack=new MyStack<IStmt>();
        MyIDictionary<Integer,IStmt> exeDictionary=new MyDictionary<Integer,IStmt>();
        MyIDictionary<String, Value> symTable=new MyDictionary<String, Value>();
        MyIDictionary<String, Pair<Value,Value>> dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        MyIList<Value> out=new MyList<Value>();
        MyIDictionary<StringValue, BufferedReader> fTbl=new MyDictionary<StringValue,BufferedReader>();
        MyIHeap heap=new MyHeap();

        PrgState prg=new PrgState(exeStack,exeDictionary,symTable,dynaimcSymTable,out,fTbl,heap,ex);


        IStmt stmt1 = new VarDeclStmt("a",new IntType(),1,1);
        stmt1.execute(prg);

        assertEquals(symTable.lookup("a"),new IntValue());

    }
}
