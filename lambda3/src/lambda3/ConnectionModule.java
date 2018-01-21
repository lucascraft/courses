package lambda3;

import com.google.inject.AbstractModule;

import lambda3.conn.Hive;
import lambda3.conn.HiveConnection;
import lambda3.conn.IConnectionConector;
import lambda3.conn.Jdbc;
import lambda3.conn.MySQLConection;
import lambda3.conn.SAP;
import lambda3.conn.SAPConnection;

public class ConnectionModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(IConnectionConector.class).annotatedWith(Hive.class).to(HiveConnection.class);
		bind(IConnectionConector.class).annotatedWith(Jdbc.class).to(MySQLConection.class);
		bind(IConnectionConector.class).annotatedWith(SAP.class).to(SAPConnection.class);
	}
}