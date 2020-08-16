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

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;
import static java.util.Collections.singletonList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Component
public class DistributionDao extends BaseDao {
    String collectionName = "distributions";
    String databaseName = "ViaposCluster";

    @Autowired
    public DistributionDao() {
        super();
    }

    public boolean updateDistributions(Distribution distribution) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Distribution> distributionCollection = db.getCollection(collectionName, Distribution.class);

            Document filterByGradeId = new Document("_id", distribution.getId());
            FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
            Distribution updatedDistributions = distributionCollection.findOneAndReplace(filterByGradeId, distribution, returnDocAfterReplace);
        }
        return true;
    }

    public ArrayList<Distribution> getDistributions() {
        ArrayList<Distribution> distributions = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Distribution> distributionCollection = db.getCollection(collectionName, Distribution.class);

            MongoCursor<Distribution> cursor = distributionCollection.find().iterator();
            try {
                while (cursor.hasNext()) {
                    distributions.add(cursor.next());
                }
            } finally {
                cursor.close();
            }
        }
        return distributions;
    }

    public boolean createDistributions(Distribution distribution) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Distribution> distributionCollection = db.getCollection(collectionName, Distribution.class);

            distributionCollection.insertOne(distribution);
        }
        return true;
    }

    public boolean deleteDistribution(Distribution distribution) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Distribution> distributionCollection = db.getCollection(collectionName, Distribution.class);

            Document distributionId = new Document("_id", distribution.getId());
            distributionCollection.deleteOne(distributionId);
        }
        return true;
    }
}
