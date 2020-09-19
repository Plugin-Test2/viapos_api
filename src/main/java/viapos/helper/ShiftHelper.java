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
            if (employee.getPreferredWeeklyHours() == null || employee.getPreferredWeeklyHours().isEmpty()) {
                employee.setPreferredWeeklyHours("40");
            }
            orderedEmployees.add(employee);
        }

        for (Shift shift:shifts) {
            Employee employee = orderedEmployees.pollFirst();
            shift.setAssignedTo(employee.getId());
            employee.subtractAvailableWeeklyHours(shift.getDuration());
            orderedEmployees.add(employee);
        }

        return shifts;
    }

    public List<Employee> getAvailableEmployees(List<Employee> employees, Shift shift) {
        List<Employee> availableEmployees = new ArrayList<>();

        return availableEmployees;
    }
}
