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
	
    @POST("user/login")
    Call<StdResponse> login(@Body LoginRequest body);
    
    @POST("user/signup")
    Call<StdResponse> signUp(@Body User body);
    
    /*
     * READ
     */
    
    @GET("user/{username}")
    Call<User> findUserByUsername(@Path("username") String username);
    
    @GET("find/ad/{username}")
    Call<List<Ad>> findAdByUsername(@Path("username") String username);
    
    /*
     * UPDATE
     */
    
    @PATCH("user/update/{username}")
    Call<StdResponse> updateUserInfo(@Path("username") String username, @Body User body);
    
    @PATCH("user/update/password/{username}")
    Call<StdResponse> updatePassword(@Path("username") String username, @QueryMap Map<String, String> password);
    
    @GET("user/update/request/changepassword/{username}")
    Call<StdResponse> requestUpdatePassword(@Path("username") String username);
    
}