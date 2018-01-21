package lambda3.cfg;

import java.util.Set;

import lambda3.vehicles.Vehicle;

public interface ICfgManager {
		void init();
		Set<Vehicle> loadCfg(String path);
}
