package lambda3.garage;

import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import lambda3.vehicles.AcountableAsset;
import lambda3.vehicles.Vehicle;

public class Garage {
	
	public void init(Set<Vehicle> vehicles)
	{
		Predicate<Vehicle> twoWheels = v -> v.getNbWheels() == 2;
		Predicate<Vehicle> fourWheels = v -> v.getNbWheels() == 2;
		
		Function<Vehicle, AcountableAsset> v2aFunc = xc -> new AcountableAsset(xc);
		
		Set<Vehicle> twoWheelsVehicles = vehicles.stream().filter(twoWheels).collect(Collectors.toSet());
		Set<Vehicle> twoOrFourWheelsVehicles = vehicles.stream().filter(twoWheels.and(fourWheels)).collect(Collectors.toSet());
		
		Set<AcountableAsset> assets = vehicles.stream().map(v2aFunc).collect(Collectors.toSet());
		
		assets.forEach(s -> System.out.println(s.toString() ) );
		vehicles.forEach(v -> System.out.println(v.toString() ) );
	}
}
