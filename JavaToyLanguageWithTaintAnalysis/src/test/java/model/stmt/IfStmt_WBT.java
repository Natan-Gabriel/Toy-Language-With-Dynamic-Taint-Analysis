package model.stmt;

import MyException.*;
import ctrl.Ctrl;
import ctrl.iCtrl;
import model.PrgState;
import model.adt.*;
import model.exp.Exp;
import model.exp.ValueExp;
import model.types.IntType;
import model.values.BoolValue;
import model.values.IntValue;
import model.values.StringValue;
import model.values.Value;
import org.junit.Test;
import repo.Repo;
import repo.iRepo;
import view.Command;
import view.RunExample;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class IfStmt_WBT {

    @Test
    public void tc_InvalidCondition() throws Exception {

        Map<Integer, IStmt> map = Stream.of(new Object[][]{
                {1, new VarDeclStmt("x", new IntType(), 1, 1)},
                {2, new IfStmt((Exp) (new ValueExp(new IntValue(5))),
                        new ArrayList<IStmt>(Arrays.asList(new AssignStmt("x", new ValueExp(new IntValue(2)), 3, 1))),
                        new ArrayList<IStmt>(Arrays.asList(new AssignStmt("x", new ValueExp(new IntValue(3)), 4, 1))), 2,2)},
                {3, new AssignStmt("x", new ValueExp(new IntValue(2)), 3, 1)},
                {4, new AssignStmt("x", new ValueExp(new IntValue(3)), 4, 1)}

        }).collect(Collectors.toMap(data ->(Integer) data[0], data -> (IStmt) data[1]));

        IStmt ex=new NopStmt();
        MyIStack<IStmt> exeStack=new MyStack<IStmt>();
        MyIDictionary<Integer,IStmt> exeDictionary=new MyDictionary<Integer,IStmt>((HashMap<Integer, IStmt>) map);
        MyIDictionary<String, Value> symTable=new MyDictionary<String, Value>();
        MyIDictionary<String, Pair<Value,Value>> dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        MyIList<Value> out=new MyList<Value>();
        MyIDictionary<StringValue, BufferedReader> fTbl=new MyDictionary<StringValue,BufferedReader>();
        MyIHeap heap=new MyHeap();

        PrgState prg=new PrgState(exeStack,exeDictionary,symTable,dynaimcSymTable,out,fTbl,heap,ex);
        ArrayList<PrgState> list = new ArrayList<PrgState>();
        list.add(prg);
        iRepo repo=new Repo(list,"log.txt");
        iCtrl ctrl=new Ctrl(repo,false);

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
    public void tc_AllValid() throws Exception {

        Map<Integer, IStmt> map = Stream.of(new Object[][]{
                {1, new VarDeclStmt("x", new IntType(), 1, 1)},
                {2, new IfStmt((Exp) (new ValueExp(new BoolValue(new Boolean("true")))),
                        new ArrayList<IStmt>(Arrays.asList(new AssignStmt("x", new ValueExp(new IntValue(2)), 3, 1))),
                        new ArrayList<IStmt>(Arrays.asList(new AssignStmt("x", new ValueExp(new IntValue(3)), 4, 1))), 2,2,2)},
                {3, new AssignStmt("x", new ValueExp(new IntValue(2)), 3, 1)},
                {4, new AssignStmt("x", new ValueExp(new IntValue(3)), 4, 1)}

        }).collect(Collectors.toMap(data ->(Integer) data[0], data -> (IStmt) data[1]));

        IStmt ex=new NopStmt();
        MyIStack<IStmt> exeStack=new MyStack<IStmt>();
        MyIDictionary<Integer,IStmt> exeDictionary=new MyDictionary<Integer,IStmt>((HashMap<Integer, IStmt>) map);
        MyIDictionary<String, Value> symTable=new MyDictionary<String, Value>();
        MyIDictionary<String, Pair<Value,Value>> dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        MyIList<Value> out=new MyList<Value>();
        MyIDictionary<StringValue, BufferedReader> fTbl=new MyDictionary<StringValue,BufferedReader>();
        MyIHeap heap=new MyHeap();

        PrgState prg=new PrgState(exeStack,exeDictionary,symTable,dynaimcSymTable,out,fTbl,heap,ex);
        ArrayList<PrgState> list = new ArrayList<PrgState>();
        list.add(prg);
        iRepo repo=new Repo(list,"log.txt");
        iCtrl ctrl=new Ctrl(repo,true);
        ctrl.allStep();


        assertEquals(symTable.lookup("x"),new IntValue(2));


    }

}
