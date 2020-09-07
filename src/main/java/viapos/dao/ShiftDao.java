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
import viapos.model.Shift;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static java.util.Collections.singletonList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Component
public class ShiftDao extends BaseDao {
    String collectionName = "shifts";
    String databaseName = "ViaposCluster";

    @Autowired
    public ShiftDao() {
        super();
    }

    public boolean updateShifts(Shift shift) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Shift> shiftCollection = db.getCollection(collectionName, Shift.class);

            Document filterByGradeId = new Document("_id", shift.getId());
            FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
            Shift updatedShifts = shiftCollection.findOneAndReplace(filterByGradeId, shift, returnDocAfterReplace);
        }
        return true;
    }

    public ArrayList<Shift> getShifts() {
        ArrayList<Shift> shifts = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Shift> shiftCollection = db.getCollection(collectionName, Shift.class);

            MongoCursor<Shift> cursor = shiftCollection.find().iterator();
            try {
                while (cursor.hasNext()) {
                    shifts.add(cursor.next());
                }
            } finally {
                cursor.close();
            }
        }
        return shifts;
    }

    public boolean createShifts(Shift shift) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Shift> shiftCollection = db.getCollection(collectionName, Shift.class);

            shiftCollection.insertOne(shift);
        }
        return true;
    }

    public boolean deleteShift(Shift shift) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Shift> shiftCollection = db.getCollection(collectionName, Shift.class);

            Document shiftId = new Document("_id", shift.getId());
            shiftCollection.deleteOne(shiftId);
        }
        return true;
    }

    public ArrayList<Shift> getUnassignedShifts(List<Event> events, String date) {
        ArrayList<Shift> unassignedShifts = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Shift> shiftCollection = db.getCollection(collectionName, Shift.class);

            for (Event event:events) {
                if (event.getMinEmployeeNbr() != null && Integer.parseInt(event.getMinEmployeeNbr()) > 0) {
                    BasicDBObject eventQuery = new BasicDBObject();
                    eventQuery.put("eventId", event.getId());
                    eventQuery.put("date", date);
                    long count = shiftCollection.count(eventQuery);
                    for (int i = 0; i < (Integer.parseInt(event.getMinEmployeeNbr()) - count); i++) {
                        Shift newShift = new Shift(event);
                        unassignedShifts.add(newShift);
                    }
                }
            }

        }
        return unassignedShifts;
    }
}
