package integration;


import MyException.*;
import analyser.Parser;
import ctrl.Ctrl;
import ctrl.iCtrl;
import model.PrgState;
import model.adt.*;
import model.stmt.IStmt;
import model.stmt.NopStmt;
import model.values.IntValue;
import model.values.StringValue;
import model.values.Value;
import org.junit.Test;
import repo.Repo;
import repo.iRepo;

import java.io.BufferedReader;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class Big_Bang_Integration {

    @Test
    public void tc_goto_inside_while() throws Exception {

        IStmt ex = (IStmt) Parser.parse("files/goto_inside_while.txt");
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
        iRepo repo=new Repo(list,"log1.txt");
        iCtrl ctrl=new Ctrl(repo);
        ctrl.allStep();

        ArrayList<Value> expected = new ArrayList<Value>(Arrays.asList(new IntValue(6), new StringValue(" ") , new IntValue(10), new StringValue(" " ), new IntValue(15), new StringValue(" ") , new IntValue(21), new StringValue(" ") , new StringValue("\n"),
                new IntValue(10), new StringValue(" ") , new IntValue(15), new StringValue(" " ), new IntValue(21), new StringValue(" ") , new IntValue(28), new StringValue(" ") , new StringValue("\n"),
                new IntValue(15), new StringValue(" ") , new IntValue(21), new StringValue(" " ), new IntValue(28), new StringValue(" ") , new IntValue(36), new StringValue(" ") , new StringValue("\n")
                ));

        assertEquals(expected, out.getList());

    }

    @Test
    public void tc_goto_outside_while() throws Exception {

        IStmt ex = (IStmt) Parser.parse("files/goto_outside_while.txt");
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
        iRepo repo=new Repo(list,"log2.txt");
        iCtrl ctrl=new Ctrl(repo);
        ctrl.allStep();

//        MyIList<Value> expected = new MyList<Value>(new ArrayList(Arrays.asList("before while", 3, " " , 6, " " , 10, " " , 15, " " ,"\n",
//                                                                                "before while", 6, " " , 10, " " , 15, " " , 21, " " , "\n",
//                                                                                "before while", 10, " " , 15, " " , 21, " " , 28, " " , "\n",
//                                                                                "before while", 15, " " , 21, " " , 28, " " , 36, " " , "\n",
//                                                                                "before while")));
        ArrayList<Value> expected = new ArrayList<Value>(Arrays.asList(new StringValue("before while"), new IntValue(3), new StringValue(" ") , new IntValue(6), new StringValue(" ") , new IntValue(10), new StringValue(" ") , new IntValue(15), new StringValue(" ") ,new StringValue("\n"),
                new StringValue("before while"), new IntValue(6), new StringValue(" ") , new IntValue(10), new StringValue(" " ), new IntValue(15), new StringValue(" ") , new IntValue(21), new StringValue(" ") , new StringValue("\n"),
                new StringValue("before while"), new IntValue(10), new StringValue(" ") , new IntValue(15), new StringValue(" " ), new IntValue(21), new StringValue(" ") , new IntValue(28), new StringValue(" ") , new StringValue("\n"),
                new StringValue("before while"), new IntValue(15), new StringValue(" ") , new IntValue(21), new StringValue(" " ), new IntValue(28), new StringValue(" ") , new IntValue(36), new StringValue(" ") , new StringValue("\n"),
                new StringValue("before while") ));

        assertEquals(expected, out.getList());
    }
}