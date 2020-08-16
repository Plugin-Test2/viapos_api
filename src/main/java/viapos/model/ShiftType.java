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
 * ShiftType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-08-14T20:01:57.464Z")




public class ShiftType   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("eligibileEmployeeTypeIds")
  @Valid
  private List<String> eligibileEmployeeTypeIds = null;

  public ShiftType id(String id) {
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

  public ShiftType name(String name) {
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

  public ShiftType eligibileEmployeeTypeIds(List<String> eligibileEmployeeTypeIds) {
    this.eligibileEmployeeTypeIds = eligibileEmployeeTypeIds;
    return this;
  }

  public ShiftType addEligibileEmployeeTypeIdsItem(String eligibileEmployeeTypeIdsItem) {
    if (this.eligibileEmployeeTypeIds == null) {
      this.eligibileEmployeeTypeIds = new ArrayList<String>();
    }
    this.eligibileEmployeeTypeIds.add(eligibileEmployeeTypeIdsItem);
    return this;
  }

  /**
   * Get eligibileEmployeeTypeIds
   * @return eligibileEmployeeTypeIds
  **/
  @ApiModelProperty(value = "")


  public List<String> getEligibileEmployeeTypeIds() {
    return eligibileEmployeeTypeIds;
  }

  public void setEligibileEmployeeTypeIds(List<String> eligibileEmployeeTypeIds) {
    this.eligibileEmployeeTypeIds = eligibileEmployeeTypeIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShiftType shiftType = (ShiftType) o;
    return Objects.equals(this.id, shiftType.id) &&
        Objects.equals(this.name, shiftType.name) &&
        Objects.equals(this.eligibileEmployeeTypeIds, shiftType.eligibileEmployeeTypeIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, eligibileEmployeeTypeIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShiftType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    eligibileEmployeeTypeIds: ").append(toIndentedString(eligibileEmployeeTypeIds)).append("\n");
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

