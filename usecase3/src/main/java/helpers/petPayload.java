package helpers;
import java.util.HashMap;
import java.util.Map;
public class petPayload {
	public Map<String, Object> createPetPayload(String name, String status) {
		Map<String, Object> payload = new HashMap<>();
		payload.put("id", 20);
		//		HashMap<String, Object> cat = new HashMap<String, Object>();
		//		cat.put("id", 15);
		//		payload.put("category", cat);
		payload.put("name", name);
		//		List<String> tag = Arrays.asList("String");
		//		payload.put("photoUrls", tag);
		//		HashMap<String, Object> cat1 = new HashMap<String, Object>();
		//		cat1.put("id", 0);
		//		cat1.put("name", "String");
		//		payload.put("tags", cat1);
		payload.put("status", status);
		return payload;
	}
	public Map<String, Object> updatePetPayload(String name, String status) {
		Map<String, Object> payload = new HashMap<>();
		payload.put("name", name);
		payload.put("status", status);
		return payload;
	}
}
