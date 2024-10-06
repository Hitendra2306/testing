package endpoints;
public class storeEndpoints {
	public String uri = "https://petstore.swagger.io/v2";
	public String GET_INVENTORY = "/store/inventory";
	public String PLACE_ORDER = "/store/order";
	public String GET_ORDER = "/store/order/{orderId}";
	public String DELETE_ORDER = "/store/order/{orderId}";
	public String getOrderEndpoint(String orderId) {
		return GET_ORDER.replace("{orderId}", orderId);
	}
	public String getDeleteOrderEndpoint(String orderId) {
		return DELETE_ORDER.replace("{orderId}", orderId);
	}
}
