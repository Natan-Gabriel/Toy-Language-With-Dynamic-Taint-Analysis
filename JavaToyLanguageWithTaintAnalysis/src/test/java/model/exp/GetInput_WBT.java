package model.exp;

import MyException.CustomException;
import MyException.DivByZero;
import MyException.VarNotDefined;
import ctrl.iCtrl;
import model.PrgState;
import model.adt.*;
import model.stmt.IStmt;
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

public class GetInput_WBT {
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

        GetInput exp = new GetInput();

        InputStream original = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("44".getBytes());
        System.setIn(in);

        IntValue res = (IntValue)exp.eval(symTable,heap);

        System.setIn(original);

        assertEquals(res.getVal(),44);

    }

    @Test
    public void tc_AllInvalid() throws CustomException, VarNotDefined, DivByZero {

        GetInput exp = new GetInput();

        InputStream original = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("string".getBytes());
        System.setIn(in);

        boolean aux=true;
        try {
            Value res = exp.eval(symTable,heap);
        }
        catch(Exception e){
            aux=false;
        }
        assertFalse(aux);

        System.setIn(original);


    }

}
