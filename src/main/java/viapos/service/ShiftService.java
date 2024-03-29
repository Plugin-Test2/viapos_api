package viapos.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.dao.*;
import viapos.helper.DateHelper;
import viapos.helper.ShiftHelper;
import viapos.model.*;

import java.lang.reflect.Array;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ShiftService extends BaseService {

    @Autowired
    ShiftDao shiftDao;
    @Autowired
    ShiftTypeDao shiftTypeDao;
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

    public List<Shift> getShifts(LocalDate date) {
        List<Shift> assignedShifts = shiftDao.getShifts(date);
        List<Shift> unassignedShifts = getUnassignedShifts(date);
        assignedShifts.addAll(unassignedShifts);
        return assignedShifts;
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

    public ArrayList<Shift> getUnassignedShifts(String dayOfWeek, LocalDate date, List<String> resources) {
        List<Event> events = eventDao.getEvents(dayOfWeek, resources);
        return shiftDao.getUnassignedShifts(events, date);
    }

    public ArrayList<Shift> getUnassignedShifts(LocalDate date) {
        List<Event> events = eventDao.getEvents(date);
        return shiftDao.getUnassignedShifts(events, date);
    }

    public List<Shift> scheduleShifts(SchedulingRequest schedulingRequest) {

        // break events into weeks
        List<ScheduleWeek> schedule = DateHelper.getWeeks(schedulingRequest.getStart(), schedulingRequest.getEnd());
        List<Shift> createdShifts = new ArrayList<>();
        for (ScheduleWeek week:schedule) {
            List<Event> events = this.eventDao.getEvents(week.getStartDate(), week.getEndDate(), schedulingRequest.getLocations());
            System.out.println("Scheduling for events: " + events.toArray().toString());
            System.out.println("Number of events: " + events.size());

            // get unassiged shifts that week
            List<Shift> unassignedShifts = this.shiftDao.getUnassignedShifts(events, week.getStartDate(), week.getEndDate());
            System.out.println("Scheduling for the unassignedShifts: " + unassignedShifts.toArray().toString());

            // get employees availability each week
            List<Employee> employees = this.employeeDao.getEmployees();

            //create shifts 1 week at a time
            List<Shift> assignedShifts = shiftHelper.assignShifts(unassignedShifts, employees);
            System.out.println("Assigned shifts are: " + assignedShifts.size());
            for (Shift shift:assignedShifts) {
                if (shift.getId() == null || shift.getId().isEmpty()) {
                    shift.setId(UUID.randomUUID().toString());
                    shiftDao.createShifts(shift);
                } else {
                    shiftDao.updateShifts(shift);
                }
                createdShifts.add(shift);
            }
        }

        return createdShifts;
    }

    public boolean updateShiftTypes(List<ShiftType> shiftTypes) {
        for (ShiftType shiftType : shiftTypes) {
            shiftTypeDao.updateShiftTypes(shiftType);
        }
        return true;
    }

    public ArrayList<ShiftType> getShiftTypes() {
        return shiftTypeDao.getShiftTypes();
    }


    public boolean createShiftTypes(List<ShiftType> shiftTypes) {
        for (ShiftType shiftType : shiftTypes) {
            shiftType.setId(UUID.randomUUID().toString());
            shiftTypeDao.createShiftTypes(shiftType);
        }
        return true;
    }

    public boolean deleteShiftTypes(List<ShiftType> shiftTypes) {
        for (ShiftType shiftType : shiftTypes) {
            shiftTypeDao.deleteShiftType(shiftType);
        }
        return true;
    }

    public List<Shift> getShiftsByIds(List<String> shiftIds) {
        return shiftDao.getShiftsByIds(shiftIds);
    }
}
