package com.mobsoft.matchapp.network.api;

import com.mobsoft.matchapp.network.model.Team;

import java.math.BigDecimal;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UsersApi {
  
  /**
   * 
   * Tries to log in the user
   * @param team The team info as JSON.
   * @return Call<BigDecimal>
   */
  
  @POST("login")
  Call<BigDecimal> loginPost(
          @Body Team team
  );

  
  /**
   * 
   * Tries to sign up a user.
   * @param team The team info as JSON.
   * @return Call<Void>
   */
  
  @POST("signup")
  Call<Void> signupPost(
          @Body Team team
  );

  
}
