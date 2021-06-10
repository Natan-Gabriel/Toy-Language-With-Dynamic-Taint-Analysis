package model.types;

import model.values.IntValue;
import model.values.RSAKeyPairValue;
import model.values.Value;

public class RSAKeyPairType implements Type{
    public RSAKeyPairType() {};
    public Value defaultValue() {return null;}
    public boolean equals(Object another){
        if (another instanceof RSAKeyPairType)
            return true;
        else
            return false;
    }
    public String toString() { return "RSAKeyPair";}
}
