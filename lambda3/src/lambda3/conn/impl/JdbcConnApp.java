package lambda3.conn.impl;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import lambda3.conn.IConnectionConector;


public class JdbcConnApp {
	@Inject @Named("Jdbc")
	IConnectionConector convection;
	public JdbcConnApp() {
		convection.connect();
	}
}
