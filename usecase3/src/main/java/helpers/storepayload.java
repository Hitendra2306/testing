package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class storepayload {
	public Map<String, Object> createOrderPayload(int id, int petId, int quantity) {
		String time = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
		Map<String, Object> payload = new HashMap<>();
		payload.put("id", id);
		payload.put("petId", petId);
		payload.put("quantity", quantity);
		payload.put("shipDate", "2024-07-19T16:26:27.0222");
		payload.put("status ", "placed");
		payload.put("complete", true);
		return payload;
	}
}
