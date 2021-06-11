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
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64String;

public class DecryptRSA implements Exp {
    Exp exp;
    Exp private_key;
    int lineNumber;

    public DecryptRSA(Exp e,Exp _private_key,int _lineNumber) {exp=e;private_key=_private_key;lineNumber=_lineNumber;}
    public String toString() { return "DecryptRSA("+exp.toString()+")";}
    public Value eval(MyIDictionary<String,Value> tbl, MyIHeap hp) throws VarNotDefined, DivByZero, CustomException {
        Value val = exp.eval(tbl,hp);
        if( !(val.getType()).equals(new StringType()) )
            throw new VarNotDefined("The message to be decrypted must be a string");
        String message_as_string = ((StringValue)val).getVal();


        Value private_key_value = private_key.eval(tbl,hp);
        if( !(private_key_value.getType()).equals(new StringType()) )
            throw new VarNotDefined("The private key must be a string");

        String private_key_as_string = ((StringValue)private_key_value).getVal();

        // I used https://stackoverflow.com/questions/22900570/key-from-string-in-java-rsa
        PrivateKey key;
        try {
            byte[] keyBytes = decodeBase64(private_key_as_string);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory fact = KeyFactory.getInstance("RSA");
            key = fact.generatePrivate(keySpec);
        }
        catch(Exception e){
            System.out.println("aici1");
            throw new CustomException(e.toString());
        }



        //I used https://www.baeldung.com/java-rsa
        Cipher decryptCipher = null;
        String decrypted_message="";
        try {
            decryptCipher = Cipher.getInstance("RSA");
            decryptCipher.init(Cipher.DECRYPT_MODE, key);
            byte[] encryptedMessageBytes = decodeBase64(message_as_string);
            byte[] decryptedMessageBytes = decryptCipher.doFinal(encryptedMessageBytes);
            decrypted_message = new String(decryptedMessageBytes, StandardCharsets.UTF_8);
            System.out.println("decrypted_message: "+decrypted_message);

        } catch (Exception e) {
            System.out.println("aici2");
            e.printStackTrace();
            throw new CustomException(e.toString());
        }


        System.out.println("aici:"+decrypted_message+decrypted_message.length());
        return new StringValue(decrypted_message,false,true);
    }
    //public int getStatementNumber(){return instructionNumber;}
    public int getLineNumber() {return lineNumber;}
    public int getEndingLine() {return lineNumber;}
}