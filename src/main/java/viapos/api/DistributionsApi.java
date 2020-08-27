package viapos.api;


import viapos.model.Distribution;
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

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-08-14T21:01:38.732Z")

@Api(value = "distributions", description = "the distributions API")
@RequestMapping(value = "/v1")
public interface DistributionsApi {

    @ApiOperation(value = "Update an existing Distributions", nickname = "createDistributions", notes = "", tags={ "Distribution", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Distributions created"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Distributions not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/distributions",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> createDistributions(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Distributions objects to be created" ,required=true )  @Valid @RequestBody List<Distribution> distributions);


    @ApiOperation(value = "Update an existing Distributions", nickname = "deleteDistributions", notes = "", tags={ "Distribution", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Distributions not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/distributions",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteDistributions(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Distributions objects to be deleted" ,required=true )  @Valid @RequestBody List<Distribution> distributions);

    @ApiOperation(value = "Delete a single distribution", nickname = "deleteDistribution", notes = "", tags={ "Distribution", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Location not found"),
            @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/distributions/{distributionId}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteDistribution(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "ID of Section to return",required=true) @PathVariable("distributionId") String distributionId);

    @ApiOperation(value = "Retrieve a single Distribution.", nickname = "getDistribution", notes = "", response = Distribution.class, tags={ "Distribution", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Distribution.class),
        @ApiResponse(code = 404, message = "Route not found"),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/distributions/{distributionId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<Distribution> getDistribution(@ApiParam(value = "ID of Distribution to return",required=true) @PathVariable("distributionId") String distributionId,@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept);


    @ApiOperation(value = "Retrieve all Distributions.", nickname = "getDistributions", notes = "", response = Distribution.class, responseContainer = "List", tags={ "Distribution", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Distribution.class, responseContainer = "List"),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/distributions",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<Distribution>> getDistributions(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept);


    @ApiOperation(value = "Update an existing Distributions", nickname = "updateDistributions", notes = "", tags={ "Distribution", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Distributions not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/distributions",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateDistributions(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Distributions objects to be updated" ,required=true )  @Valid @RequestBody List<Distribution> distributions);

}
