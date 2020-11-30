package repo;

import model.*;
import model.stmt.*;
import model.values.*;
import java.util.*;
import java.io.*;

public class Repo implements iRepo{
	List<PrgState> list;
	PrintWriter logFile;
	String logFilePath;
	public Repo(List<PrgState> l,String f) {list=l;logFilePath=f;}
	public PrgState getCrtPrg(){return list.get(0);}//we get the only one prg in the repo
	public PrgState getCrtPrg(int a){return list.get(a-1);}
	public int getLength() {return list.size();}
	
	public void logPrgStateExec() throws Exception{
		
		try {
			logFile= new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
			//logFile.write("Exe stack\n");
			//logFile.newLine();
			for(PrgState state: list){
				logFile.write("ExeStack:\n");
				for(int i=state.getStk().getSize()-1;i>=0;i--) {
			
					 logFile.write(state.getStk().get(i).toString());
					 logFile.write("\n");
					 
				}
				logFile.write("SymTable:\n");
				
				for(String a:state.getSymTable().keySet()) {
			
					 logFile.write(a.toString()+"="+state.getSymTable().getValue(a).toString()); 
					 logFile.write("\n");
					 
				}
				logFile.write("Out:\n");
				
				for(int i=0;i<state.getOut().getSize();i++) {
			
					 logFile.write(state.getOut().get(i).toString());
					 logFile.write("\n");
					 
				}
				logFile.write("FileTable:\n");
				
				for(StringValue a:state.getFileTable().keySet()) {
			
					logFile.write(a.toString()+"="+state.getFileTable().getValue(a).toString()); 
					logFile.write("\n");
					 
				}
				
				logFile.write("\n");
			}
		}catch (IOException e) {
			 throw e;
		 } finally {
			 if (logFile!=null)
				 try {
					 logFile.close();
				 } catch (Exception e) {
					 System.err.println("Eroare inchidere fisier "+e);
				 }
		 }
	}
}
