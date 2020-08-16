package viapos.api;


import java.util.List;
import viapos.model.Route;
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

@Api(value = "routes", description = "the routes API")
@RequestMapping(value = "/v1")
public interface RoutesApi {

    @ApiOperation(value = "Update an existing Routes", nickname = "createRoutes", notes = "", tags={ "Route", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Routes created"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Routes not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/routes",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> createRoutes(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Routes objects to be created" ,required=true )  @Valid @RequestBody List<Route> routes);


    @ApiOperation(value = "Update an existing Routes", nickname = "deleteRoutes", notes = "", tags={ "Route", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Routes not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/routes",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteRoutes(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Routes objects to be deleted" ,required=true )  @Valid @RequestBody List<Route> routes);


    @ApiOperation(value = "Retrieve a single Route.", nickname = "getRoute", notes = "", response = Route.class, tags={ "Route", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Route.class),
        @ApiResponse(code = 404, message = "Route not found"),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/routes/{routeId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<Route> getRoute(@ApiParam(value = "ID of Route to return",required=true) @PathVariable("routeId") String routeId,@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept);


    @ApiOperation(value = "Retrieve all Routes.", nickname = "getRoutes", notes = "", response = Route.class, responseContainer = "List", tags={ "Route", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Route.class, responseContainer = "List"),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/routes",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<Route>> getRoutes(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept);


    @ApiOperation(value = "Update an existing Route", nickname = "updateRoutes", notes = "", tags={ "Route", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Routes not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/routes",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateRoutes(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Routes objects to be updated" ,required=true )  @Valid @RequestBody List<Route> routes);

}
