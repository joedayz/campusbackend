package pe.joedayz.api.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageableResult<T> {

    public PageableResult(){
        aggregates= new HashMap<>();
    }

    private long total;
    private List<T> resultList;

    private Map<String, Object> aggregates;


    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    public Map<String, Object> getAggregates() {
        return aggregates;
    }

    public void setAggregates(Map<String, Object> aggregates) {
        this.aggregates = aggregates;
    }
}
