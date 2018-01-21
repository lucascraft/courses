package lambda3.conn.settings;

import lambda3.conn.app.AbstractConnApp;

/**
 * Retrieves connection Class<?> for Guice injection purpose
 * 
 * @author LBI
 *
 */
public interface IConnectionAppMapper 
{
	/**
	 * Get connection {@link Class} from class simple name
	 * 
	 * @param conAppName app name
	 * @return Class for Guice injection purpose (extends {@link AbstractConnApp})
	 */
	Class<?> getConnectionApByName(String conAppName);
}
