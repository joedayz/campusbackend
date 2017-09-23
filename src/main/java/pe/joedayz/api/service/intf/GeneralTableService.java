package pe.joedayz.api.service.intf;

import pe.joedayz.api.dto.GeneralTableDto;
import pe.joedayz.api.dto.GeneralTableFilterDto;
import pe.joedayz.api.dto.PageableResult;

/**
 * Created by josediaz on 17/08/2016.
 */
public interface GeneralTableService {

    PageableResult findList(GeneralTableFilterDto filter);
    GeneralTableDto findById(Long generalTableId);
    String delete(Long generalTableid);
    Long create(GeneralTableDto value);
}
