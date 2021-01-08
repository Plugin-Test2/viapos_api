package viapos.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.dao.LocationsDao;
import viapos.dao.RouteDao;
import viapos.model.Location;
import viapos.model.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class RouteService extends BaseService {

    @Autowired
    RouteDao routeDao;

    public boolean updateRoutes(List<Route> routes) {
        for (Route route : routes) {
            routeDao.updateRoute(route);
        }
        return true;
    }

    public ArrayList<Route> getRoutes() {
        return routeDao.getRoutes();
    }

    public boolean createRoutes(List<Route> routes) {
        for (Route route : routes) {
            route.setNumber(UUID.randomUUID().toString());
            routeDao.createRoutes(route);
        }
        return true;
    }

    public boolean deleteRoutes(List<Route> routes) {
        for (Route route : routes) {
            routeDao.deleteRoute(route);
        }
        return true;
    }
}
