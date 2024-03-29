package viapos.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import viapos.model.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import viapos.service.TransactionService;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-11T00:25:13.745Z")

@CrossOrigin
@Controller
public class TransactionsApiController implements TransactionsApi {

    private static final Logger log = LoggerFactory.getLogger(TransactionsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private TransactionService transactionService;

    @org.springframework.beans.factory.annotation.Autowired
    public TransactionsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Transaction>> authorizeTransactions(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Merchant Id to Process Under" ,required=true) @RequestHeader(value="merchantId", required=true) String merchantId,@ApiParam(value = "The preferred payment processor to send the transaction to." ,required=true) @RequestHeader(value="paymentProcessor", required=true) String paymentProcessor,@ApiParam(value = "Transaction objects to be authorized" ,required=true )  @Valid @RequestBody List<Transaction> transactions) {
        List<Transaction> transactionResults = transactionService.authorizeTransactions(transactions, paymentProcessor, merchantId);
        if (transactionResults != null) {
            transactionService.createTransactions(transactionResults);
            return new ResponseEntity<List<Transaction>>(transactionResults, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Transaction>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> createTransaction(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Transaction objects to be created" ,required=true )  @Valid @RequestBody List<Transaction> transactions) {
        Boolean creation = transactionService.createTransactions(transactions);
        if (creation) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> deleteTransaction(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Transaction objects to be deleted" ,required=true )  @Valid @RequestBody List<Transaction> transactions) {
        Boolean deletion = transactionService.createTransactions(transactions);
        if (deletion) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Transaction> getTransaction(@ApiParam(value = "ID of Transaction to return",required=true) @PathVariable("transactionId") String transactionId,@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept) {
        Transaction transaction = transactionService.getTransaction(transactionId);
        if (transaction != null) {
            return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
        } else {
            return new ResponseEntity<Transaction>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Transaction>> getTransactions(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept) {
        List<Transaction> transactions = transactionService.getTransactions();
        if (transactions != null) {
            return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Transaction>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Transaction>> refundTransactions(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Transaction objects to be refunded" ,required=true )  @Valid @RequestBody List<Transaction> transactions) {

        return new ResponseEntity<List<Transaction>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateTransaction(@ApiParam(value = "Content Type" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType,@ApiParam(value = "Format to send back" ,required=true) @RequestHeader(value="Accept", required=true) String accept,@ApiParam(value = "Transaction objects to be updated" ,required=true )  @Valid @RequestBody List<Transaction> transactions) {
        Boolean update = transactionService.updateTransactions(transactions);
        if (update) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
