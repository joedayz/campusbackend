package pe.joedayz.api.util;

import java.math.BigDecimal;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtil {
    static final Logger LOG = LoggerFactory.getLogger(JsonUtil.class);


    public static String getString(JSONObject jsonObject, String key){
        try{
            return jsonObject.getString(key);
        }catch (Exception ex){
            LOG.error("error in json value <"+key+">",ex);
        }
        return null;
    }
    public static boolean getBoolean(JSONObject jsonObject, String key){
        try{
            return jsonObject.getBoolean(key);
        }catch (Exception ex){
            LOG.error("error in json value <"+key+">",ex);
        }
        return false;
    }
    public static BigDecimal getBigDecimal(JSONObject jsonObject, String key){
        try{
            return jsonObject.getBigDecimal(key);
        }catch (Exception ex){
            LOG.error("error in json value <"+key+">",ex);
        }
        return null;
    }
    public static Long getLong(JSONObject jsonObject, String key){
        try{
            return jsonObject.getLong(key);
        }catch (Exception ex){
            LOG.error("error in json value <"+key+">",ex);
        }
        return null;
    }
}
