package viapos.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.dao.DistributionDao;
import viapos.dao.EventDao;
import viapos.dao.LocationsDao;
import viapos.model.Distribution;
import viapos.model.Event;
import viapos.model.Location;
import viapos.model.Section;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class EventService extends BaseService {

    @Autowired
    EventDao eventDao;

    public boolean updateEvents(List<Event> events) {
        for (Event event : events) {
            eventDao.updateEvents(event);
        }
        return true;
    }

    public ArrayList<Event> getEvents() {
        return eventDao.getEvents();
    }

    public boolean createEvents(List<Event> events) {
        for (Event event : events) {
            event.setId(UUID.randomUUID().toString());
            eventDao.createEvent(event);
        }
        return true;
    }

    public boolean deleteEvents(List<Event> events) {
        for (Event event : events) {
            eventDao.deleteEvent(event);
        }
        return true;
    }

    public boolean deleteEvent(String id) {
        Event event = new Event();
        event.setId(id);
        eventDao.deleteEvent(event);
        return true;
    }
}
