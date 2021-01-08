package viapos.external.clover.helper;

import org.springframework.stereotype.Component;
import viapos.external.clover.model.ChargeRequest;
import viapos.external.clover.model.ChargeResponse;
import viapos.model.Authorization;
import viapos.model.Transaction;

@Component
public class CloverHelper {

    private String ecomInd = "ecom";
    private String cloverProcessor = "Clover";
    private String captured = "Captured";
    private String authorized = "Authorized";

    public ChargeRequest convertTransaction(Transaction transaction) {
        ChargeRequest chargeRequest = new ChargeRequest();
        if (transaction.getPaymentMethod() != null) {
            if (transaction.getPaymentMethod().getToken() != null) {
                chargeRequest.setSource(transaction.getPaymentMethod().getToken());
            }
        }
        if (transaction.getAmount() != null) {
            chargeRequest.setAmount(Integer.parseInt(transaction.getAmount()));
        }
        if (transaction.getCurrency() != null) {
            chargeRequest.setCurrency(transaction.getCurrency());
        }
        chargeRequest.setCapture(true);
        chargeRequest.setEcomind(ecomInd);
        return chargeRequest;
    }

    public Transaction paresResponse(Transaction transaction, ChargeResponse chargeResponse) {
        Authorization authorization = new Authorization();
        if (chargeResponse.getAuthCode() != null) {
            authorization.setCode(chargeResponse.getAuthCode());
        }
        authorization.setProcessor(cloverProcessor);
        if (chargeResponse.getId() != null) {
            authorization.setId(chargeResponse.getId());
        }
        if (chargeResponse.isCaptured()) {
            authorization.setStatus(captured);
        } else {
            authorization.setStatus(authorized);
        }
        transaction.setAuthorization(authorization);
        return transaction;
    }
}
