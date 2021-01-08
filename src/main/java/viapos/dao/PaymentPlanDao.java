package viapos.dao;

import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.model.Distribution;
import viapos.model.Location;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import viapos.model.PaymentPlan;
import viapos.model.Subscription;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;
import static java.util.Collections.singletonList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Component
public class PaymentPlanDao extends BaseDao {
    String collectionName = "paymentPlans";
    String databaseName = "ViaposCluster";

    @Autowired
    public PaymentPlanDao() {
        super();
    }

    public boolean updatePaymentPlans(PaymentPlan paymentPlan) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<PaymentPlan> paymentPlanCollection = db.getCollection(collectionName, PaymentPlan.class);

            Document filterByGradeId = new Document("_id", paymentPlan.getId());
            FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
            PaymentPlan updatedPaymentPlans = paymentPlanCollection.findOneAndReplace(filterByGradeId, paymentPlan, returnDocAfterReplace);
        }
        return true;
    }

    public ArrayList<PaymentPlan> getPaymentPlans() {
        ArrayList<PaymentPlan> paymentPlans = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<PaymentPlan> distributionCollection = db.getCollection(collectionName, PaymentPlan.class);

            MongoCursor<PaymentPlan> cursor = distributionCollection.find().iterator();
            try {
                while (cursor.hasNext()) {
                    paymentPlans.add(cursor.next());
                }
            } finally {
                cursor.close();
            }
        }
        return paymentPlans;
    }

    public PaymentPlan getPaymentPlan(String id) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<PaymentPlan> subscriptionCollection = db.getCollection(collectionName, PaymentPlan.class);

            Document idQuery = new Document("_id", id);

            MongoCursor<PaymentPlan> cursor = subscriptionCollection.find(idQuery).iterator();
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

    public boolean createPaymentPlans(PaymentPlan paymentPlan) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<PaymentPlan> paymentPlanCollection = db.getCollection(collectionName, PaymentPlan.class);

            paymentPlanCollection.insertOne(paymentPlan);
        }
        return true;
    }

    public boolean deletePaymentPlan(PaymentPlan paymentPlan) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<PaymentPlan> paymentPlanCollection = db.getCollection(collectionName, PaymentPlan.class);

            Document paymentPlanId = new Document("_id", paymentPlan.getId());
            paymentPlanCollection.deleteOne(paymentPlanId);
        }
        return true;
    }
}
