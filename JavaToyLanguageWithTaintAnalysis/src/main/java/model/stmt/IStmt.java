package model.stmt;
import model.PrgState;
import MyException.*;

public interface IStmt {
	public String toString();
	public PrgState execute(PrgState state) throws VarNotDefined, DivByZero, VarIsDefined, TaintedAddress, CustomException;
	public int getStatementNumber();
	public void setStatementNumber(int number);
	public int getNumberOfNestedStatements();
}
