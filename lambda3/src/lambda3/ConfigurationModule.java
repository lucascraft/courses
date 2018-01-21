package lambda3;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import lambda3.cfg.CfgManager;
import lambda3.cfg.ICfgManager;
import lambda3.conn.IConnectionConnector;
import lambda3.conn.impl.HiveConnectionImpl;
import lambda3.conn.impl.MySQLConectionImpl;
import lambda3.conn.impl.SAPConnectionImpl;

public class ConfigurationModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(ICfgManager.class).to(CfgManager.class);

		bind(IConnectionConnector.class).annotatedWith(Names.named("Hive")).to(HiveConnectionImpl.class);
		bind(IConnectionConnector.class).annotatedWith(Names.named("Jdbc")).to(MySQLConectionImpl.class);
		bind(IConnectionConnector.class).annotatedWith(Names.named("SAP")).to(SAPConnectionImpl.class);
	}
}