package lambda3.cfg;

import java.util.Set;

import lambda3.conn.ConnectionSetting;

public interface IConnectionManager 
{
	void init();
		
	Set<ConnectionSetting> loadCfg(String path);
}
