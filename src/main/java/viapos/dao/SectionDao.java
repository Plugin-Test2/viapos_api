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
import viapos.model.Section;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;
import static java.util.Collections.singletonList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Component
public class SectionDao extends BaseDao {
    String collectionName = "sections";
    String databaseName = "ViaposCluster";

    @Autowired
    public SectionDao() {
        super();
    }

    public boolean updateSection(Section section) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Section> sectionCollection = db.getCollection(collectionName, Section.class);

            Document filterByGradeId = new Document("_id", section.getId());
            FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
            Section updatedSection = sectionCollection.findOneAndReplace(filterByGradeId, section, returnDocAfterReplace);
        }
        return true;
    }

    public ArrayList<Section> getSections() {
        ArrayList<Section> sections = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Section> sectionCollection = db.getCollection(collectionName, Section.class);

            MongoCursor<Section> cursor = sectionCollection.find().iterator();
            try {
                while (cursor.hasNext()) {
                    sections.add(cursor.next());
                }
            } finally {
                cursor.close();
            }
        }
        return sections;
    }

    public boolean createSection(Section section) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Section> sectionCollection = db.getCollection(collectionName, Section.class);

            sectionCollection.insertOne(section);
        }
        return true;
    }

    public boolean deleteSection(Section section) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Section> sectionCollection = db.getCollection(collectionName, Section.class);

            Document locationId = new Document("_id", section.getId());
            sectionCollection.deleteOne(locationId);
        }
        return true;
    }
}
