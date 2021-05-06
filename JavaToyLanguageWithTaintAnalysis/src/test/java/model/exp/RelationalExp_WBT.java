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
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class RelationalExp_WBT {
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
        exeStack=new MyStack<IStmt>();
        exeDictionary=new MyDictionary<Integer,IStmt>();
        symTable=new MyDictionary<String, Value>();
        dynaimcSymTable=new MyDictionary<String,Pair<Value,Value>>();
        out=new MyList<Value>();
        fTbl=new MyDictionary<StringValue,BufferedReader>();
        heap=new MyHeap();
    }


    @Test
    public void tc_FirstOperandInvalid() throws CustomException, VarNotDefined, DivByZero {

        RelationalExp exp = new RelationalExp("<",new ValueExp(new BoolValue(false)),new ValueExp(new IntValue(0)));
        boolean aux=true;
        try {
            BoolValue res = (BoolValue)exp.eval(symTable,heap);
        }
        catch(Exception e){
            aux=false;
        }
        assertFalse(aux);

    }
    @Test
    public void tc_SecondOperandInvalid() throws CustomException, VarNotDefined, DivByZero {

        RelationalExp exp = new RelationalExp("<",new ValueExp(new IntValue(5)),new ValueExp(new StringValue("0")));
        boolean aux=true;
        try {
            BoolValue res = (BoolValue)exp.eval(symTable,heap);
        }
        catch(Exception e){
            aux=false;
        }
        assertFalse(aux);

    }
    @Test
    public void tc_OperatorInvalid() throws CustomException, VarNotDefined, DivByZero {

        RelationalExp exp = new RelationalExp("<<",new ValueExp(new IntValue(5)),new ValueExp(new IntValue(3)));
        boolean aux=true;
        try {
            BoolValue res = (BoolValue)exp.eval(symTable,heap);
        }
        catch(Exception e){
            aux=false;
        }
        assertFalse(aux);

    }
    @Test
    public void tc_AllValid_LessThan() throws CustomException, VarNotDefined, DivByZero {

        RelationalExp exp = new RelationalExp("<",new ValueExp(new IntValue(5)),new ValueExp(new IntValue(6)));
        BoolValue res = (BoolValue)exp.eval(symTable,heap);
        assertTrue(res.getVal());

    }
    @Test
    public void tc_AllValid_LessOrEqual() throws CustomException, VarNotDefined, DivByZero {

        RelationalExp exp = new RelationalExp("<=",new ValueExp(new IntValue(5)),new ValueExp(new IntValue(5)));
        BoolValue res = (BoolValue)exp.eval(symTable,heap);
        assertTrue(res.getVal());

    }
    @Test
    public void tc_AllValid_Equal() throws CustomException, VarNotDefined, DivByZero {

        RelationalExp exp = new RelationalExp("==",new ValueExp(new IntValue(3)),new ValueExp(new IntValue(1)));
        BoolValue res = (BoolValue)exp.eval(symTable,heap);
        assertFalse(res.getVal());

    }
    @Test
    public void tc_AllValid_NotEqual() throws CustomException, VarNotDefined, DivByZero {

        RelationalExp exp = new RelationalExp("!=",new ValueExp(new IntValue(5)),new ValueExp(new IntValue(5)));
        BoolValue res = (BoolValue)exp.eval(symTable,heap);
        assertFalse(res.getVal());

    }
    @Test
    public void tc_AllValid_GreaterThan() throws CustomException, VarNotDefined, DivByZero {

        RelationalExp exp = new RelationalExp(">",new ValueExp(new IntValue(11)),new ValueExp(new IntValue(10)));
        BoolValue res = (BoolValue)exp.eval(symTable,heap);
        assertTrue(res.getVal());

    }
    @Test
    public void tc_AllValid_GreaterOrEqual() throws CustomException, VarNotDefined, DivByZero {

        RelationalExp exp = new RelationalExp(">=",new ValueExp(new IntValue(1)),new ValueExp(new IntValue(7)));
        BoolValue res = (BoolValue)exp.eval(symTable,heap);
        assertFalse(res.getVal());

    }
}
