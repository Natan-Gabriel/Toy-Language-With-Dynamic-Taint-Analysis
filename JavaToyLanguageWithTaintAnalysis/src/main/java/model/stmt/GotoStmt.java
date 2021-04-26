package model.stmt;

import MyException.*;
import model.PrgState;
import model.adt.*;
import model.exp.Exp;
import model.types.IntType;
import model.types.Type;
import model.values.IntValue;
import model.values.Value;

public class GotoStmt implements IStmt{
    Exp exp;
    int lineNumber;

    public GotoStmt(Exp e,int _lineNumber) {exp=e;lineNumber=_lineNumber;}
    public String toString() { return "goto "+ exp.toString();}
    public PrgState execute(PrgState state) throws VarNotDefined, DivByZero, TaintedAddress, CustomException, VarIsDefined {
        //MyIStack<IStmt> stk=state.getStk();
        MyIDictionary<Integer,IStmt> exeDictionary=state.getExeDictionary();

        MyIDictionary<String, Value> symTbl= state.getSymTable();
        MyIHeap hp= state.getHeap();
        Value val = exp.eval(symTbl,hp);
        if (val.getType().equals(new IntType())) {
            IntValue i1 = (IntValue)val;
            int n1;
            n1= i1.getVal();
            if(!i1.getTaint()) {
                //state.setNextInstruction(n1);
                MyIStack<IStmt> stk = new MyStack<IStmt>();
                state.setStk(stk);
                stk.push(state.getOriginalProgram());
                MyIList<IStmt> visited = new MyList<IStmt>();
                while (!stk.isEmpty()){
                    IStmt crtStmt = stk.pop();
                    if(crtStmt instanceof CompStmt){
                        crtStmt.execute(state);
                        System.out.println("I reached here. stk is: "+stk);
                    }
                    else if(crtStmt.getLineNumber()>=n1 ){
                        stk.push(crtStmt);
                        break;
                    }
                    else if ((crtStmt instanceof WhileStmt) && (crtStmt.getLineNumber()<=n1 && n1<=((WhileStmt)crtStmt).getEndingLine()  )){ //(crtStmt instanceof IfStmt) ||
                        if(!visited.contains(crtStmt)) {
                            visited.add(crtStmt); // in order to avoid running the loop forever, when the goto's argument satisfies the above condition, but there are no statements after this line
                            ((WhileStmt) crtStmt).simulateExecution(state);
                            System.out.println("crtStmt instanceof WhileStmt. stk is: " + stk);
                        }
                    }
                    else if ((crtStmt instanceof IfStmt) && (crtStmt.getLineNumber()<=n1 && n1<=((IfStmt)crtStmt).getEndingLine()  )){ //(crtStmt instanceof IfStmt) ||
                        if(!visited.contains(crtStmt)){
                            visited.add(crtStmt);
                            crtStmt.execute(state);
                            System.out.println("crtStmt instanceof WhileStmt. stk is: " + stk);

                        }

                    }

                }
            }
            else
                throw new TaintedAddress("goto's argument is an tainted address!");
        }else
            throw new VarNotDefined("goto's argument is not an integer");


        return state;
    }
    public int  getLineNumber(){return lineNumber;}
}
