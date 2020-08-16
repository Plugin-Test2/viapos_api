package viapos.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Setter
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-08-14T20:01:57.464Z")




public class Setter   {
  @JsonProperty("availibleLocations")
  @Valid
  private List<String> availibleLocations = null;

  public Setter availibleLocations(List<String> availibleLocations) {
    this.availibleLocations = availibleLocations;
    return this;
  }

  public Setter addAvailibleLocationsItem(String availibleLocationsItem) {
    if (this.availibleLocations == null) {
      this.availibleLocations = new ArrayList<String>();
    }
    this.availibleLocations.add(availibleLocationsItem);
    return this;
  }

  /**
   * Get availibleLocations
   * @return availibleLocations
  **/
  @ApiModelProperty(value = "")


  public List<String> getAvailibleLocations() {
    return availibleLocations;
  }

  public void setAvailibleLocations(List<String> availibleLocations) {
    this.availibleLocations = availibleLocations;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Setter setter = (Setter) o;
    return Objects.equals(this.availibleLocations, setter.availibleLocations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(availibleLocations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Setter {\n");
    
    sb.append("    availibleLocations: ").append(toIndentedString(availibleLocations)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

