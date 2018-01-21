package lambda3.conn.impl;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import lambda3.conn.IConnectionConnector;


public class HiveConnApp {
	@Inject @Named("Hive")
	public IConnectionConnector connection;

	
	public void init() {
		connection.connect("");
		
		System.out.println(connection.getClass().getName());
	}
}
