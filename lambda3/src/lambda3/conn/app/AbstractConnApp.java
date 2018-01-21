package lambda3.conn.app;

import lambda3.conn.IConnectionConnector;

/**
 * Basic infrastructure for connected applications
 * 
 * @author LBI
 *
 */
public abstract class AbstractConnApp 
{
	/**
	 * Get connector
	 * @return connector
	 */
	abstract public IConnectionConnector getConnector();
	
	/**
	 * Initialize connector from current URL
	 */
	public void init() 
	{
		IConnectionConnector connector = getConnector();
		connector.connect(connector.getURL());
	}
}
