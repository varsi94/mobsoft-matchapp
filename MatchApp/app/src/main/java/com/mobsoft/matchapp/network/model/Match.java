package com.mobsoft.matchapp.network.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class Match   {
  
  @SerializedName("homeTeam")
  private MatchHomeTeam homeTeam = null;
  
  @SerializedName("awayTeam")
  private MatchHomeTeam awayTeam = null;
  
  @SerializedName("homeTeamScore")
  private BigDecimal homeTeamScore = null;
  
  @SerializedName("awayTeamScore")
  private BigDecimal awayTeamScore = null;
  
  @SerializedName("homeTeamHalfTimeScore")
  private BigDecimal homeTeamHalfTimeScore = null;
  
  @SerializedName("awayTeamHalfTimeScore")
  private BigDecimal awayTeamHalfTimeScore = null;
  
  @SerializedName("venue")
  private String venue = null;
  
  @SerializedName("matchDate")
  private Date matchDate = null;
  
  @SerializedName("highlights")
  private String highlights = null;
  

  
  /**
   **/
  @ApiModelProperty(value = "")
  public MatchHomeTeam getHomeTeam() {
    return homeTeam;
  }
  public void setHomeTeam(MatchHomeTeam homeTeam) {
    this.homeTeam = homeTeam;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public MatchHomeTeam getAwayTeam() {
    return awayTeam;
  }
  public void setAwayTeam(MatchHomeTeam awayTeam) {
    this.awayTeam = awayTeam;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public BigDecimal getHomeTeamScore() {
    return homeTeamScore;
  }
  public void setHomeTeamScore(BigDecimal homeTeamScore) {
    this.homeTeamScore = homeTeamScore;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public BigDecimal getAwayTeamScore() {
    return awayTeamScore;
  }
  public void setAwayTeamScore(BigDecimal awayTeamScore) {
    this.awayTeamScore = awayTeamScore;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public BigDecimal getHomeTeamHalfTimeScore() {
    return homeTeamHalfTimeScore;
  }
  public void setHomeTeamHalfTimeScore(BigDecimal homeTeamHalfTimeScore) {
    this.homeTeamHalfTimeScore = homeTeamHalfTimeScore;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public BigDecimal getAwayTeamHalfTimeScore() {
    return awayTeamHalfTimeScore;
  }
  public void setAwayTeamHalfTimeScore(BigDecimal awayTeamHalfTimeScore) {
    this.awayTeamHalfTimeScore = awayTeamHalfTimeScore;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getVenue() {
    return venue;
  }
  public void setVenue(String venue) {
    this.venue = venue;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Date getMatchDate() {
    return matchDate;
  }
  public void setMatchDate(Date matchDate) {
    this.matchDate = matchDate;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getHighlights() {
    return highlights;
  }
  public void setHighlights(String highlights) {
    this.highlights = highlights;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Match match = (Match) o;
    return Objects.equals(homeTeam, match.homeTeam) &&
        Objects.equals(awayTeam, match.awayTeam) &&
        Objects.equals(homeTeamScore, match.homeTeamScore) &&
        Objects.equals(awayTeamScore, match.awayTeamScore) &&
        Objects.equals(homeTeamHalfTimeScore, match.homeTeamHalfTimeScore) &&
        Objects.equals(awayTeamHalfTimeScore, match.awayTeamHalfTimeScore) &&
        Objects.equals(venue, match.venue) &&
        Objects.equals(matchDate, match.matchDate) &&
        Objects.equals(highlights, match.highlights);
  }

  @Override
  public int hashCode() {
    return Objects.hash(homeTeam, awayTeam, homeTeamScore, awayTeamScore, homeTeamHalfTimeScore, awayTeamHalfTimeScore, venue, matchDate, highlights);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Match {\n");
    
    sb.append("    homeTeam: ").append(toIndentedString(homeTeam)).append("\n");
    sb.append("    awayTeam: ").append(toIndentedString(awayTeam)).append("\n");
    sb.append("    homeTeamScore: ").append(toIndentedString(homeTeamScore)).append("\n");
    sb.append("    awayTeamScore: ").append(toIndentedString(awayTeamScore)).append("\n");
    sb.append("    homeTeamHalfTimeScore: ").append(toIndentedString(homeTeamHalfTimeScore)).append("\n");
    sb.append("    awayTeamHalfTimeScore: ").append(toIndentedString(awayTeamHalfTimeScore)).append("\n");
    sb.append("    venue: ").append(toIndentedString(venue)).append("\n");
    sb.append("    matchDate: ").append(toIndentedString(matchDate)).append("\n");
    sb.append("    highlights: ").append(toIndentedString(highlights)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
