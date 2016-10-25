package fi.eis.applications.highscore.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class DateISO8601Serializer extends StdSerializer<Date>{

    private static final String ISO8601_TIMESTAMP_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final TimeZone tz = TimeZone.getTimeZone("UTC");

    public static String toISO8601(Date date) {
        // remember, simpledateformat needs to be created every time
        // since it is internally unstable
        DateFormat df = new SimpleDateFormat(ISO8601_TIMESTAMP_PATTERN);
        df.setTimeZone(tz);
        return df.format(date);
    }

    protected DateISO8601Serializer() {
        super(Date.class, true);
    }

    @Override
    public void serialize(Date timestamp, JsonGenerator jgen, SerializerProvider arg2)
            throws IOException, JsonGenerationException {
        String convertedTs = toISO8601(timestamp);
        jgen.writeString(convertedTs);
    }

}