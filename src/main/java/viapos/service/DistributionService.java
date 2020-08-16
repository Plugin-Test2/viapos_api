package viapos.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.dao.DistributionDao;
import viapos.dao.LocationsDao;
import viapos.model.Distribution;
import viapos.model.Location;

import java.util.ArrayList;
import java.util.List;

@Component
public class DistributionService {

    @Autowired
    DistributionDao distributionDao;

    public boolean updateDistributions(List<Distribution> distributions) {
        for (Distribution distribution : distributions) {
            distributionDao.updateDistributions(distribution);
        }
        return true;
    }

    public ArrayList<Distribution> getDistributions() {
        return distributionDao.getDistributions();
    }

    public boolean createDistributions(List<Distribution> distributions) {
        for (Distribution distribution : distributions) {
            distributionDao.createDistributions(distribution);
        }
        return true;
    }

    public boolean deleteDistributions(List<Distribution> distributions) {
        for (Distribution distribution : distributions) {
            distributionDao.deleteDistribution(distribution);
        }
        return true;
    }
}
