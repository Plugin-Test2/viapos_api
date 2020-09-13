package viapos.helper;

import viapos.model.Event;
import viapos.model.ScheduleWeek;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DateHelper {

    private static long sevenDigit = 7;

    public static List<ScheduleWeek> getWeeks(String start, String end) {
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        ScheduleWeek firstWeek = new ScheduleWeek();
        firstWeek.setStartDate(startDate);
        List<ScheduleWeek> scheduleWeeks = new ArrayList<>();
        while (startDate.isBefore(endDate)) {
            ScheduleWeek week = new ScheduleWeek();
            week.setStartDate(startDate);
            if (startDate.minusDays(sevenDigit).isBefore(endDate)) {
                week.setEndDate(startDate.plusDays(sevenDigit));
            } else {
                week.setEndDate(endDate);
            }
            startDate = startDate.plusDays(sevenDigit);
            scheduleWeeks.add(week);
        }
        for (ScheduleWeek week:scheduleWeeks) {
            System.out.println("Schedulingggg new week of: " + week.getStartDate() + " " + week.getEndDate());
        }
        return scheduleWeeks;
    }
}
