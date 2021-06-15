package model.values;
import model.types.*;

public interface Value {
	public Type getType();
	public String toString();
	public boolean getTaint();
	public boolean getSecret();
	public void setTaint(boolean s);
	public void setSecret(boolean s);
}
