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
	    ICfgManager config = injector.getInstance(ICfgManager.class);

	    new Garage().init(config.loadCfg("in/vehicles.json"));
	    
	    SAPConnApp sap = new SAPConnApp();
	    JdbcConnApp jdbc = new JdbcConnApp();
	    HiveConnApp hive = new HiveConnApp();
	    
	    injector.injectMembers(sap);
	    injector.injectMembers(jdbc);
	    injector.injectMembers(hive);
	    
	    sap.init();
	    jdbc.init();
	    hive.init();
	}
	
}
