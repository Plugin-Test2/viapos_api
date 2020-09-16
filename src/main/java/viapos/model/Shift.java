package viapos.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Shift
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-08-14T20:01:57.464Z")




public class Shift   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("date")
  private String date = null;

  @JsonProperty("assignedTo")
  private String assignedTo = null;

  @JsonProperty("shiftTypeId")
  private String shiftTypeId = null;

  @JsonProperty("eventId")
  private String eventId = null;
  @JsonProperty("start")
  private LocalDateTime start;
  @JsonProperty("end")
  private LocalDateTime end;
  @JsonProperty("locationId")
  private String locationId;
  @JsonProperty("duration")
  private String duration;

  public Shift id(String id) {
    this.id = id;
    return this;
  }

  public Shift(){}

  public Shift(Event event, LocalDate date){
    this.start = LocalDateTime.parse(date.toString() + "T" + event.getStartTime());
    this.end = LocalDateTime.parse(date.toString() + "T" + event.getEndTime());
    this.locationId = event.getLocationId();
    this.eventId = event.getId();
    this.name = event.getName();
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

  public Shift name(String name) {
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

  public Shift date(String date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
  **/
  @ApiModelProperty(value = "")


  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public Shift assignedTo(String assignedTo) {
    this.assignedTo = assignedTo;
    return this;
  }

  /**
   * Get assignedTo
   * @return assignedTo
  **/
  @ApiModelProperty(value = "")


  public String getAssignedTo() {
    return assignedTo;
  }

  public void setAssignedTo(String assignedTo) {
    this.assignedTo = assignedTo;
  }

  public Shift shiftTypeId(String shiftTypeId) {
    this.shiftTypeId = shiftTypeId;
    return this;
  }

  /**
   * Get shiftTypeId
   * @return shiftTypeId
  **/
  @ApiModelProperty(value = "")


  public String getShiftTypeId() {
    return shiftTypeId;
  }

  public void setShiftTypeId(String shiftTypeId) {
    this.shiftTypeId = shiftTypeId;
  }

  public String getEventId() {
    return eventId;
  }

  public void setEventId(String eventId) {
    this.eventId = eventId;
  }

  public LocalDateTime getStart() {
    return start;
  }

  public void setStart(LocalDateTime start) {
    this.start = start;
  }

  public LocalDateTime getEnd() {
    return end;
  }

  public void setEnd(LocalDateTime end) {
    this.end = end;
  }

  public String getLocationId() {
    return locationId;
  }

  public void setLocationId(String locationId) {
    this.locationId = locationId;
  }

  public String getDuration() {
    if (this.start != null && this.end != null) {
      return Long.toString(this.start.until(this.end, ChronoUnit.MONTHS));
    } else {
      return "0";
    }
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Shift shift = (Shift) o;
    return Objects.equals(this.id, shift.id) &&
        Objects.equals(this.name, shift.name) &&
        Objects.equals(this.date, shift.date) &&
        Objects.equals(this.assignedTo, shift.assignedTo) &&
        Objects.equals(this.shiftTypeId, shift.shiftTypeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, date, assignedTo, shiftTypeId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Shift {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    assignedTo: ").append(toIndentedString(assignedTo)).append("\n");
    sb.append("    shiftTypeId: ").append(toIndentedString(shiftTypeId)).append("\n");
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

