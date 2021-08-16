package viapos.dao;

import com.mongodb.client.*;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.model.Organization;

import java.util.ArrayList;

@Component
public class OrganizationDao extends BaseDao {
    String collectionName = "organizations";
    String databaseName = "ViaposCluster";

    @Autowired
    public OrganizationDao() {
        super();
    }

    public boolean updateOrganization(Organization organization) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Organization> organizationCollection = db.getCollection(collectionName, Organization.class);

            Document filterByGradeId = new Document("_id", organization.getId());
            FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
            Organization updatedOrganization = organizationCollection.findOneAndReplace(filterByGradeId, organization, returnDocAfterReplace);
        }
        return true;
    }

    public ArrayList<Organization> getOrganizations() {
        ArrayList<Organization> organizations = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Organization> organizationCollection = db.getCollection(collectionName, Organization.class);

            MongoCursor<Organization> cursor = organizationCollection.find().iterator();
            try {
                while (cursor.hasNext()) {
                    organizations.add(cursor.next());
                }
            } finally {
                cursor.close();
            }
        }
        return organizations;
    }

    public Organization getOrganization(String id) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Organization> organizationCollection = db.getCollection(collectionName, Organization.class);

            Document idQuery = new Document("_id", id);

            MongoCursor<Organization> cursor = organizationCollection.find(idQuery).iterator();
            try {
                if (cursor.hasNext()) {
                    return cursor.next();
                }
            } finally {
                cursor.close();
            }
        }
        return null;
    }

    public boolean createOrganization(Organization organization) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Organization> organizationCollectiom = db.getCollection(collectionName, Organization.class);

            organizationCollectiom.insertOne(organization);
        }
        return true;
    }

    public boolean deleteOrganization(Organization organization) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Organization> organizationCollection = db.getCollection(collectionName, Organization.class);

            Document organizationId = new Document("_id", organization.getId());
            organizationCollection.deleteOne(organizationId);
        }
        return true;
    }
}
