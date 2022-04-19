package guru.springframework.sfgpetclinic;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.TimeZone;

public class DateExample {
    public static void main(String...args){
        System.out.println("Start");
        final Date date = new Date();
        final String ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS zzz";
        final SimpleDateFormat sdf = new SimpleDateFormat(ISO_FORMAT);
        System.out.println(sdf.format(date));

        final TimeZone utc = TimeZone.getTimeZone("UTC");
        System.out.println(utc);
        System.out.println(utc.getDisplayName());


        sdf.setTimeZone(utc);
        System.out.println(sdf.format(date));
        System.out.println("------------");


        Instant instant = date.toInstant() ;
        OffsetDateTime now = OffsetDateTime.now( ZoneOffset.UTC );
        System.out.println( "instant.toString(): " + instant );

    }
}
