package lambda3.conn.app;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import lambda3.conn.IConnectionConnector;


public final class HiveConnApp extends AbstractConApp {
	@Inject @Named("Hive")
	public IConnectionConnector connection;

	@Override
	public IConnectionConnector getConnector() {
		return connection;
	}
}
