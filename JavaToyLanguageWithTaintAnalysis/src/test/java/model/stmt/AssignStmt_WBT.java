package model.stmt;

import MyException.*;
import ctrl.iCtrl;
import model.PrgState;
import model.adt.*;
import model.exp.RelationalExp;
import model.exp.ValueExp;
import model.exp.VarExp;
import model.types.IntType;
import model.types.StringType;
import model.values.BoolValue;
import model.values.IntValue;
import model.values.StringValue;
import model.values.Value;
import org.junit.BeforeClass;
import org.junit.Test;
import repo.iRepo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class AssignStmt_WBT {


    @Test
    public void tc_ValueNotInSymbolTable() throws CustomException, VarNotDefined, DivByZero, TaintedAddress, VarIsDefined {

        IStmt ex=new NopStmt();
        MyIStack<IStmt> exeStack=new MyStack<IStmt>();
        MyIDictionary<Integer,IStmt> exeDictionary=new MyDictionary<Integer,IStmt>();
        MyIDictionary<String, Value> symTable=new MyDictionary<String, Value>();
        MyIDictionary<String,Pair<Value,Value>> dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        MyIList<Value> out=new MyList<Value>();
        MyIDictionary<StringValue, BufferedReader> fTbl=new MyDictionary<StringValue,BufferedReader>();
        MyIHeap heap=new MyHeap();

        PrgState prg=new PrgState(exeStack,exeDictionary,symTable,dynaimcSymTable,out,fTbl,heap,ex);


        RelationalExp exp = new RelationalExp("<",new ValueExp(new BoolValue(false)),new ValueExp(new IntValue(0)));
        boolean aux=true;
        try {
            IStmt stmt2 = new AssignStmt("x",new ValueExp(new IntValue(10)),1,1);
            stmt2.execute(prg);
        }
        catch(Exception e){
            aux=false;
        }
        assertFalse(aux);

    }

    @Test
    public void tc_ValueAndVariableHaveDifferentTypes() throws CustomException, VarNotDefined, DivByZero, TaintedAddress, VarIsDefined {

        IStmt ex=new NopStmt();
        MyIStack<IStmt> exeStack=new MyStack<IStmt>();
        MyIDictionary<Integer,IStmt> exeDictionary=new MyDictionary<Integer,IStmt>();
        MyIDictionary<String, Value> symTable=new MyDictionary<String, Value>();
        MyIDictionary<String,Pair<Value,Value>> dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        MyIList<Value> out=new MyList<Value>();
        MyIDictionary<StringValue, BufferedReader> fTbl=new MyDictionary<StringValue,BufferedReader>();
        MyIHeap heap=new MyHeap();

        PrgState prg=new PrgState(exeStack,exeDictionary,symTable,dynaimcSymTable,out,fTbl,heap,ex);


        RelationalExp exp = new RelationalExp("<",new ValueExp(new BoolValue(false)),new ValueExp(new IntValue(0)));
        boolean aux=true;
        try {
            IStmt stmt1 = new VarDeclStmt("x",new StringType(),1,1);
            IStmt stmt2 = new AssignStmt("x",new ValueExp(new IntValue(10)),1,1);
            stmt1.execute(prg);
            stmt2.execute(prg);
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
        MyIDictionary<String,Pair<Value,Value>> dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        MyIList<Value> out=new MyList<Value>();
        MyIDictionary<StringValue, BufferedReader> fTbl=new MyDictionary<StringValue,BufferedReader>();
        MyIHeap heap=new MyHeap();

        PrgState prg=new PrgState(exeStack,exeDictionary,symTable,dynaimcSymTable,out,fTbl,heap,ex);

        IStmt stmt1 = new VarDeclStmt("x",new IntType(),1,1);
        IStmt stmt2 = new AssignStmt("x",new ValueExp(new IntValue(10)),1,1);
        stmt1.execute(prg);
        stmt2.execute(prg);
        assertEquals(new VarExp("x").eval(symTable,heap),new IntValue(10));

    }

}
