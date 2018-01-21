package lambda3;

import com.google.inject.AbstractModule;

public class BasicModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(ICfgManager.class).to(CfgManager.class);
	}
}