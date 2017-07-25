package com.jumore.zhxf.util;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;
import java.util.Calendar;
import java.util.Date;

public class ZonedDateTimeTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("======================================");
        String instantStr1 = "2049-01-02T03:48:00Z";
        printYearAndWeekOfYear(instantStr1);
        System.out.println("======================================");
        String instantStr2 = "2049-12-31T03:48:00Z";
        printYearAndWeekOfYear(instantStr2);
        System.out.println("======================================");
    }

    public static void printYearAndWeekOfYear(String ISODate) {
        System.out.println("Date provided -> " + ISODate);

        ZonedDateTime utcTimestamp = parseToInstant(ISODate).atZone(ZoneOffset.UTC);
        int year = utcTimestamp.getYear();
        int weekOfYear = utcTimestamp.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
        System.out.println("Using ZonedDateTime API:: Year " + year + " weekOfYear " + weekOfYear);


        Date d1 = Date.from(parseToInstant(ISODate));
        Calendar cl = Calendar.getInstance();
        cl.setTime(d1);
        int year1 = cl.get(Calendar.YEAR);
        int weekOfYear1 = cl.get(Calendar.WEEK_OF_YEAR);
        System.out.println("Using Calendar API:: Year " + year1 + " weekOfYear " + weekOfYear1);
    }

    public static Instant parseToInstant(String ISODate) {
        return DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(ISODate, Instant::from);
    }
}
