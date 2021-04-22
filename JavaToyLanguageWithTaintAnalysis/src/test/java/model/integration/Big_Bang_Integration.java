package model.integration;

import MyException.*;
import analyser.Parser;
import ctrl.Ctrl;
import ctrl.iCtrl;
import model.PrgState;
import model.adt.*;
import model.stmt.IStmt;
import model.stmt.NopStmt;
import model.values.StringValue;
import model.values.Value;
import org.junit.Test;
import repo.Repo;
import repo.iRepo;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Big_Bang_Integration {

//    @Test
//    public void tc_AllInvalid_VariableNotDefined() throws Exception {
//
//
//        IStmt ex=new NopStmt();
//        boolean flag = false;
//
//        Map<Integer, IStmt> map = (Map<Integer, IStmt>) Parser.parse("files/test_integration_if_nested.txt");
//        System.out.println("map:"+map);
//        MyIStack<IStmt> exeStack = new MyStack<IStmt>();
//        MyIDictionary<Integer, IStmt> exeDictionary = new MyDictionary<Integer, IStmt>((HashMap<Integer, IStmt>) map);
//        MyIDictionary<String, Value> symTable = new MyDictionary<String, Value>();
//        MyIDictionary<String, Pair<Value, Value>> dynaimcSymTable = new MyDictionary<String, Pair<Value, Value>>();
//        MyIList<Value> out = new MyList<Value>();
//        MyIDictionary<StringValue, BufferedReader> fTbl = new MyDictionary<StringValue, BufferedReader>();
//        MyIHeap heap = new MyHeap();
//
//        PrgState prg = new PrgState(exeStack, exeDictionary, symTable, dynaimcSymTable, out, fTbl, heap, ex);
//
//        ArrayList<PrgState> list = new ArrayList<PrgState>();
//        list.add(prg);
//        iRepo repo = new Repo(list, "log.txt");
//        iCtrl ctrl = new Ctrl(repo, true);
//        ctrl.allStep();
////        ctrl.givenNumberOfSteps(7);
//
//
//
//    }
//
//    @Test
//    public void tc_AllInvalid_VariableNotDefined() throws Exception {
//
//
//        IStmt ex=new NopStmt();
//        boolean flag = false;
//
//        Map<Integer, IStmt> map = (Map<Integer, IStmt>) Parser.parse("files/test_integration_while_nested.txt");
//        System.out.println("map:"+map);
//        MyIStack<IStmt> exeStack = new MyStack<IStmt>();
//        MyIDictionary<Integer, IStmt> exeDictionary = new MyDictionary<Integer, IStmt>((HashMap<Integer, IStmt>) map);
//        MyIDictionary<String, Value> symTable = new MyDictionary<String, Value>();
//        MyIDictionary<String, Pair<Value, Value>> dynaimcSymTable = new MyDictionary<String, Pair<Value, Value>>();
//        MyIList<Value> out = new MyList<Value>();
//        MyIDictionary<StringValue, BufferedReader> fTbl = new MyDictionary<StringValue, BufferedReader>();
//        MyIHeap heap = new MyHeap();
//
//        PrgState prg = new PrgState(exeStack, exeDictionary, symTable, dynaimcSymTable, out, fTbl, heap, ex);
//
//        ArrayList<PrgState> list = new ArrayList<PrgState>();
//        list.add(prg);
//        iRepo repo = new Repo(list, "log.txt");
//        iCtrl ctrl = new Ctrl(repo, true);
//    //    ctrl.allStep();
//        ctrl.givenNumberOfSteps(30);
//
//
//
//    }

//    @Test
//    public void tc_AllInvalid_VariableNotDefined() throws Exception {
//
//
//        IStmt ex=new NopStmt();
//        boolean flag = false;
//
//        Map<Integer, IStmt> map = (Map<Integer, IStmt>) Parser.parse("files/test_integration2.txt");
//        System.out.println("map:"+map);
//        MyIStack<IStmt> exeStack = new MyStack<IStmt>();
//        MyIDictionary<Integer, IStmt> exeDictionary = new MyDictionary<Integer, IStmt>((HashMap<Integer, IStmt>) map);
//        MyIDictionary<String, Value> symTable = new MyDictionary<String, Value>();
//        MyIDictionary<String, Pair<Value, Value>> dynaimcSymTable = new MyDictionary<String, Pair<Value, Value>>();
//        MyIList<Value> out = new MyList<Value>();
//        MyIDictionary<StringValue, BufferedReader> fTbl = new MyDictionary<StringValue, BufferedReader>();
//        MyIHeap heap = new MyHeap();
//
//        PrgState prg = new PrgState(exeStack, exeDictionary, symTable, dynaimcSymTable, out, fTbl, heap, ex);
//
//        ArrayList<PrgState> list = new ArrayList<PrgState>();
//        list.add(prg);
//        iRepo repo = new Repo(list, "log.txt");
//        iCtrl ctrl = new Ctrl(repo, true);
//        ctrl.allStep();
////        ctrl.givenNumberOfSteps(30);
//
//
//
//    }

    @Test
    public void tc_AllInvalid_VariableNotDefined() throws Exception {


        IStmt ex=new NopStmt();
        boolean flag = false;

        Map<Integer, IStmt> map = (Map<Integer, IStmt>) Parser.parse("files/test_integration_is_prime.txt");
        System.out.println("map:"+map);
        MyIStack<IStmt> exeStack = new MyStack<IStmt>();
        MyIDictionary<Integer, IStmt> exeDictionary = new MyDictionary<Integer, IStmt>((HashMap<Integer, IStmt>) map);
        MyIDictionary<String, Value> symTable = new MyDictionary<String, Value>();
        MyIDictionary<String, Pair<Value, Value>> dynaimcSymTable = new MyDictionary<String, Pair<Value, Value>>();
        MyIList<Value> out = new MyList<Value>();
        MyIDictionary<StringValue, BufferedReader> fTbl = new MyDictionary<StringValue, BufferedReader>();
        MyIHeap heap = new MyHeap();

        PrgState prg = new PrgState(exeStack, exeDictionary, symTable, dynaimcSymTable, out, fTbl, heap, ex);

        ArrayList<PrgState> list = new ArrayList<PrgState>();
        list.add(prg);
        iRepo repo = new Repo(list, "log.txt");
        iCtrl ctrl = new Ctrl(repo, true);
        ctrl.allStep();
//        ctrl.givenNumberOfSteps(30);



    }


}
