package model.stmt;

import MyException.CustomException;
import MyException.DivByZero;
import MyException.VarNotDefined;
import model.PrgState;
import model.adt.*;
import model.exp.Exp;
import model.types.IntType;
import model.types.StringType;
import model.types.Type;
import model.values.IntValue;
import model.values.RSAKeyPairValue;
import model.values.StringValue;
import model.values.Value;

import java.security.*;

import static org.apache.commons.codec.binary.Base64.encodeBase64String;

public class GenerateRSAKey implements IStmt {
    Exp exp;
    String private_key, public_key;
    int lineNumber;

    public GenerateRSAKey(Exp e,String _private_key,String _public_key, int _lineNumber) {exp=e;private_key=_private_key;public_key=_public_key;lineNumber=_lineNumber;}
    public String toString() { return "GenerateRSAKey("+exp.toString()+")";}
    public PrgState execute(PrgState state) throws VarNotDefined, DivByZero, CustomException {

        MyIStack<IStmt> stk=state.getStk();
        MyIDictionary<String,Value> symTbl= state.getSymTable();
        MyIHeap hp= state.getHeap();

        Value val = exp.eval(symTbl,hp);
        if( !(val.getType()).equals(new IntType()) )
            throw new VarNotDefined("The key size must be an integer");

        //I used https://www.baeldung.com/java-rsa
        KeyPairGenerator generator = null;
        try {
            generator = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            throw new CustomException(e.toString());
        }
        generator.initialize(((IntValue)val).getVal());
        KeyPair pair = generator.generateKeyPair();

        if(symTbl.isDefined(private_key) && symTbl.isDefined(public_key)){
            Type typ_private_key= (symTbl.lookup(private_key)).getType();
            Type typ_public_key= (symTbl.lookup(public_key)).getType();

            if( (new StringType()).equals(typ_private_key) && (new StringType()).equals(typ_public_key) ) {
                symTbl.update(private_key, new StringValue(encodeBase64String(pair.getPrivate().getEncoded()),false,true));
                System.out.println("private_key1:"+new StringValue(encodeBase64String(pair.getPrivate().getEncoded())));
                symTbl.update(public_key, new StringValue(encodeBase64String(pair.getPublic().getEncoded())));
                System.out.println("public_key1:"+new StringValue(encodeBase64String(pair.getPublic().getEncoded()),false,false));
                Key kk = pair.getPublic();
                System.out.println("public_key2:"+kk);

            }
            else throw new VarNotDefined("declared type of at least a variable is not string");
        }
        else throw new VarNotDefined("at least one used variable was not declared");

        return state;
    }
    //public int getStatementNumber(){return instructionNumber;}
    public int getLineNumber() {return lineNumber;}
    public int getEndingLine() {return lineNumber;}
}
