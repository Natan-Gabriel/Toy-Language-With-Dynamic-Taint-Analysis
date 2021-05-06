package model.exp;

import MyException.CustomException;
import MyException.DivByZero;
import MyException.VarNotDefined;
import ctrl.iCtrl;
import model.PrgState;
import model.adt.*;
import model.stmt.IStmt;
import model.values.BoolValue;
import model.values.IntValue;
import model.values.StringValue;
import model.values.Value;
import org.junit.BeforeClass;
import org.junit.Test;
import repo.iRepo;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ValueExp_WBT {

    static MyIStack<IStmt> exeStack;
    static MyIDictionary<Integer,IStmt> exeDictionary;
    static MyIDictionary<String, Value> symTable;
    static MyIDictionary<String, Pair<Value,Value>> dynaimcSymTable;
    static MyIList<Value> out;
    static MyIDictionary<StringValue, BufferedReader> fTbl;
    static MyIHeap heap;

    static PrgState prg;

    static ArrayList<PrgState> list;
    static iRepo repo;
    static iCtrl ctrl;

    @BeforeClass
    public static void setup() throws FileNotFoundException {
        exeStack = new MyStack<IStmt>();
        exeDictionary = new MyDictionary<Integer, IStmt>();
        symTable = new MyDictionary<String, Value>();
        dynaimcSymTable = new MyDictionary<String, Pair<Value, Value>>();
        out = new MyList<Value>();
        fTbl = new MyDictionary<StringValue, BufferedReader>();
        heap = new MyHeap();
    }

    @Test
    public void tc_AllValid() throws CustomException, VarNotDefined, DivByZero {

        ValueExp exp = new ValueExp(new IntValue(7));
        Value res = exp.eval(symTable,heap);
        assertEquals(res,new IntValue(7));

    }


}
