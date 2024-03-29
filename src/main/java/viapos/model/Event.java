package viapos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Event {

    @JsonProperty("start")
    private LocalDateTime start;
    @JsonProperty("end")
    private LocalDateTime end;
    @JsonProperty("startTime")
    private String startTime;
    @JsonProperty("endTime")
    private String endTime;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("allowedEmployeeTypes")
    private List<String> allowedEmployeeTypes;
    @JsonProperty("locationId")
    private String locationId;
    @JsonProperty("reoccurence")
    private String reoccurence;
    @JsonProperty("daysOfWeek")
    private List<String> daysOfWeek;
    @JsonProperty("exclusions")
    private List<Exclusion> exclusions;
    @JsonProperty("minEmployeeNbr")
    private String minEmployeeNbr;
    @JsonProperty("minShiftsNbr")
    private String minShiftsNbr;
    @JsonProperty("shiftType")
    private String shiftType;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAllowedEmployeeTypes() {
        return allowedEmployeeTypes;
    }

    public void setAllowedEmployeeTypes(List<String> allowedEmployeeTypes) {
        this.allowedEmployeeTypes = allowedEmployeeTypes;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getReoccurence() {
        return reoccurence;
    }

    public void setReoccurence(String reoccurence) {
        this.reoccurence = reoccurence;
    }

    public List<String> getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(List<String> daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public List<Exclusion> getExclusions() {
        return exclusions;
    }

    public void setExclusions(List<Exclusion> exclusions) {
        this.exclusions = exclusions;
    }

    public String getMinEmployeeNbr() {
        return minEmployeeNbr;
    }

    public void setMinEmployeeNbr(String minEmployeeNbr) {
        this.minEmployeeNbr = minEmployeeNbr;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getMinShiftsNbr() {
        return minShiftsNbr;
    }

    public void setMinShiftsNbr(String minShiftsNbr) {
        this.minShiftsNbr = minShiftsNbr;
    }

    public String getShiftType() {
        return shiftType;
    }

    public void setShiftType(String shiftType) {
        this.shiftType = shiftType;
    }
}
