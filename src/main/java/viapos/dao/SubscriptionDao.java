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
import viapos.model.Subscription;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;
import static java.util.Collections.singletonList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Component
public class SubscriptionDao extends BaseDao {
    String collectionName = "subscriptions";
    String databaseName = "ViaposCluster";

    @Autowired
    public SubscriptionDao() {
        super();
    }

    public boolean updateSubscription(Subscription subscription) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Subscription> subscriptionCollection = db.getCollection(collectionName, Subscription.class);

            Document filterByGradeId = new Document("_id", subscription.getId());
            FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
            Subscription updatedSubscriptions = subscriptionCollection.findOneAndReplace(filterByGradeId, subscription, returnDocAfterReplace);
        }
        return true;
    }

    public ArrayList<Subscription> getSubscriptions() {
        ArrayList<Subscription> subscriptions = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Subscription> subscriptionCollection = db.getCollection(collectionName, Subscription.class);

            MongoCursor<Subscription> cursor = subscriptionCollection.find().iterator();
            try {
                while (cursor.hasNext()) {
                    subscriptions.add(cursor.next());
                }
            } finally {
                cursor.close();
            }
        }
        return subscriptions;
    }

    public Subscription getSubscription(String id) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Subscription> subscriptionCollection = db.getCollection(collectionName, Subscription.class);

            Document idQuery = new Document("_id", id);

            MongoCursor<Subscription> cursor = subscriptionCollection.find(idQuery).iterator();
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

    public boolean createSubscription(Subscription subscription) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Subscription> subscriptionCollection = db.getCollection(collectionName, Subscription.class);

            subscriptionCollection.insertOne(subscription);
        }
        return true;
    }

    public boolean deleteSubscription(Subscription subscription) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Subscription> subscriptionCollection = db.getCollection(collectionName, Subscription.class);

            Document subscriptionId = new Document("_id", subscription.getId());
            subscriptionCollection.deleteOne(subscriptionId);
        }
        return true;
    }
}
