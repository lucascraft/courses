package lambda3;

import com.google.inject.Guice;
import com.google.inject.Injector;

import lambda3.conn.ConnectionPool;
import lambda3.conn.IConnectionPool;
import lambda3.garage.Garage;

public class Main 
{
	public static void main(String[] args) 
	{
		Injector injector = Guice.createInjector(new ConfigurationModule());

		Garage garage = injector.getInstance(Garage.class);
	    garage.init("in/vehicles.json");
	   
	    IConnectionPool pool = injector.getInstance(IConnectionPool.class);
	    pool.init("in/connections.json");

	    ((ConnectionPool)pool).getConnectionsMap().values().forEach(c -> {
	    	System.out.println(c.getConnector().getURL());
	    });
	}
}
