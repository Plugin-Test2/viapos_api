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
 * Employee
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-08-14T20:01:57.464Z")




public class Employee   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("typeId")
  private String typeId = null;

  @JsonProperty("availability")
  private String availability = null;

  @JsonProperty("preferredWeeklyHours")
  private String preferredWeeklyHours = null;

  @JsonProperty("availableWeeklyHours")
  private String availableWeeklyHours = null;

  @JsonProperty("organizationId")
  private String organizationId = null;

  @JsonProperty("email")
  private String email = null;

  public Employee id(String id) {
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

  public Employee name(String name) {
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

  public Employee typeId(String typeId) {
    this.typeId = typeId;
    return this;
  }

  public String getOrganizationId() {
    return organizationId;
  }

  public void setOrganizationId(String organizationId) {
    this.organizationId = organizationId;
  }

  /**
   * Get typeId
   * @return typeId
  **/
  @ApiModelProperty(value = "")


  public String getTypeId() {
    return typeId;
  }

  public void setTypeId(String typeId) {
    this.typeId = typeId;
  }

  public Employee availability(String availability) {
    this.availability = availability;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  public String getPreferredWeeklyHours() {
    return preferredWeeklyHours;
  }

  public void setPreferredWeeklyHours(String preferredWeeklyHours) {
    this.preferredWeeklyHours = preferredWeeklyHours;
  }

  public String getAvailableWeeklyHours() {
    return availableWeeklyHours;
  }

  public void setAvailableWeeklyHours(String availableWeeklyHours) {
    this.availableWeeklyHours = availableWeeklyHours;
  }

  public void subtractAvailableWeeklyHours(String subtract) {
    this.availableWeeklyHours = Float.toString(Float.parseFloat(this.availableWeeklyHours) - Float.parseFloat(subtract));
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return Objects.equals(this.id, employee.id) &&
        Objects.equals(this.name, employee.name) &&
        Objects.equals(this.typeId, employee.typeId) &&
        Objects.equals(this.availability, employee.availability);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, typeId, availability);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Employee {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    typeId: ").append(toIndentedString(typeId)).append("\n");
    sb.append("    availability: ").append(toIndentedString(availability)).append("\n");
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

