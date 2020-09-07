package viapos.api;


import java.util.List;
import viapos.model.Shift;
import viapos.model.ShiftType;
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

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-08-14T21:01:38.732Z")

@Api(value = "shifts", description = "the shifts API")
@RequestMapping(value = "/v1")
public interface ShiftsApi {

    @ApiOperation(value = "Update an existing ShiftTypes", nickname = "createShiftTypes", notes = "", tags={ "Shift", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "ShiftTypes created"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "ShiftTypes not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/shifts/types",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> createShiftTypes(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "ShiftTypes objects to be created" ,required=true )  @Valid @RequestBody List<ShiftType> shiftTypes);


    @ApiOperation(value = "Update an existing Shifts", nickname = "createShifts", notes = "", tags={ "Shift", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Shifts created"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Shifts not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/shifts",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> createShifts(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Shifts objects to be created" ,required=true )  @Valid @RequestBody List<Shift> shifts);


    @ApiOperation(value = "Update an existing ShiftTypes", nickname = "deleteShiftTypes", notes = "", tags={ "Shift", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "ShiftTypes not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/shifts/types",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteShiftTypes(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "ShiftTypes objects to be deleted" ,required=true )  @Valid @RequestBody List<ShiftType> shiftTypes);


    @ApiOperation(value = "Update an existing Shifts", nickname = "deleteShifts", notes = "", tags={ "Shift", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Shifts not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/shifts",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteShifts(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Shifts objects to be deleted" ,required=true )  @Valid @RequestBody List<Shift> shifts);


    @ApiOperation(value = "Retrieve a single Shift.", nickname = "getShift", notes = "", response = Shift.class, tags={ "Shift", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Shift.class),
        @ApiResponse(code = 404, message = "Route not found"),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/shifts/{shiftId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<Shift> getShift(@ApiParam(value = "ID of Shift to return",required=true) @PathVariable("shiftId") String shiftId,@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept);


    @ApiOperation(value = "Retrieve a single ShiftType.", nickname = "getShiftType", notes = "", response = ShiftType.class, tags={ "Shift", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ShiftType.class),
        @ApiResponse(code = 404, message = "Route not found"),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/shifts/types/{shiftTypeId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<ShiftType> getShiftType(@ApiParam(value = "ID of ShiftType to return",required=true) @PathVariable("shiftTypeId") String shiftTypeId,@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept);


    @ApiOperation(value = "Retrieve all ShiftTypes.", nickname = "getShiftTypes", notes = "", response = ShiftType.class, responseContainer = "List", tags={ "Shift", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ShiftType.class, responseContainer = "List"),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/shifts/types",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<ShiftType>> getShiftTypes(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept);


    @ApiOperation(value = "Retrieve all Shifts.", nickname = "getShifts", notes = "", response = Shift.class, responseContainer = "List", tags={ "Shift", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Shift.class, responseContainer = "List"),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/shifts",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<Shift>> getShifts(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept);


    @ApiOperation(value = "Update an existing ShiftTypes", nickname = "updateShiftTypes", notes = "", tags={ "Shift", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "ShiftTypes not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/shifts/types",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateShiftTypes(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "ShiftTypes objects to be updated" ,required=true )  @Valid @RequestBody List<ShiftType> shiftTypes);


    @ApiOperation(value = "Update an existing Shifts", nickname = "updateShifts", notes = "", tags={ "Shift", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Shifts not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/shifts",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateShifts(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Shifts objects to be updated" ,required=true )  @Valid @RequestBody List<Shift> shifts);

    @ApiOperation(value = "Retrieve all Unassigned Shifts.", nickname = "getUnassignedShifts", notes = "", response = Shift.class, responseContainer = "List", tags={ "Shift", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Shift.class, responseContainer = "List"),
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/shifts/unassigned",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Shift>> getUnassignedShifts(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept, @ApiParam(value = "Day of the Week to retrieve unassigned shifts for",required=false) @RequestParam("dayOfWeek") String dayOfWeek, @ApiParam(value = "Date to retrieve unassigned shifts for",required=false) @RequestParam("date") String date, @ApiParam(value = "ID of ShiftType to return",required=true) @RequestParam("resources") List<String> resources);
}
