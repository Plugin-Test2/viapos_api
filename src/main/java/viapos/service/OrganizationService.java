package viapos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.dao.OrganizationDao;
import viapos.model.Organization;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class OrganizationService extends BaseService {
    @Autowired
    OrganizationDao organizationDao;

    public boolean updateOrganizations(List<Organization> organizations) {
        for (Organization organization : organizations) {
            organizationDao.updateOrganization(organization);
        }
        return true;
    }

    public ArrayList<Organization> getOrganizations() {
        return organizationDao.getOrganizations();
    }

    public Organization getOrganization(String id) {

        return organizationDao.getOrganization(id);
    }

    public boolean createOrganizations(List<Organization> organizations) {
        for (Organization organization : organizations) {
            organization.setId(UUID.randomUUID().toString());
            organizationDao.createOrganization(organization);
        }
        return true;
    }

    public boolean deleteOrganization(List<Organization> organizations) {
        for (Organization organization : organizations) {
            organizationDao.deleteOrganization(organization);
        }
        return true;
    }

    public boolean deleteOrganization(String id) {
        Organization organization = new Organization();
        organization.setId(id);
        organizationDao.deleteOrganization(organization);
        return true;
    }
}
