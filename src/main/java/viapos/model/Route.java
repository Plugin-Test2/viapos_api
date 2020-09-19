package viapos.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Route
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-08-14T20:01:57.464Z")




public class Route   {
  @JsonProperty("shiftId")
  private String shiftId = null;

  @JsonProperty("number")
  private String number = null;

  @JsonProperty("sectionId")
  private String sectionId = null;

  @JsonProperty("assignedGrade")
  private String assignedGrade = null;

  @JsonProperty("grade")
  private String grade = null;

  @JsonProperty("setter")
  private String setter = null;

  public Route id(String shiftId) {
    this.shiftId = shiftId;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public String getShiftId() {
    return shiftId;
  }

  public void setShiftId(String shiftId) {
    this.shiftId = shiftId;
  }

  public Route number(String number) {
    this.number = number;
    return this;
  }

  /**
   * Get number
   * @return number
  **/
  @ApiModelProperty(value = "")


  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Route sectionId(String sectionId) {
    this.sectionId = sectionId;
    return this;
  }

  /**
   * Get sectionId
   * @return sectionId
  **/
  @ApiModelProperty(value = "")


  public String getSectionId() {
    return sectionId;
  }

  public void setSectionId(String sectionId) {
    this.sectionId = sectionId;
  }

  public Route assignedGrade(String assignedGrade) {
    this.assignedGrade = assignedGrade;
    return this;
  }

  /**
   * Get assignedGrade
   * @return assignedGrade
  **/
  @ApiModelProperty(value = "")


  public String getAssignedGrade() {
    return assignedGrade;
  }

  public void setAssignedGrade(String assignedGrade) {
    this.assignedGrade = assignedGrade;
  }

  public Route grade(String grade) {
    this.grade = grade;
    return this;
  }

  /**
   * Get grade
   * @return grade
  **/
  @ApiModelProperty(value = "")


  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public Route setter(String setter) {
    this.setter = setter;
    return this;
  }

  /**
   * Get setter
   * @return setter
  **/
  @ApiModelProperty(value = "")


  public String getSetter() {
    return setter;
  }

  public void setSetter(String setter) {
    this.setter = setter;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Route route = (Route) o;
    return Objects.equals(this.shiftId, route.shiftId) &&
        Objects.equals(this.number, route.number) &&
        Objects.equals(this.sectionId, route.sectionId) &&
        Objects.equals(this.assignedGrade, route.assignedGrade) &&
        Objects.equals(this.grade, route.grade) &&
        Objects.equals(this.setter, route.setter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shiftId, number, sectionId, assignedGrade, grade, setter);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Route {\n");
    
    sb.append("    id: ").append(toIndentedString(shiftId)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    sectionId: ").append(toIndentedString(sectionId)).append("\n");
    sb.append("    assignedGrade: ").append(toIndentedString(assignedGrade)).append("\n");
    sb.append("    grade: ").append(toIndentedString(grade)).append("\n");
    sb.append("    setter: ").append(toIndentedString(setter)).append("\n");
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

