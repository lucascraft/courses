package lambda3.conn;

/**
 * Defines connection lifecycle
 * 
 * @author LBI
 */
public interface IConnectionConnector 
{
	void setURL(String url);
	
	String getURL();
	
	boolean connect(String url);
	
	boolean close();
	
	byte[] read();
	
	void write(byte[] bytes);
	
}
