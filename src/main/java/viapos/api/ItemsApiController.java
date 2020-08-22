package viapos.api;

import org.springframework.web.bind.annotation.*;
import viapos.model.Item;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-05T19:31:06.939Z")

@CrossOrigin
@Controller
public class ItemsApiController implements ItemsApi {

    private static final Logger log = LoggerFactory.getLogger(ItemsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ItemsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addItem(@ApiParam(value = "An array of items to create" ,required=true )  @Valid @RequestBody List<Item> items) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteItems(@ApiParam(value = "Items to be deleted" ,required=true )  @Valid @RequestBody Item body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Item>> getItems(@ApiParam(value = "ID of the item to retrieve" ,required=true) @RequestHeader(value="id", required=true) String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Item>>(objectMapper.readValue("[ {  \"quantity\" : 0,  \"price\" : 6.0274563,  \"name\" : \"name\",  \"id\" : \"id\",  \"category\" : \"category\",  \"sku\" : \"sku\"}, {  \"quantity\" : 0,  \"price\" : 6.0274563,  \"name\" : \"name\",  \"id\" : \"id\",  \"category\" : \"category\",  \"sku\" : \"sku\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Item>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Item>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateItem(@ApiParam(value = "An array of items to update" ,required=true )  @Valid @RequestBody List<Item> items) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
