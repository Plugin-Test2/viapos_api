package viapos.dao;

import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import jdk.vm.ci.meta.Local;
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
import viapos.model.Shift;

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
public class ShiftDao extends BaseDao {
    String collectionName = "shifts";
    String databaseName = "ViaposCluster";

    private long oneDay = 1;

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

            MongoCursor<Shift> cursor  = shiftCollection.find().iterator();
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

    public ArrayList<Shift> getShifts(LocalDate date) {
        ArrayList<Shift> shifts = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Shift> shiftCollection = db.getCollection(collectionName, Shift.class);

            BasicDBObject eventQuery = new BasicDBObject();
            eventQuery.put("start", new BasicDBObject("$gte", date));
            eventQuery.put("end", new BasicDBObject("$lte", date.plusDays(this.oneDay)));

            MongoCursor<Shift> cursor  = shiftCollection.find(eventQuery).iterator();
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
    public ArrayList<Shift> getShifts(LocalDate start, LocalDate end, List<String> events) {
        ArrayList<Shift> shifts = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Shift> shiftCollection = db.getCollection(collectionName, Shift.class);

            BasicDBObject query = new BasicDBObject();
            BasicDBList startQuery = new BasicDBList();
            DBObject startClause1 = new BasicDBObject("start", new BasicDBObject("$lte", end));
            DBObject startClause2 = new BasicDBObject("start", new BasicDBObject("$gte", start));
            startQuery.add(startClause1);
            startQuery.add(startClause2);
            BasicDBObject startAndQuery = new BasicDBObject("$and", startQuery);

            BasicDBList endQuery = new BasicDBList();
            DBObject endClause1 = new BasicDBObject("end", new BasicDBObject("$lte", end));
            DBObject endClause2 = new BasicDBObject("end", new BasicDBObject("$gte", start));
            endQuery.add(endClause1);
            endQuery.add(endClause2);
            BasicDBObject endAndQuery = new BasicDBObject("$and", endQuery);

            BasicDBList or = new BasicDBList();
            or.add(startAndQuery);
            or.add(endAndQuery);
            query = new BasicDBObject("$or", or);

            BasicDBObject inQuery = new BasicDBObject();
            if (events != null) {
                inQuery.put("eventId", new BasicDBObject("$in", events));
            }

            BasicDBList and = new BasicDBList();
            and.add(query);
            and.add(inQuery);

            BasicDBObject totalQuery = new BasicDBObject("$and", and);

            MongoCursor<Shift> cursor  = shiftCollection.find(totalQuery).iterator();
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

    public ArrayList<Shift> getUnassignedShifts(List<Event> events, LocalDate date) {
        ArrayList<Shift> unassignedShifts = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Shift> shiftCollection = db.getCollection(collectionName, Shift.class);

            for (Event event:events) {
                if (event.getMinEmployeeNbr() != null && Integer.parseInt(event.getMinEmployeeNbr()) > 0) {
                    BasicDBObject eventQuery = new BasicDBObject();
                    eventQuery.put("eventId", event.getId());
                    eventQuery.put("start", new BasicDBObject("$gte", date));
                    eventQuery.put("end", new BasicDBObject("$lte", date.plusDays(this.oneDay)));
                    long count = shiftCollection.count(eventQuery);
                    for (int i = 0; i < (Integer.parseInt(event.getMinEmployeeNbr()) - count); i++) {
                        Shift newShift = new Shift(event, date);
                        unassignedShifts.add(newShift);
                    }
                }
            }

        } catch (Exception e) {

        }
        return unassignedShifts;
    }

    public ArrayList<Shift> getUnassignedShifts(List<Event> events, LocalDate start, LocalDate end) {
        ArrayList<Shift> unassignedShifts = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Shift> shiftCollection = db.getCollection(collectionName, Shift.class);


            for (Event event:events) {
                BasicDBObject eventQuery = new BasicDBObject();
                eventQuery.put("eventId", event.getId());
                if (event.getReoccurence() == null) {
                    long count = shiftCollection.count(eventQuery);
                } else if (event.getDaysOfWeek() != null && event.getDaysOfWeek().size() > 0){
                    for (String day:event.getDaysOfWeek()) {
                        int mappedDay = start.getDayOfWeek().getValue();
                        if (mappedDay == 7) {
                            mappedDay = 0;
                        }
                        int dayDifference = Integer.parseInt(day) - mappedDay;
                        LocalDate eventDate = LocalDate.now();
                        if (dayDifference >= 0) {
                            eventDate = start.plusDays(dayDifference);
                            eventQuery.put("start", new BasicDBObject("$gte", eventDate));
                            eventQuery.put("end", new BasicDBObject("$lte", eventDate.plusDays(this.oneDay)));
                            long count = shiftCollection.count(eventQuery);
                            int shiftsNeeded = 0;
                            if (event.getMinEmployeeNbr() != null) {
                                shiftsNeeded = Integer.parseInt(event.getMinEmployeeNbr());
                            }
                            for (int i = 0; i < (shiftsNeeded - count); i++) {
                                Shift newShift = new Shift(event, eventDate);
                                unassignedShifts.add(newShift);
                            }
                        }
                    }
                }
            }


        } catch (Exception e) {

        }
        return unassignedShifts;
    }

    public ArrayList<Shift> getShiftsByIds(List<String> shiftIds) {
        ArrayList<Shift> shifts = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Shift> shiftCollection = db.getCollection(collectionName, Shift.class);

            BasicDBObject eventQuery = new BasicDBObject();
            eventQuery.put("_id", new BasicDBObject("$in", shiftIds));

            MongoCursor<Shift> cursor  = shiftCollection.find(eventQuery).iterator();
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
}
