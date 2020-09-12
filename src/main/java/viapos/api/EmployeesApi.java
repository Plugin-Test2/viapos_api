package viapos.api;


import viapos.model.Employee;
import java.util.List;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import viapos.model.EmployeeType;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-08-14T21:01:38.732Z")

@Api(value = "employees", description = "the employees API")
@RequestMapping(value = "/v1")
public interface EmployeesApi {

    @ApiOperation(value = "Update an existing Employees", nickname = "createEmployees", notes = "", tags={ "Employee", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Employees created"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Employees not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/employees",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> createEmployees(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Employees objects to be created" ,required=true )  @Valid @RequestBody List<Employee> employees);


    @ApiOperation(value = "Update an existing Employees", nickname = "deleteEmployees", notes = "", tags={ "Employee", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Employees not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/employees",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteEmployees(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Employees objects to be deleted" ,required=true )  @Valid @RequestBody List<Employee> employee);


    @ApiOperation(value = "Retrieve a single Employee.", nickname = "getEmployee", notes = "", response = Employee.class, tags={ "Employee", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Employee.class),
        @ApiResponse(code = 404, message = "Location not found"),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/employees/{employeeId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<Employee> getEmployee(@ApiParam(value = "ID of Employee to return",required=true) @PathVariable("employeeId") String employeeId,@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept);


    @ApiOperation(value = "Retrieve all Employees.", nickname = "getEmployees", notes = "", response = Employee.class, responseContainer = "List", tags={ "Employee", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Employee.class, responseContainer = "List"),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/employees",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<Employee>> getEmployees(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept);


    @ApiOperation(value = "Update an existing Employee", nickname = "updateEmployees", notes = "", tags={ "Employee", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Employees not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/employees",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateEmployees(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Employees objects to be updated" ,required=true )  @Valid @RequestBody List<Employee> employees);

    @ApiOperation(value = "Create Employee Type", nickname = "createEmployeeTypes", notes = "", tags={ "Employee", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Employee Types created"),
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Employees not found"),
            @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/employees/types",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Void> createEmployeeTypes(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Employee Type objects to be created" ,required=true )  @Valid @RequestBody List<EmployeeType> employeeTypes);


    @ApiOperation(value = "Delete an existing Employee Type", nickname = "deleteEmployeeTypes", notes = "", tags={ "Employee", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Employee Types not found"),
            @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/employees/types",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteEmployeeTypes(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Employee Type objects to be deleted" ,required=true )  @Valid @RequestBody List<EmployeeType> employeeTypes);


    @ApiOperation(value = "Retrieve a single Employee Type.", nickname = "getEmployeeType", notes = "", response = EmployeeType.class, tags={ "Employee", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = EmployeeType.class),
            @ApiResponse(code = 404, message = "Location not found"),
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/employees/types/{employeeTypeId}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<Employee> getEmployeeType(@ApiParam(value = "ID of Employee to return",required=true) @PathVariable("employeeTypeId") String employeeTypeId,@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept);


    @ApiOperation(value = "Retrieve all Employee Types.", nickname = "getEmployeeTypes", notes = "", response = EmployeeType.class, responseContainer = "List", tags={ "Employee", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = EmployeeType.class, responseContainer = "List"),
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/employees/types",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<EmployeeType>> getEmployeeTypes(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept);


    @ApiOperation(value = "Update an existing Employee Type", nickname = "updateEmployeeTypes", notes = "", tags={ "Employee", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Employees not found"),
            @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/employees/types",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<Void> updateEmployeeTypes(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Employee Type objects to be updated" ,required=true )  @Valid @RequestBody List<EmployeeType> employeeTypes);
}
