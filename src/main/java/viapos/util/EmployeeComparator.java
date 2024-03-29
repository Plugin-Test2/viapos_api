package viapos.util;

import viapos.model.Employee;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {
        if(Float.parseFloat(e1.getAvailableWeeklyHours()) > Float.parseFloat(e2.getAvailableWeeklyHours())){
            return -1;
        } else {
            return 1;
        }
    }
}
