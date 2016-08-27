package pe.joedayz.api.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.joedayz.api.domain.model.repository.ParameterJdbcRepository;
import pe.joedayz.api.dto.PageableResult;
import pe.joedayz.api.dto.ParameterDto;
import pe.joedayz.api.dto.ParameterFilterDto;
import pe.joedayz.api.dto.ParameterViewRsl;
import pe.joedayz.api.service.intf.ParameterService;

@RestController
@RequestMapping("/parameter")
public class ParameterController {

	@Autowired
	private ParameterService parameterService;

	@Autowired
	private ParameterJdbcRepository parameterJdbcRepository;

	@RequestMapping(value = "/create/", method = RequestMethod.POST)
	public ResponseEntity<Long> createParameterService(@RequestBody ParameterDto value) {
		Long id = parameterService.createParameter(value);
		return new ResponseEntity<Long>(id, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ParameterDto> viewParameterService(@PathVariable("id") Long id) {
		ParameterDto result = parameterService.searchUniqueParameter(id);
		return new ResponseEntity<ParameterDto>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/searchParameter/", method = RequestMethod.POST, produces = "application/json")
	public PageableResult searchParameter(@RequestBody ParameterFilterDto filter) {
		PageableResult result = new PageableResult();
		result.setResultList(new ArrayList<>());

		long totalCount = parameterJdbcRepository.searchParameterPageableTotalCount(filter);
		result.setTotal(totalCount);

		if (totalCount > 0) {
			List<ParameterViewRsl> items = parameterJdbcRepository.searchParameter(filter, "T");
			result.setResultList(items);
		}
		return result;
	}

}

