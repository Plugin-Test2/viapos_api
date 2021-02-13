package viapos.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.dao.CustomerDao;
import viapos.dao.LocationsDao;
import viapos.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class CustomerService extends BaseService {

    public boolean updateCustomers(List<Customer> customers) {
        for (Customer customer : customers) {
            customerDao.updateCustomer(customer);
        }
        return true;
    }

    public ArrayList<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    public boolean createCustomers(List<Customer> customers) {
        for (Customer customer : customers) {
            customer.setId(UUID.randomUUID().toString());
            customerDao.createCustomer(customer);
        }
        return true;
    }

    public boolean deleteCustomers(List<Customer> customers) {
        for (Customer customer : customers) {
            customerDao.deleteCustomer(customer);
        }
        return true;
    }

    public List<PaymentMethod> getCustomersPaymentMethods(String customerId) {
        return paymentMethodDao.getCustomersPaymentMethods(customerId);
    }
}
