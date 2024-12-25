package com.example.corejava.datetime;


import java.time.*;
import java.time.format.DateTimeFormatter;

public class Example {

    public static void run() {
        datetime();
    }

    private static void datetime() {
        System.out.println("7.1.1. LocalDate, LocalTime, and LocalDateTime ");
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();

        System.out.println("Today: " + today);
        System.out.println("Current time: " + now);
        System.out.println("Current date and time: " + currentDateTime);

        System.out.println("7.1.2. ZonedDateTime and ZoneId ");
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("Current time in New York: " + zonedDateTime);

        System.out.println("7.1.3. Instant");
        Instant instant = Instant.now();
        System.out.println("Current timestamp: " + instant);

        System.out.println("7.1.4. Duration and Period");
        Duration duration = Duration.between(LocalTime.now(), LocalTime.now().plusHours(2));
        Period period = Period.between(LocalDate.now(), LocalDate.now().plusDays(10));
        System.out.println("Duration: " + duration);
        System.out.println("Period: " + period);

        System.out.println("7.1.5. DateTimeFormatter");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.now();
        String formatted = dateTime.format(formatter);
        System.out.println("Formatted DateTime: " + formatted);

        LocalDateTime parsedDateTime = LocalDateTime.parse("24-12-2024 14:30", formatter);
        System.out.println("Parsed DateTime: " + parsedDateTime);

    }


}
