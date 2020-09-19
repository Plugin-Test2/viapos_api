package viapos.dao;

import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.model.Distribution;
import viapos.model.Event;
import viapos.model.Location;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
            whereQuery.put("locationId", new BasicDBObject("$in", resources));

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

    public ArrayList<Event> getEvents(LocalDate date) {
        ArrayList<Event> events = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Event> eventCollection = db.getCollection(collectionName, Event.class);

            int dayInt = date.getDayOfWeek().getValue();
            if (dayInt == 7) {
                dayInt = 0;
            }
            String day = Integer.toString(dayInt);

            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("start", new BasicDBObject("$lte", date));
            whereQuery.put("end", new BasicDBObject("$gte", date));
            whereQuery.put("daysOfWeek", day);

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

    public ArrayList<Event> getEvents(LocalDate start, LocalDate end, List<String> resources) {
        return getEvents(start, end, resources, null);
    }

    public ArrayList<Event> getEvents(LocalDate start, LocalDate end, List<String> resources, List<String> shiftTypes) {
        ArrayList<Event> events = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Event> eventCollection = db.getCollection(collectionName, Event.class);

            System.out.println("parsing... " + start + " " + end);

            BasicDBObject query = new BasicDBObject();
            BasicDBObject totalQuery = new BasicDBObject();
            try {
                DBObject clause1 = new BasicDBObject("start", new BasicDBObject("$lte", end));
                DBObject clause2 = new BasicDBObject("end", new BasicDBObject("$gte", start));
                BasicDBList or = new BasicDBList();
                or.add(clause1);
                or.add(clause2);
                query = new BasicDBObject("$or", or);

                BasicDBObject inQuery = new BasicDBObject();
                if (resources != null) {
                    inQuery.put("locationId", new BasicDBObject("$in", resources));
                }
                if (shiftTypes != null) {
                    inQuery.put("shiftType", new BasicDBObject("$in", shiftTypes));
                }
                BasicDBList and = new BasicDBList();
                and.add(query);
                and.add(inQuery);

                totalQuery = new BasicDBObject("$and", and);
            } catch (Exception e) {
                System.out.println("Issue parsing date in get events");
            }
            // whereQuery.put("locationId", new BasicDBObject("$in", resources));
//            whereQuery.put("start", new BasicDBObject("$gte", start));
//            whereQuery.put("end", new BasicDBObject("$lte", end));

            MongoCursor<Event> cursor = eventCollection.find(totalQuery).iterator();
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
