package api.endpoints;

public class Routes {

	public static String base_url="https://petstore.swagger.io/v2";
	
	
	//UsersEndPoints
	
	public static String create_user = base_url+"/user";
	public static String get_user = base_url+"/user/{username}";
	public static String update_user = base_url+"/user/{username}";
	public static String delete_user = base_url+"/user/{username}";
	
	
	//PetEndPoints
}
