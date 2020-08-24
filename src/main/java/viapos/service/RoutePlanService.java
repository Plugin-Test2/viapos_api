package viapos.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.dao.LocationsDao;
import viapos.dao.RoutePlanDao;
import viapos.model.Location;
import viapos.model.RoutePlan;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class RoutePlanService {

    @Autowired
    RoutePlanDao routePlanDao;

    public boolean updateRoutePlans(List<RoutePlan> routePlans) {
        for (RoutePlan routePlan : routePlans) {
            routePlanDao.updateRoutePlan(routePlan);
        }
        return true;
    }

    public ArrayList<RoutePlan> getRoutePlans() {
        return routePlanDao.getRoutePlans();
    }

    public boolean createRoutePlans(List<RoutePlan> routePlans) {
        for (RoutePlan routePlan : routePlans) {
            routePlan.setId(UUID.randomUUID().toString());
            routePlanDao.createRoutePlan(routePlan);
        }
        return true;
    }

    public boolean deleteRoutePlans(List<RoutePlan> routePlans) {
        for (RoutePlan routePlan : routePlans) {
            routePlanDao.deleteRoutePlan(routePlan);
        }
        return true;
    }
}
