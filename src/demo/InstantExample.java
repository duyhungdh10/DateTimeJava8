package demo;

import java.time.Duration;
import java.time.Instant;

public class InstantExample {
    public static void main(String[] args) {

        // Current timestamp
        Instant now = Instant.now();
        System.out.println("Current Timestamp = " + now);                       // Current Timestamp = 2022-04-24T17:10:04.708Z

        // Instant from timestamp
        Instant specificTime = Instant.ofEpochMilli(now.toEpochMilli());
        System.out.println("Specific Time = " + specificTime);                  // Specific Time = 2022-04-24T17:10:04.708Z

        // Obtain an instance of Instant from a text string
        Instant specifyString = Instant.parse("2018-06-20T10:37:30.00Z");
        System.out.println("specifyString = " + specifyString);                 // specifyString = 2018-06-20T10:37:30Z

        // Tính theo unix timestamp
        Instant fromUnixTimestamp = Instant.ofEpochSecond(1262347200);

        // theo mili giây
        Instant fromEpochMilli = Instant.ofEpochMilli(1262347200000l);


        // Copy of this instant with the specified amount subtracted
        Instant minus5 = now.minus(Duration.ofDays(5));
        System.out.println("minus5 = " + minus5);                               // minus5 = 2022-04-19T17:10:04.708Z

        // Copy of this instant with the specified amount added
        Instant plus5 = now.plus(Duration.ofDays(5));
        System.out.println("plus5 = " + plus5);                                 // plus5 = 2022-04-29T17:10:04.708Z
    }
}
