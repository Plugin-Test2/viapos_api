package viapos.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.model.Distribution;
import viapos.model.Event;
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
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static java.util.Collections.singletonList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Component
public class EventDao extends BaseDao {
    String collectionName = "events";
    String databaseName = "ViaposCluster";

    @Autowired
    public EventDao() {
        super();
    }

    public boolean updateEvents(Event event) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Event> eventCollection = db.getCollection(collectionName, Event.class);

            Document filterByGradeId = new Document("_id", event.getId());
            FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
            Event updatedEvents = eventCollection.findOneAndReplace(filterByGradeId, event, returnDocAfterReplace);
        }
        return true;
    }

    public ArrayList<Event> getEvents() {
        ArrayList<Event> events = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Event> eventCollection = db.getCollection(collectionName, Event.class);

            MongoCursor<Event> cursor = eventCollection.find().iterator();
            try {
                while (cursor.hasNext()) {
                    events.add(cursor.next());
                }
            } finally {
                cursor.close();
            }
        }
        return events;
    }

    public ArrayList<Event> getEvents(String dayOfWeek, List<String> resources) {
        ArrayList<Event> events = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Event> eventCollection = db.getCollection(collectionName, Event.class);

            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("daysOfWeek", dayOfWeek);

            MongoCursor<Event> cursor = eventCollection.find(whereQuery).iterator();
            try {
                while (cursor.hasNext()) {
                    events.add(cursor.next());
                }
            } finally {
                cursor.close();
            }
        }
        return events;
    }

    public boolean createEvent(Event event) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Event> eventCollection = db.getCollection(collectionName, Event.class);

            eventCollection.insertOne(event);
        }
        return true;
    }

    public boolean deleteEvent(Event event) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Event> eventCollection = db.getCollection(collectionName, Event.class);

            Document distributionId = new Document("_id", event.getId());
            eventCollection.deleteOne(distributionId);
        }
        return true;
    }
}
