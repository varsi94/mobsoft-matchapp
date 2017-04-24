package com.mobsoft.matchapp.network.api;

import com.mobsoft.matchapp.network.model.StandingsItem;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface TeamsApi {
  
  /**
   * 
   * Gets the current standings table for the league.
   * @return Call<List<StandingsItem>>
   */
  
  @GET("standings")
  Call<List<StandingsItem>> standingsGet();
    

  
}
