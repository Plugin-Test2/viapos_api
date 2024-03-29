/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.18).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
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
import viapos.model.Customer;
import viapos.model.PaymentMethod;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-02-06T19:56:12.793Z")

@Api(value = "customers", description = "the customers API")
@RequestMapping(value = "/v1")
public interface CustomersApi {

    @ApiOperation(value = "Create new customers", nickname = "createCustomers", notes = "", tags={ "Customer", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Customers created"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Pet not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/customers",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> createCustomers(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Customer objects to be created" ,required=true )  @Valid @RequestBody List<Customer> customers);


    @ApiOperation(value = "Delete existing customers", nickname = "deleteCustomer", notes = "", tags={ "Customer", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Customer not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/customers",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteCustomer(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Customer objects to be deleted" ,required=true )  @Valid @RequestBody List<Customer> customers);


    @ApiOperation(value = "Retrieve a single Customer.", nickname = "getCustomer", notes = "", response = Customer.class, tags={ "Customer", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Customer.class),
        @ApiResponse(code = 404, message = "Customer not found"),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customers/{customerId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<Customer> getCustomer(@ApiParam(value = "ID of Customer to return",required=true) @PathVariable("customerId") String customerId,@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept);


    @ApiOperation(value = "Retrieve all customers.", nickname = "getCustomers", notes = "", response = Customer.class, responseContainer = "List", tags={ "Customer", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Customer.class, responseContainer = "List"),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customers",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<Customer>> getCustomers(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept);


    @ApiOperation(value = "Update existing customers", nickname = "updateCustomers", notes = "", tags={ "Customer", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Customer not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/customers",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateCustomers(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Customer objects to be updated" ,required=true )  @Valid @RequestBody List<Customer> customers);


    @ApiOperation(value = "Retrieve payment methods for a customer", nickname = "getCustomerPaymentMethods", notes = "", response = PaymentMethod.class, responseContainer = "List", tags={ "Customer", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = PaymentMethod.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Customer not found"),
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customers/{customerId}/paymentMethods",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<PaymentMethod>> getCustomerPaymentMethods(@ApiParam(value = "ID of Customer to return",required=true) @PathVariable("customerId") String customerId, @ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType, @ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept);

}
