package viapos.api;

import java.util.ArrayList;
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
import viapos.model.Customer;
import viapos.model.PaymentMethod;
import viapos.service.CustomerService;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-02-06T19:56:12.793Z")

@CrossOrigin
@Controller
public class CustomersApiController implements CustomersApi {

    private static final Logger log = LoggerFactory.getLogger(CustomersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private CustomerService customerService;

    @org.springframework.beans.factory.annotation.Autowired
    public CustomersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> createCustomers(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Customer objects to be created" ,required=true )  @Valid @RequestBody List<Customer> customers) {
        boolean creation = customerService.createCustomers(customers);
        if (creation) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> deleteCustomer(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Customer objects to be deleted" ,required=true )  @Valid @RequestBody List<Customer> customers) {
        boolean deletion = customerService.deleteCustomers(customers);
        if (deletion) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Customer> getCustomer(@ApiParam(value = "ID of Customer to return",required=true) @PathVariable("customerId") String customerId, @ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType, @ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept) {
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Customer>(objectMapper.readValue("{  \"firstName\" : \"firstName\",  \"lastName\" : \"lastName\",  \"emailAddress\" : \"emailAddress\",  \"phoneNumber\" : \"phoneNumber\",  \"id\" : \"id\",  \"contactMethod\" : \"contactMethod\"}", Customer.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Customer>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Customer>> getCustomers(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept) {
        ArrayList<Customer> customers = customerService.getCustomers();
        if (customers != null) {
            return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Customer>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> updateCustomers(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Customer objects to be updated" ,required=true )  @Valid @RequestBody List<Customer> customers) {
        boolean update = customerService.updateCustomers(customers);
        if (update) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<PaymentMethod>> getCustomerPaymentMethods(@ApiParam(value = "ID of Customer to return",required=true) @PathVariable("customerId") String customerId, @ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType, @ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept) {
        List<PaymentMethod> paymentMethods = customerService.getCustomersPaymentMethods(customerId);
        if (paymentMethods != null && !paymentMethods.isEmpty()) {
            return new ResponseEntity<List<PaymentMethod>>(paymentMethods, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<PaymentMethod>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
