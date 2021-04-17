package view;
import java.io.IOException;
import java.util.Arrays;

import MyException.*;
import ctrl.*;

public class RunExample extends Command{
	 private iCtrl ctrl;
	 public RunExample(String key, String desc,iCtrl ctrl){
		 super(key, desc);
		 this.ctrl=ctrl;
	 }
	 @Override
	 public void execute() {
		 try{
				System.out.println("The execution begins");
				ctrl.allStep();
				System.out.println("The execution is over");
			}
			catch(ExeStackEmpty | VarNotDefined | DivByZero | VarIsDefined | TaintedAddress e1) {
				System.out.println(e1);//System.out.println(Arrays.toString(e1.getStackTrace()));
			}
			catch(Exception e) {
		 		e.printStackTrace();
				System.out.println(e);//System.out.println(Arrays.toString(e.getStackTrace()));
			}
	 }

}
