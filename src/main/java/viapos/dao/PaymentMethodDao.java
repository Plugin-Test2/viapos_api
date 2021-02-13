package viapos.dao;

import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.model.PaymentMethod;
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
public class PaymentMethodDao extends BaseDao {
    String collectionName = "paymentMethods";
    String databaseName = "ViaposCluster";

    @Autowired
    public PaymentMethodDao() {
        super();
    }

    public boolean updatePaymentMethods(PaymentMethod paymentMethod) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<PaymentMethod> paymentMethodCollection = db.getCollection(collectionName, PaymentMethod.class);

            Document filterByGradeId = new Document("_id", paymentMethod.getId());
            FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
            PaymentMethod updatedPaymentMethods = paymentMethodCollection.findOneAndReplace(filterByGradeId, paymentMethod, returnDocAfterReplace);
        }
        return true;
    }

    public ArrayList<PaymentMethod> getCustomersPaymentMethods(String customerId) {
        ArrayList<PaymentMethod> paymentMethods = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<PaymentMethod> paymentMethodCollection = db.getCollection(collectionName, PaymentMethod.class);

            Document idQuery = new Document("customerId", customerId);

            MongoCursor<PaymentMethod> cursor = paymentMethodCollection.find(idQuery).iterator();
            try {
                while (cursor.hasNext()) {
                    paymentMethods.add(cursor.next());
                }
            } finally {
                cursor.close();
            }
        }
        return paymentMethods;
    }

    public PaymentMethod getPaymentMethod(String id) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<PaymentMethod> paymentMethodCollection = db.getCollection(collectionName, PaymentMethod.class);

            Document idQuery = new Document("_id", id);

            MongoCursor<PaymentMethod> cursor = paymentMethodCollection.find(idQuery).iterator();
            try {
                if (cursor.hasNext()) {
                    return cursor.next();
                }
            } finally {
                cursor.close();
            }
        }
        return null;
    }

    public boolean createPaymentMethod(PaymentMethod paymentMethod) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<PaymentMethod> paymentMethodCollection = db.getCollection(collectionName, PaymentMethod.class);

            paymentMethodCollection.insertOne(paymentMethod);
        }
        return true;
    }

    public boolean deletePaymentMethod(PaymentMethod paymentMethod) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<PaymentMethod> paymentMethodCollection = db.getCollection(collectionName, PaymentMethod.class);

            Document paymentMethodId = new Document("_id", paymentMethod.getId());
            paymentMethodCollection.deleteOne(paymentMethodId);
        }
        return true;
    }
}
