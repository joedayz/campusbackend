package pe.joedayz.api.domain.model.repository;

import org.springframework.stereotype.Repository;
import pe.joedayz.api.dto.GeneralTableDto;
import pe.joedayz.api.dto.GeneralTableFilterDto;
import pe.joedayz.api.dto.GeneralTableViewRsl;

import java.util.List;

/**
 * Created by josediaz on 17/08/2016.
 */
@Repository
public interface GeneralTableJdbcRepository {

    long searchGeneralTablePageableTotalCount(GeneralTableFilterDto filter);

    long generateGeneralTableSearchQueryCodeUniqueTotalCount(GeneralTableFilterDto filter);

    List<GeneralTableViewRsl> searchGeneralTable(GeneralTableFilterDto filter, String paginable);

    List<GeneralTableDto> findGeneralTableByGroup();

}