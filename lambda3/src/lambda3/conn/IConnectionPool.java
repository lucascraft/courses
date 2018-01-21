package lambda3.conn;

import java.util.Map;

import lambda3.conn.app.AbstractConApp;

public interface IConnectionPool {
	Map<ConnectionSetting, AbstractConApp> getConnectionsMap();
	void init(String path);
}
