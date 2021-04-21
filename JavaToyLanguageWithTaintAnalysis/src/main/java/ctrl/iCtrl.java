package ctrl;

import java.io.IOException;

import MyException.*;
import model.PrgState;

public interface iCtrl {
	public PrgState oneStep(PrgState state) throws ExeStackEmpty, VarNotDefined, DivByZero, VarIsDefined,Exception;
	public void allStep() throws ExeStackEmpty, VarNotDefined, DivByZero, VarIsDefined,Exception;
	public void  givenNumberOfSteps(int number) throws ExeStackEmpty, VarNotDefined, DivByZero, VarIsDefined,Exception;
	public void allStep(int b) throws ExeStackEmpty, VarNotDefined, DivByZero, VarIsDefined,Exception;
	public void displayPrgState (PrgState state);
	public int getLength();
	public void setFlag(boolean b);
}
