package lambda3.conn.app;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import lambda3.conn.IConnectionConnector;


public class SAPConnApp {
	public @Inject @Named("SAP") IConnectionConnector connection;
	
	public void init() {
		connection.connect("");

		System.out.println(connection.getClass().getName());
	}
}
