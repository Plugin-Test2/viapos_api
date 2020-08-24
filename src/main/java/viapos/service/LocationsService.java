package viapos.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.dao.LocationsDao;
import viapos.model.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class LocationsService {

    @Autowired
    LocationsDao locationsDao;

    public boolean updateLocations(List<Location> locations) {
        for (Location location : locations) {
            locationsDao.updateLocations(location);
        }
        return true;
    }

    public ArrayList<Location> getLocations() {
        return locationsDao.getLocations();
    }

    public boolean createLocations(List<Location> locations) {
        for (Location location : locations) {
            if (location.getId() == null || location.getId().toString().isEmpty()) {
                location.setId(new ObjectId(UUID.randomUUID().toString()));
                System.out.println("Setting id to: " + location.getId());
            } else {
                System.out.println("Do something crazy");
                location.setId(new ObjectId(UUID.randomUUID().toString()));
            }
            locationsDao.createLocations(location);
        }
        return true;
    }

    public boolean deleteLocations(List<Location> locations) {
        for (Location location : locations) {
            locationsDao.deleteLocations(location);
        }
        return true;
    }
}
