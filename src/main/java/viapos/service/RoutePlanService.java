package viapos.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.dao.*;
import viapos.model.*;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class RoutePlanService {

    @Autowired
    RoutePlanDao routePlanDao;
    @Autowired
    ShiftDao shiftDao;
    @Autowired
    SectionDao sectionDao;
    @Autowired
    EventDao eventDao;

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
            // Get All Sections
            List<Section> allSections = sectionDao.getSections();

            // Group by Location
            List<String> locations = new ArrayList<>();
            HashMap<String, String> sectionCount = new HashMap<>();
            HashMap<String, List<Section>> sectionsByLocation = new HashMap<>();
            for (Section section: allSections) {
                if (section.getId() != null && routePlan.getSections().contains(section.getId())) {
                    if (locations.contains(section.getLocationId())) {
                        int routes = Integer.parseInt(sectionCount.get(section.getLocationId())) + Integer.parseInt(section.getNbrRoutes());
                        sectionCount.put(section.getLocationId(), Integer.toString(routes));
                        List<Section> sections = sectionsByLocation.get(section.getLocationId());
                        sections.add(section);
                        sectionsByLocation.put(section.getLocationId(), sections);
                    } else {
                        locations.add(section.getLocationId());
                        sectionCount.put(section.getLocationId(), section.getNbrRoutes());
                        List<Section> sections = new ArrayList<>();
                        sections.add(section);
                        sectionsByLocation.put(section.getLocationId(), sections);
                    }
                }
            }
            for (String location: locations) {
                // Retrieve events during this period
                List<String> locationList = new ArrayList<>();
                locationList.add(location);
                List<Event> events = eventDao.getEvents(routePlan.getStartDate(), routePlan.getEndDate(), locationList, routePlan.getShiftTypes());
                System.out.println("Pulling events: " + events.size());
                // Get all shifts for that
                List<String> eventList = events.stream()
                        .map(Event::getId)
                        .collect(Collectors.toList());

                List<Shift> shifts = shiftDao.getUnassignedShifts(events, routePlan.getStartDate(), routePlan.getEndDate());
                shifts.addAll(shiftDao.getShifts(routePlan.getStartDate(), routePlan.getEndDate(), eventList));

                System.out.println("Total shifts: " + shifts.size());
                int routesPerShift = (int) Math.ceil(Double.parseDouble(sectionCount.get(location)) / (double) shifts.size());
                int sectionRoutesSet = 0;
                int shiftsSet = 1;
                int sectionMod = (int) Double.parseDouble(sectionCount.get(location)) % routesPerShift;
                List<Route> routes = new ArrayList<>();
                List<Section> locationSections = sectionsByLocation.get(location);
                Iterator<Section> sectionIterator = locationSections.iterator();
                Section section = sectionIterator.next();
                for (Shift shift: shifts) {
                    for (int i = 0; i < routesPerShift; i++) {
                        if (sectionRoutesSet >= Integer.parseInt(section.getNbrRoutes())) {
                            section = sectionIterator.next();
                            sectionRoutesSet = 0;
                        }
                        Route route = new Route();
                        route.setNumber(Integer.toString(sectionRoutesSet + 1));
                        route.setSectionId(section.getId());
                        route.setShiftId(shift.getId());
                        routes.add(route);
                        sectionRoutesSet++;

                        if (shiftsSet == sectionMod) {
                            routesPerShift--;
                            shiftsSet++;
                        } else {
                            shiftsSet++;
                        }
                    }
                }
                routePlan.setRoutes(routes);
            }


            // Assign routes to Shift
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
