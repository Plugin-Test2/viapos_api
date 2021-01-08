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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import viapos.dao.PaymentPlanDao;
import viapos.model.PaymentPlan;
import viapos.service.PaymentPlanService;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-01-06T23:36:52.493Z")

@Controller
public class PaymentplansApiController implements PaymentplansApi {

    private static final Logger log = LoggerFactory.getLogger(PaymentplansApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private PaymentPlanService paymentPlanService;

    @org.springframework.beans.factory.annotation.Autowired
    public PaymentplansApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> createPaymentPlans(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "PaymentPlan objects to be created" ,required=true )  @Valid @RequestBody List<PaymentPlan> paymentPlans) {
        boolean creation = paymentPlanService.createPaymentPlans(paymentPlans);
        if (creation) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> deletePaymentPlans(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "PaymentPlan objects to be deleted" ,required=true )  @Valid @RequestBody List<PaymentPlan> paymentPlans) {
        boolean deleted = paymentPlanService.deletePaymentPlans(paymentPlans);
        if (deleted) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<PaymentPlan> getPaymentPlan(@ApiParam(value = "ID of Payment Plan to return",required=true) @PathVariable("paymentPlanId") String paymentPlanId, @ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType, @ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept) {
        PaymentPlan paymentPlan = paymentPlanService.getPaymentPlan(paymentPlanId);
        if (paymentPlan != null) {
            return new ResponseEntity<PaymentPlan>(paymentPlan, HttpStatus.OK);
        } else {
            return new ResponseEntity<PaymentPlan>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<PaymentPlan>> getPaymentPlans(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept) {
        ArrayList<PaymentPlan> paymentPlans = paymentPlanService.getPaymentPlans();
        if (paymentPlans != null) {
            return new ResponseEntity<List<PaymentPlan>>(paymentPlans, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<PaymentPlan>>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Void> updatePaymentPlans(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "PaymentPlan objects to be updated" ,required=true )  @Valid @RequestBody List<PaymentPlan> paymentPlans) {
        boolean updated = paymentPlanService.updatePaymentPlans(paymentPlans);
        if (updated) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
