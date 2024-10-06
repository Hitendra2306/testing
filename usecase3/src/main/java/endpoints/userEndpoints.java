package endpoints;
public class userEndpoints {
	public String BASE_URL = "https://petstore.swagger.io/v2";
	public String Create_USER = "/user";
	public String Create_User_withlist = "user/createWithList";
	public String Create_User_witharray = "user/createWithArray";
	public String GET_USER = "/user/{username}";
	public String UPDATE_USER = "/user/{username}";
	public String DELETE_USER = "/user/{username}";
	public String LOGIN_USER = "/user/login";
	public String LOGOUT_USER = "/user/logout";
	public String getUserEndpoint(String username) {
		return GET_USER.replace("{username}", username);
	}
	public String getUpdateUserEndpoint(String username) {
		return UPDATE_USER.replace("{username}", username);
	}
	public String getDeleteUserEndpoint(String username) {
		return DELETE_USER.replace("{username}", username);
	}
}
