package model.stmt;

import MyException.CustomException;
import MyException.DivByZero;
import MyException.TaintedAddress;
import MyException.VarNotDefined;
import model.PrgState;
import model.adt.*;
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
    public PrgState execute(PrgState state) throws VarNotDefined, DivByZero, TaintedAddress, CustomException {
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
                    if(exeDictionary.getValue(instr) instanceof VarDeclStmt && n1<=((VarDeclStmt)exeDictionary.getValue(instr)).getLineNumber())
                    {
                        actualInstruction=instr;
                        break;
                    }
                    else if(exeDictionary.getValue(instr) instanceof AssignStmt && n1<=((AssignStmt)exeDictionary.getValue(instr)).getLineNumber())
                    {
                        actualInstruction=instr;
                        break;
                    }
                }
                //state.getNextInstructions().push(actualInstruction);//state.setNextInstruction(n1);
                state.setNextInstructions(new MyStack<Integer>());

                for (int instr: exeDictionary.keySet()){
                    if (instr==actualInstruction){
                        state.getNextInstructions().push(actualInstruction);
                        return state;
                    }
                    else if(exeDictionary.lookup(instr) instanceof WhileStmt){
                        WhileStmt stmt = (WhileStmt)exeDictionary.lookup(instr);
                        int startingStatement = stmt.getStatements().get(0).getStatementNumber();
                        int endingStatement = startingStatement + stmt.getTotalLength()-1;
                        if(startingStatement<=actualInstruction && actualInstruction<=endingStatement){
                            state.getNextInstructions().push(instr);
                            System.out.println("endingStatement:"+endingStatement);
                            for(int index=endingStatement;index>actualInstruction;){
                                if(exeDictionary.lookup(index) instanceof WhileStmt){
                                    state.getNextInstructions().push(index);
                                    index = index - ((WhileStmt)exeDictionary.lookup(index)).getTotalLength() - 1;
                                }
                                else{
                                    state.getNextInstructions().push(index);
                                    index--;
                                }
                            }
                        }
                        return state;

                    }


                }
            }

            else
                throw new TaintedAddress("goto's argument ("+ n1 + ") is an tainted address!");
        }else
            throw new VarNotDefined("goto's argument is not an integer");


        return state;
    }
    public int getStatementNumber(){return instructionNumber;}
    public void setStatementNumber(int number){instructionNumber=number;}
    public int getNumberOfNestedStatements(){return 0;}
}
