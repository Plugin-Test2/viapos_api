package viapos.external.cardconnect.helper;

import org.apache.tomcat.util.bcel.Const;
import org.springframework.stereotype.Component;
import viapos.external.cardconnect.model.Authorization;
import viapos.external.cardconnect.model.AuthorizationResponse;
import viapos.model.Transaction;
import viapos.util.Constants;

@Component
public class CardConnectHelper {

    private String captureInd = "Y";
    private String captured = "captured";

    public Authorization convertTransaction(Transaction transaction, String merchantId) {
        Authorization authorization = new Authorization();
        authorization.setMerchid(merchantId);
        authorization.setAmount(transaction.getAmount());
        authorization.setCurrency(transaction.getCurrency());
        authorization.setCapture(captureInd);
        if (transaction.getPaymentMethod() != null) {
            authorization.setExpiry(transaction.getPaymentMethod().getExpirationDate());
            authorization.setAccount(transaction.getPaymentMethod().getToken());
            if (transaction.getPaymentMethod().getBillingAddress() != null) {
                authorization.setAddress(transaction.getPaymentMethod().getBillingAddress().getStreetLine1());
                authorization.setAddress2(transaction.getPaymentMethod().getBillingAddress().getStreetLine2());
                authorization.setCity(transaction.getPaymentMethod().getBillingAddress().getCity());
                authorization.setPostal(transaction.getPaymentMethod().getBillingAddress().getPostalCode());
                authorization.setRegion(transaction.getPaymentMethod().getBillingAddress().getRegion());
                authorization.setCountry(transaction.getPaymentMethod().getBillingAddress().getCountry());
            }
        }
        return authorization;
    }

    public Transaction paresResponse(Transaction transaction, AuthorizationResponse authorizationResponse) {
        viapos.model.Authorization authorization = new viapos.model.Authorization();
        authorization.setCode(authorizationResponse.getAuthcode());
        authorization.setStatus(captured);
        authorization.setProcessor(Constants.CARDCONNECT_NAME);
        authorization.setId(authorizationResponse.getRetref());
        transaction.setAuthorization(authorization);
        return transaction;
    }

}
