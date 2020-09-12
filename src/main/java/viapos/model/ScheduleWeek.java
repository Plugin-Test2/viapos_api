package viapos.model;

import java.time.LocalDate;
import java.util.List;

public class ScheduleWeek {

    private LocalDate startDate;
    private LocalDate endDate;
    private List<Event> events;
    private List<Shift> unassignedShifts;
    private List<Shift> assignedShifts;
    private Boolean fullWeek;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Shift> getUnassignedShifts() {
        return unassignedShifts;
    }

    public void setUnassignedShifts(List<Shift> unassignedShifts) {
        this.unassignedShifts = unassignedShifts;
    }

    public List<Shift> getAssignedShifts() {
        return assignedShifts;
    }

    public void setAssignedShifts(List<Shift> assignedShifts) {
        this.assignedShifts = assignedShifts;
    }

    public Boolean getFullWeek() {
        return fullWeek;
    }

    public void setFullWeek(Boolean fullWeek) {
        this.fullWeek = fullWeek;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
