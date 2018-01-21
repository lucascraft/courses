
package lambda3.cfg;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.json.JSONObject;

import com.google.common.collect.Sets;

import lambda3.vehicles.Vehicle;

public class GarageJsonParser 
{
	@SuppressWarnings("unchecked")
	public Set<Vehicle> parse(String path)
	{
		try {
			String jsonText = new String(Files.readAllBytes(Paths.get(path)));
			JSONObject json = new JSONObject(jsonText);
			Function<Object, Map<String, String>> o2hMap = o2m -> new HashMap<String, String>((Map<String, String>)o2m);
			return json.getJSONArray("vehicles").toList().stream().map(o2hMap).map( o  -> new Vehicle(
					o.get("brand"), 
					o.get("kind"), 
					o.get("mk"), 
					o.get("wheels")
			)).collect(Collectors.toSet());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Sets.newHashSet();
	}
}
