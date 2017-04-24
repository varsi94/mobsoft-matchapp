package com.mobsoft.matchapp.network.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class StandingsItem   {
  
  @SerializedName("name")
  private String name = null;
  
  @SerializedName("played")
  private BigDecimal played = null;
  
  @SerializedName("points")
  private BigDecimal points = null;
  

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public BigDecimal getPlayed() {
    return played;
  }
  public void setPlayed(BigDecimal played) {
    this.played = played;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public BigDecimal getPoints() {
    return points;
  }
  public void setPoints(BigDecimal points) {
    this.points = points;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StandingsItem standingsItem = (StandingsItem) o;
    return Objects.equals(name, standingsItem.name) &&
        Objects.equals(played, standingsItem.played) &&
        Objects.equals(points, standingsItem.points);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, played, points);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StandingsItem {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    played: ").append(toIndentedString(played)).append("\n");
    sb.append("    points: ").append(toIndentedString(points)).append("\n");
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
