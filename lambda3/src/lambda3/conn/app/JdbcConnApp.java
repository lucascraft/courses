package lambda3.conn.app;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import lambda3.conn.IConnectionConnector;


public final class JdbcConnApp extends AbstractConnApp 
{
	public @Inject @Named("Jdbc") IConnectionConnector connection;

	@Override
	public IConnectionConnector getConnector() {
		return connection;
	}
}
