package pe.joedayz.api.dto;

public class PageableFilter {

    private Long skip= 1L;
    private Long take= 10L;
    private Long pageSize= 10L;
    private Long page= 1L;

    private String sortColumn;
    private String sortDir;


    public Long getSkip() {
        return skip;
    }

    public void setSkip(Long skip) {
        this.skip = skip;
    }

    public Long getTake() {
        return take;
    }

    public void setTake(Long take) {
        this.take = take;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public String getSortColumn() {
        return sortColumn;
    }

    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }

    public String getSortDir() {
        return sortDir;
    }

    public void setSortDir(String sortDir) {
        this.sortDir = sortDir;
    }
}
