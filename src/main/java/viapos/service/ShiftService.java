package viapos.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.dao.EmployeeDao;
import viapos.dao.EventDao;
import viapos.dao.LocationsDao;
import viapos.dao.ShiftDao;
import viapos.helper.DateHelper;
import viapos.helper.ShiftHelper;
import viapos.model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ShiftService {

    @Autowired
    ShiftDao shiftDao;
    @Autowired
    EventDao eventDao;
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    ShiftHelper shiftHelper;

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

    public ArrayList<Shift> getUnassignedShifts(String dayOfWeek, String date, List<String> resources) {
        List<Event> events = eventDao.getEvents(dayOfWeek, resources);
        return shiftDao.getUnassignedShifts(events, date);
    }

    public List<Shift> scheduleShifts(SchedulingRequest schedulingRequest) {

        // break events into weeks
        List<ScheduleWeek> schedule = DateHelper.getWeeks(schedulingRequest.getStart(), schedulingRequest.getEnd());
        List<Shift> createdShifts = new ArrayList<>();
        for (ScheduleWeek week:schedule) {
            List<Event> events = this.eventDao.getEvents(week.getStartDate().toString(), week.getEndDate().toString(), schedulingRequest.getLocations());

            // get unassiged shifts that week
            List<Shift> unassignedShifts = this.shiftDao.getUnassignedShifts(events, week.getStartDate().toString(), week.getEndDate().toString());

            // get employees availability each week
            List<Employee> employees = this.employeeDao.getEmployees();

            //create shifts 1 week at a time
            List<Shift> assignedShifts = shiftHelper.assignShifts(unassignedShifts, employees);
            for (Shift shift:assignedShifts) {
                if (shift.getId() == null || shift.getId().isEmpty()) {
                    shift.setId(UUID.randomUUID().toString());
                    shiftDao.createShifts(shift);
                } else {
                    shiftDao.updateShifts(shift);
                }
            }
        }

        return createdShifts;
    }
}
