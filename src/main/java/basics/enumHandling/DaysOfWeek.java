package basics.enumHandling;

public enum DaysOfWeek {
    SUNDAY(01),
    MONDAY(02),
    TUESDAY(03),
    WEDNESDAY(04),
    THURSDAY(05),
    FRIDAY(06),
    SATURDAY(07);

    final int day;

    DaysOfWeek(int day) {
        this.day = day;
    }

}
