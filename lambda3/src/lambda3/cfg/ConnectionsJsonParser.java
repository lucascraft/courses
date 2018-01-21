
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

import lambda3.conn.ConnectionSetting;

public class ConnectionsJsonParser {
	
	@SuppressWarnings("unchecked")
	public Set<ConnectionSetting> parse(String path)
	{
		try {
			String jsonText = new String(Files.readAllBytes(Paths.get(path)));
			JSONObject json = new JSONObject(jsonText);
			Function<Object, Map<String, String>> o2hMap = o2m -> new HashMap<String, String>((Map<String, String>)o2m);
			return json.getJSONArray("connections").toList().stream().map(o2hMap).map( o  -> new ConnectionSetting(
					o.get("type"), 
					o.get("url") 
			)).collect(Collectors.toSet());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Sets.newHashSet();
	}
}
