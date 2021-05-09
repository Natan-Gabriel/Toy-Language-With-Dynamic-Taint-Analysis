package model.stmt;

import MyException.VarNotDefined;
import analyser.Parser;
import ctrl.Ctrl;
import ctrl.iCtrl;
import model.PrgState;
import model.adt.*;
import model.exp.ValueExp;
import model.exp.VarExp;
import model.types.IntType;
import model.values.IntValue;
import model.values.StringValue;
import model.values.Value;
import org.junit.Test;
import repo.Repo;
import repo.iRepo;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GotoStmt_BBT {


    @Test
    public void tc_InvalidExpression() throws Exception {

        IStmt ex = new CompStmt(new VarDeclStmt("x",new IntType(),1),new CompStmt( new GotoStmt(new ValueExp(new StringValue("4")),2),new CompStmt(new AssignStmt("x",new ValueExp(new IntValue(10)),3),new PrintStmt(new VarExp("x"),4))));
        MyIStack<IStmt> exeStack=new MyStack<IStmt>();
        MyIStack<IStmt> exeStack_executed=new MyStack<IStmt>();
        MyIDictionary<Integer,IStmt> exeDictionary=new MyDictionary<Integer,IStmt>(); //((HashMap<Integer, IStmt>) map);
        MyIDictionary<String, Value> symTable=new MyDictionary<String, Value>();
        MyIDictionary<String,Pair<Value,Value>> dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        MyIList<Value> out=new MyList<Value>();
        MyIDictionary<StringValue,BufferedReader> fTbl=new MyDictionary<StringValue,BufferedReader>();
        MyIHeap heap=new MyHeap();

        PrgState prg=new PrgState(exeStack,exeStack_executed,exeDictionary,symTable,dynaimcSymTable,out,fTbl,heap,ex);

        ArrayList<PrgState> list = new ArrayList<PrgState>();
        list.add(prg);
        iRepo repo=new Repo(list,"log6.txt");
        iCtrl ctrl=new Ctrl(repo);

        boolean aux=true;
        try {
            ctrl.allStep();
        }
        catch(VarNotDefined e){
            aux=false;
        }
        assertFalse(aux);


    }


    @Test
    public void tc_ExpressionLessThan0() throws Exception {

        IStmt ex = new CompStmt(new PrintStmt(new ValueExp(new IntValue(0)),1), new GotoStmt(new ValueExp(new IntValue(-7)),2));
        MyIStack<IStmt> exeStack=new MyStack<IStmt>();
        MyIStack<IStmt> exeStack_executed=new MyStack<IStmt>();
        MyIDictionary<Integer,IStmt> exeDictionary=new MyDictionary<Integer,IStmt>(); //((HashMap<Integer, IStmt>) map);
        MyIDictionary<String, Value> symTable=new MyDictionary<String, Value>();
        MyIDictionary<String,Pair<Value,Value>> dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        MyIList<Value> out=new MyList<Value>();
        MyIDictionary<StringValue,BufferedReader> fTbl=new MyDictionary<StringValue,BufferedReader>();
        MyIHeap heap=new MyHeap();

        PrgState prg=new PrgState(exeStack,exeStack_executed,exeDictionary,symTable,dynaimcSymTable,out,fTbl,heap,ex);

        ArrayList<PrgState> list = new ArrayList<PrgState>();
        list.add(prg);
        iRepo repo=new Repo(list,"log6.txt");
        iCtrl ctrl=new Ctrl(repo);

        ctrl.allStep(6);

        ArrayList<Value> expected = new ArrayList<Value>(Arrays.asList(new IntValue(0),new IntValue(0),new IntValue(0)));

//        System.out.println("out.getList():"+out.getList());
//        System.out.println("expected:"+expected);
        assertEquals(expected, out.getList());


    }

    @Test
    public void tc_ExpressionGreaterThanLastLine() throws Exception {

        IStmt ex = new CompStmt( new GotoStmt(new ValueExp(new IntValue(7)),1), new PrintStmt(new ValueExp(new IntValue(0)),2));
        MyIStack<IStmt> exeStack=new MyStack<IStmt>();
        MyIStack<IStmt> exeStack_executed=new MyStack<IStmt>();
        MyIDictionary<Integer,IStmt> exeDictionary=new MyDictionary<Integer,IStmt>(); //((HashMap<Integer, IStmt>) map);
        MyIDictionary<String, Value> symTable=new MyDictionary<String, Value>();
        MyIDictionary<String,Pair<Value,Value>> dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        MyIList<Value> out=new MyList<Value>();
        MyIDictionary<StringValue,BufferedReader> fTbl=new MyDictionary<StringValue,BufferedReader>();
        MyIHeap heap=new MyHeap();

        PrgState prg=new PrgState(exeStack,exeStack_executed,exeDictionary,symTable,dynaimcSymTable,out,fTbl,heap,ex);

        ArrayList<PrgState> list = new ArrayList<PrgState>();
        list.add(prg);
        iRepo repo=new Repo(list,"log6.txt");
        iCtrl ctrl=new Ctrl(repo);

        ctrl.allStep();

        ArrayList<Value> expected = new ArrayList<Value>();

//        System.out.println("out.getList():"+out.getList());
//        System.out.println("expected:"+expected);
        assertEquals(expected, out.getList());


    }

    @Test
    public void tc_AllValid() throws Exception {

        IStmt ex = new CompStmt(new VarDeclStmt("x",new IntType(),1),new CompStmt( new GotoStmt(new ValueExp(new IntValue(4)),2),new CompStmt(new AssignStmt("x",new ValueExp(new IntValue(10)),3),new PrintStmt(new VarExp("x"),4))));
        MyIStack<IStmt> exeStack=new MyStack<IStmt>();
        MyIStack<IStmt> exeStack_executed=new MyStack<IStmt>();
        MyIDictionary<Integer,IStmt> exeDictionary=new MyDictionary<Integer,IStmt>(); //((HashMap<Integer, IStmt>) map);
        MyIDictionary<String, Value> symTable=new MyDictionary<String, Value>();
        MyIDictionary<String,Pair<Value,Value>> dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        MyIList<Value> out=new MyList<Value>();
        MyIDictionary<StringValue,BufferedReader> fTbl=new MyDictionary<StringValue,BufferedReader>();
        MyIHeap heap=new MyHeap();

        PrgState prg=new PrgState(exeStack,exeStack_executed,exeDictionary,symTable,dynaimcSymTable,out,fTbl,heap,ex);

        ArrayList<PrgState> list = new ArrayList<PrgState>();
        list.add(prg);
        iRepo repo=new Repo(list,"log6.txt");
        iCtrl ctrl=new Ctrl(repo);
        ctrl.allStep();

        ArrayList<Value> expected = new ArrayList<Value>(Arrays.asList(new IntValue(0)));

        assertEquals(expected, out.getList());

    }



}
