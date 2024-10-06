package helpers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class usepayload {
	String uname = "";
	String pwd = "";
	public Map<String, Object> createUserPayload(String username, String password) {
		uname = username;
		;
		pwd = password;
		List<Map<String, Object>> li = new ArrayList<Map<String, Object>>();
		Map<String, Object> payload = new HashMap<>();
		payload.put("id", 0);
		payload.put("username", username);
		payload.put("firstName", "John");
		payload.put("lastName", "Doe");
		payload.put("email", "john.doe@example.com");
		payload.put("password", password);
		payload.put("phone", "1234567890");
		payload.put("userStatus", 1);
		li.add(payload);
		return payload;
	}
	public Map<String, Object> updateUserPayload(String username) {
		List<Map<String, Object>> li = new ArrayList<Map<String, Object>>();
		Map<String, Object> payload = new HashMap<>();
		payload.put("id", 0);
		payload.put("username", username);
		payload.put("firstName", "John");
		payload.put("lastName", "Doe");
		payload.put("email", "john.doe@example.com");
		payload.put("password", pwd);
		payload.put("phone", "1234567898");
		payload.put("userStatus", 1);
		li.add(payload);
		return payload;
	}
}
