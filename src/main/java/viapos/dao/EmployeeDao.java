package viapos.dao;

import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.model.Employee;
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
public class EmployeeDao extends BaseDao {
    String collectionName = "employees";
    String databaseName = "ViaposCluster";

    @Autowired
    public EmployeeDao() {
        super();
    }

    public boolean updateEmployee(Employee employee) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Employee> employeeCollection = db.getCollection(collectionName, Employee.class);

            Document filterByGradeId = new Document("_id", employee.getId());
            FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
            Employee updatedEmployee = employeeCollection.findOneAndReplace(filterByGradeId, employee, returnDocAfterReplace);
        }
        return true;
    }

    public ArrayList<Employee> getEmployees() {
        ArrayList<Employee> employee = new ArrayList<>();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Employee> employeeCollection = db.getCollection(collectionName, Employee.class);

            MongoCursor<Employee> cursor = employeeCollection.find().iterator();
            try {
                while (cursor.hasNext()) {
                    employee.add(cursor.next());
                }
            } finally {
                cursor.close();
            }
        }
        return employee;
    }

    public boolean createEmployee(Employee employee) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Employee> employeeCollection = db.getCollection(collectionName, Employee.class);

            employeeCollection.insertOne(employee);
        }
        return true;
    }

    public boolean deleteEmployee(Employee employee) {
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase(databaseName);
            MongoCollection<Employee> employeeCollection = db.getCollection(collectionName, Employee.class);

            Document employeeId = new Document("_id", employee.getId());
            employeeCollection.deleteOne(employeeId);
        }
        return true;
    }
}
