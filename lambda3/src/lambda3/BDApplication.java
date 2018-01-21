package lambda3;

import com.google.inject.Guice;
import com.google.inject.Injector;

import lambda3.conn.ConnectionPool;
import lambda3.garage.Garage;

public class BDApplication 
{
	public static void run()
	{
		Injector injector = Guice.createInjector(new ConfigurationModule());

		Garage garage = injector.getInstance(Garage.class);
	    garage.init("in/vehicles.json");
	   
	    ConnectionPool pool = injector.getInstance(ConnectionPool.class);
	    pool.init("in/connections.json");

	    pool.getConnectionsMap().values().forEach(c -> {
	    	System.out.println(c.getConnector().getURL());
	    });
	}
}
