package service;

import java.util.List;
import java.util.Map;

import model.Ad;
import model.StdResponse;
import model.user.LoginRequest;
import model.user.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface UserService {

	/*
	 * CREATE
	 */
	
	/**
	 * 
	 * method for login. On successful login, the server response will contain an authentication token in
	 * its header. this token must be include on future 
	 * 
	 * @param body object that contains user's password and user's login
	 * @return standard json message with information about the request(status code, error message, etc)
  	 * that will be serialize to a object of type StdResponse. 
	 */
	
    @POST("user/login")
    Call<StdResponse> login(@Body LoginRequest body);
    
    /**
     * 
     * this methods send a new user to be register
     * 
     * @param body new user object to be persisted
     * @return standard json message with information about the request(status code, error message, etc)
  	 * that will be serialize to a object of type StdResponse.
     */
    
    @POST("user/signup")
    Call<StdResponse> signUp(@Body User body);
    
    /*
     * READ
     */
    
    /**
     * 
     * returns all user information
     * 
     * @param username user's username
     * @return User object
     */
    
    @GET("user/{username}")
    Call<User> findUserByUsername(@Path("username") String username);
    
    /**
     * 
     * find all ads that belongs to a specific user
     * 
     * @param username user's username
     * @return ArrayList of ad
     */
    
    @GET("find/ad/{username}")
    Call<List<Ad>> findAdByUsername(@Path("username") String username);
    
    /*
     * UPDATE
     */
    
    /**
     * 
     * method with the purpose of update user information, a user object must be passed as 
     * a parameters. the user properties with null values will be ignored by the server and thus
     * the user original properties value will be remain unaltered
     * 
     * @param username user's username.
     * @param body object of type User, it contains the user's properties that will be changed.
     * @return standard json message with information about the request(status code, error message, etc)
  	 * that will be serialize to a object of type StdResponse
     */
    
    @PATCH("user/update/{username}")
    Call<StdResponse> updateUserInfo(@Path("username") String username, @Body User body);
    
    /**
 	* 
 	* this method purpose is to update the user password, it will check if the new password
 	* matchs with the old password, if it does, the method returns a error message.
 	* 
 	* @param username user's username
 	* @param password hashmap object that must contain 
 	* two elements: ("dldPassword",<old user's password>),("newPassword",<new user's password>)
  	* @return standard json message with information about the request(status code, error message, etc)
  	* that will be serialize to a object of type StdResponse
 	*/
    
    @PATCH("user/update/password/{username}")
    Call<StdResponse> updatePassword(@Path("username") String username, @QueryMap Map<String, String> password);
    
    /**
     * 
     * will send a mail to the user with the purpose to reset his or her
     * password.
     * 
     * @param username User's username
     * @return standard json message with information about the request(status code, error message, etc)
     * that will be serialize to a object of type StdResponse
     */
    
    @GET("user/update/request/changepassword/{username}")
    Call<StdResponse> requestUpdatePassword(@Path("username") String username);
    
}