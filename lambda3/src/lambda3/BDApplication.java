package lambda3;

import com.google.inject.Guice;
import com.google.inject.Injector;

import lambda3.conn.ConnectionPool;
import lambda3.garage.Garage;

public class BDApplication 
{
	public static void run(String vehiclesCfg, String connCfg)
	{
		Injector injector = Guice.createInjector(new ConfigurationModule());

		Garage garage = injector.getInstance(Garage.class);
	    garage.init(vehiclesCfg);
	   
	    ConnectionPool pool = injector.getInstance(ConnectionPool.class);
	    pool.init(connCfg);

	    pool.getConnectionsMap().values().forEach(c -> {
	    	System.out.println(c.getConnector().getURL());
	    });
	}
}
