package model.integration;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

        PrgState prg = new PrgState(exeStack, exeDictionary, symTable, dynaimcSymTable, out, fTbl, heap, ex);

        ArrayList<PrgState> list = new ArrayList<PrgState>();
        list.add(prg);
        iRepo repo = new Repo(list, "log.txt");
        iCtrl ctrl = new Ctrl(repo, true);
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

        PrgState prg = new PrgState(exeStack, exeDictionary, symTable, dynaimcSymTable, out, fTbl, heap, ex);

        ArrayList<PrgState> list = new ArrayList<PrgState>();
        list.add(prg);
        iRepo repo = new Repo(list, "log.txt");
        iCtrl ctrl = new Ctrl(repo, true);
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


    @Test
    public void tc_goto_inside_if() throws Exception {

        IStmt ex = (IStmt) Parser.parse("files/goto_inside_if.txt");
        MyIStack<IStmt> exeStack=new MyStack<IStmt>();
        MyIStack<IStmt> exeStack_executed=new MyStack<IStmt>();
        MyIDictionary<Integer,IStmt> exeDictionary=new MyDictionary<Integer,IStmt>(); //((HashMap<Integer, IStmt>) map);
        MyIDictionary<String, Value> symTable=new MyDictionary<String, Value>();
        MyIDictionary<String,Pair<Value,Value>> dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        MyIList<Value> out=new MyList<Value>();
        MyIDictionary<StringValue,BufferedReader> fTbl=new MyDictionary<StringValue,BufferedReader>();
        MyIHeap heap=new MyHeap();

        PrgState prg = new PrgState(exeStack, exeDictionary, symTable, dynaimcSymTable, out, fTbl, heap, ex);

        ArrayList<PrgState> list = new ArrayList<PrgState>();
        list.add(prg);
        iRepo repo = new Repo(list, "log.txt");
        iCtrl ctrl = new Ctrl(repo, true);
        ctrl.allStep();

//        MyIList<Value> expected = new MyList<Value>(new ArrayList(Arrays.asList("before while", 3, " " , 6, " " , 10, " " , 15, " " ,"\n",
//                                                                                "before while", 6, " " , 10, " " , 15, " " , 21, " " , "\n",
//                                                                                "before while", 10, " " , 15, " " , 21, " " , 28, " " , "\n",
//                                                                                "before while", 15, " " , 21, " " , 28, " " , 36, " " , "\n",
//                                                                                "before while")));
        ArrayList<Value> expected = new ArrayList<Value>(Arrays.asList(new StringValue("3rd if"),new StringValue("2nd if"),new StringValue("1st if"),new IntValue(1),new IntValue(0) ));
//        System.out.println("expected"+expected);
//        System.out.println("out.getList()"+out.getList());

        assertEquals(expected, out.getList());

    }


    @Test
    public void tc_goto_outside_if() throws Exception {

        IStmt ex = (IStmt) Parser.parse("files/goto_outside_if.txt");
        MyIStack<IStmt> exeStack=new MyStack<IStmt>();
        MyIStack<IStmt> exeStack_executed=new MyStack<IStmt>();
        MyIDictionary<Integer,IStmt> exeDictionary=new MyDictionary<Integer,IStmt>(); //((HashMap<Integer, IStmt>) map);
        MyIDictionary<String, Value> symTable=new MyDictionary<String, Value>();
        MyIDictionary<String,Pair<Value,Value>> dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        MyIList<Value> out=new MyList<Value>();
        MyIDictionary<StringValue,BufferedReader> fTbl=new MyDictionary<StringValue,BufferedReader>();
        MyIHeap heap=new MyHeap();

        PrgState prg = new PrgState(exeStack, exeDictionary, symTable, dynaimcSymTable, out, fTbl, heap, ex);

        ArrayList<PrgState> list = new ArrayList<PrgState>();
        list.add(prg);
        iRepo repo = new Repo(list, "log.txt");
        iCtrl ctrl = new Ctrl(repo, true);
        ctrl.allStep();

//        MyIList<Value> expected = new MyList<Value>(new ArrayList(Arrays.asList("before while", 3, " " , 6, " " , 10, " " , 15, " " ,"\n",
//                                                                                "before while", 6, " " , 10, " " , 15, " " , 21, " " , "\n",
//                                                                                "before while", 10, " " , 15, " " , 21, " " , 28, " " , "\n",
//                                                                                "before while", 15, " " , 21, " " , 28, " " , 36, " " , "\n",
//                                                                                "before while")));
        ArrayList<Value> expected = new ArrayList<Value>(Arrays.asList(new IntValue(3), new IntValue(1) ));
        System.out.println("expected"+expected);
        System.out.println("out.getList()"+out.getList());

        assertEquals(expected, out.getList());

    }

    @Test
    public void tc_goto_inside_for() throws Exception {

        IStmt ex = (IStmt) Parser.parse("files/goto_inside_for.txt");
        MyIStack<IStmt> exeStack=new MyStack<IStmt>();
        MyIStack<IStmt> exeStack_executed=new MyStack<IStmt>();
        MyIDictionary<Integer,IStmt> exeDictionary=new MyDictionary<Integer,IStmt>(); //((HashMap<Integer, IStmt>) map);
        MyIDictionary<String, Value> symTable=new MyDictionary<String, Value>();
        MyIDictionary<String,Pair<Value,Value>> dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        MyIList<Value> out=new MyList<Value>();
        MyIDictionary<StringValue,BufferedReader> fTbl=new MyDictionary<StringValue,BufferedReader>();
        MyIHeap heap=new MyHeap();

        PrgState prg = new PrgState(exeStack, exeDictionary, symTable, dynaimcSymTable, out, fTbl, heap, ex);

        ArrayList<PrgState> list = new ArrayList<PrgState>();
        list.add(prg);
        iRepo repo = new Repo(list, "log.txt");
        iCtrl ctrl = new Ctrl(repo, true);
        ctrl.allStep();

//        MyIList<Value> expected = new MyList<Value>(new ArrayList(Arrays.asList("before while", 3, " " , 6, " " , 10, " " , 15, " " ,"\n",
//                                                                                "before while", 6, " " , 10, " " , 15, " " , 21, " " , "\n",
//                                                                                "before while", 10, " " , 15, " " , 21, " " , 28, " " , "\n",
//                                                                                "before while", 15, " " , 21, " " , 28, " " , 36, " " , "\n",
//                                                                                "before while")));
        ArrayList<Value> expected = new ArrayList<Value>(Arrays.asList(new StringValue("\n"),new IntValue(6), new StringValue(" ") , new IntValue(24), new StringValue(" "), new IntValue(120), new StringValue(" ") , new StringValue("\n"),
                new IntValue(24), new StringValue(" "), new IntValue(120), new StringValue(" ") , new IntValue(720), new StringValue(" ") ,new StringValue("\n"),
                new IntValue(120), new StringValue(" ") , new IntValue(720), new StringValue(" ") ,new IntValue(5040), new StringValue(" " ), new StringValue("\n"),
                new IntValue(720), new StringValue(" ") ,new IntValue(5040), new StringValue(" " ), new IntValue(40320), new StringValue(" ") ,new StringValue("\n")
        ));

        assertEquals(expected, out.getList());

    }


    @Test
    public void tc_goto_outside_for() throws Exception {

        IStmt ex = (IStmt) Parser.parse("files/goto_outside_for.txt");
        MyIStack<IStmt> exeStack=new MyStack<IStmt>();
        MyIStack<IStmt> exeStack_executed=new MyStack<IStmt>();
        MyIDictionary<Integer,IStmt> exeDictionary=new MyDictionary<Integer,IStmt>(); //((HashMap<Integer, IStmt>) map);
        MyIDictionary<String, Value> symTable=new MyDictionary<String, Value>();
        MyIDictionary<String,Pair<Value,Value>> dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        MyIList<Value> out=new MyList<Value>();
        MyIDictionary<StringValue,BufferedReader> fTbl=new MyDictionary<StringValue,BufferedReader>();
        MyIHeap heap=new MyHeap();

        PrgState prg = new PrgState(exeStack, exeDictionary, symTable, dynaimcSymTable, out, fTbl, heap, ex);

        ArrayList<PrgState> list = new ArrayList<PrgState>();
        list.add(prg);
        iRepo repo = new Repo(list, "log.txt");
        iCtrl ctrl = new Ctrl(repo, true);
        ctrl.allStep();

//        MyIList<Value> expected = new MyList<Value>(new ArrayList(Arrays.asList("before while", 3, " " , 6, " " , 10, " " , 15, " " ,"\n",
//                                                                                "before while", 6, " " , 10, " " , 15, " " , 21, " " , "\n",
//                                                                                "before while", 10, " " , 15, " " , 21, " " , 28, " " , "\n",
//                                                                                "before while", 15, " " , 21, " " , 28, " " , 36, " " , "\n",
//                                                                                "before while")));
        ArrayList<Value> expected = new ArrayList<Value>(Arrays.asList(new StringValue("before for") , new IntValue(1), new StringValue(" ") ,new IntValue(1), new StringValue(" ") , new IntValue(2), new StringValue(" " ), new IntValue(6), new StringValue(" ") , new IntValue(24), new StringValue(" "), new StringValue("\n")
        ));
        System.out.println("expected"+expected);
        System.out.println("out.getList()"+out.getList());

        assertEquals(expected, out.getList());

    }

    @Test
    public void tc_AllInvalid_VariableNotDefined() throws Exception {


        IStmt ex=new NopStmt();
        boolean flag = false;

        Map<Integer, IStmt> map = (Map<Integer, IStmt>) Parser.parse("files/test_integration_if_nested.txt");
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
//        ctrl.givenNumberOfSteps(7);



    }
