package pe.joedayz.api.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.joedayz.api.domain.model.entities.GeneralTable;
import pe.joedayz.api.domain.model.repository.GeneralTableJdbcRepository;
import pe.joedayz.api.domain.model.repository.jpa.GeneralTableJpaRepository;
import pe.joedayz.api.dto.*;
import pe.joedayz.api.service.intf.GeneralTableService;

/**
 * Created by MATRIX-JAVA on 2/5/2016.
 */
@RestController
@RequestMapping("/generalTable")
public class GeneralTableController {

	final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private GeneralTableJpaRepository generalTableJpaRepository;

    @Autowired
    private GeneralTableJdbcRepository generalTableJdbcRepository;
    
    @Autowired
    private GeneralTableService generalTableService;

    @RequestMapping(value="/allEnums", method= RequestMethod.GET, produces="application/json")
    public Map allEnums() {

        Iterable<GeneralTable> generalTableIter=generalTableJpaRepository.findAll();

        List<ComboDto> generalTableList= new ArrayList<ComboDto>();

        for (GeneralTable item:generalTableIter ) {
            ComboDto dto= new ComboDto();
            dto.setCode(item.getCode());
            dto.setName(item.getValue());

            String tableEnum=item.getTableName().substring(item.getTableName().lastIndexOf(".")+1);
            tableEnum  = Character.toLowerCase(tableEnum.charAt(0)) +
                    (tableEnum.length() > 1 ? tableEnum.substring(1) : "");
            dto.setTableName(tableEnum);
            dto.setOrder(item.getSortOrder());

            generalTableList.add(dto);
        }

        Map<String, List<ComboDto>> mapList = generalTableList.stream().collect(Collectors.groupingBy(ComboDto::getTableName));


        mapList.forEach((k,v)-> v.sort((ComboDto o1,ComboDto o2)->o1.getOrder().compareTo(o2.getOrder())));
        return mapList;

    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET, produces = "application/json")
	public GeneralTableDto viewGeneralTable(@PathVariable("id") Long generalTableId) {

    	GeneralTableDto generalTableDto = generalTableService.findById(generalTableId);

	    return generalTableDto;
	}
    
    @RequestMapping(value = "/find/", method = RequestMethod.POST, produces = "application/json")
	public PageableResult searchGeneralTables(@RequestBody GeneralTableFilterDto filter) {
    	
    	PageableResult result = new PageableResult();
		result.setResultList(new ArrayList<>());

		long totalCount = generalTableJdbcRepository.searchGeneralTablePageableTotalCount(filter);
		result.setTotal(totalCount);

		if (totalCount > 0) {
			List<GeneralTableViewRsl> items = generalTableJdbcRepository.searchGeneralTable(filter, "T");
			result.setResultList(items);
		}

		return result;
	}
    
    @RequestMapping(value = "/create/", method = RequestMethod.POST)
	public ResponseEntity<Long> create(@RequestBody GeneralTableDto value) {
		
		Long id = generalTableService.create(value);
		return new ResponseEntity<Long>(id , HttpStatus.CREATED);
	}
    
    @RequestMapping(value = "/delete/", method = RequestMethod.POST)
	public ResponseEntity<String> delete(@RequestBody GeneralTableDto value) {
		
    	String message = generalTableService.delete(value.getGeneralTableId());
		return new ResponseEntity<String>("{\"message\":\"" + message + "\"}", HttpStatus.CREATED);

    }



}
