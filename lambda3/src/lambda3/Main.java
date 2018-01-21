package lambda3;

import com.google.inject.Guice;
import com.google.inject.Injector;

import lambda3.cfg.ICfgManager;
import lambda3.garage.Garage;

public class Main 
{
	public static void main(String[] args) 
	{
		Injector injector = Guice.createInjector(new BasicModule());
	    ICfgManager comms = injector.getInstance(ICfgManager.class);
	    
	    new Garage().init(comms.loadCfg("in/vehicles.json"));
	}
	
}
