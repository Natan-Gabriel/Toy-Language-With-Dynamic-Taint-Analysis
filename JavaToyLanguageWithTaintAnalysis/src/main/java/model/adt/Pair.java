package model.adt;

public class Pair<T, T1> {
    T elem1;
    T1 elem2;

    T getValue(){return  elem1;}
    void setValue(T e){ elem1=e;}

    T1 getTainted(){return elem2;}
    void setTainted(T1 e){elem2=e;}

}
