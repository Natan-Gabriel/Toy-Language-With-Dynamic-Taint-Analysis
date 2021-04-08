package model.adt;
import java.util.*;

public class MyDictionary<K,V> implements MyIDictionary<K,V>{
	HashMap<K,V> dict;
	public boolean equals(HashMap<K,V> a,HashMap<K,V> b) {return a.equals(b);}
	public MyDictionary(HashMap<K,V> d){dict=d;}
	public MyDictionary(){dict=new HashMap<K,V>();}
	public String toString() {return dict.toString();}
	public void add(K x,V y) {dict.put(x,y);}
	public V lookup(K x) {return dict.get(x);}
	public V getValue(K x){return dict.get(x);}
	public boolean isDefined(K x) {return dict.containsKey(x);}
	public void update(K x,V y) {dict.put(x,y);}
	public void remove(K x) {dict.remove(x);}
	public HashMap<K,V> getD(){return dict;}
	public Set<K>  keySet() {return dict.keySet();}
	public int  getSize() {return dict.size();}
	public HashMap<K,V> getContent(){return dict;}
}
