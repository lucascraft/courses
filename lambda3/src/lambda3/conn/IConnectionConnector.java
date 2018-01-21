package lambda3.conn;

public interface IConnectionConnector 
{
	boolean connect(String url);
	
	boolean close();
	
	byte[] read();
	
	void write(byte[] bytes);
	
}
