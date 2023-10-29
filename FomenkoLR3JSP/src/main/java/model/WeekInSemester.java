package model;


import java.time.LocalDate;

public class WeekInSemester {

    public static int numOfWeekInSemester() {
        LocalDate mydate = LocalDate.now();
        java.time.LocalDate startSemester = java.time.LocalDate.of(java.time.LocalDate.now().getYear(), 9, 1); //начало семестра 1 сентября тек года
        java.time.temporal.WeekFields weekFields = java.time.temporal.WeekFields.of(java.util.Locale.getDefault());
        int weekNumber1 = startSemester.get(weekFields.weekOfWeekBasedYear());
        int weekNumber2 = mydate.get(weekFields.weekOfWeekBasedYear());
        int numberWeekSemester = weekNumber2 - weekNumber1 + 1;

        return numberWeekSemester;
    }
}