//
//    @Test
//    public void tc_AllInvalid_VariableNotDefined() throws Exception {
//
//
//        IStmt ex=new NopStmt();
//        boolean flag = false;
//
//        Map<Integer, IStmt> map = (Map<Integer, IStmt>) Parser.parse("files/test_integration_while_nested2.txt");
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
    public void tc_isPrime() throws Exception {


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

    @Test
    public void tc_WhileNestedToConstructMatrix() throws Exception {


        IStmt ex=new NopStmt();
        boolean flag = false;

//        Parser parser = new Parser();
        Map<Integer, IStmt> map = (Map<Integer, IStmt>) Parser.parse("files/test_integration_while_nested.txt");
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
        iRepo repo = new Repo(list, "log1.txt");
//        iCtrl ctrl = new Ctrl(repo, true);
        iCtrl ctrl = new Ctrl(repo, false);
        ctrl.allStep();
//        ctrl.givenNumberOfSteps(30);



    }


    @Test
    public void tc_ForNestedToConstructMatrix() throws Exception {


        IStmt ex=new NopStmt();
        boolean flag = false;

        Map<Integer, IStmt> map = (Map<Integer, IStmt>) Parser.parse("files/test_integration_for_nested.txt");
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
//        iCtrl ctrl = new Ctrl(repo, true);
        iCtrl ctrl = new Ctrl(repo, false);
        ctrl.allStep();
//        ctrl.givenNumberOfSteps(30);



    }

    @Test
    public void tc_Dumb() throws Exception {


        IStmt ex=new NopStmt();
        boolean flag = false;

        //Parser parser = new Parser();
        Map<Integer, IStmt> map = (Map<Integer, IStmt>) Parser.parse("files/dumb1.txt");
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
//        iCtrl ctrl = new Ctrl(repo, false);
        ctrl.allStep();
//        ctrl.givenNumberOfSteps(30);



    }



}
