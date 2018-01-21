package lambda3.cfg;

import java.util.Set;

public interface IConfigLoader<T> 
{
	Set<T> loadConfig(String path);
}
