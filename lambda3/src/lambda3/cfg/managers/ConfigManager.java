package lambda3.cfg.managers;

import java.util.Set;

import javax.inject.Singleton;

import lambda3.cfg.IConfigLoader;
import lambda3.cfg.parsers.GarageJsonParser;
import lambda3.vehicles.Vehicle;

@Singleton
public class ConfigManager implements IConfigLoader<Vehicle> 
{
	@Override
	public Set<Vehicle> loadConfig(String path) {
		return new GarageJsonParser().parse(path);
	}
}
