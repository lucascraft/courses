package lambda3.conn.app;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import lambda3.conn.IConnectionConnector;


public final class JdbcConnApp extends AbstractConApp {
	@Inject @Named("Jdbc")
	public IConnectionConnector connection;

	@Override
	public IConnectionConnector getConnector() {
		return connection;
	}
}
