package viapos.model;

import java.time.LocalDate;
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
 * RoutePlan
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-08-14T20:01:57.464Z")




public class RoutePlan   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("setters")
  @Valid
  private List<String> setters = null;

  @JsonProperty("routes")
  @Valid
  private List<Route> routes = null;

  @JsonProperty("startDate")
  private LocalDate startDate = null;

  @JsonProperty("endDate")
  private LocalDate endDate = null;

  @JsonProperty("sections")
  private List<String> sections = null;

  @JsonProperty("shiftTypes")
  private List<String> shiftTypes = null;

  public RoutePlan id(String id) {
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

  public RoutePlan name(String name) {
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

  public RoutePlan setters(List<String> setters) {
    this.setters = setters;
    return this;
  }

  public RoutePlan addSettersItem(String settersItem) {
    if (this.setters == null) {
      this.setters = new ArrayList<String>();
    }
    this.setters.add(settersItem);
    return this;
  }

  /**
   * Get setters
   * @return setters
  **/
  @ApiModelProperty(value = "")


  public List<String> getSetters() {
    return setters;
  }

  public void setSetters(List<String> setters) {
    this.setters = setters;
  }

  public RoutePlan routes(List<Route> routes) {
    this.routes = routes;
    return this;
  }

  public RoutePlan addRoutesItem(Route routesItem) {
    if (this.routes == null) {
      this.routes = new ArrayList<Route>();
    }
    this.routes.add(routesItem);
    return this;
  }

  /**
   * Get routes
   * @return routes
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Route> getRoutes() {
    return routes;
  }

  public void setRoutes(List<Route> routes) {
    this.routes = routes;
  }

  public RoutePlan startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Get startDate
   * @return startDate
  **/
  @ApiModelProperty(value = "")


  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public RoutePlan endDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Get endDate
   * @return endDate
  **/
  @ApiModelProperty(value = "")


  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public List<String> getSections() {
    return sections;
  }

  public void setSections(List<String> sections) {
    this.sections = sections;
  }

  public List<String> getShiftTypes() {
    return shiftTypes;
  }

  public void setShiftTypes(List<String> shiftTypes) {
    this.shiftTypes = shiftTypes;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoutePlan routePlan = (RoutePlan) o;
    return Objects.equals(this.id, routePlan.id) &&
        Objects.equals(this.name, routePlan.name) &&
        Objects.equals(this.setters, routePlan.setters) &&
        Objects.equals(this.routes, routePlan.routes) &&
        Objects.equals(this.startDate, routePlan.startDate) &&
        Objects.equals(this.endDate, routePlan.endDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, setters, routes, startDate, endDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoutePlan {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    setters: ").append(toIndentedString(setters)).append("\n");
    sb.append("    routes: ").append(toIndentedString(routes)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
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

