package lambda3;

import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


import com.google.common.collect.Sets;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class Garage {
	
	public void doIt()
	{
		Injector injector = Guice.createInjector(new BasicModule());
	    ICfgManager comms = injector.getInstance(ICfgManager.class);		
	    
		Set<Vehicle> vehicles = Sets.newHashSet();

		Predicate<Vehicle> twoWheels = v -> v.getNbWheels() == 2;
		Predicate<Vehicle> fourWheels = v -> v.getNbWheels() == 2;
		
		Function<Vehicle, AcountableAsset> v2aFunc = xc -> new AcountableAsset(xc);
		
		Set<Vehicle> twoWheelsVehicles = vehicles.stream().filter(twoWheels).collect(Collectors.toSet());
		Set<Vehicle> twoOrFourWheelsVehicles = vehicles.stream().filter(twoWheels.and(fourWheels)).collect(Collectors.toSet());
		
		Set<AcountableAsset> assets = vehicles.stream().map(v2aFunc).collect(Collectors.toSet());
		
		assets.forEach(AcountableAsset::toString);
		
		Set<Vehicle> allVehicles = comms.loadCfg("in/vehicles.json");
		
		for (Vehicle v : allVehicles)
		{
			System.out.println(v.toString());
		}

	}
}
