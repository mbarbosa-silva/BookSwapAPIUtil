package config;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import service.UserService;

public class RetrofitConfig {
	
	private final Retrofit retrofit;
	
	public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://myvmlab.senecacollege.ca:6510/bookswap-0.0.1/")
        		//.baseUrl("http://localhost:8080/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
	}
	
    public UserService getUserService() {
        return this.retrofit.create(UserService.class);
    }
	
}
