package lambda3.cfg.managers;

import java.util.Set;

import javax.inject.Singleton;

import lambda3.cfg.IConfigLoader;
import lambda3.cfg.parsers.ConnectionsJsonParser;
import lambda3.conn.settings.ConnectionSetting;

@Singleton
public class ConnectionManager implements IConfigLoader<ConnectionSetting>
{
	@Override
	public Set<ConnectionSetting> loadConfig(String path) {
		return new ConnectionsJsonParser().parse(path);
	}
}
