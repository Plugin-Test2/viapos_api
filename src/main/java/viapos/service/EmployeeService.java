package viapos.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import viapos.dao.EmployeeDao;
import viapos.dao.EmployeeTypeDao;
import viapos.dao.LocationsDao;
import viapos.model.Employee;
import viapos.model.EmployeeType;
import viapos.model.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    EmployeeTypeDao employeeTypeDao;

    public boolean updateEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            employeeDao.updateEmployee(employee);
        }
        return true;
    }

    public ArrayList<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    public boolean createEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            employee.setId(UUID.randomUUID().toString());
            employeeDao.createEmployee(employee);
        }
        return true;
    }

    public boolean deleteEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            employeeDao.deleteEmployee(employee);
        }
        return true;
    }

    public boolean updateEmployeeTypes(List<EmployeeType> employeeTypes) {
        for (EmployeeType employeeType : employeeTypes) {
            employeeTypeDao.updateEmployeeType(employeeType);
        }
        return true;
    }

    public ArrayList<EmployeeType> getEmployeeTypes() {
        return employeeTypeDao.getEmployeeTypes();
    }

    public boolean createEmployeeTypes(List<EmployeeType> employeeTypes) {
        for (EmployeeType employeeType : employeeTypes) {
            employeeType.setId(UUID.randomUUID().toString());
            employeeTypeDao.createEmployeeType(employeeType);
        }
        return true;
    }

    public boolean deleteEmployeeTypes(List<EmployeeType> employeeTypes) {
        for (EmployeeType employeeType : employeeTypes) {
            employeeTypeDao.deleteEmployeeType(employeeType);
        }
        return true;
    }
}
