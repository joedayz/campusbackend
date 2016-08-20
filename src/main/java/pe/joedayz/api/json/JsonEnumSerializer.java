package pe.joedayz.api.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import pe.joedayz.api.util.EnumBase;


@SuppressWarnings("rawtypes")
public class JsonEnumSerializer extends JsonSerializer<EnumBase> {

	@Override
    public void serialize (EnumBase value, JsonGenerator gen, SerializerProvider arg2)
            throws IOException, JsonProcessingException {
        gen.writeString((value.getCode()));
    }
}
