package api.endpoints;



// this class for just maintaining the url or routes

/*
 Sawgger URI---> https://petstore.swagger.io
 
 CreateUser(POST) : https://petstore.swagger.io/v2/user
 GetUser(GET) : https://petstore.swagger.io/v2/user/{username}
 UpdateUser(UPDATE) : https://petstore.swagger.io/v2/user/{username}
 DeleteUser(DELETE) : https://petstore.swagger.io/v2/user/{username}
 */

public class Routes {
	
	public static String base_Url="https://petstore.swagger.io/v2";
	
	public static String post_Url=base_Url+"/user";
	public static String get_Url=base_Url+"/user/{username}";
	public static String update_Url=base_Url+"/user/{username}";
	public static String delete_Url=base_Url+"/user/{username}";

}
