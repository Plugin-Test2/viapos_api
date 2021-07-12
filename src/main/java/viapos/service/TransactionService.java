package viapos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.dao.TransactionDao;
import viapos.model.Location;
import viapos.model.Transaction;
import viapos.util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class TransactionService extends BaseService {

    @Autowired
    TransactionDao transactionDao;

    public List<Transaction> authorizeTransactions(List<Transaction> transactions, String processor, String merchantId) {
        List<Transaction> transactionResults = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (Constants.CARDCONNECT_NAME.equalsIgnoreCase(processor)) {
                transactionResults.add(this.cardConnectService.authorizeTransaction(transaction, merchantId));
            } else {
                transactionResults.add(this.cloverService.createCharge(transaction));
            }
            List<Transaction> updateList = new ArrayList<>();
            updateList.add(transaction);
            if (transaction.getId() != null && !transaction.getId().isEmpty()) {
                createTransactions(updateList);
            } else {
                updateTransactions(updateList);
            }
        }
        return transactionResults;
    }

    public List<Transaction> refundTransactions(List<Transaction> transactions) {
        return new ArrayList<Transaction>();
    }

    public boolean updateTransactions(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            transactionDao.updateTransactions(transaction);
        }
        return true;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactionDao.getTransactions();
    }

    public Transaction getTransaction(String transactionId) {
        return transactionDao.getTransaction(transactionId);
    }

    public boolean createTransactions(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            transaction.setId(UUID.randomUUID().toString());
            transactionDao.createTransactions(transaction);
        }
        return true;
    }

    public boolean deleteTransactions(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            transactionDao.deleteTransactions(transaction);
        }
        return true;
    }
}
