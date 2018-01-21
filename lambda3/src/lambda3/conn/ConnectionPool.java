package lambda3.conn;

import java.util.Map;
import java.util.TreeMap;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import lambda3.ConfigurationModule;
import lambda3.cfg.IConnectionManager;
import lambda3.conn.app.AbstractConApp;

public class ConnectionPool implements IConnectionPool 
{

	@Inject
	IConnectionManager config;
	
	@Inject
	IConnectionAppMapper appMapper;
	
	Map<ConnectionSetting, AbstractConApp> connectionsMap;
	
	public ConnectionPool() {
		connectionsMap = new TreeMap<ConnectionSetting, AbstractConApp>();
	}
	
	public void init (String path)
	{
		Injector injector = Guice.createInjector(new ConfigurationModule());
	    config.loadCfg(path).forEach(c -> {
	    	Class<?> connectionApp = appMapper.getConnectionApByName(c.getType());
			connectionsMap.put(c, (AbstractConApp) injector.getInstance(connectionApp));
			AbstractConApp conn = connectionsMap.get(c);
			if (conn instanceof AbstractConApp)
			{
				((AbstractConApp)conn).init();
				((AbstractConApp)conn).getConnector().setURL(c.getUrl());
			}
		});
	}

	@Override
	public Map<ConnectionSetting, AbstractConApp> getConnectionsMap() {
		return connectionsMap;
	}
}
