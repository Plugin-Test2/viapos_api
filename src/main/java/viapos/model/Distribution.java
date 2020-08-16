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
 * Distribution
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-08-14T20:01:57.464Z")




public class Distribution   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("sectionIds")
  @Valid
  private List<String> sectionIds = null;

  @JsonProperty("availability")
  private String availability = null;

  @JsonProperty("assignments")
  @Valid
  private List<Assignment> assignments = null;

  public Distribution id(String id) {
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

  public Distribution name(String name) {
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

  public Distribution sectionIds(List<String> sectionIds) {
    this.sectionIds = sectionIds;
    return this;
  }

  public Distribution addSectionIdsItem(String sectionIdsItem) {
    if (this.sectionIds == null) {
      this.sectionIds = new ArrayList<String>();
    }
    this.sectionIds.add(sectionIdsItem);
    return this;
  }

  /**
   * Get sectionIds
   * @return sectionIds
  **/
  @ApiModelProperty(value = "")


  public List<String> getSectionIds() {
    return sectionIds;
  }

  public void setSectionIds(List<String> sectionIds) {
    this.sectionIds = sectionIds;
  }

  public Distribution availability(String availability) {
    this.availability = availability;
    return this;
  }

  /**
   * Get availability
   * @return availability
  **/
  @ApiModelProperty(value = "")


  public String getAvailability() {
    return availability;
  }

  public void setAvailability(String availability) {
    this.availability = availability;
  }

  public Distribution assignments(List<Assignment> assignments) {
    this.assignments = assignments;
    return this;
  }

  public Distribution addAssignmentsItem(Assignment assignmentsItem) {
    if (this.assignments == null) {
      this.assignments = new ArrayList<Assignment>();
    }
    this.assignments.add(assignmentsItem);
    return this;
  }

  /**
   * Get assignments
   * @return assignments
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Assignment> getAssignments() {
    return assignments;
  }

  public void setAssignments(List<Assignment> assignments) {
    this.assignments = assignments;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Distribution distribution = (Distribution) o;
    return Objects.equals(this.id, distribution.id) &&
        Objects.equals(this.name, distribution.name) &&
        Objects.equals(this.sectionIds, distribution.sectionIds) &&
        Objects.equals(this.availability, distribution.availability) &&
        Objects.equals(this.assignments, distribution.assignments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, sectionIds, availability, assignments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Distribution {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    sectionIds: ").append(toIndentedString(sectionIds)).append("\n");
    sb.append("    availability: ").append(toIndentedString(availability)).append("\n");
    sb.append("    assignments: ").append(toIndentedString(assignments)).append("\n");
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

