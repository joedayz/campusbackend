package pe.joedayz.api.support;

import pe.joedayz.api.dto.PageableFilter;

public class PageableQuery {

    //private String fromSection;
    private String mainSection;
    //private String orderBySection;

    private PageableFilter pageableFilter;

    public PageableQuery(PageableFilter pageableFilter){
        this.pageableFilter=pageableFilter;
    }

    public void addMainSection(String mainSection){
        this.mainSection=mainSection;
    }

//    public void addOrderBySection(String orderBySection){
//        this.orderBySection=orderBySection;
//    }

    public String buildQuery(){

        StringBuilder query= new StringBuilder();
        /*
        select *
                from (
                        select temp.*,
                        row_number()
                        over (order by sal desc) rn
                        from temp
                )
        where rn <= 3
        order by sal desc

                */
        String sortQuery=buildSortSecction();

        query.append("select * ");
        query.append(" from (");
        query.append(" select temp.*,");

        //sort
        if(sortQuery !=null && !sortQuery.isEmpty()){
            query.append(" row_number() over ( ").append(sortQuery).append(" ) ");
        }else{
            query.append(" ROWNUM ");
        }

        query.append(" rn");
        query.append(" from ( ") ;

        query.append(mainSection);

        query.append(" )temp");

        query.append(" )");
        query.append(" where ");
//filter.getSkip().intValue(),filter.getSkip().intValue()+filter.getTake().intValue()
        int fromRow=pageableFilter.getSkip().intValue()+1;
        int toRow=pageableFilter.getSkip().intValue()+pageableFilter.getTake().intValue();
        query.append(" rn>= ").append(fromRow);
        query.append(" and rn<= ").append(toRow);

        query.append(sortQuery);
        //query.append(" order by sal desc");

        return query.toString();
    }

    private String buildSortSecction(){
        StringBuilder query= new StringBuilder();
        if(pageableFilter.getSortColumn() !=null && !pageableFilter.getSortColumn().isEmpty()){

            query.append(" order by  ").append(pageableFilter.getSortColumn());

            if(pageableFilter.getSortDir() !=null && !pageableFilter.getSortDir().isEmpty()){
                query.append(" ").append(pageableFilter.getSortDir());
            }else{
                query.append(" asc ");
            }
        }

        return query.toString();

    }
}
