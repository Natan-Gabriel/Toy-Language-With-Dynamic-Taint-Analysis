package model.values;
import model.types.IntType;
import model.types.RSAKeyPairType;
import model.types.Type;
import model.values.Value;
import static org.apache.commons.codec.binary.Base64.encodeBase64String;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;

public class RSAKeyPairValue implements Value{
    PrivateKey privateKey;
    PublicKey publicKey;
    boolean taint=false;
    boolean secret=false;

    public RSAKeyPairValue(PrivateKey _privateKey,PublicKey _publicKey){privateKey=_privateKey;publicKey=_publicKey;}

    public PrivateKey getPrivateKey()
    {
        return privateKey;
    }

    public PublicKey getPublicKey()
    {
        return publicKey;
    }


    public String getPrivateKeyAsString()
    {
        return encodeBase64String(privateKey.getEncoded());
    }

    public String getPublicKeyAsString()
    {
        return encodeBase64String(publicKey.getEncoded());
    }

    public Type getType() {return new RSAKeyPairType();}
    @Override
    public String toString() {
        return "RSAKeyPair{" +
                "privateKey=" + getPrivateKey() +
                ", publicKey=" + getPublicKey() +
                '}';
    }

    public boolean getTaint() {
        return taint;
    }

    public boolean getSecret() {
        return secret;
    }

    public void setSecret(boolean s) {
        secret=s;
    }
    public void setTaint(boolean s){ taint=s;}
}
