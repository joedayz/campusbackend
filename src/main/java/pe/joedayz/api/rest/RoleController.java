package pe.joedayz.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.joedayz.api.dto.ListResultModule;
import pe.joedayz.api.dto.PageableResult;
import pe.joedayz.api.dto.RoleFilterDto;
import pe.joedayz.api.dto.RoleViewDto;
import pe.joedayz.api.service.intf.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RoleService roleService;


	@RequestMapping(value = "/find", method = RequestMethod.POST, produces = "application/json")
	public PageableResult searchRampAreas(@RequestBody RoleFilterDto filter) {

		return roleService.find(filter);
	}

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET, produces = "application/json")
	public RoleViewDto viewRole(@PathVariable("id") Long roleId) {

		RoleViewDto roleViewDto = roleService.findById(roleId);
	    return roleViewDto;
	}


	@RequestMapping(value = "/findModuleActive", method = RequestMethod.POST, produces = "application/json")
	public ListResultModule searchModuleActive() {

		return roleService.findModuleActive(null);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody RoleViewDto dto) {

		String dataRoleProcess = roleService.save(dto);  //"";// searchDataProcessRampArea.getDataProcess(dto,false);

		return   new ResponseEntity<String>( dataRoleProcess , HttpStatus.CREATED);
	}


	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<String> delete(@RequestBody RoleViewDto dto) {
		String message = roleService.delete(dto);

		return   new ResponseEntity<String>("{\"message\":\""+message+"\"}", HttpStatus.CREATED);
	}


	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<String> update(@RequestBody RoleViewDto dto) {

		String dataRoleProcess = roleService.save(dto);

		return   new ResponseEntity<String>( dataRoleProcess , HttpStatus.CREATED);
	}

}