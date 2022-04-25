package demo;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class FormatParse {
    public static void main(String[] args) {
        // 2014-04-01 10:45
        LocalDateTime lcdateTime = LocalDateTime.of(2014, Month.APRIL, 1, 10, 45);
        // Định dạng theo ISO date cơ bản (20140220)
        String asBasicIsoDate = lcdateTime.format(DateTimeFormatter.BASIC_ISO_DATE);
        // theo ISO week date (2014-W08-4)
        String asIsoWeekDate = lcdateTime.format(DateTimeFormatter.ISO_WEEK_DATE);
        // theo ISO date time (2014-02-20T20:04:05.867)
        String asIsoDateTime = lcdateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        // Hay theo pattern (01/04/2014)
        String asCustomPattern = lcdateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        // parsing date strings
        LocalDate fromIsoDate = LocalDate.parse("2014-01-20");
        LocalDate fromIsoWeekDate = LocalDate.parse("2014-W14-2", DateTimeFormatter.ISO_WEEK_DATE);
        LocalDate fromCustomPattern = LocalDate.parse("20.01.2014", DateTimeFormatter.ofPattern("dd.MM.yyyy"));


        // ---------

        // Format LocalDate examples
        LocalDate date = LocalDate.now();
        System.out.println("Default format of LocalDate = " + date);    // Default format of LocalDate = 2022-04-25
        System.out.println(date.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));   // 25::Apr::2022
        System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));  // 20220425

        // Format LocalDateTime examples
        LocalDateTime dateTime = LocalDateTime.now();   // Default format of LocalDateTime = 2022-04-25T00:31:52.253
        System.out.println("\nDefault format of LocalDateTime = " + dateTime);
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss")));    // 25::Apr::2022 00::31::52
        System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));  // 20220425

        // Format Instant Example
        Instant timestamp = Instant.now();
        System.out.println("\nDefault format of Instant = " + timestamp);   // Default format of Instant = 2022-04-24T17:31:52.253Z

        // Parse examples
        LocalDateTime dt = LocalDateTime.parse("27::Apr::2014 21::39::48", DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss"));
        System.out.println("\nDefault format after parsing = " + dt);       // Default format after parsing = 2014-04-27T21:39:48
    }
}
