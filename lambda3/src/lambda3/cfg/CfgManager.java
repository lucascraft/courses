package lambda3.cfg;

import java.util.Set;

import javax.inject.Singleton;

import lambda3.garage.GarageJsonParser;
import lambda3.vehicles.Vehicle;

@Singleton
public class CfgManager implements ICfgManager{

	@Override
	public void init() {
		
	}

	@Override
	public Set<Vehicle> loadCfg(String path) {
		return new GarageJsonParser().parse(path);
	}
}
