package pe.joedayz.api.json;


import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import pe.joedayz.api.enums.YesNoEnum;


public class JsonYesNoEnumDeserializer extends JsonDeserializer<YesNoEnum> {

    @Override
    public YesNoEnum deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return YesNoEnum.findByCode(p.getText());
    }
}