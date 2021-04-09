package view;
import analyser.Parser;
import model.*;
import model.adt.*;
import model.stmt.*;
import model.types.*;
import model.values.*;
import model.exp.*;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import MyException.*;

import ctrl.*;
import repo.*;

public class main {
	public static void main(String[] arg) {//throws VarNotDefined, DivByZero, VarIsDefined{
		
		
	// int v; v=get_input(); goto v ; v=3;Print(v)
	IStmt ex1=   new CompStmt(new VarDeclStmt("v",new IntType(),1,1),
			 new CompStmt( new CompStmt( new AssignStmt("v",new GetInput(),2,1),new CompStmt(new GotoStmt(new VarExp("v"),3),
					 new AssignStmt("v",new ValueExp(new IntValue(3)),4,1)) ), new PrintStmt(new
					 VarExp("v"),5)));
//
//
//	Map<Integer, IStmt> map1 = Stream.of(new Object[][] {
//			{ 1,new VarDeclStmt("v",new IntType(),1)},
//			{ 2, new AssignStmt("v",new GetInput(),2) },
//			{ 3, new GotoStmt(new VarExp("v"),3)},
//			{ 4, new AssignStmt("v",new ValueExp(new IntValue(3)),4)  },
//			{ 5, new PrintStmt(new
//					VarExp("v"),5) }
//	}).collect(Collectors.toMap(data ->(Integer) data[0], data -> (IStmt) data[1]));
//
//
//		//int a;int b; a=2+3*5;b=a+1;Print(b)
//    IStmt ex2= new CompStmt( new VarDeclStmt("a",new IntType(),1),
//    	new CompStmt(new VarDeclStmt("b",new IntType(),2),
//    	new CompStmt(new AssignStmt("a", new ArithExp('+',new ValueExp(new IntValue(2)),new
//    	ArithExp('*',new ValueExp(new IntValue(3)), new ValueExp(new IntValue(5)))),3),
//    	new CompStmt(new AssignStmt("b",new ArithExp('+',new VarExp("a"), new
//        ValueExp(new IntValue(1))),4), new PrintStmt(new VarExp("b"),5)))));
//
//
//		Map<Integer, IStmt> map2 = Stream.of(new Object[][] {
//				{ 1,new VarDeclStmt("a",new IntType(),1)},
//				{ 2,new VarDeclStmt("b",new IntType(),2) },
//				{ 3, new AssignStmt("a", new ArithExp('+',new ValueExp(new IntValue(2)),new
//						ArithExp('*',new ValueExp(new IntValue(3)), new ValueExp(new IntValue(5)))),3)},
//				{ 4, new AssignStmt("b",new ArithExp('+',new VarExp("a"), new
//						ValueExp(new IntValue(1))),4)  },
//				{ 5, new PrintStmt(new VarExp("b"),5) }
//		}).collect(Collectors.toMap(data ->(Integer) data[0], data -> (IStmt) data[1]));
//
//
//
//
//
//		// int v; v=2; goto 5 ; v=3;Print(v)
//	List<IStmt> ex3 = Arrays.asList(new VarDeclStmt("v",new IntType(),1),
//			new AssignStmt("v",new ValueExp(new IntValue(2)),4),new GotoStmt(new ValueExp(new IntValue(5)),3),
//					new AssignStmt("v",new ValueExp(new IntValue(3)),4) , new PrintStmt(new
//					VarExp("v"),5));
//



		// int v; v=2; goto 5 ; v=3;Print(v)
//		Map<Integer, IStmt> map3 = Stream.of(new Object[][] {
//				{ 1,new VarDeclStmt("v",new IntType(),1)},
//				{ 2, new AssignStmt("v",new ValueExp(new IntValue(2)),2) },
//				{ 3, new GotoStmt(new ValueExp(new IntValue(5)),3)},
//				{ 4, new AssignStmt("v",new ValueExp(new IntValue(3)),4)  },
//				{ 5, new PrintStmt(new
//						VarExp("v"),5) }
//		}).collect(Collectors.toMap(data ->(Integer) data[0], data -> (IStmt) data[1]));



//		Map<Integer, IStmt> map3 = Stream.of(new Object[][] {
//				{1,new VarDeclStmt("a",new IntType(),1,1)},{2,new VarDeclStmt("b",new IntType(),2,1)},{3,new VarDeclStmt("c",new IntType(),3,1)},{4,new VarDeclStmt("d",new IntType(),4,1)},{5,new VarDeclStmt("e",new IntType(),5,1)},{6,new VarDeclStmt("f",new IntType(),6,1)},{7,new GotoStmt(new ValueExp(new IntValue(5)),7)},{8,new AssignStmt("a",new ValueExp(new IntValue(2)),8,3)},{9,new AssignStmt("b",new ValueExp(new IntValue(3)),9,4)},{10,new AssignStmt("c",new ValueExp(new IntValue(4)),10,5)},{11,new AssignStmt("d",new ValueExp(new IntValue(5)),11,5)},{12,new GotoStmt(new ValueExp(new IntValue(7)),12)},{13,new AssignStmt("e",new ValueExp(new IntValue(7)),13,6)},{14,new AssignStmt("f",new ValueExp(new IntValue(8)),14,7)},
//
//
//		}).collect(Collectors.toMap(data ->(Integer) data[0], data -> (IStmt) data[1]));

		Map<Integer, IStmt> map3=null;

		Object res=null;
		try {
			map3=(Map<Integer, IStmt>)Parser.parse("simple.minijava");
			MyIStack<IStmt> exeStack3=new MyStack<IStmt>();
			MyIDictionary<Integer,IStmt> exeDictionary3=new MyDictionary<Integer,IStmt>((HashMap<Integer, IStmt>) map3);
			MyIDictionary<String, Value> symTable3=new MyDictionary<String, Value>();
			MyIDictionary<String,Pair<Value,Value>> dynaimcSymTable3=new MyDictionary<String,Pair<Value,Value>>();
			MyIList<Value> out3=new MyList<Value>();
			MyIDictionary<StringValue,BufferedReader> fTbl3=new MyDictionary<StringValue,BufferedReader>();
			MyIHeap heap3=new MyHeap();

			PrgState prg3=new PrgState(exeStack3,exeDictionary3,symTable3,dynaimcSymTable3,out3,fTbl3,heap3,ex1);

			ArrayList<PrgState> list3 = new ArrayList<PrgState>();
			list3.add(prg3);
			iRepo repo3=new Repo(list3,"log3.txt");
			iCtrl ctrl3=new Ctrl(repo3);
			Command cmd=new RunExample("3",ex1.toString(),ctrl3);
			cmd.execute();
		} catch (Exception e) {
			System.out.println("Error: "+e);
			e.printStackTrace();
		}
		System.out.println("res:"+(String)res);



		// int x; x=2*get_input(); int y ; y=5+x ; goto y
//		Map<Integer, IStmt> map4 = Stream.of(new Object[][] {
//				{ 1,new VarDeclStmt("x",new IntType(),1)},
//				{ 2,  new AssignStmt("x",new ArithExp('*',new GetInput(), new
//						ValueExp(new IntValue(2))),2) },
//				{ 3,new VarDeclStmt("y",new IntType(),3)},
//				{ 4, new AssignStmt("y",new ArithExp('+',new VarExp("x"), new
//						ValueExp(new IntValue(5))),4)},
//				{ 5,new GotoStmt(new VarExp("y"),5)  },
//		}).collect(Collectors.toMap(data ->(Integer) data[0], data -> (IStmt) data[1]));


		// int x; if(0==0) then x=2 else x=3; Print(x)
//		Map<Integer, IStmt> map5 = Stream.of(new Object[][] {
//				{ 1,new VarDeclStmt("x",new IntType(),1,1)},
//				{2, new IfStmt(new RelationalExp("==",new ValueExp(new IntValue(0)),new ValueExp(new IntValue(0))),
//						new AssignStmt("x",new ArithExp('*',new GetInput(), new
//								ValueExp(new IntValue(2))),3,3),
//						new AssignStmt("x",new ArithExp('*',new GetInput(), new
//								ValueExp(new IntValue(2))),4,3),2) },
//				{ 5, new PrintStmt(new
//						VarExp("v"),5) }
//		}).collect(Collectors.toMap(data ->(Integer) data[0], data -> (IStmt) data[1]));

		// int x; if(0==0) then x=2 else x=3; Print(x)
		Map<Integer, IStmt> map5 = Stream.of(new Object[][] {
				{ 1,new VarDeclStmt("x",new IntType(),1,1)},
				{2, new IfStmt(new RelationalExp("==",new ValueExp(new IntValue(0)),new ValueExp(new IntValue(0))),
						new ArrayList<IStmt>(Arrays.asList(new AssignStmt("x",new ValueExp(new IntValue(2)),3,1))),
						new ArrayList<IStmt>(Arrays.asList(new AssignStmt("x",new ValueExp(new IntValue(3)),5,1))),2) },
				{3, new AssignStmt("x",new ValueExp(new IntValue(2)),3,1)},
				{4,new NopStmt()},
				{5, new AssignStmt("x",new ValueExp(new IntValue(3)),5,1)},
				{ 6, new PrintStmt(new
						VarExp("x"),6) }
		}).collect(Collectors.toMap(data ->(Integer) data[0], data -> (IStmt) data[1]));
//
//
//		// int x; x=0 ; while(x<6) { x=x+1 } ; Print(x)
//		Map<Integer, IStmt> map6 = Stream.of(new Object[][] {
//				{ 1,new VarDeclStmt("x",new IntType(),1)},
//				{ 2,new AssignStmt("x",new ValueExp(new IntValue(1)),2) },
//				{ 3, new WhileStmt(new RelationalExp("<",new VarExp("x"),new ValueExp(new IntValue(6))),
//						new ArrayList<IStmt>(Arrays.asList(new AssignStmt("x",new ArithExp('+',new VarExp("x"), new
//								ValueExp(new IntValue(1))),4))),3) },
//				{ 4, new AssignStmt("x",new ArithExp('+',new VarExp("x"), new
//						ValueExp(new IntValue(1))),4)},
//
//				{ 5, new NopStmt(),5 },
//				{ 6, new PrintStmt(new
//						VarExp("x"),6) }
//		}).collect(Collectors.toMap(data ->(Integer) data[0], data -> (IStmt) data[1]));
//


    


//	MyIStack<IStmt> exeStack1=new MyStack<IStmt>();
//    MyIDictionary<Integer,IStmt> exeDictionary1=new MyDictionary<Integer,IStmt>((HashMap<Integer, IStmt>) map1);//new MyDictionary<Integer,IStmt>();
//	MyIDictionary<String, Value> symTable1=new MyDictionary<String, Value>();
//	MyIDictionary<String,Pair<Value,Value>> dynaimcSymTable1=new MyDictionary<String,Pair<Value,Value>>();
//	MyIList<Value> out1=new MyList<Value>();
//	MyIDictionary<StringValue,BufferedReader> fTbl1=new MyDictionary<StringValue,BufferedReader>();
//	MyIHeap heap1=new MyHeap();
//
//	MyIStack<IStmt> exeStack2=new MyStack<IStmt>();
//	MyIDictionary<Integer,IStmt> exeDictionary2=new MyDictionary<Integer,IStmt>((HashMap<Integer, IStmt>) map2);
//	MyIDictionary<String, Value> symTable2=new MyDictionary<String, Value>();
//	MyIDictionary<String,Pair<Value,Value>> dynaimcSymTable2=new MyDictionary<String,Pair<Value,Value>>();
//	MyIList<Value> out2=new MyList<Value>();
//	MyIDictionary<StringValue,BufferedReader> fTbl2=new MyDictionary<StringValue,BufferedReader>();
//	MyIHeap heap2=new MyHeap();




	MyIStack<IStmt> exeStack3=new MyStack<IStmt>();
	MyIDictionary<Integer,IStmt> exeDictionary3=new MyDictionary<Integer,IStmt>((HashMap<Integer, IStmt>) map3);
	MyIDictionary<String, Value> symTable3=new MyDictionary<String, Value>();
	MyIDictionary<String,Pair<Value,Value>> dynaimcSymTable3=new MyDictionary<String,Pair<Value,Value>>();
	MyIList<Value> out3=new MyList<Value>();
	MyIDictionary<StringValue,BufferedReader> fTbl3=new MyDictionary<StringValue,BufferedReader>();
	MyIHeap heap3=new MyHeap();


//	MyIStack<IStmt> exeStack4=new MyStack<IStmt>();
//	MyIDictionary<Integer,IStmt> exeDictionary4=new MyDictionary<Integer,IStmt>((HashMap<Integer, IStmt>) map4);
//	MyIDictionary<String, Value> symTable4=new MyDictionary<String, Value>();
//	MyIDictionary<String,Pair<Value,Value>> dynaimcSymTable4=new MyDictionary<String,Pair<Value,Value>>();
//	MyIList<Value> out4=new MyList<Value>();
//	MyIDictionary<StringValue,BufferedReader> fTbl4=new MyDictionary<StringValue,BufferedReader>();
//	MyIHeap heap4=new MyHeap();
//
//	MyIStack<IStmt> exeStack5=new MyStack<IStmt>();
//	MyIDictionary<Integer,IStmt> exeDictionary5=new MyDictionary<Integer,IStmt>((HashMap<Integer, IStmt>) map5);
//	MyIDictionary<String, Value> symTable5=new MyDictionary<String, Value>();
//	MyIDictionary<String,Pair<Value,Value>> dynaimcSymTable5=new MyDictionary<String,Pair<Value,Value>>();
//	MyIList<Value> out5=new MyList<Value>();
//	MyIDictionary<StringValue,BufferedReader> fTbl5=new MyDictionary<StringValue,BufferedReader>();
//	MyIHeap heap5=new MyHeap();
//
//	MyIStack<IStmt> exeStack6=new MyStack<IStmt>();
//	MyIDictionary<Integer,IStmt> exeDictionary6=new MyDictionary<Integer,IStmt>((HashMap<Integer, IStmt>) map6);
//	MyIDictionary<String, Value> symTable6=new MyDictionary<String, Value>();
//	MyIDictionary<String,Pair<Value,Value>> dynaimcSymTable6=new MyDictionary<String,Pair<Value,Value>>();
//	MyIList<Value> out6=new MyList<Value>();
//	MyIDictionary<StringValue,BufferedReader> fTbl6=new MyDictionary<StringValue,BufferedReader>();
//	MyIHeap heap6=new MyHeap();

//	PrgState prg1=new PrgState(exeStack1,exeDictionary1,symTable1,dynaimcSymTable1,out1,fTbl1,heap1,ex1);
//	PrgState prg2=new PrgState(exeStack2,exeDictionary2,symTable2,dynaimcSymTable2,out2,fTbl2,heap2,ex2);
	PrgState prg3=new PrgState(exeStack3,exeDictionary3,symTable3,dynaimcSymTable3,out3,fTbl3,heap3,ex1);
//	PrgState prg4=new PrgState(exeStack4,exeDictionary4,symTable4,dynaimcSymTable4,out4,fTbl4,heap4,ex2);
//	PrgState prg5=new PrgState(exeStack5,exeDictionary5,symTable5,dynaimcSymTable5,out5,fTbl5,heap5,ex2);
//	PrgState prg6=new PrgState(exeStack6,exeDictionary6,symTable6,dynaimcSymTable6,out6,fTbl6,heap6,ex2);

//	ArrayList<PrgState> list1 = new ArrayList<PrgState>();
//	list1.add(prg1);
//	iRepo repo1=new Repo(list1,"log1.txt");
//	iCtrl ctrl1=new Ctrl(repo1);
//
//	ArrayList<PrgState> list2 = new ArrayList<PrgState>();
//	list2.add(prg2);
//	iRepo repo2=new Repo(list2,"log2.txt");
//	iCtrl ctrl2=new Ctrl(repo2);

	ArrayList<PrgState> list3 = new ArrayList<PrgState>();
	list3.add(prg3);
	iRepo repo3=new Repo(list3,"log3.txt");
	iCtrl ctrl3=new Ctrl(repo3);

//	ArrayList<PrgState> list4 = new ArrayList<PrgState>();
//	list4.add(prg4);
//	iRepo repo4=new Repo(list4,"log4.txt");
//	iCtrl ctrl4=new Ctrl(repo4);
//
//	ArrayList<PrgState> list5 = new ArrayList<PrgState>();
//	list5.add(prg5);
//	iRepo repo5=new Repo(list5,"log5.txt");
//	iCtrl ctrl5=new Ctrl(repo5);
//
//	ArrayList<PrgState> list6 = new ArrayList<PrgState>();
//	list6.add(prg6);
//	iRepo repo6=new Repo(list6,"log6.txt");
//	iCtrl ctrl6=new Ctrl(repo6);

			
	TextMenu menu = new TextMenu();
	menu.addCommand(new ExitCommand("0", "exit"));
//	menu.addCommand(new RunExample("1",ex1.toString(),ctrl1));
//	menu.addCommand(new RunExample("2",ex2.toString(),ctrl2));
	menu.addCommand(new RunExample("3",ex1.toString(),ctrl3));
//	menu.addCommand(new RunExample("4",ex3.toString(),ctrl4));
//	menu.addCommand(new RunExample("5",ex3.toString(),ctrl5));
//	menu.addCommand(new RunExample("6",ex3.toString(),ctrl6));
	menu.show();
	
    
    
	}

//	// int x; x=0 ; while(x<6) { x=x+1 } ; Print(x)
//	Map<Integer, IStmt> map6 = Stream.of(new Object[][] {
//			{ 1,new VarDeclStmt("x",new IntType(),1)},
//			{ 2,new AssignStmt("x",new ValueExp(new IntValue(1)),2) },
//			{ 3, new WhileStmt(new RelationalExp("<",new VarExp("x"),new ValueExp(new IntValue(6))),
//					new ArrayList<IStmt>(Arrays.asList(new AssignStmt("x",new ArithExp('+',new VarExp("x"), new
//							ValueExp(new IntValue(1))),4))),3) },
//			{ 4, new AssignStmt("x",new ArithExp('+',new VarExp("x"), new
//					ValueExp(new IntValue(1))),4)},
//
//			{ 5, new NopStmt(),5 },
//			{ 6, new PrintStmt(new
//					VarExp("x"),6) }
//	}).collect(Collectors.toMap(data ->(Integer) data[0], data -> (IStmt) data[1]));
//
//	Map<Integer, IStmt> parseList(List<IStmt> l,Map<Integer, IStmt> m,int count){
//		for(int i=0;i<l.size();i++){
//			count+=1;
//			m.put(count,l.get(i));
//			if(l.get(i) instanceof IfStmt){
//
//
//			}
//			else if (l.get(i) instanceof IfStmt){
//
//			}
//			else{
//
//			}
//		}
//		return m;
//	}
}
