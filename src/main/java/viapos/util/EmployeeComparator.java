package viapos.util;

import viapos.model.Employee;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {
        if((Float.parseFloat(e1.getAvalaibleWeeklyHours()) / Float.parseFloat(e2.getPreferredWeeklyHours()))
                > (Float.parseFloat(e2.getAvalaibleWeeklyHours()) / Float.parseFloat(e2.getPreferredWeeklyHours()))){
            return 1;
        } else {
            return -1;
        }
    }
}
