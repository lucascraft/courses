package lambda3.conn.app;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import lambda3.conn.settings.IConnectionConnector;


public final class HiveConnApp extends AbstractConnApp 
{
	public @Inject @Named("Hive") IConnectionConnector connection;

	@Override
	public IConnectionConnector getConnector() {
		return connection;
	}
}
