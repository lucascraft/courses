package lambda3;

import java.util.Set;

public interface ICfgManager {

		void init();
		Set<Vehicle> loadCfg(String path);
}
