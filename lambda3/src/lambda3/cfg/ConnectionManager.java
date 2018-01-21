package lambda3.cfg;

import java.util.Set;

import javax.inject.Singleton;

import lambda3.conn.ConnectionSetting;

@Singleton
public class ConnectionManager implements IConnectionManager{

	@Override
	public void init() {
		
	}
	@Override
	public Set<ConnectionSetting> loadCfg(String path) {
		return new ConnectionsJsonParser().parse(path);
	}
}
