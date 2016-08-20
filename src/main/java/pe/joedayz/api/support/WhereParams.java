package pe.joedayz.api.support;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import pe.joedayz.api.util.StringUtil;


public class WhereParams {
    Map<String, Object> params = new HashMap<String, Object>();

    public WhereParams() {
    }

    public String filter(String sqlFilter, Map<String, Object> externalParams) {
        String paramName = extractParamName(sqlFilter);
        Object paramValue = externalParams.get(paramName);
        if (paramValue != null) {
            params.put(paramName, paramValue);
            return sqlFilter;
        } else
            return "";
    }

    public String filterRangeDate(String sqlFilter, Date start , Date end) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if(start!= null && end !=null ){
            return  sqlFilter + " BETWEEN TO_DATE('"+sdf.format(start)+" 00:00:00','dd/mm/yyyy HH24:MI:SS') "
             +" AND TO_DATE('"+sdf.format(end)+" 23:59:59','dd/mm/yyyy HH24:MI:SS')  ";
        }
        return "";
    }

    public String filter(String sqlFilter, Object paramValue) {
        if (paramValue == null || !StringUtil.hasText(String.valueOf(paramValue))) return "";
        String paramName = extractParamName(sqlFilter);
        params.put(paramName, paramValue);
        return sqlFilter;
    }

    public String filterNULL(String sqlFilter, Object paramValue) {
        if (paramValue == null || !StringUtil.hasText(String.valueOf(paramValue))) paramValue = null;
        String paramName = extractParamName(sqlFilter);
        params.put(paramName, paramValue);
        return sqlFilter;
    }


    public String replaceForDebug(String sql) {
        StringBuffer buf = new StringBuffer(sql);
        for (String paramName : params.keySet()) {
            String paramVal = String.valueOf(params.get(paramName));
            buf = StringUtil.replace(buf, ":"+paramName, paramVal);
        }
        return buf.toString();
    }

    public String filterIsNull(String sqlFilterNotNull, String sqlFilterNull, Object paramValue) {
        if (paramValue == null || !StringUtil.hasText(String.valueOf(paramValue))) {
            try {
                String paramName = extractParamName(sqlFilterNotNull);
                params.put(paramName, paramValue);
            } catch (ParamNameNotFound e) {
                //ignorar
            }
            return sqlFilterNull;
        } else {
            return filter(sqlFilterNotNull, paramValue);
        }
    }

    public static String replaceFull(String str, Map<String, String> params) {
        StringBuffer buf = new StringBuffer(str);
        for (String valueOld : params.keySet()) {
            String valueNew = params.get(valueOld);
            replace(buf, valueOld, valueNew);
        }
        return buf.toString();
    }

    public static StringBuffer replace(StringBuffer buf, String valueOld, String valueNew) {
        while (true) {
            int idx = buf.indexOf(valueOld);
            if (idx == -1) {
                break;
            }
            buf.replace(idx, idx + valueOld.length(), valueNew);
        }
        return buf;

    }

    public static String replace(String buf, String valueOld, String valueNew) {
        return replace(new StringBuffer(buf), valueOld, valueNew).toString();
    }

    public String filterIn(String sqlFilter, Collection paramsList, String enclosing) {
        if (paramsList == null || paramsList.isEmpty()) return "";
        String paramName = extractParamName(sqlFilter);
        sqlFilter = StringUtil.replace(sqlFilter, ":" + paramName, StringUtil.concat(paramsList, ",", enclosing));
        return sqlFilter;
    }

    private String extractParamName(String sqlFilter) {
        int idx = sqlFilter.indexOf(':');

        if (idx < 0) throw new ParamNameNotFound(sqlFilter);
        int idx2 = StringUtil.firstIdx(sqlFilter, idx, " ", ")", "\n", "\t");
        if (idx2 < 0) idx2 = sqlFilter.length();
        return sqlFilter.substring(idx + 1, idx2);
    }

    public Map<String, Object> getParams() {
        return params;
    }


    public static class ParamNameNotFound extends IllegalArgumentException {
        public ParamNameNotFound(String sqlFilter) {
            super("No se pudo encontrar parametro con prefido ':' " + sqlFilter);
        }
    }
}
