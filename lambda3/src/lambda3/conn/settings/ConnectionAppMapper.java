package lambda3.conn.settings;

import java.util.HashMap;
import java.util.Map;

import lambda3.conn.app.HiveConnApp;
import lambda3.conn.app.JdbcConnApp;
import lambda3.conn.app.SAPConnApp;

/**
 * Connection mapper
 * 
 * @author LBI
 */
public class ConnectionAppMapper implements IConnectionAppMapper 
{
	/** Connection apps map */
	private Map<String, Class<?>> appsMap;
	
	public ConnectionAppMapper() 
	{
		appsMap = new HashMap<String, Class<?>>();
		appsMap.put(SAPConnApp.class.getSimpleName(), SAPConnApp.class);
		appsMap.put(HiveConnApp.class.getSimpleName(), HiveConnApp.class);
		appsMap.put(JdbcConnApp.class.getSimpleName(), JdbcConnApp.class);
	}
	 
	@Override
	public Class<?> getConnectionApByName(String conAppName) 
	{
		return appsMap.get(conAppName);
	}
}
