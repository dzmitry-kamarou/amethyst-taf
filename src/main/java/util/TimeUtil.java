package util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeUtil extends JsonDeserializer<Calendar> {

  private static final String DEFAULT_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSX";

  @Override
  public Calendar deserialize(JsonParser jsonParser, DeserializationContext context) {
    try {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(new SimpleDateFormat(DEFAULT_TIME_FORMAT).parse(jsonParser.getText()));
      return calendar;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
