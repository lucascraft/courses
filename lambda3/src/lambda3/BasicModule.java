package lambda3;

import com.google.inject.AbstractModule;

import lambda3.cfg.CfgManager;
import lambda3.cfg.ICfgManager;

public class BasicModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(ICfgManager.class).to(CfgManager.class);
//		bind(IConectionManager.class).to(HiveConnection.class).in(Hive.class);
//		bind(IConectionManager.class).to(MySQLConection.class).in(Jdbc.class);
	}
}