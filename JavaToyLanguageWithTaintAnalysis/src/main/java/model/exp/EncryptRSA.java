package model.exp;

import MyException.CustomException;
import MyException.DivByZero;
import MyException.VarNotDefined;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import model.adt.MyIDictionary;
import model.adt.MyIHeap;
import model.types.StringType;
import model.values.StringValue;
import model.values.Value;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;

import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64String;

public class EncryptRSA implements Exp {
    Exp exp;
    Exp public_key;
    int lineNumber;

    public EncryptRSA(Exp e,Exp _public_key,int _lineNumber) {exp=e;public_key=_public_key;lineNumber=_lineNumber;}
    public String toString() { return "EncryptRSA("+exp.toString()+")";}
    public Value eval(MyIDictionary<String,Value> tbl,MyIHeap hp) throws VarNotDefined, DivByZero, CustomException {
        Value val = exp.eval(tbl,hp);
        if( !(val.getType()).equals(new StringType()) )
            throw new VarNotDefined("The message to be encrypted must be a string");
        String message_as_string = ((StringValue)val).getVal();


        Value public_key_value = public_key.eval(tbl,hp);
        if( !(public_key_value.getType()).equals(new StringType()) )
            throw new VarNotDefined("The public key must be a string");

        String publicKey_as_string = ((StringValue)public_key_value).getVal();
        PublicKey key;
        try {
            byte[] keyBytes = decodeBase64(publicKey_as_string);
            X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            key = keyFactory.generatePublic(spec);
        }
        catch(Exception e){
            throw new CustomException(e.toString());
        }



        Cipher encryptCipher = null;
        String encrypted_message="";
        System.out.println("message_as_string:"+message_as_string);
        try {
            encryptCipher = Cipher.getInstance("RSA");
            encryptCipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] secretMessageBytes = message_as_string.getBytes(StandardCharsets.UTF_8);
            byte[] encryptedMessageBytes = encryptCipher.doFinal(secretMessageBytes);
            encrypted_message = encodeBase64String(encryptedMessageBytes);

        } catch (Exception e) {
            throw new CustomException(e.toString());
        }


        return new StringValue(encrypted_message,false,false);
    }
    //public int getStatementNumber(){return instructionNumber;}
    public int getLineNumber() {return lineNumber;}
    public int getEndingLine() {return lineNumber;}
}