package lambda3;

import com.google.inject.Guice;
import com.google.inject.Injector;

import lambda3.conn.impl.HiveConnApp;
import lambda3.conn.impl.JdbcConnApp;
import lambda3.conn.impl.SAPConnApp;
import lambda3.garage.Garage;

public class Main 
{
	public static void main(String[] args) 
	{
		Injector injector = Guice.createInjector(new ConfigurationModule());

		Garage garage = injector.getInstance(Garage.class);
	    
	    garage.init("in/vehicles.json");
	    
	    SAPConnApp sap = injector.getInstance(SAPConnApp.class);
	    JdbcConnApp jdbc = injector.getInstance(JdbcConnApp.class);
	    HiveConnApp hive = injector.getInstance(HiveConnApp.class);
	    
	    sap.init();
	    jdbc.init();
	    hive.init();
	}
	
}
