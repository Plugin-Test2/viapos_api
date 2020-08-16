package viapos.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.dao.LocationsDao;
import viapos.dao.SectionDao;
import viapos.model.Location;
import viapos.model.Section;

import java.util.ArrayList;
import java.util.List;

@Component
public class SectionService {

    @Autowired
    SectionDao sectionDao;

    public boolean updateSections(List<Section> sections) {
        for (Section section : sections) {
            sectionDao.updateSection(section);
        }
        return true;
    }

    public ArrayList<Section> getSections() {
        return sectionDao.getSections();
    }

    public boolean createSections(List<Section> sections) {
        for (Section section : sections) {
            sectionDao.createSection(section);
        }
        return true;
    }

    public boolean deleteSections(List<Section> sections) {
        for (Section section : sections) {
            sectionDao.deleteSection(section);
        }
        return true;
    }
}
