package viapos.api;

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
import viapos.model.Organization;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-08-16T10:41:21.709Z")

@Validated
@Api(value = "organizations", description = "the organizations API")
@RequestMapping(value = "/v1")
public interface OrganizationsApi {

    @ApiOperation(value = "Create new Organizations", nickname = "createOrganizations", notes = "", tags={ "Organization", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Organizations created"),
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Organization not found"),
            @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/organizations",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Void> createOrganizations(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Organization objects to be created" ,required=true )  @Valid @RequestBody List<Organization> organizations);


    @ApiOperation(value = "Delete existing Organizations", nickname = "deleteOrganizations", notes = "", tags={ "Organization", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Organization not found"),
            @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/organizations",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteOrganizations(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Organization objects to be deleted" ,required=true )  @Valid @RequestBody List<Organization> organizations);


    @ApiOperation(value = "Retrieve a single Organization.", nickname = "getOrganization", notes = "", response = Organization.class, tags={ "Organization", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Organization.class),
            @ApiResponse(code = 404, message = "Customer not found"),
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/organizations/{organizationId}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<Organization> getOrganization(@ApiParam(value = "ID of Organization to return",required=true) @PathVariable("organizationId") String organizationId,@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept);


    @ApiOperation(value = "Retrieve all Organizations.", nickname = "getOrganizations", notes = "", response = Organization.class, responseContainer = "List", tags={ "Organization", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Organization.class, responseContainer = "List"),
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/organizations",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Organization>> getOrganizations(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept);


    @ApiOperation(value = "Update existing Organizations", nickname = "updateOrganizations", notes = "", tags={ "Organization", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Organization not found"),
            @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/organizations",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<Void> updateOrganizations(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Organization objects to be updated" ,required=true )  @Valid @RequestBody List<Organization> organizations);

}
