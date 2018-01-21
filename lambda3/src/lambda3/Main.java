package lambda3;

import com.google.inject.Guice;
import com.google.inject.Injector;

import lambda3.cfg.ICfgManager;
import lambda3.conn.impl.HiveConnApp;
import lambda3.conn.impl.JdbcConnApp;
import lambda3.conn.impl.SAPConnApp;
import lambda3.garage.Garage;

public class Main 
{
	public static void main(String[] args) 
	{
		Injector injector = Guice.createInjector(new ConfigurationModule());
	    ICfgManager comms = injector.getInstance(ICfgManager.class);
	    
	    new Garage().init(comms.loadCfg("in/vehicles.json"));
	    
	    injector.injectMembers(new SAPConnApp());
	    injector.injectMembers(new JdbcConnApp());
	    injector.injectMembers(new HiveConnApp());
	    
	}
	
}
