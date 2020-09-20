package viapos.dao;

import com.mongodb.BasicDBObject;
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
import viapos.model.Route;
import viapos.model.User;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;
import static java.util.Collections.singletonList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Component
public class UserDao extends BaseDao {
    String collectionName = "users";
    String databaseName = "ViaposCluster";

    @Autowired
    public UserDao() {
        super();
    }

    public boolean updateUser(User user) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<User> routeCollections = db.getCollection(collectionName, User.class);

            Document filterByGradeId = new Document("_id", user.getId());
            FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
            User updatedUser = routeCollections.findOneAndReplace(filterByGradeId, user, returnDocAfterReplace);
        }
        return true;
    }

    public User getUser(String username) {
        User user = new User();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<User> routesCollection = db.getCollection(collectionName, User.class);

            BasicDBObject query = new BasicDBObject("username", username);

            MongoCursor<User> cursor = routesCollection.find(query).iterator();
            try {
                while (cursor.hasNext()) {
                    user = cursor.next();
                }
            } finally {
                cursor.close();
            }
        }
        return user;
    }

    public boolean createUser(User user) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<User> routesCollection = db.getCollection(collectionName, User.class);

            routesCollection.insertOne(user);
        }
        return true;
    }

    public boolean deleteUser(User user) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<User> routeCollection = db.getCollection(collectionName, User.class);

            Document routeId = new Document("_id", user.getId());
            routeCollection.deleteOne(routeId);
        }
        return true;
    }
}
