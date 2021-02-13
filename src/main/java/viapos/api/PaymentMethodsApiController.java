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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import viapos.model.PaymentMethod;
import viapos.service.PaymentMethodService;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-02-13T15:48:17.031Z")

@Controller
public class PaymentMethodsApiController implements PaymentMethodsApi {

    private static final Logger log = LoggerFactory.getLogger(PaymentMethodsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    PaymentMethodService paymentMethodService;

    @org.springframework.beans.factory.annotation.Autowired
    public PaymentMethodsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> createPaymentMethods(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "PaymentMethod objects to be created" ,required=true )  @Valid @RequestBody List<PaymentMethod> paymentMethods) {
        boolean creation = paymentMethodService.createPaymentMethods(paymentMethods);
        if (creation) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> deletePaymentMethods(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "PaymentMethod objects to be deleted" ,required=true )  @Valid @RequestBody List<PaymentMethod> paymentMethods) {
        boolean deletion = paymentMethodService.deletePaymentMethods(paymentMethods);
        if (deletion) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<PaymentMethod> getPaymentMethod(@ApiParam(value = "ID of PaymentMethod to return",required=true) @PathVariable("paymentMethodId") String paymentMethodId, @ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType, @ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept) {
        PaymentMethod paymentMethod = paymentMethodService.getPaymentMethod(paymentMethodId);
        if (paymentMethod != null) {
            return new ResponseEntity<PaymentMethod>(paymentMethod, HttpStatus.OK);
        } else {
            return new ResponseEntity<PaymentMethod>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> updatePaymentMethods(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "PaymentMethod objects to be updated" ,required=true )  @Valid @RequestBody List<PaymentMethod> paymentMethods) {
        boolean update = paymentMethodService.updatePaymentMethods(paymentMethods);
        if (update) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
