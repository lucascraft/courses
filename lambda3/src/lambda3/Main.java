package lambda3;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main 
{
	public static void main(String[] args) 
	{
		Injector injector = Guice.createInjector(new BasicModule());
	    ICfgManager comms = injector.getInstance(ICfgManager.class);
	    comms.loadCfg("in/vehicles.json");
	    
	    new Garage().doIt();
	}
	
}
