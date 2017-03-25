package pe.joedayz.api.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import pe.joedayz.api.domain.model.repository.ModuleJdbcRepository;
import pe.joedayz.api.dto.*;
import pe.joedayz.api.service.impl.ModuleServiceImpl;

@RestController
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    private ModuleServiceImpl moduleService;

    @Autowired
	private ModuleJdbcRepository moduleJdbcRepository;

    @RequestMapping(value="/allowedModules", method= RequestMethod.GET, produces="application/json")
    public List<ModuleDto> allowedModules(@RequestParam("username") String userName) {
        return moduleService.getAllowedModulesByUserId(userName);
    }

    @RequestMapping(value="/allModulesWithPermission", method= RequestMethod.GET, produces="application/json")
    public List<ModuleDto> modulesWithPermission(@RequestParam("username") String userName) {
        return moduleService.getAllModulesWithPermsByUserId(userName);
    }


    @RequestMapping(value="/permissionModules", method= RequestMethod.GET, produces="application/json")
    public List<ModuleDto> permissionModules(@RequestParam("username") String userName) {
        return moduleService.getPermissionModulesByUserId(userName);
    }

    @RequestMapping(value="/visibleModules", method= RequestMethod.GET, produces="application/json")
    public List<ModuleDto> visibleModules() {
        return moduleService.getAllVisibleModules();
    }

    @RequestMapping(value = "/searchModule/", method = RequestMethod.POST, produces = "application/json")
	public PageableResult searchModule(@RequestBody ModuleFilterDto filter) {

		PageableResult result = new PageableResult();
		result.setResultList(new ArrayList<>());

		long totalCount = moduleJdbcRepository.searchModulePageableTotalCount(filter);
		result.setTotal(totalCount);

		if (totalCount > 0) {
			List<ModuleViewRsl> items = moduleJdbcRepository.searchModule(filter, "T");
			result.setResultList(items);
		}
		return result;
	}
    
    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ModuleViewDto> viewModuleService(@PathVariable("id") Long id) {

    	ModuleViewDto result =  moduleJdbcRepository.findModuleById(id);

		return new ResponseEntity<ModuleViewDto>(result, HttpStatus.OK);
	}
    
    @RequestMapping(value = "/update/", method = RequestMethod.POST)
	public ResponseEntity<Long> updateModule(@RequestBody ModuleViewDto value) {
		Long id = moduleService.updateModule(value);
		return new ResponseEntity<Long>(id, HttpStatus.CREATED);

	}

}
