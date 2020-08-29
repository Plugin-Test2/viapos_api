package viapos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {

    @JsonProperty("start")
    private String start;
    @JsonProperty("end")
    private String end;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("allowedEmployeeTypes")
    private String[] allowedEmployeeTypes;
    @JsonProperty("locationId")
    private String locationId;
    @JsonProperty("reoccurence")
    private String reoccurence;
    @JsonProperty("daysOfWeek")
    private String[] daysOfWeek;
    @JsonProperty("exclusions")
    private Exclusion[] exclusions;

    public String getStartTime() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
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

    public String[] getAllowedEmployeeTypes() {
        return allowedEmployeeTypes;
    }

    public void setAllowedEmployeeTypes(String[] allowedEmployeeTypes) {
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

    public String[] getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(String[] daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public Exclusion[] getExclusions() {
        return exclusions;
    }

    public void setExclusions(Exclusion[] exclusions) {
        this.exclusions = exclusions;
    }
}
