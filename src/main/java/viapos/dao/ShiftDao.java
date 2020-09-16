package viapos.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.client.*;
import jdk.vm.ci.meta.Local;
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

    public ArrayList<Shift> getUnassignedShifts(List<Event> events, String dateStr) {
        ArrayList<Shift> unassignedShifts = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Shift> shiftCollection = db.getCollection(collectionName, Shift.class);

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            Date date = formatter.parse(dateStr);

            for (Event event:events) {
                if (event.getMinEmployeeNbr() != null && Integer.parseInt(event.getMinEmployeeNbr()) > 0) {
                    BasicDBObject eventQuery = new BasicDBObject();
                    eventQuery.put("eventId", event.getId());
                    eventQuery.put("date", date);
                    long count = shiftCollection.count(eventQuery);
                    for (int i = 0; i < (Integer.parseInt(event.getMinEmployeeNbr()) - count); i++) {
                        // Shift newShift = new Shift(event, date);
                        // unassignedShifts.add(newShift);
                    }
                }
            }

        } catch (Exception e) {

        }
        return unassignedShifts;
    }

    public ArrayList<Shift> getUnassignedShifts(List<Event> events, String start, String end) {
        ArrayList<Shift> unassignedShifts = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Shift> shiftCollection = db.getCollection(collectionName, Shift.class);

            LocalDate startDate = LocalDate.parse(start);
            LocalDate endDate = LocalDate.parse(end);

            for (Event event:events) {
                BasicDBObject eventQuery = new BasicDBObject();
                eventQuery.put("eventId", event.getId());
                if (event.getReoccurence() == null) {
                    long count = shiftCollection.count(eventQuery);
                } else if (event.getDaysOfWeek() != null && event.getDaysOfWeek().size() > 0){
                    for (String day:event.getDaysOfWeek()) {
                        int mappedDay = startDate.getDayOfWeek().getValue();
                        if (mappedDay == 7) {
                            mappedDay = 0;
                        }
                        int dayDifference = Integer.parseInt(day) - mappedDay;
                        LocalDate eventDate = LocalDate.now();
                        if (dayDifference >= 0) {
                            eventDate = startDate.plusDays(dayDifference);
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
}
