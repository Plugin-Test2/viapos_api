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
import viapos.model.Event;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-08-14T21:01:38.732Z")

@Api(value = "events", description = "the events API")
@RequestMapping(value = "/v1")
public interface EventsApi {

    @ApiOperation(value = "Update an existing Events", nickname = "createEvents", notes = "", tags={ "Event", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Events created"),
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Distributions not found"),
            @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/events",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Void> createEvents(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Events objects to be created" ,required=true )  @Valid @RequestBody List<Event> events);


    @ApiOperation(value = "Delete an existing Events", nickname = "deleteEvents", notes = "", tags={ "Event", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Events not found"),
            @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/events",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteEvents(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Events objects to be deleted" ,required=true )  @Valid @RequestBody List<Event> events);

    @ApiOperation(value = "Delete a single event", nickname = "deleteEvent", notes = "", tags={ "Event", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Location not found"),
            @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/events/{eventId}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteEvent(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "ID of Event to delete",required=true) @PathVariable("eventId") String eventId);

    @ApiOperation(value = "Retrieve a single Event.", nickname = "getEvent", notes = "", response = Event.class, tags={ "Event", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Event.class),
            @ApiResponse(code = 404, message = "Route not found"),
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/events/{eventId}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<Event> getEvent(@ApiParam(value = "ID of Distribution to return",required=true) @PathVariable("distributionId") String distributionId,@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept);


    @ApiOperation(value = "Retrieve all Events.", nickname = "getEvents", notes = "", response = Event.class, responseContainer = "List", tags={ "Event", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Event.class, responseContainer = "List"),
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/distributions",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Event>> getEvents(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept);


    @ApiOperation(value = "Update an existing Events", nickname = "updateEvents", notes = "", tags={ "Event", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Distributions not found"),
            @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/events",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<Void> updateEvents(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Events objects to be updated" ,required=true )  @Valid @RequestBody List<Event> events);

}
