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

    public List<Shift> assignShifts(List<Shift> unassignedShifts, List<Employee> employees) {
        List<Shift> assignedShifts = new ArrayList<>();
        TreeSet<Employee> orderedEmployees = new TreeSet<>(new EmployeeComparator());
        for (Employee employee:employees) {
            orderedEmployees.add(employee);
        }

        for (Shift shift:unassignedShifts) {
            shift.setAssignedTo(orderedEmployees.first().getId());
            orderedEmployees.first().subtractAvalaibleWeeklyHours(shift.getDuration());
        }

        return assignedShifts;
    }
}
