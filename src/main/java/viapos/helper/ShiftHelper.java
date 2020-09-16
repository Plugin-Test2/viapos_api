package viapos.helper;

import org.springframework.stereotype.Component;
import viapos.model.Employee;
import viapos.model.Shift;
import viapos.util.EmployeeComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

@Component
public class ShiftHelper {

    public List<Shift> assignShifts(List<Shift> shifts, List<Employee> employees) {
        TreeSet<Employee> orderedEmployees = new TreeSet<>(new EmployeeComparator());
        for (Employee employee:employees) {
            orderedEmployees.add(employee);
        }

        for (Shift shift:shifts) {
            shift.setAssignedTo(orderedEmployees.first().getId());
            orderedEmployees.first().subtractAvailableWeeklyHours(shift.getDuration());
        }

        return shifts;
    }
}
