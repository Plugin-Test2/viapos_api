package viapos.service;

import org.springframework.stereotype.Component;
import viapos.model.Transaction;
import viapos.util.Constants;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionService extends BaseService {

    public List<Transaction> authorizeTransactions(List<Transaction> transactions, String processor, String merchantId) {
        List<Transaction> transactionResults = new ArrayList<>();
        if (Constants.CARDCONNECT_NAME.equalsIgnoreCase(processor)) {
            for (Transaction transaction : transactions) {
                transactionResults.add(this.cardConnectService.authorizeTransaction(transaction, merchantId));
            }
        } else {
            for (Transaction transaction : transactions) {
                transactionResults.add(this.cloverService.createCharge(transaction));
            }
        }
        return transactionResults;
    }

    public List<Transaction> refundTransactions(List<Transaction> transactions) {
        return new ArrayList<Transaction>();
    }
}
