package repo;
import java.io.IOException;

import MyException.CustomException;
import model.*;
public interface iRepo {
	public PrgState getCrtPrg();
	public PrgState getCrtPrg(int b);
	public int getLength();
	
	void logPrgStateExec() throws IOException;

}
