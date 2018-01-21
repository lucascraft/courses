package lambda3.garage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

import org.json.JSONObject;

import com.google.common.collect.Sets;

import lambda3.vehicles.Vehicle;

public class GarageJsonParser {
	
	public Set<Vehicle> parse(String path)
	{
		try {
			String jsonText = new String(Files.readAllBytes(Paths.get(path)));
			JSONObject json = new JSONObject(jsonText);
			return json.getJSONArray("vehicles").toList().stream().map(o -> new Vehicle(((HashMap<String, String>)o).get("brand"), ((HashMap<String, String>)o).get("kind"), ((HashMap<String, String>)o).get("mk"))).collect(Collectors.toSet());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Sets.newHashSet();
	}
}
