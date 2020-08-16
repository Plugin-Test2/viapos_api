package viapos.dao;

import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.model.Location;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import viapos.model.RoutePlan;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;
import static java.util.Collections.singletonList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Component
public class RoutePlanDao extends BaseDao {
    String collectionName = "routeplans";
    String databaseName = "ViaposCluster";

    @Autowired
    public RoutePlanDao() {
        super();
    }

    public boolean updateRoutePlan(RoutePlan routePlan) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<RoutePlan> routePlanCollection = db.getCollection(collectionName, RoutePlan.class);

            Document filterByGradeId = new Document("_id", routePlan.getId());
            FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
            RoutePlan updatedRoutePlan = routePlanCollection.findOneAndReplace(filterByGradeId, routePlan, returnDocAfterReplace);
        }
        return true;
    }

    public ArrayList<RoutePlan> getRoutePlans() {
        ArrayList<RoutePlan> routePlan = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<RoutePlan> routePlanCollection = db.getCollection(collectionName, RoutePlan.class);

            MongoCursor<RoutePlan> cursor = routePlanCollection.find().iterator();
            try {
                while (cursor.hasNext()) {
                    routePlan.add(cursor.next());
                }
            } finally {
                cursor.close();
            }
        }
        return routePlan;
    }

    public boolean createRoutePlan(RoutePlan routePlan) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<RoutePlan> routePlanCollection = db.getCollection(collectionName, RoutePlan.class);

            routePlanCollection.insertOne(routePlan);
        }
        return true;
    }

    public boolean deleteRoutePlan(RoutePlan routePlan) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<RoutePlan> locationsCollection = db.getCollection(collectionName, RoutePlan.class);

            Document routePlanId = new Document("_id", routePlan.getId());
            locationsCollection.deleteOne(routePlanId);
        }
        return true;
    }
}
