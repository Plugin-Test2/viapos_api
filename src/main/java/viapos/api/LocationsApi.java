package viapos.api;

import java.util.List;
import viapos.model.Location;
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

@Api(value = "locations", description = "the locations API")
@RequestMapping(value = "/v1")
public interface LocationsApi {

    @ApiOperation(value = "Update an existing pet", nickname = "createLocation", notes = "", tags={ "Location", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Locations created"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Pet not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/locations",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> createLocation(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Location objects to be created" ,required=true )  @Valid @RequestBody List<Location> locations);


    @ApiOperation(value = "Update an existing pet", nickname = "deleteLocation", notes = "", tags={ "Location", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Location not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/locations",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteLocation(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Location objects to be deleted" ,required=true )  @Valid @RequestBody List<Location> locations);


    @ApiOperation(value = "Retrieve a single location.", nickname = "getLocation", notes = "", response = Location.class, tags={ "Location", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Location.class),
        @ApiResponse(code = 404, message = "Section not found"),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/locations/{locationId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<Location> getLocation(@ApiParam(value = "ID of pet to return",required=true) @PathVariable("locationId") String locationId,@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept);


    @ApiOperation(value = "Retrieve all locations.", nickname = "getLocations", notes = "", response = Location.class, responseContainer = "List", tags={ "Location", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Location.class, responseContainer = "List"),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/locations",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<Location>> getLocations(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept);


    @ApiOperation(value = "Update an existing pet", nickname = "updateLocation", notes = "", tags={ "Location", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Location not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/locations",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateLocation(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Location objects to be updated" ,required=true )  @Valid @RequestBody List<Location> locations);

}
