package lambda3.conn.app;

import lambda3.conn.IConnectionConnector;

public abstract class AbstractConApp 
{
	abstract public IConnectionConnector getConnector();
	
	public void init() 
	{
		IConnectionConnector connector = getConnector();
		connector.connect(connector.getURL());
	}
}
