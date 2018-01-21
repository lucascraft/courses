package lambda3.conn;

import java.util.Map;

import lambda3.conn.app.AbstractConnApp;

/**
 * Connection pool maintains a list of connection accordingly to settings loaded from configuration
 * 
 * @author LBI
 *
 */
public interface IConnectionPool 
{
	/**
	 * Connection map
	 * 
	 * @return setting mapping to to AbstractConnApp instance
	 */
	Map<ConnectionSetting, AbstractConnApp> getConnectionsMap();
	
	/**
	 * Init pool from given setting file
	 * 
	 * @param path config file path
	 */
	void init(String path);
}
