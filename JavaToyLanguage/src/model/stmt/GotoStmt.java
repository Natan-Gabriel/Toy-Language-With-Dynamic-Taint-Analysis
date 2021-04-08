package model.stmt;

import MyException.DivByZero;
import MyException.TaintedAddress;
import MyException.VarNotDefined;
import model.PrgState;
import model.adt.MyIDictionary;
import model.adt.MyIHeap;
import model.adt.MyIList;
import model.adt.MyIStack;
import model.exp.Exp;
import model.types.IntType;
import model.types.Type;
import model.values.IntValue;
import model.values.Value;

public class GotoStmt implements IStmt{
    Exp exp;
    int instructionNumber;

    public GotoStmt(Exp e,int _instructionNumber) {exp=e;instructionNumber=_instructionNumber;}
    public String toString() { return "goto "+ exp.toString();}
    public PrgState execute(PrgState state) throws VarNotDefined, DivByZero, TaintedAddress {
        MyIStack<IStmt> stk=state.getStk();
        MyIDictionary<Integer,IStmt> exeDictionary=state.getExeDictionary();

        MyIDictionary<String, Value> symTbl= state.getSymTable();
        MyIHeap hp= state.getHeap();
        Value val = exp.eval(symTbl,hp);
        if (val.getType().equals(new IntType())) {
            IntValue i1 = (IntValue)val;
            int n1;
            n1= i1.getVal();
            int actualInstruction=1;
            if(!i1.getTaint()) {
                for (int instr: exeDictionary.keySet()){
                    if(exeDictionary.getValue(instr) instanceof VarDeclStmt && n1==((VarDeclStmt)exeDictionary.getValue(instr)).getLineNumber())
                    {
                        actualInstruction=instr;
                        System.out.println("INSTR"+instr);
                        break;
                    }
                    else if(exeDictionary.getValue(instr) instanceof AssignStmt && n1==((AssignStmt)exeDictionary.getValue(instr)).getLineNumber())
                    {
                        actualInstruction=instr;
                        System.out.println("INSTR"+instr);
                        break;
                    }
                }
                state.getNextInstructions().push(actualInstruction);//state.setNextInstruction(n1);
            }

            else
                throw new TaintedAddress("goto's argument ("+ n1 + ") is an tainted address!");
        }else
            throw new VarNotDefined("goto's argument is not an integer");


        return state;
    }
    public int getStatementNumber(){return instructionNumber;}
}
