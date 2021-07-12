package viapos.dao;

import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.model.Transaction;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;
import static java.util.Collections.singletonList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Component
public class TransactionDao extends BaseDao {
    String collectionName = "transactions";
    String databaseName = "ViaposCluster";

    @Autowired
    public TransactionDao() {
        super();
    }

    public boolean updateTransactions(Transaction transaction) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Transaction> transactionsCollection = db.getCollection(collectionName, Transaction.class);

            Document filterByGradeId = new Document("_id", transaction.getId());
            FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
            Transaction updatedTransactions = transactionsCollection.findOneAndReplace(filterByGradeId, transaction, returnDocAfterReplace);
        }
        return true;
    }

    public ArrayList<Transaction> getTransactions() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Transaction> transactionsCollection = db.getCollection(collectionName, Transaction.class);

            MongoCursor<Transaction> cursor = transactionsCollection.find().iterator();
            try {
                while (cursor.hasNext()) {
                    transactions.add(cursor.next());
                }
            } finally {
                cursor.close();
            }
        }
        return transactions;
    }

    public Transaction getTransaction(String transactionId) {
        return new Transaction();
    }

    public boolean createTransactions(Transaction transaction) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Transaction> transactionsCollection = db.getCollection(collectionName, Transaction.class);

            transactionsCollection.insertOne(transaction);
        }
        return true;
    }

    public boolean deleteTransactions(Transaction transaction) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Transaction> transactionsCollection = db.getCollection(collectionName, Transaction.class);

            Document transactionId = new Document("_id", transaction.getId());
            transactionsCollection.deleteOne(transactionId);
        }
        return true;
    }
}
