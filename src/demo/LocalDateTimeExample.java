package demo;

import java.time.*;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class LocalDateTimeExample {
    public static void main(String[] args) {

    }

    public static void demoLocalDate() {
        // Khởi tạo ngày tháng năm hiện tại
        LocalDate today = LocalDate.now();      // 2022-04-24

        // Khởi tạo ngày cu the
        LocalDate date1 = LocalDate.of(2022, Month.APRIL, 24);  // 2022-04-24
        LocalDate date2 = LocalDate.of(1990, 9, 1);      // 1990-09-01

        // Khởi tạo ngày thứ 102 của năm 2022
        LocalDate date3 = LocalDate.ofYearDay(2022, 102);        // 2022-04-12

        LocalDate todayHCM = LocalDate.now(ZoneId.of("Asia/Ho_Chi_Minh"));  // // 2022-04-24
    }

    public static void demoLocalTime() {
        // Khởi tạo giờ hiện tại
        LocalTime currentTime = LocalTime.now();    // 22:25:36.942

        // hay lúc 12 giờ trưa
        LocalTime midday = LocalTime.of(12, 0); // 12:00

        // 13:30:15
        LocalTime afterMidday = LocalTime.of(13, 30, 15);   // 13:30:15

        // hay giây thứ 12345 của một ngày là (03:25:45)
        LocalTime fromSecondsOfDay = LocalTime.ofSecondOfDay(12345);    // 03:25:45

        LocalTime timeHCM = LocalTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));   //  // 22:25:36.942
    }

    public static void demoLocalDateTime() {
        LocalDateTime today = LocalDateTime.now();
        today = LocalDateTime.of(LocalDate.now(), LocalTime.now());

        // LocalDateTime.of(int year, Month month, int dayOfMonth, int hour, int minute, int second)
        LocalDateTime specificDate = LocalDateTime.of(2014, Month.JANUARY, 1, 10, 10, 30);


        LocalDateTime todayHCM = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
        System.out.println("Current Date in IST = " + todayHCM);

        // java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
        // LocalDateTime todayIST = LocalDateTime.now(ZoneId.of("IST"));

        // Getting date from the base date i.e 01/01/1970 - 10000th second time from 01/01/1970
        LocalDateTime dateFromBase = LocalDateTime.ofEpochSecond(10000, 0, ZoneOffset.UTC);
    }

    public static void someMethods() {
        LocalDate date = LocalDate.of(2016, 5, 15);
        boolean isBefore = LocalDate.now().isBefore(date); // => trả về true/false
        // Lấy tên của tháng
        Month may = date.getMonth();// => MAY
        // Lấy tháng dạng số
        int mayValue = may.getValue(); // 5

        // Lấy số ngày lớn nhất/nhỏ nhất của tháng (thay đổi theo năm nhuân, không nhuận)
        LocalDate date2 = LocalDate.of(2016, 2, 15);
        Month february = date2.getMonth();// => FEBRUARY
        int minLength = february.minLength(); // 28
        int maxLength = february.maxLength(); // 29

        // Lấy tháng trước tháng hiện tại
        Month firstMonthOfQuarter = february.firstMonthOfQuarter(); // JANUARY

        // Lấy ngày sau ngày hôm nay
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        // Trước hiện tại 5 giờ and 30 phút
        LocalDateTime dateTime = LocalDateTime.now().minusHours(5).minusMinutes(30);

        // Lấy ngày đầu tiên của tháng
        LocalDate firstDayOfMonth = date.with(TemporalAdjusters.firstDayOfMonth()); // => 2016-05-01

        // Lấy ngày cuối của tháng
        LocalDate lastDayOfMonth = date.with(TemporalAdjusters.lastDayOfMonth());   // => 2016-05-31

        LocalDate lastDayOfYear = date.with(TemporalAdjusters.lastDayOfYear());

        LocalDate firstDayOfNextMonth = date.with(TemporalAdjusters.firstDayOfNextMonth());

        LocalDate nextSunday = date.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));

        // ------------

        LocalTime time = LocalTime.of(15, 30); // 15:30:00
        int hour = time.getHour(); // 15
        int second = time.getSecond(); // 0
        int minute = time.getMinute(); // 30
        int secondOfDay = time.toSecondOfDay(); // 55800

        // ------------
        int year = date.getYear(); // 2016
        int dayOfYear = date.getDayOfYear(); // 46
        int lengthOfYear = date.lengthOfYear(); // 365
        boolean isLeapYear = date.isLeapYear(); // false
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int dayOfWeekIntValue = dayOfWeek.getValue(); // 6
        String dayOfWeekName = dayOfWeek.name(); // SATURDAY
        int dayOfMonth = date.getDayOfMonth(); // 25
        LocalDateTime startOfDay = date.atStartOfDay(); // 2016-05-25 00:00
        // Một số hàm đặc biệt khác cho năm
        Year currentYear = Year.now();
        Year twoThousand = Year.of(2000);
        boolean isLeap = currentYear.isLeap(); // false
        int length = currentYear.length(); // 365
        // sixtyFourth day of 2014 (2014-03-05)
        LocalDate lcdate = Year.of(2014).atDay(64);

        // Year Example
        Year currentYear1 = Year.now();
        System.out.println("currentYear: " + currentYear1); // 2018

        Year specifyYear = Year.of(2016);
        System.out.println("specifyYear: " + specifyYear); // 2016
        System.out.println("isLeap : " + specifyYear.isLeap()); // true

        int dayOfYear1 = 100;
        LocalDate localDate = currentYear1.atDay(dayOfYear1);
        System.out.println("localDate: " + localDate); // 2018-04-10

        // YearMonth Example

        YearMonth currentYearMonth = YearMonth.now();
        System.out.println("currentYearMonth: " + currentYearMonth);

        YearMonth specifyYearMonth = YearMonth.of(2016, 1);
        System.out.println("specifyYearMonth: " + specifyYearMonth);

        int dayOfMonth1 = 20;
        LocalDate localDate2 = currentYearMonth.atDay(dayOfMonth1);
        System.out.println("localDate2: " + localDate2); // 2018-06-20

        // Year -> YearMonth

        YearMonth ym = currentYear1.atMonth(5);
        System.out.println("ym: " + ym); // 2018-05


        // ----------------
        // DayOfWeek Enum Example
        DayOfWeek monday = DayOfWeek.MONDAY;
        System.out.println(monday); // MONDAY
        System.out.println(monday.getDisplayName(TextStyle.SHORT, Locale.getDefault())); // Mon
        System.out.println(monday.getDisplayName(TextStyle.FULL, Locale.getDefault())); // Monday
        System.out.println(monday.plus(5)); // SATURDAY
        System.out.println(DayOfWeek.of(1)); // MONDAY
        System.out.println(DayOfWeek.of(7)); // SUNDAY
        System.out.println(DayOfWeek.valueOf("SUNDAY")); // SUNDAY
        System.out.println(monday.compareTo(DayOfWeek.SUNDAY)); // -6

        // Month Enum Example
        Month april = Month.APRIL;
        System.out.println(april); // APRIL
        System.out.println(april.getDisplayName(TextStyle.SHORT, Locale.getDefault())); // Apr
        System.out.println(april.getDisplayName(TextStyle.FULL, Locale.getDefault())); // April
        System.out.println(april.plus(3)); // JULY
        System.out.println(Month.FEBRUARY.maxLength()); // 29
        System.out.println(Month.FEBRUARY.minLength()); // 28
        System.out.println(april.firstDayOfYear(true)); // 92
        System.out.println(Month.of(1)); // JANUARY
        System.out.println(Month.of(12)); // DECEMBER
        System.out.println(Month.valueOf("FEBRUARY")); // FEBRUARY
        System.out.println(april.compareTo(Month.FEBRUARY)); // 2

    }

}

