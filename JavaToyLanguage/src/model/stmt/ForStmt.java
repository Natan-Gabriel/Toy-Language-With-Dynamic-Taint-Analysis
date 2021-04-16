package model.stmt;

import MyException.CustomException;
import MyException.DivByZero;
import MyException.VarNotDefined;
import model.PrgState;
import model.adt.MyIDictionary;
import model.adt.MyIHeap;
import model.adt.MyIStack;
import model.exp.Exp;
import model.exp.RelationalExp;
import model.exp.ValueExp;
import model.exp.VarExp;
import model.types.BoolType;
import model.types.IntType;
import model.types.RefType;
import model.types.Type;
import model.values.BoolValue;
import model.values.IntValue;
import model.values.Value;

import java.util.ArrayList;
import java.util.List;

public class ForStmt  implements IStmt{
    Exp exp1,exp2,exp3;
    List<IStmt> s;
    int instructionNumber;

    //public ForStmt(IStmt s11,Exp e,IStmt s22,IStmt s33) {exp=e;s1=s11;s2=s22;stmt=s33;}
    public ForStmt(Exp e1,Exp e2,Exp e3, List<IStmt> s1,int _instructionNumber) {exp1=e1;exp2=e2;exp3=e3;s=s1;instructionNumber=_instructionNumber;}
    public String toString() { return "for(v="+exp1.toString()+",v<"+exp2.toString()+",v="+exp3.toString()+")"+s.toString();}
    public PrgState execute(PrgState state) throws VarNotDefined, DivByZero{
        MyIStack<IStmt> stk=state.getStk();
        MyIDictionary<String,Value> symTbl= state.getSymTable();
        MyIHeap hp= state.getHeap();

        MyIStack<Integer> nextInstructions=state.getNextInstructions();
//        Value val=exp.eval(symTbl,hp);
//        List<IStmt> l = new ArrayList<IStmt>();
//        l.add()
//        l.addAll(s);
//
//        if(val.getType().equals(new BoolType())){
//            if( ((BoolValue)val).getVal() ) {
//
//                nextInstructions.push(instructionNumber);
//
//                for(int i=s.size()-1;i>=0;i--) {
//
////				 	if(i==s.size()-1) {
////						nextInstructions.push(-1);
////					}
//
//                    nextInstructions.push(s.get(i).getStatementNumber());
//                    System.out.println("s.get(i).getStatementNumber()"+s.get(i).getStatementNumber());
//                }
//
//
//            }
//            else{
//                nextInstructions.push(instructionNumber+s.size()+1);
//                System.out.println("nextInstructions:"+nextInstructions);
//            }
//
//        }
//        else throw new VarNotDefined("while  condition is not a boolena value");

        return state;
    }

    public int getStatementNumber(){return instructionNumber;}
    public void setStatementNumber(int number){instructionNumber=number;}

}
