package lambda3;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import lambda3.cfg.CfgManager;
import lambda3.cfg.ConnectionManager;
import lambda3.cfg.ICfgManager;
import lambda3.cfg.IConnectionManager;
import lambda3.conn.ConnectionAppMapper;
import lambda3.conn.ConnectionPool;
import lambda3.conn.IConnectionAppMapper;
import lambda3.conn.IConnectionConnector;
import lambda3.conn.IConnectionPool;
import lambda3.conn.impl.HiveConnectionImpl;
import lambda3.conn.impl.MySQLConectionImpl;
import lambda3.conn.impl.SAPConnectionImpl;

public class ConfigurationModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(ICfgManager.class).to(CfgManager.class);
		bind(IConnectionManager.class).to(ConnectionManager.class);
		bind(IConnectionPool.class).to(ConnectionPool.class);
		bind(IConnectionAppMapper.class).to(ConnectionAppMapper.class);
		bind(IConnectionConnector.class).annotatedWith(Names.named("Hive")).to(HiveConnectionImpl.class);
		bind(IConnectionConnector.class).annotatedWith(Names.named("Jdbc")).to(MySQLConectionImpl.class);
		bind(IConnectionConnector.class).annotatedWith(Names.named("SAP")).to(SAPConnectionImpl.class);
	}
}