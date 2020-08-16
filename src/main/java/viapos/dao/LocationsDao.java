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

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;
import static java.util.Collections.singletonList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Component
public class LocationsDao extends BaseDao {
    String collectionName = "locations";
    String databaseName = "ViaposCluster";

    @Autowired
    public LocationsDao() {
        super();
    }

    public boolean updateLocations(Location location) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Location> locationsCollection = db.getCollection(collectionName, Location.class);

            Document filterByGradeId = new Document("_id", location.getId());
            FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
            Location updatedLocation = locationsCollection.findOneAndReplace(filterByGradeId, location, returnDocAfterReplace);
        }
        return true;
    }

    public ArrayList<Location> getLocations() {
        ArrayList<Location> locations = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Location> locationsCollection = db.getCollection(collectionName, Location.class);

            MongoCursor<Location> cursor = locationsCollection.find().iterator();
            try {
                while (cursor.hasNext()) {
                    locations.add(cursor.next());
                }
            } finally {
                cursor.close();
            }
        }
        return locations;
    }

    public boolean createLocations(Location location) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Location> locationsCollection = db.getCollection(collectionName, Location.class);

            locationsCollection.insertOne(location);
        }
        return true;
    }

    public boolean deleteLocations(Location location) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Location> locationsCollection = db.getCollection(collectionName, Location.class);

            Document locationId = new Document("_id", location.getId());
            locationsCollection.deleteOne(locationId);
        }
        return true;
    }
}
