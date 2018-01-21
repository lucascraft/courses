package lambda3;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import lambda3.cfg.CfgManager;
import lambda3.cfg.ICfgManager;
import lambda3.conn.HiveConnection;
import lambda3.conn.IConnectionConector;
import lambda3.conn.MySQLConection;
import lambda3.conn.SAPConnection;

public class ConfigurationModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(ICfgManager.class).to(CfgManager.class);

		bind(IConnectionConector.class).annotatedWith(Names.named("Hive")).to(HiveConnection.class);
		bind(IConnectionConector.class).annotatedWith(Names.named("Jdbc")).to(MySQLConection.class);
		bind(IConnectionConector.class).annotatedWith(Names.named("SAP")).to(SAPConnection.class);
}
}