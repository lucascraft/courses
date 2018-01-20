package lambda3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.json.JSONObject;

import com.google.common.collect.Sets;

public class GarageJsonParser {
	
	public Set<Vehicle> parse(String path)
	{
		Function<Object, Vehicle> o2v = o -> new Vehicle(((HashMap<String, String>)o).get("brand"), ((HashMap<String, String>)o).get("kind"), ((HashMap<String, String>)o).get("mk"));
		try {
			String jsonText = new String(Files.readAllBytes(Paths.get(path)));
			JSONObject json = new JSONObject(jsonText);
			return json.getJSONArray("vehicles").toList().stream().map(o2v).collect(Collectors.toSet());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Sets.newHashSet();
	}
}
