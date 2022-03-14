package viapos.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.model.*;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
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
public class ShiftTypeDao extends BaseDao {
    String collectionName = "shiftTypes";
    String databaseName = "ViaposCluster";

    private long oneDay = 1;

    @Autowired
    public ShiftTypeDao() {
        super();
    }

    public boolean updateShiftTypes(ShiftType shiftType) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<ShiftType> shiftCollection = db.getCollection(collectionName, ShiftType.class);

            Document filterByGradeId = new Document("_id", shiftType.getId());
            FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
            ShiftType updatedShiftTypes = shiftCollection.findOneAndReplace(filterByGradeId, shiftType, returnDocAfterReplace);
        }
        return true;
    }

    public ArrayList<ShiftType> getShiftTypes() {
        ArrayList<ShiftType> shiftTypes = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<ShiftType> shiftCollection = db.getCollection(collectionName, ShiftType.class);

            MongoCursor<ShiftType> cursor  = shiftCollection.find().iterator();
            try {
                while (cursor.hasNext()) {
                    shiftTypes.add(cursor.next());
                }
            } finally {
                cursor.close();
            }
        }
        return shiftTypes;
    }

    public boolean createShiftTypes(ShiftType shiftType) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<ShiftType> shiftCollection = db.getCollection(collectionName, ShiftType.class);

            shiftCollection.insertOne(shiftType);
        }
        return true;
    }

    public boolean deleteShiftType(ShiftType shiftType) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<ShiftType> shiftCollection = db.getCollection(collectionName, ShiftType.class);

            Document shiftId = new Document("_id", shiftType.getId());
            shiftCollection.deleteOne(shiftId);
        }
        return true;
    }

}
