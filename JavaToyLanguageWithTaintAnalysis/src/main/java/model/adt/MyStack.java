package model.adt;

import java.util.*;


public class MyStack<T> implements MyIStack<T>{
	 Stack<T> stack;
	 public MyStack(Stack<T> s){stack=s;}
	 public MyStack(){stack=new Stack<T>();}
	 public Stack<T> getStack(){return stack;}
	 public String toString() {return stack.toString();}
	 public T pop() {return stack.pop();}
	 public void push(T v) { if (stack.size()==0 || stack.lastElement()!=v) stack.push(v);}
	 public boolean isEmpty() {return stack.isEmpty();}
	 public int getSize() {return stack.size();}
	 public T get(int i) {return stack.get(i);}
	 public T lastElement(){return stack.lastElement();}
	public T remove(int index){return  stack.remove(index);}
}
