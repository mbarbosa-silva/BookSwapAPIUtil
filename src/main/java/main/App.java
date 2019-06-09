package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import config.RetrofitConfig;
import model.Address;
import model.Campus;
import model.Role;
import model.StdResponse;
import model.user.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {	
    	
//    	Campus campus = new Campus();
//    	campus.setName("seneca@york");
//    	List<Role> roles = new ArrayList<>();
//    	roles.add(new Role("ADMIN"));
//    	roles.add(new Role("USER"));
//    	
//    	List<Address> address = new ArrayList<>();
//    	address.add(new Address("AAAAA", "AAAAA", "AAAAA", "AAAAA", "AAAAA",
//    					"AAAAA","AAAAA"));
//    	
//    	User user = new User("matheus", "silva", "matheus.alexandre3002@gmail.com", "matheus23", "leon23",
//    			roles,campus,address);
//    	
//		Call<StdResponse> call = new RetrofitConfig()
//    			.getUserService().signUp(user);
//		
//		call.enqueue(new Callback<StdResponse>() {
//
//			@Override
//			public void onResponse(Call<StdResponse> call, Response<StdResponse> response) {
//				// TODO Auto-generated method stub
//				System.out.println(response.code());
//				
//			}
//
//			@Override
//			public void onFailure(Call<StdResponse> call, Throwable t) {
//				// TODO Auto-generated method stub
//				
//			}
//						
//    	});
    	
    	
    	Call<User> call = new RetrofitConfig().getUserService().findUserByUsername("matheus");
    	call.enqueue(new Callback<User>() {

			public void onResponse(Call<User> call, Response<User> response) {
				// TODO Auto-generated method stub
				System.out.println(response.body().getEmail());

			}
		
			public void onFailure(Call<User> call, Throwable t) {
				// TODO Auto-generated method stub
				System.out.println(t.toString());
			}
    		
    	});
    	
    }

}
