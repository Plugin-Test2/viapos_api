package viapos.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import viapos.model.Route;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import viapos.service.RouteService;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-08-14T21:01:38.732Z")

@CrossOrigin
@Controller
public class RoutesApiController implements RoutesApi {

    private static final Logger log = LoggerFactory.getLogger(RoutesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private RouteService routeService;

    @org.springframework.beans.factory.annotation.Autowired
    public RoutesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> createRoutes(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Routes objects to be created" ,required=true )  @Valid @RequestBody List<Route> routes) {
        boolean creation = routeService.createRoutes(routes);
        if (creation) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> deleteRoutes(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Routes objects to be deleted" ,required=true )  @Valid @RequestBody List<Route> routes) {
        boolean creation = routeService.deleteRoutes(routes);
        if (creation) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Route> getRoute(@ApiParam(value = "ID of Route to return",required=true) @PathVariable("routeId") String routeId,@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept) {
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Route>(objectMapper.readValue("{  \"number\" : \"number\",  \"grade\" : \"grade\",  \"assignedGrade\" : \"assignedGrade\",  \"id\" : \"id\",  \"sectionId\" : \"sectionId\",  \"setter\" : \"setter\"}", Route.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Route>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Route>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Route>> getRoutes(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept) {
        List<Route> routes = routeService.getRoutes();
        if (routes != null) {
            return new ResponseEntity<List<Route>>(routes, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Route>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> updateRoutes(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Routes objects to be updated" ,required=true )  @Valid @RequestBody List<Route> routes) {
        boolean creation = routeService.updateRoutes(routes);
        if (creation) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
