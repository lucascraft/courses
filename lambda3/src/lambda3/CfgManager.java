package lambda3;

import java.util.Set;

import javax.inject.Singleton;

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
