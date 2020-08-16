package viapos.api;


import java.util.List;
import viapos.model.Section;
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

@Api(value = "sections", description = "the sections API")
@RequestMapping(value = "/v1")
public interface SectionsApi {

    @ApiOperation(value = "Update an existing Sections", nickname = "createSections", notes = "", tags={ "Section", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Sections created"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Pet not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/sections",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> createSections(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Sections objects to be created" ,required=true )  @Valid @RequestBody List<Section> sections);


    @ApiOperation(value = "Update an existing Sections", nickname = "deleteSections", notes = "", tags={ "Section", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Location not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/sections",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteSections(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Sections objects to be deleted" ,required=true )  @Valid @RequestBody List<Section> sections);


    @ApiOperation(value = "Retrieve a single Section.", nickname = "getSection", notes = "", response = Section.class, tags={ "Section", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Section.class),
        @ApiResponse(code = 404, message = "Location not found"),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sections/{sectionId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<Section> getSection(@ApiParam(value = "ID of Section to return",required=true) @PathVariable("sectionId") String sectionId,@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept);


    @ApiOperation(value = "Retrieve all Sections.", nickname = "getSections", notes = "", response = Section.class, responseContainer = "List", tags={ "Section", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Section.class, responseContainer = "List"),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sections",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<Section>> getSections(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept);


    @ApiOperation(value = "Update an existing pet", nickname = "updateSections", notes = "", tags={ "Section", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Location not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/sections",
        produces = { "application/xml", "application/json" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateSections(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Section objects to be updated" ,required=true )  @Valid @RequestBody List<Section> locations);

}
