package lambda3.cfg;

import java.util.Set;

import javax.inject.Singleton;

import lambda3.conn.ConnectionSetting;

@Singleton
public class ConnectionManager implements IConfigLoader<ConnectionSetting>
{
	@Override
	public Set<ConnectionSetting> loadConfig(String path) {
		return new ConnectionsJsonParser().parse(path);
	}
}
