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
import viapos.model.PaymentMethod;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-02-13T15:48:17.031Z")

@Api(value = "paymentMethods", description = "the paymentMethods API")
@RequestMapping(value = "/v1")
public interface PaymentMethodsApi {

    @ApiOperation(value = "Create new Payment Method", nickname = "createPaymentMethods", notes = "", tags={ "PaymentMethod", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "PaymentMethods created"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "PaymentMethod not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/paymentMethods",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> createPaymentMethods(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "PaymentMethod objects to be created" ,required=true )  @Valid @RequestBody List<PaymentMethod> paymentMethods);


    @ApiOperation(value = "Delete existing Payment Methods", nickname = "deletePaymentMethods", notes = "", tags={ "PaymentMethod", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "PaymentMethod not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/paymentMethods",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deletePaymentMethods(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "PaymentMethod objects to be deleted" ,required=true )  @Valid @RequestBody List<PaymentMethod> paymentMethods);


    @ApiOperation(value = "Retrieve a single PaymentMethod.", nickname = "getPaymentMethod", notes = "", response = PaymentMethod.class, tags={ "PaymentMethod", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = PaymentMethod.class),
        @ApiResponse(code = 404, message = "PaymentMethod not found"),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/paymentMethods/{paymentMethodId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<PaymentMethod> getPaymentMethod(@ApiParam(value = "ID of PaymentMethod to return",required=true) @PathVariable("paymentMethodId") String paymentMethodId,@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept);


    @ApiOperation(value = "Update existing Payment Methods", nickname = "updatePaymentMethods", notes = "", tags={ "PaymentMethod", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "PaymentMethod not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/paymentMethods",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updatePaymentMethods(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "PaymentMethod objects to be updated" ,required=true )  @Valid @RequestBody List<PaymentMethod> paymentMethods);

}
