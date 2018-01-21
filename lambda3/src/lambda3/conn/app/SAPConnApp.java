package lambda3.conn.app;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import lambda3.conn.IConnectionConnector;


public final class SAPConnApp extends AbstractConApp {
	public @Inject @Named("SAP") IConnectionConnector connection;

	@Override
	public IConnectionConnector getConnector() {
		return connection;
	}
}
