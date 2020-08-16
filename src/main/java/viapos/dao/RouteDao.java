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
import viapos.model.Route;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;
import static java.util.Collections.singletonList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Component
public class RouteDao extends BaseDao {
    String collectionName = "routes";
    String databaseName = "ViaposCluster";

    @Autowired
    public RouteDao() {
        super();
    }

    public boolean updateRoute(Route route) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Route> routeCollections = db.getCollection(collectionName, Route.class);

            Document filterByGradeId = new Document("_id", route.getId());
            FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
            Route updatedRoute = routeCollections.findOneAndReplace(filterByGradeId, route, returnDocAfterReplace);
        }
        return true;
    }

    public ArrayList<Route> getRoutes() {
        ArrayList<Route> routes = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Route> routesCollection = db.getCollection(collectionName, Route.class);

            MongoCursor<Route> cursor = routesCollection.find().iterator();
            try {
                while (cursor.hasNext()) {
                    routes.add(cursor.next());
                }
            } finally {
                cursor.close();
            }
        }
        return routes;
    }

    public boolean createRoutes(Route route) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Route> routesCollection = db.getCollection(collectionName, Route.class);

            routesCollection.insertOne(route);
        }
        return true;
    }

    public boolean deleteRoute(Route route) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Route> routeCollection = db.getCollection(collectionName, Route.class);

            Document routeId = new Document("_id", route.getId());
            routeCollection.deleteOne(routeId);
        }
        return true;
    }
}
