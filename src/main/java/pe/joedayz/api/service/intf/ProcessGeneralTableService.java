package pe.joedayz.api.service.intf;

import java.util.List;

import pe.joedayz.api.dto.GeneralTableDto;
import pe.joedayz.api.dto.maintenance.StatusProcessDto;

public interface ProcessGeneralTableService {
	
    List<StatusProcessDto> validateUniqueCodeForGroup(GeneralTableDto dto, boolean b);

    Long processDataSaveGeneralTable(GeneralTableDto dto)  throws Exception;

    Long processDataUpdateGeneralTable(GeneralTableDto dto)  throws Exception;   

}
