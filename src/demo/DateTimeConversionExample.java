package demo;

import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateTimeConversionExample {
    public static void main(String[] args) {
        // LocalDate/ LocalTime <-> LocalDateTime/ ZonedDateTime
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTimeFromDateAndTime = LocalDateTime.of(date, time);
        LocalDate dateFromDateTime = dateTimeFromDateAndTime.toLocalDate();
        LocalTime timeFromDateTime = dateTimeFromDateAndTime.toLocalTime();
        ZonedDateTime hcmDateTime = ZonedDateTime.of(dateTimeFromDateAndTime, ZoneId.of("Asia/Ho_Chi_Minh"));
        ZonedDateTime hcmDateTime2 = dateTimeFromDateAndTime.atZone(ZoneId.of("Asia/Ho_Chi_Minh"));

        // Convert old classes to Java 8 Date Time
        Instant instantFromDate = new Date().toInstant();
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        Instant instantFromCalendar = Calendar.getInstance().toInstant();
        ZonedDateTime zonedDateTime = new GregorianCalendar().toZonedDateTime();

        // Instant <-> LocalDateTime
        Instant instant = Instant.now();
        LocalDateTime dateTimeFromInstant = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        Instant instantFromLocalDateTime = dateTimeFromInstant.toInstant(ZoneOffset.ofHours(+7));

        // Instant <-> LocalDate
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        Instant instantFromLocalDate = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();

        // Convert Java 8 Date Time to old classes
        Date dateFromInstant = Date.from(Instant.now());
        TimeZone timeZone = TimeZone.getTimeZone(ZoneId.of("Asia/Ho_Chi_Minh"));
        GregorianCalendar gregorianCalendar = GregorianCalendar.from(ZonedDateTime.now());

        // -------------

        // tái hiện lại thời điểm bắt đầu DST tại Victoria
        // lúc 2h sáng chủ nhật đầu tiên của tháng 10 (là ngày 04/10/2020)

        ZoneId zId = ZoneId.of("Australia/Melbourne"); // https://time.is/Victoria

        // Vì 2h sẽ xảy ra DST, chúng ta sẽ lấy thời gian sớm hơn 5 phút
        ZonedDateTime before = LocalDateTime.parse("2020-10-04T01:55:00").atZone(zId);
        System.out.println(before.toLocalTime());           // 01:55
        System.out.println(before.getOffset());             // +10:00

        // Sau đó cộng thêm 10 phút để qua thời điểm DST.
        ZonedDateTime after = before.plusMinutes(10);
        System.out.println(after.toLocalTime());            // 03:05    // không có khoảng thời gian 2h-3h. 1h đến 3h luôn
        System.out.println(after.getOffset());              //+11:00    // offset tăng 1 đơn vị

        System.out.println(after);
        System.out.println(after.toLocalDateTime());
        System.out.println(after.toEpochSecond());

        // -------------
        System.out.println("-------------------");

        // Thời gian hiện tại ở HCM (+07:00)
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now.toLocalDateTime());              // 2022-04-25T17:09:59.932

        ZoneId florida = ZoneId.of("America/New_York");
        // Cũng là hiện tại nhưng ở Florida (-04:00)
        ZonedDateTime nowAtFlorida = now.withZoneSameInstant(florida);
        System.out.println(nowAtFlorida.toLocalDateTime());     // 2022-04-25T06:09:59.932
        // withZoneSameInstant chức năng của nó là dịch chuyển từ timezone này sang timezone khác
        // mà vẫn giữ nguyên giá trị moment ("sameInstant").

        ZonedDateTime nowAtFlorida2 = ZonedDateTime.ofInstant(now.toInstant(), florida);
        System.out.println(nowAtFlorida2.toLocalDateTime());    // 2022-04-25T06:09:59.932      ~ same nowAtFlorida

        System.out.println("-------");

        String newYear = "2021-01-01T00:00:00";
        ZoneId hcm = ZoneId.of("Asia/Ho_Chi_Minh");

        // Giao thừa 2021 tại HCM
        ZonedDateTime newYearEveHCM = LocalDateTime.parse(newYear).atZone(hcm);
        // Giao thừa 2021 tại Florida
        ZonedDateTime newYearEveFlorida = newYearEveHCM.withZoneSameLocal(florida);
        System.out.println(newYearEveHCM.toLocalDateTime());        // 2021-01-01T00:00
        System.out.println(newYearEveFlorida.toLocalDateTime());    // 2021-01-01T00:00
        System.out.println(newYearEveHCM.toEpochSecond());          // 1609434000
        System.out.println(newYearEveFlorida.toEpochSecond());      // 1609477200

        // Trái ngược với ví dụ trên, ở đây .withZoneSameLocal(ZoneId) sẽ giữa nguyên tgian tuong doi ("sameLocal")
        // và gắn vào đó một timezone khác, do đó giá trị tuyệt đối (moment) của newYearEveHCM và newYearEveFlorida hoàn toàn khác nhau.

    }

    // Kiểm tra xem thời gian của báo cáo có nằm giữa 2 khoảng instant hay không
    boolean isBetween(Date d, Instant start, Instant end) {
        Instant timePoint = d.toInstant();
        return (start.equals(timePoint) || start.isBefore(timePoint)) &&
                (timePoint.equals(end) || timePoint.isBefore(end));
    }
}
