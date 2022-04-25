package demo;

import java.time.*;

public class PeriodAndDuration {
    public static void main(String[] args) {

        // Tính toán khoảng thời gian giữa hai mốc thời gian
        // Period tính chính xác số năm, tháng
        // Duration tính toán chi tiết số giờ, đến mili giây giữa hai môc thời gian

        // Period ----------------------------------
        LocalDate firstDate = LocalDate.of(2010, 5, 17); // 2010-05-17
        LocalDate secondDate = LocalDate.of(2015, 3, 7); // 2015-03-07

        Period period = Period.between(firstDate, secondDate);
        int daysP = period.getDays(); // 18
        int monthsP = period.getMonths(); // 9
        int yearsP = period.getYears(); // 4

        boolean isNegative = period.isNegative(); // false

        Period twoMonthsAndFiveDays = Period.ofMonths(2).plusDays(5);
        LocalDate sixthOfJanuary = LocalDate.of(2014, 1, 6);
        // Cộng 2 tháng và 5 ngày cho sixthOfJanuary ta được ngày 2014-03-11
        LocalDate eleventhOfMarch = sixthOfJanuary.plus(twoMonthsAndFiveDays);

        // Duration ----------------------------------
        LocalDateTime lcfirstDate = LocalDateTime.now();
        LocalDateTime lcsecondDate = LocalDateTime.of(2018, 6, 20, 0, 0, 0);
        System.out.println("firstDate: " + lcfirstDate); // 2018-06-23T21:31:28.924
        System.out.println("secondDate: " + lcsecondDate); // 2018-06-20T00:00

        // Obtains a Duration representing the duration between two temporal objects
        // The temporal objects are Instant or LocalDateTime
        Duration duration = Duration.between(lcfirstDate, lcsecondDate);
        System.out.println("duration: " + duration); // PT-93H-31M-28.924S

        long days = duration.toDays();
        long hours = duration.toHours();
        long minutes = duration.toMinutes();
        long seconds = duration.getSeconds();
        long millis = duration.toMillis();
        long nanos = duration.toNanos();
        System.out.println("days: " + days); // -3
        System.out.println("hours: " + hours); // -93
        System.out.println("minutes: " + minutes); // -5611
        System.out.println("seconds: " + seconds); // -336689
        System.out.println("millis: " + millis); // -336688924
        System.out.println("nanos: " + nanos); // -336688924000000

        Duration twoHours = Duration.ofHours(2);
        System.out.println("twoHours: " + twoHours); // PT2H

        LocalDateTime plusDate = lcfirstDate.plus(twoHours);
        System.out.println("plusDate: " + plusDate); // 2018-06-23T23:35:21.045

        LocalDateTime minusDate = lcfirstDate.minus(twoHours);
        System.out.println("minusDate: " + minusDate); // 2018-06-23T19:35:21.045
    }

}
