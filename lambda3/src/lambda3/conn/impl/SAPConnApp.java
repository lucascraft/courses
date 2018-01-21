package lambda3.conn.impl;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import lambda3.conn.IConnectionConector;


public class SAPConnApp {
	@Inject @Named("SAP") IConnectionConector convection;
	public SAPConnApp() {
		convection.connect();
	}
}
