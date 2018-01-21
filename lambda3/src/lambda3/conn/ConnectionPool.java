package lambda3.conn;

import java.util.Map;
import java.util.TreeMap;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

import lambda3.ConfigurationModule;
import lambda3.cfg.IConfigLoader;
import lambda3.conn.app.AbstractConnApp;

/**
 * Connection impl
 * 
 * @author LBI
 *
 */
public class ConnectionPool implements IConnectionPool 
{

	@SuppressWarnings("rawtypes")
	public @Inject @Named("Connection") IConfigLoader config;
	
	@Inject
	IConnectionAppMapper appMapper;
	
	Map<ConnectionSetting, AbstractConnApp> connectionsMap;
	
	ConnectionPool() {
		connectionsMap = new TreeMap<ConnectionSetting, AbstractConnApp>();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void init (String path)
	{
		Injector injector = Guice.createInjector(new ConfigurationModule());
	    ((IConfigLoader<ConnectionSetting>)config).loadConfig(path).forEach(c -> {
	    	Class<?> connectionApp = appMapper.getConnectionApByName(c.getType());
			connectionsMap.put(c, (AbstractConnApp) injector.getInstance(connectionApp));
			AbstractConnApp conn = connectionsMap.get(c);
			conn.init();
			conn.getConnector().setURL(c.getUrl());
		});
	}

	@Override
	public Map<ConnectionSetting, AbstractConnApp> getConnectionsMap() {
		return connectionsMap;
	}
}
