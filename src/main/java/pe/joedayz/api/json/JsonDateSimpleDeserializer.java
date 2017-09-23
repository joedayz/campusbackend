package pe.joedayz.api.json;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class JsonDateSimpleDeserializer extends JsonDeserializer<Date> {
    private SimpleDateFormat formatter =
            new SimpleDateFormat("MM/dd/yyyy");

    static private SimpleDateFormat formatterFull =
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");


    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String dateAsString = p.getText();
        try {
            if (!StringUtils.hasText(dateAsString)) {
                return null;
            }
            if(dateAsString.length()>10){
                return formatterFull.parse(dateAsString);
            }
            return formatter.parse(dateAsString);

        }
        catch (ParseException pe) {
            throw new RuntimeException(pe);
        }
    }

}