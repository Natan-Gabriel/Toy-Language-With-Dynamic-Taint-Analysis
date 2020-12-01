package view;
import model.*;
import model.adt.*;
import model.stmt.*;
import model.types.*;
import model.values.*;
import model.exp.*;
import java.util.*;
import java.io.*;
import MyException.*;

import ctrl.*;
import repo.*;

public class main {
	public static void main(String[] arg) {//throws VarNotDefined, DivByZero, VarIsDefined{
		
		
	// int v; v=2;v=3;Print(v)
	IStmt ex1=   new CompStmt(new VarDeclStmt("v",new IntType(),1),
			 new CompStmt( new CompStmt( new AssignStmt("v",new GetInput(),2),new CompStmt(new GotoStmt(new ValueExp(new IntValue(5)),3),
					 new AssignStmt("v",new ValueExp(new IntValue(3)),4)) ), new PrintStmt(new
					 VarExp("v"),5)));

	//int a;int b; a=2+3*5;b=a+1;Print(b)
    IStmt ex2= new CompStmt( new VarDeclStmt("a",new IntType(),1),
    	new CompStmt(new VarDeclStmt("b",new IntType(),2),
    	new CompStmt(new AssignStmt("a", new ArithExp('+',new ValueExp(new IntValue(2)),new
    	ArithExp('*',new ValueExp(new IntValue(3)), new ValueExp(new IntValue(5)))),3),
    	new CompStmt(new AssignStmt("b",new ArithExp('+',new VarExp("a"), new
        ValueExp(new IntValue(1))),4), new PrintStmt(new VarExp("b"),5)))));
    

//  //int a; int v; a=1;(If a>0 Then v=2 Else v=3);Print(v) is represented as
//    IStmt ex3 = new CompStmt(new VarDeclStmt("a",new IntType()),
//    new CompStmt(new VarDeclStmt("v", new IntType()),
//   new CompStmt(new AssignStmt("a", new ValueExp(new IntValue(1))),
//    new CompStmt(new IfStmt(new RelationalExp(">",new VarExp("a"),new ValueExp(new IntValue(0))),new AssignStmt("v",new ValueExp(new
//   IntValue(2))), new AssignStmt("v", new ValueExp(new IntValue(3)))), new PrintStmt(new
//   VarExp("v"))))));
//
//
//
    MyIStack<IStmt> exeStack1=new MyStack<IStmt>();
    MyIDictionary<Integer,IStmt> exeDictionary1=new MyDictionary<Integer,IStmt>();
	MyIDictionary<String, Value> symTable1=new MyDictionary<String, Value>();
	MyIDictionary<String,Pair<Value,Value>> dynaimcSymTable1=new MyDictionary<String,Pair<Value,Value>>();
	MyIList<Value> out1=new MyList<Value>();
	MyIDictionary<StringValue,BufferedReader> fTbl1=new MyDictionary<StringValue,BufferedReader>();
	MyIHeap heap1=new MyHeap();

	MyIStack<IStmt> exeStack2=new MyStack<IStmt>();
	MyIDictionary<Integer,IStmt> exeDictionary2=new MyDictionary<Integer,IStmt>();
	MyIDictionary<String, Value> symTable2=new MyDictionary<String, Value>();
	MyIDictionary<String,Pair<Value,Value>> dynaimcSymTable2=new MyDictionary<String,Pair<Value,Value>>();
	MyIList<Value> out2=new MyList<Value>();
	MyIDictionary<StringValue,BufferedReader> fTbl2=new MyDictionary<StringValue,BufferedReader>();
	MyIHeap heap2=new MyHeap();
//
//	MyIStack<IStmt> exeStack3=new MyStack<IStmt>();
//	MyIDictionary<String, Value> symTable3=new MyDictionary<String, Value>();
//	MyIList<Value> out3=new MyList<Value>();
//	MyIDictionary<StringValue,BufferedReader> fTbl3=new MyDictionary<StringValue,BufferedReader>();
//	MyIHeap heap3=new MyHeap();
//
	PrgState prg1=new PrgState(exeStack1,exeDictionary1,symTable1,dynaimcSymTable1,out1,fTbl1,heap1,ex1);
	PrgState prg2=new PrgState(exeStack2,exeDictionary2,symTable2,dynaimcSymTable2,out2,fTbl2,heap2,ex2);
//	PrgState prg3=new PrgState(exeStack3,symTable3,out3,fTbl3,heap3,ex3);

	ArrayList<PrgState> list1 = new ArrayList<PrgState>();
	list1.add(prg1);
	iRepo repo1=new Repo(list1,"log1.txt");
	iCtrl ctrl1=new Ctrl(repo1);

	ArrayList<PrgState> list2 = new ArrayList<PrgState>();
	list2.add(prg2);
	iRepo repo2=new Repo(list2,"log2.txt");
	iCtrl ctrl2=new Ctrl(repo2);

//	ArrayList<PrgState> list3 = new ArrayList<PrgState>();
//	list3.add(prg3);
//	iRepo repo3=new Repo(list3,"log3.txt");
//	iCtrl ctrl3=new Ctrl(repo3);
//
//	//TESTARE
//	IStmt ex0=new VarDeclStmt("a",new IntType());
//
//	MyIStack<IStmt> exeStack0=new MyStack<IStmt>();
//	MyIDictionary<String, Value> symTable0=new MyDictionary<String, Value>();
//	MyIList<Value> out0=new MyList<Value>();
//	MyIDictionary<StringValue,BufferedReader> fTbl0=new MyDictionary<StringValue,BufferedReader>();
//	MyIHeap heap0=new MyHeap();
//	PrgState prg0=new PrgState(exeStack0,symTable0,out0,fTbl0,heap0,ex0);
//	ArrayList<PrgState> list0 = new ArrayList<PrgState>();
//	list0.add(prg0);
//	iRepo repo0=new Repo(list0,"log4.txt");
//	iCtrl ctrl0=new Ctrl(repo0);
//
//
//	String varf="test.in.txt";
//	Exp str=new ValueExp(new StringValue(varf));
//
//	OpenRFile o=new OpenRFile(str);
//
//	readFile r=new readFile(str,"a");//reads a line in fact
//
//	closeRFile c=new closeRFile(str);
//
//	IStmt ex4 = new CompStmt(new VarDeclStmt("a",new RefType(new IntType())),
//		new New("a",new ValueExp(new IntValue(5))));
//
//
//    MyIStack<IStmt> exeStack4=new MyStack<IStmt>();
//	MyIDictionary<String, Value> symTable4=new MyDictionary<String, Value>();
//	MyIList<Value> out4=new MyList<Value>();
//	MyIDictionary<StringValue,BufferedReader> fTbl4=new MyDictionary<StringValue,BufferedReader>();
//	MyIHeap heap4=new MyHeap();
//
//	PrgState prg4=new PrgState(exeStack4,symTable4,out4,fTbl4,heap4,ex4);
//
//	ArrayList<PrgState> list4 = new ArrayList<PrgState>();
//	list4.add(prg4);
//	iRepo repo4=new Repo(list4,"log4.txt");
//	iCtrl ctrl4=new Ctrl(repo4);
//
//
//
//	//? Ref int v;new(v,20);Ref Ref int a; new(a,v);print(rH(v));print(rH(rH(a))+5)
//	IStmt ex5 = new CompStmt(new CompStmt(new CompStmt(new CompStmt(new VarDeclStmt("v",new RefType(new IntType())),
//			new New("v",new ValueExp(new IntValue(20)))),
//			new CompStmt(new VarDeclStmt("a",new RefType(new RefType(new IntType()))),
//				new New("a",new VarExp("v")))),new PrintStmt(new rH(new VarExp("v")))),
//			new PrintStmt(new ArithExp('+',new rH(new rH(new VarExp("a"))),new ValueExp(new IntValue(5)))));
//	//IStmt ex5 = new CompStmt(new CompStmt(new VarDeclStmt("a",new RefType(new IntType())),
//		//	new New("a",new ValueExp(new IntValue(5)))),new PrintStmt(new rH(new VarExp("a"))));
//
//
//	    MyIStack<IStmt> exeStack5=new MyStack<IStmt>();
//		MyIDictionary<String, Value> symTable5=new MyDictionary<String, Value>();
//		MyIList<Value> out5=new MyList<Value>();
//		MyIDictionary<StringValue,BufferedReader> fTbl5=new MyDictionary<StringValue,BufferedReader>();
//		MyIHeap heap5=new MyHeap();
//
//		PrgState prg5=new PrgState(exeStack5,symTable5,out5,fTbl5,heap5,ex5);
//
//		ArrayList<PrgState> list5 = new ArrayList<PrgState>();
//		list5.add(prg5);
//		iRepo repo5=new Repo(list5,"log5.txt");
//		iCtrl ctrl5=new Ctrl(repo5);
//
//		try{
//			System.out.println("The execution begins");
//			ctrl5.allStep();
//			System.out.println("The execution is over");
//		}
//		catch(ExeStackEmpty | VarNotDefined | DivByZero | VarIsDefined e1) {
//			System.out.println(e1);
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//
//
//		//Ref int v;new(v,20);Ref Ref int a; new(a,v);print(v);print(a)
//		IStmt ex6 = new CompStmt(new CompStmt(new CompStmt(new CompStmt(new VarDeclStmt("v",new RefType(new IntType())),
//				new New("v",new ValueExp(new IntValue(20)))),
//				new CompStmt(new VarDeclStmt("a",new RefType(new RefType(new IntType()))),
//						new New("a",new VarExp("v")))),new PrintStmt(new VarExp("v"))),
//				new PrintStmt(new VarExp("a")));
//
//
//		    MyIStack<IStmt> exeStack6=new MyStack<IStmt>();
//			MyIDictionary<String, Value> symTable6=new MyDictionary<String, Value>();
//			MyIList<Value> out6=new MyList<Value>();
//			MyIDictionary<StringValue,BufferedReader> fTbl6=new MyDictionary<StringValue,BufferedReader>();
//			MyIHeap heap6=new MyHeap();
//
//			PrgState prg6=new PrgState(exeStack6,symTable6,out6,fTbl6,heap6,ex6);
//
//			ArrayList<PrgState> list6 = new ArrayList<PrgState>();
//			list6.add(prg6);
//			iRepo repo6=new Repo(list6,"log6.txt");
//			iCtrl ctrl6=new Ctrl(repo6);
//
//			try{
//				System.out.println("The execution begins");
//				ctrl6.allStep();
//				System.out.println("The execution is over");
//			}
//			catch(ExeStackEmpty | VarNotDefined | DivByZero | VarIsDefined e1) {
//				System.out.println(e1);
//			}
//			catch(Exception e) {
//				System.out.println(e);
//			}
//
//	//Ref int v;new(v,20);print(rH(v)); wH(v,30);print(rH(v)+5);
//			IStmt ex7 =new CompStmt(new CompStmt(new CompStmt(new CompStmt(new VarDeclStmt("a",new RefType(new IntType())),
//					new New("a",new ValueExp(new IntValue(20))))
//					,new PrintStmt(new rH(new VarExp("a"))))
//					,new wH("a",new ValueExp(new IntValue(30))) )
//					,new PrintStmt(new ArithExp('+',new rH(new VarExp("a")),new ValueExp(new IntValue(5))))  );
//
//
//			    MyIStack<IStmt> exeStack7=new MyStack<IStmt>();
//				MyIDictionary<String, Value> symTable7=new MyDictionary<String, Value>();
//				MyIList<Value> out7=new MyList<Value>();
//				MyIDictionary<StringValue,BufferedReader> fTbl7=new MyDictionary<StringValue,BufferedReader>();
//				MyIHeap heap7=new MyHeap();
//
//				PrgState prg7=new PrgState(exeStack7,symTable7,out7,fTbl7,heap7,ex7);
//
//				ArrayList<PrgState> list7 = new ArrayList<PrgState>();
//				list7.add(prg7);
//				iRepo repo7=new Repo(list7,"log7.txt");
//				iCtrl ctrl7=new Ctrl(repo7);
//
//				try{
//					System.out.println("The execution begins");
//					ctrl7.allStep();
//					System.out.println("The execution is over");
//				}
//				catch(ExeStackEmpty | VarNotDefined | DivByZero | VarIsDefined e1) {
//					System.out.println(e1);
//				}
//				catch(Exception e) {
//					System.out.println(e);
//				}
//
//
//				//Ref int v;new(v,20);Ref Ref int a; new(a,v); new(v,30);print(rH(rH(a)))
//				IStmt ex8 =new CompStmt(new CompStmt(new CompStmt(new CompStmt(new VarDeclStmt("v",new RefType(new IntType())),
//						new New("v",new ValueExp(new IntValue(20)))),
//						new CompStmt(new VarDeclStmt("a",new RefType(new RefType(new IntType()))),
//								new New("a",new VarExp("v")))),new New("v",new ValueExp(new IntValue(30))) ),
//						new PrintStmt(new rH(new rH(new VarExp("a")))) );
//
//				    MyIStack<IStmt> exeStack8=new MyStack<IStmt>();
//					MyIDictionary<String, Value> symTable8=new MyDictionary<String, Value>();
//					MyIList<Value> out8=new MyList<Value>();
//					MyIDictionary<StringValue,BufferedReader> fTbl8=new MyDictionary<StringValue,BufferedReader>();
//					MyIHeap heap8=new MyHeap();
//
//					PrgState prg8=new PrgState(exeStack8,symTable8,out8,fTbl8,heap8,ex8);
//
//					ArrayList<PrgState> list8 = new ArrayList<PrgState>();
//					list8.add(prg8);
//					iRepo repo8=new Repo(list8,"log8.txt");
//					iCtrl ctrl8=new Ctrl(repo8);
//
//					try{
//						System.out.println("The execution begins");
//						ctrl8.allStep();
//						System.out.println("The execution is over");
//					}
//					catch(ExeStackEmpty | VarNotDefined | DivByZero | VarIsDefined e1) {
//						System.out.println(e1);
//					}
//					catch(Exception e) {
//						System.out.println(e);
//					}
//
//
//
//
//					//Ref int v;new(v,20);Ref Ref int a; new(a,v); new(v,30);new(a,v);print(rH(rH(a)))
//					IStmt ex81 =new CompStmt(new CompStmt(new CompStmt(new CompStmt(new CompStmt(new VarDeclStmt("v",new RefType(new IntType())),
//							new New("v",new ValueExp(new IntValue(20)))),
//							new CompStmt(new VarDeclStmt("a",new RefType(new RefType(new IntType()))),
//									new New("a",new VarExp("v")))),new New("v",new ValueExp(new IntValue(30))) ),
//							new New("a",new VarExp("v"))),
//							new PrintStmt(new rH(new rH(new VarExp("a")))) );
//
//					    MyIStack<IStmt> exeStack81=new MyStack<IStmt>();
//						MyIDictionary<String, Value> symTable81=new MyDictionary<String, Value>();
//						MyIList<Value> out81=new MyList<Value>();
//						MyIDictionary<StringValue,BufferedReader> fTbl81=new MyDictionary<StringValue,BufferedReader>();
//						MyIHeap heap81=new MyHeap();
//
//						PrgState prg81=new PrgState(exeStack81,symTable81,out81,fTbl81,heap81,ex81);
//
//						ArrayList<PrgState> list81 = new ArrayList<PrgState>();
//						list81.add(prg81);
//						iRepo repo81=new Repo(list81,"log81.txt");
//						iCtrl ctrl81=new Ctrl(repo81);
//
//						try{
//							System.out.println("The execution begins");
//							ctrl81.allStep();
//							System.out.println("The execution is over");
//						}
//						catch(ExeStackEmpty | VarNotDefined | DivByZero | VarIsDefined e1) {
//							System.out.println(e1);
//						}
//						catch(Exception e) {
//							System.out.println(e);
//						}
//
//
//
//
//
//
//				// int v; v=4; (while (v>0) print(v);v=v-1);print(v)
//				IStmt ex9 =new CompStmt(new CompStmt(new CompStmt(new VarDeclStmt("v",new IntType()),
//						new AssignStmt("v",new ValueExp(new IntValue(4))))
//						,new WhileStmt(new RelationalExp(">",new VarExp("v"),new ValueExp(new IntValue(0)))
//						,new CompStmt(new PrintStmt(new VarExp("v"))
//						,new 	AssignStmt("v",new ArithExp('-',new VarExp("v"),new ValueExp(new IntValue(1))))	) ) )
//						,new PrintStmt(new VarExp("v")) );
//
//				    MyIStack<IStmt> exeStack9=new MyStack<IStmt>();
//					MyIDictionary<String, Value> symTable9=new MyDictionary<String, Value>();
//					MyIList<Value> out9=new MyList<Value>();
//					MyIDictionary<StringValue,BufferedReader> fTbl9=new MyDictionary<StringValue,BufferedReader>();
//					MyIHeap heap9=new MyHeap();
//
//					PrgState prg9=new PrgState(exeStack9,symTable9,out9,fTbl9,heap9,ex9);
//
//					ArrayList<PrgState> list9 = new ArrayList<PrgState>();
//					list9.add(prg9);
//					iRepo repo9=new Repo(list9,"log9.txt");
//					iCtrl ctrl9=new Ctrl(repo9);
//
//					try{
//						System.out.println("The execution begins");
//						ctrl9.allStep();
//						System.out.println("The execution is over");
//					}
//					catch(ExeStackEmpty | VarNotDefined | DivByZero | VarIsDefined e1) {
//						System.out.println(e1);
//					}
//					catch(Exception e) {
//						System.out.println(e);
//					}
			
	TextMenu menu = new TextMenu();
	menu.addCommand(new ExitCommand("0", "exit"));
	menu.addCommand(new RunExample("1",ex1.toString(),ctrl1));
	menu.addCommand(new RunExample("2",ex2.toString(),ctrl2));
//	menu.addCommand(new RunExample("3",ex3.toString(),ctrl3));
	menu.show();
	
    
    
	}
}
