package MyException;

public class TaintedAddress extends Exception{

    public TaintedAddress(String s) {
        super(s);
    }

}
