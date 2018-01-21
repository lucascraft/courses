package lambda3;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import lambda3.cfg.IConfigLoader;
import lambda3.cfg.managers.ConfigManager;
import lambda3.cfg.managers.ConnectionManager;
import lambda3.conn.impl.HiveConnectionImpl;
import lambda3.conn.impl.MySQLConectionImpl;
import lambda3.conn.impl.SAPConnectionImpl;
import lambda3.conn.settings.ConnectionAppMapper;
import lambda3.conn.settings.ConnectionPool;
import lambda3.conn.settings.IConnectionAppMapper;
import lambda3.conn.settings.IConnectionConnector;
import lambda3.conn.settings.IConnectionPool;

public class ConfigurationModule extends AbstractModule 
{
	@Override
	protected void configure() 
	{
		bind(IConnectionPool.class).to(ConnectionPool.class);
		bind(IConnectionAppMapper.class).to(ConnectionAppMapper.class);
		bind(IConfigLoader.class).annotatedWith(Names.named("Config")).to(ConfigManager.class);
		bind(IConfigLoader.class).annotatedWith(Names.named("Connection")).to(ConnectionManager.class);
		bind(IConnectionConnector.class).annotatedWith(Names.named("Hive")).to(HiveConnectionImpl.class);
		bind(IConnectionConnector.class).annotatedWith(Names.named("Jdbc")).to(MySQLConectionImpl.class);
		bind(IConnectionConnector.class).annotatedWith(Names.named("SAP")).to(SAPConnectionImpl.class);
	}
}