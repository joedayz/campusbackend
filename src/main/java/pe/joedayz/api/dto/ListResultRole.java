package pe.joedayz.api.dto;

import java.util.List;

public class ListResultRole {
    private List<RoleViewDto> resultList;

    public List<RoleViewDto> getResultList() {
        return resultList;
    }

    public void setResultList(List<RoleViewDto> resultList) {
        this.resultList = resultList;
    }

}
