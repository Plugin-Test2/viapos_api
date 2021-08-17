package viapos.api;

import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import viapos.model.Organization;
import viapos.service.OrganizationService;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-08-16T10:41:21.709Z")

@CrossOrigin
@Controller
public class OrganizationsApiController implements OrganizationsApi {

    private static final Logger log = LoggerFactory.getLogger(OrganizationsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    OrganizationService organizationService;

    @org.springframework.beans.factory.annotation.Autowired
    public OrganizationsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> createOrganizations(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Organization objects to be created" ,required=true )  @Valid @RequestBody List<Organization> organizations) {
        boolean creation = organizationService.createOrganizations(organizations);
        if (creation) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> deleteOrganizations(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Organization objects to be deleted" ,required=true )  @Valid @RequestBody List<Organization> organizations) {
        boolean deletion = organizationService.deleteOrganization(organizations);
        if (deletion) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Organization> getOrganization(@ApiParam(value = "ID of Organization to return",required=true) @PathVariable("organizationId") String organizationId, @ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType, @ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept) {
        Organization organization = organizationService.getOrganization(organizationId);
        if (organization != null) {
            return new ResponseEntity<Organization>(organization, HttpStatus.OK);
        } else {
            return new ResponseEntity<Organization>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Organization>> getOrganizations(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept) {
        List<Organization> organizations = organizationService.getOrganizations();
        if (organizations != null) {
            return new ResponseEntity<List<Organization>>(organizations, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Organization>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> updateOrganizations(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Organization objects to be updated" ,required=true )  @Valid @RequestBody List<Organization> organizations) {
        boolean update = organizationService.updateOrganizations(organizations);
        if (update) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
