package model.stmt;
import model.PrgState;
import MyException.*;

public interface IStmt {
	public String toString();
	public PrgState execute(PrgState state) throws VarNotDefined,DivByZero,VarIsDefined;
	public int getStatementNumber();
}
