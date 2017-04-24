package com.mobsoft.matchapp.network.api;


import com.mobsoft.matchapp.network.model.Match;

import java.math.BigDecimal;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface MatchesApi {
  
  /**
   * 
   * Adds a new match to the database.
   * @param match The match as a JSON object.
   * @param userId The id of the user who wants to create the match.
   * @return Call<Void>
   */
  
  @POST("matches")
  Call<Void> matchesPost(
          @Body Match match, @Header("userId") BigDecimal userId
  );

  
  /**
   * 
   * Updates a match in the database.
   * @param matchId The unique identifier of the match.
   * @param match The match as a JSON object
   * @param userId The id of the user who wants to update the match.
   * @return Call<Void>
   */
  
  @PUT("matches/{matchId}")
  Call<Void> matchesMatchIdPut(
          @Path("matchId") BigDecimal matchId, @Body Match match, @Header("userId") BigDecimal userId
  );

  
  /**
   * 
   * Gets the matches for the given Team Id.
   * @param teamId The unique identifier of the team.
   * @return Call<List<Match>>
   */
  
  @GET("teams/{teamId}/matches")
  Call<List<Match>> teamsTeamIdMatchesGet(
          @Path("teamId") BigDecimal teamId
  );

  
}
