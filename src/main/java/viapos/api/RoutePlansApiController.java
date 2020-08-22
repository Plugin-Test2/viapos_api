package viapos.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import viapos.model.RoutePlan;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import viapos.service.RoutePlanService;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-08-14T21:01:38.732Z")

@CrossOrigin
@Controller
public class RoutePlansApiController implements RoutePlansApi {

    private static final Logger log = LoggerFactory.getLogger(RoutePlansApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private RoutePlanService routePlanService;

    @org.springframework.beans.factory.annotation.Autowired
    public RoutePlansApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> createRoutePlans(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "RoutePlans objects to be created" ,required=true )  @Valid @RequestBody List<RoutePlan> routePlans) {
        boolean creation = routePlanService.createRoutePlans(routePlans);
        if (creation) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> deleteRoutePlans(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "RoutePlans objects to be deleted" ,required=true )  @Valid @RequestBody List<RoutePlan> routePlans) {
        boolean creation = routePlanService.deleteRoutePlans(routePlans);
        if (creation) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<RoutePlan> getRoutePlan(@ApiParam(value = "ID of RoutePlan to return",required=true) @PathVariable("routePlanId") String routePlanId,@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept) {
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<RoutePlan>(objectMapper.readValue("{  \"routes\" : [ {    \"number\" : \"number\",    \"grade\" : \"grade\",    \"assignedGrade\" : \"assignedGrade\",    \"id\" : \"id\",    \"sectionId\" : \"sectionId\",    \"setter\" : \"setter\"  }, {    \"number\" : \"number\",    \"grade\" : \"grade\",    \"assignedGrade\" : \"assignedGrade\",    \"id\" : \"id\",    \"sectionId\" : \"sectionId\",    \"setter\" : \"setter\"  } ],  \"endDate\" : \"endDate\",  \"name\" : \"name\",  \"setters\" : [ \"setters\", \"setters\" ],  \"id\" : \"id\",  \"startDate\" : \"startDate\"}", RoutePlan.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<RoutePlan>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<RoutePlan>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<RoutePlan>> getRoutePlans(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept) {
        List<RoutePlan> routePlans = routePlanService.getRoutePlans();
        if (routePlans != null) {
            return new ResponseEntity<List<RoutePlan>>(routePlans, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<RoutePlan>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> updateRoutePlans(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "RoutePlans objects to be updated" ,required=true )  @Valid @RequestBody List<RoutePlan> routePlans) {
        boolean creation = routePlanService.updateRoutePlans(routePlans);
        if (creation) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
