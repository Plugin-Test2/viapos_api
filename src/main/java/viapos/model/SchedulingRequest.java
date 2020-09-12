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
 * SchedulingRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-10T00:46:52.062Z")




public class SchedulingRequest   {
    @JsonProperty("start")
    private String start = null;

    @JsonProperty("end")
    private String end = null;

    @JsonProperty("locations")
    @Valid
    private List<String> locations = null;

    @JsonProperty("employees")
    @Valid
    private List<String> employees = null;

    @JsonProperty("shiftTypes")
    @Valid
    private List<String> shiftTypes = null;

    public SchedulingRequest start(String start) {
        this.start = start;
        return this;
    }

    /**
     * Get start
     * @return start
     **/
    @ApiModelProperty(value = "")


    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public SchedulingRequest end(String end) {
        this.end = end;
        return this;
    }

    /**
     * Get end
     * @return end
     **/
    @ApiModelProperty(value = "")


    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public SchedulingRequest locations(List<String> locations) {
        this.locations = locations;
        return this;
    }

    public SchedulingRequest addLocationsItem(String locationsItem) {
        if (this.locations == null) {
            this.locations = new ArrayList<String>();
        }
        this.locations.add(locationsItem);
        return this;
    }

    /**
     * Get locations
     * @return locations
     **/
    @ApiModelProperty(value = "")


    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public SchedulingRequest employees(List<String> employees) {
        this.employees = employees;
        return this;
    }

    public SchedulingRequest addEmployeesItem(String employeesItem) {
        if (this.employees == null) {
            this.employees = new ArrayList<String>();
        }
        this.employees.add(employeesItem);
        return this;
    }

    /**
     * Get employees
     * @return employees
     **/
    @ApiModelProperty(value = "")


    public List<String> getEmployees() {
        return employees;
    }

    public void setEmployees(List<String> employees) {
        this.employees = employees;
    }

    public SchedulingRequest shiftTypes(List<String> shiftTypes) {
        this.shiftTypes = shiftTypes;
        return this;
    }

    public SchedulingRequest addShiftTypesItem(String shiftTypesItem) {
        if (this.shiftTypes == null) {
            this.shiftTypes = new ArrayList<String>();
        }
        this.shiftTypes.add(shiftTypesItem);
        return this;
    }

    /**
     * Get shiftTypes
     * @return shiftTypes
     **/
    @ApiModelProperty(value = "")


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
        SchedulingRequest schedulingRequest = (SchedulingRequest) o;
        return Objects.equals(this.start, schedulingRequest.start) &&
                Objects.equals(this.end, schedulingRequest.end) &&
                Objects.equals(this.locations, schedulingRequest.locations) &&
                Objects.equals(this.employees, schedulingRequest.employees) &&
                Objects.equals(this.shiftTypes, schedulingRequest.shiftTypes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, locations, employees, shiftTypes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SchedulingRequest {\n");

        sb.append("    start: ").append(toIndentedString(start)).append("\n");
        sb.append("    end: ").append(toIndentedString(end)).append("\n");
        sb.append("    locations: ").append(toIndentedString(locations)).append("\n");
        sb.append("    employees: ").append(toIndentedString(employees)).append("\n");
        sb.append("    shiftTypes: ").append(toIndentedString(shiftTypes)).append("\n");
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

