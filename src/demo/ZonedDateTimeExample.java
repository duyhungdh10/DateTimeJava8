package demo;

import java.time.*;

public class ZonedDateTimeExample {
    public static void main(String[] args) {


        LocalDateTime today = LocalDateTime.now();
        System.out.println("LocalDateTime = " + today);     // LocalDateTime = 2022-04-25T00:05:57.546

        ZoneId zoneHCM = ZoneId.of("Asia/Ho_Chi_Minh");
        System.out.println("zoneHCM = " + zoneHCM);         // zoneHCM = Asia/Ho_Chi_Minh

        // ZonedDateTime = LocalDateTime + ZoneId
        ZonedDateTime hcmDateTime = ZonedDateTime.of(today, zoneHCM);
        System.out.println("ZonedDateTime = " + hcmDateTime);   // ZonedDateTime = 2022-04-25T00:05:57.546+07:00[Asia/Ho_Chi_Minh]


        ZoneOffset offset = ZoneOffset.of("+05:00");
        System.out.println("offset = " + offset);       // offset = +05:00

        // OffsetDateTime = LocalDateTime + ZoneOffset
        OffsetDateTime todayPlusFive = OffsetDateTime.of(today, offset);
        System.out.println("todayPlusFive = " + todayPlusFive);     // todayPlusFive = 2022-04-25T00:05:57.546+05:00

        OffsetDateTime todayMinusTwo = todayPlusFive.withOffsetSameInstant(ZoneOffset.ofHours(-2));
        System.out.println("todayMinusTwo = " + todayMinusTwo);     // todayMinusTwo = 2022-04-24T17:05:57.546-02:00
    }
}
