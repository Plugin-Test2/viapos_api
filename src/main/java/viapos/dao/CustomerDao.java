package viapos.dao;

import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.model.Customer;
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

import static com.mongodb.client.model.Filters.eq;
import static java.util.Collections.singletonList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Component
public class CustomerDao extends BaseDao {
    String collectionName = "customers";
    String databaseName = "ViaposCluster";

    @Autowired
    public CustomerDao() {
        super();
    }

    public boolean updateCustomer(Customer customer) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Customer> customerCollection = db.getCollection(collectionName, Customer.class);

            Document filterByGradeId = new Document("_id", customer.getId());
            FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
            Customer updatedCustomer = customerCollection.findOneAndReplace(filterByGradeId, customer, returnDocAfterReplace);
        }
        return true;
    }

    public ArrayList<Customer> getCustomers() {
        ArrayList<Customer> customer = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Customer> customerCollection = db.getCollection(collectionName, Customer.class);

            MongoCursor<Customer> cursor = customerCollection.find().iterator();
            try {
                while (cursor.hasNext()) {
                    customer.add(cursor.next());
                }
            } finally {
                cursor.close();
            }
        }
        return customer;
    }

    public boolean createCustomer(Customer customer) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Customer> customerCollection = db.getCollection(collectionName, Customer.class);

            customerCollection.insertOne(customer);
        }
        return true;
    }

    public boolean deleteCustomer(Customer customer) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Customer> customerCollection = db.getCollection(collectionName, Customer.class);

            Document customerId = new Document("_id", customer.getId());
            customerCollection.deleteOne(customerId);
        }
        return true;
    }
}
