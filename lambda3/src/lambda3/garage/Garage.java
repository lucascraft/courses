
package lambda3.garage;

import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.google.inject.Inject;

import lambda3.cfg.ICfgManager;
import lambda3.vehicles.Asset;
import lambda3.vehicles.Vehicle;

public class Garage 
{
	
	@Inject
	ICfgManager config;
	
	public void init(String path)
	{
	    Set<Vehicle> vehicles = config.loadCfg(path);
	    
	    Predicate<Vehicle> twoWheels = v -> v.getNbWheels() == 2;
		Predicate<Vehicle> threeWheels = v -> v.getNbWheels() == 3;
		Predicate<Vehicle> fourWheels = v -> v.getNbWheels() == 4;
		
		Function<Vehicle, Asset> v2aFunc = xc -> new Asset(xc);
		
		Set<Asset> assets = vehicles.stream().map(v2aFunc).collect(Collectors.toSet());
		
		assets.forEach(s -> System.out.println(s.toString() ) );
		
		Set<Vehicle> twoWheelsVehicles = vehicles.stream().filter(twoWheels).collect(Collectors.toSet());
		Set<Vehicle> threeWheelsVehicles = vehicles.stream().filter(threeWheels).collect(Collectors.toSet());
		Set<Vehicle> twoOrFourWheelsVehicles = vehicles.stream().filter(twoWheels.or(fourWheels)).collect(Collectors.toSet());
		Set<Vehicle> fourWheelsVehicles = vehicles.stream().filter(fourWheels).collect(Collectors.toSet());
		Set<Vehicle> otherThanThreeWheelsVehicles = vehicles.stream().filter(threeWheels.negate()).collect(Collectors.toSet());

		
		System.out.println("2 Wheels vehicles");
		twoWheelsVehicles.forEach(v -> System.out.println(v.toString() ) );
		System.out.println("\n\n");
		
		
		System.out.println("3 Wheels vehicles");
		threeWheelsVehicles.forEach(v -> System.out.println(v.toString() ) );
		System.out.println("\n\n");
		
		
		System.out.println("4 Wheels vehicles");
		fourWheelsVehicles.forEach(v -> System.out.println(v.toString() ) );
		System.out.println("\n\n");
		
		
		System.out.println("other than 3 Wheels vehicles");
		otherThanThreeWheelsVehicles.forEach(v -> System.out.println(v.toString() ) );
		System.out.println("\n\n");
		

		System.out.println("2 or 4 Wheels vehicles");
		twoOrFourWheelsVehicles.forEach(v -> System.out.println(v.toString() ) );
		System.out.println("\n\n");
		

		System.out.println("All vehicles");
		vehicles.forEach(v -> System.out.println(v.toString() ) );
		System.out.println("\n\n");
		
	}
}
