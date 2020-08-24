package viapos.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.dao.LocationsDao;
import viapos.dao.ShiftDao;
import viapos.model.Location;
import viapos.model.Shift;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ShiftService {

    @Autowired
    ShiftDao shiftDao;

    public boolean updateShifts(List<Shift> shifts) {
        for (Shift shift : shifts) {
            shiftDao.updateShifts(shift);
        }
        return true;
    }

    public ArrayList<Shift> getShifts() {
        return shiftDao.getShifts();
    }

    public boolean createShifts(List<Shift> shifts) {
        for (Shift shift : shifts) {
            shift.setId(UUID.randomUUID().toString());
            shiftDao.createShifts(shift);
        }
        return true;
    }

    public boolean deleteShifts(List<Shift> shifts) {
        for (Shift shift : shifts) {
            shiftDao.deleteShift(shift);
        }
        return true;
    }
}
