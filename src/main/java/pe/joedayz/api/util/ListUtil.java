package pe.joedayz.api.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by RAZANERO on 24/02/14.
 */
public class ListUtil {
    public static <T> List<T> asList(Iterable<T> iterable) {
        ArrayList<T> list = new ArrayList<T>();
        for (Iterator<T> iterator = iterable.iterator(); iterator.hasNext(); ) {
            T next = iterator.next();
            list.add(next);

        }
        return list;
    }

    public static <T> List<T> safeNull(List<T> railRates2) {
        if (railRates2 != null) return railRates2;
        return new ArrayList<>();
    }

    public static <Bean, Property> List<Property> asColumnList(List<Bean> laneRoutingCalculations, Function<Bean, Property> function) {
        return laneRoutingCalculations.stream().map(function).collect(Collectors.toList());
    }

    public static <T> List<List<T>> split(List<T> list, int maxSize) {
        List<List<T>> listMaster = new ArrayList<>();
        for (int startIdx = 0, endIdx; startIdx < list.size(); startIdx = endIdx) {
            endIdx = Math.min(startIdx + maxSize, list.size());
            listMaster.add(list.subList(startIdx, endIdx));
        }

        return listMaster;
    }

    public static String forLog(List list) {
        if (list == null) return "NULL";
        if (list.size() < 20) return list.toString();
        else return list.subList(0, 19).toString()+"...";
    }

    public static <TBean, TIds> List<TBean> queryIn1000(List<TIds> idsFull, Function<List<TIds>, Iterable<TBean>> queryFunction) {
        List<TBean> list = new ArrayList<>();
        idsFull = idsFull.stream().distinct().collect(Collectors.toList());
        for (int startIdx = 0, endIdx; startIdx < idsFull.size(); startIdx = endIdx) {
            endIdx = Math.min(startIdx + ContextUtils.MAX_QUERY_IN, idsFull.size());
            List<TIds> id1000s = idsFull.subList(startIdx, endIdx);
            list.addAll(asList(queryFunction.apply(id1000s)));
        }
        return list;
    }

    public static <TIds> List<TIds> join(List<TIds>... subList) {
        List<TIds> list = new ArrayList<>();
        for (int i = 0; i < subList.length; i++) {
            List<TIds> tIdses = subList[i];
            list.addAll(tIdses);
        }
        return list;
    }
}
