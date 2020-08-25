package viapos.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Section
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-08-14T20:01:57.464Z")




public class Section   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("nbrRoutes")
  private String nbrRoutes = null;

  @JsonProperty("nbrBolts")
  private String nbrBolts = null;

  @JsonProperty("occruence")
  private String occruence = null;

  @JsonProperty("difficulty")
  private String difficulty = null;

  @JsonProperty("locationName")
  private String locationName = null;

  @JsonProperty("locationId")
  private String locationId = null;

  public Section id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Section name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Section nbrRoutes(String nbrRoutes) {
    this.nbrRoutes = nbrRoutes;
    return this;
  }

  /**
   * Get nbrRoutes
   * @return nbrRoutes
  **/
  @ApiModelProperty(value = "")

  @Valid

  public String getNbrRoutes() {
    return nbrRoutes;
  }

  public void setNbrRoutes(String nbrRoutes) {
    this.nbrRoutes = nbrRoutes;
  }

  public Section nbrBolts(String nbrBolts) {
    this.nbrBolts = nbrBolts;
    return this;
  }

  /**
   * Get nbrBolts
   * @return nbrBolts
  **/
  @ApiModelProperty(value = "")

  @Valid

  public String getNbrBolts() {
    return nbrBolts;
  }

  public void setNbrBolts(String nbrBolts) {
    this.nbrBolts = nbrBolts;
  }

  public Section occruence(String occruence) {
    this.occruence = occruence;
    return this;
  }

  /**
   * Get occruence
   * @return occruence
  **/
  @ApiModelProperty(value = "")


  public String getOccruence() {
    return occruence;
  }

  public void setOccruence(String occruence) {
    this.occruence = occruence;
  }

  public String getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(String difficulty) {
    this.difficulty = difficulty;
  }

  public String getLocationName() {
    return locationName;
  }

  public void setLocationName(String locationName) {
    this.locationName = locationName;
  }

  public String getLocationId() {
    return locationId;
  }

  public void setLocationId(String locationId) {
    this.locationId = locationId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Section section = (Section) o;
    return Objects.equals(this.id, section.id) &&
        Objects.equals(this.name, section.name) &&
        Objects.equals(this.nbrRoutes, section.nbrRoutes) &&
        Objects.equals(this.nbrBolts, section.nbrBolts) &&
        Objects.equals(this.occruence, section.occruence);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, nbrRoutes, nbrBolts, occruence);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Section {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    nbrRoutes: ").append(toIndentedString(nbrRoutes)).append("\n");
    sb.append("    nbrBolts: ").append(toIndentedString(nbrBolts)).append("\n");
    sb.append("    occruence: ").append(toIndentedString(occruence)).append("\n");
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

