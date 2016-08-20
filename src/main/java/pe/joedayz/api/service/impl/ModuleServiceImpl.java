package pe.joedayz.api.service.impl;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.joedayz.api.domain.model.entities.Module;
import pe.joedayz.api.domain.model.repository.jdbc.ModuleCustomRepository;
import pe.joedayz.api.domain.model.repository.jpa.ModuleJpaRepository;
import pe.joedayz.api.dto.ModuleDto;
import pe.joedayz.api.dto.ModuleParentDto;
import pe.joedayz.api.dto.ModuleViewDto;
import pe.joedayz.api.enums.ModuleVisibleEnum;
import pe.joedayz.api.enums.YesNoEnum;
import pe.joedayz.api.rest.GenericRestException;

@Service
public class ModuleServiceImpl  {

//	@Value("${module.errorcode}")
	private String errorcode;

//	@Value("${module.messageerror}")
	private String messageerror;

//	@Value("${module.messagesuccess}")
	private String messagesuccess;
	
//	@Value("${module.messageerror.create}")
	private String module_messageerror_create;
	
    @Autowired
    Mapper mapper;

    @Autowired
    ModuleCustomRepository moduleCustomRepository;

    @Autowired
    ModuleJpaRepository moduleJpaRepository;

    public List<ModuleDto> getAllowedModulesByUserId(String userName) {
        List<ModuleParentDto> allowedMods = moduleCustomRepository.getAllowedModulesByUserId(userName);
        List<ModuleParentDto> distintc = new ArrayList<>(new LinkedHashSet<>(allowedMods));
        List<ModuleDto> moduleDtos = groupByParentModule(distintc);
        return moduleDtos;
    }

    public List<ModuleDto> getAllModulesWithPermsByUserId(String userName) {
        List<ModuleParentDto> allowedMods = moduleCustomRepository.getPermissionModulesByUserId(userName);
        List<ModuleParentDto> distintc = new ArrayList<>(new LinkedHashSet<>(allowedMods));
        List<ModuleDto> moduleDtos = groupByParentModule(distintc);
        return moduleDtos;
    }


    public List<ModuleDto> getPermissionModulesByUserId(String userName) {
        List<ModuleParentDto> allowedMods = moduleCustomRepository.getPermissionModulesByUserId(userName);
        List<ModuleParentDto> distintc = new ArrayList<>(new LinkedHashSet<>(allowedMods));
        List<ModuleDto> moduleDtos = groupByParentModule(distintc);
        return moduleDtos;
    }

    public List<ModuleDto> getAllVisibleModules() {
        List<Module> allVisible = moduleJpaRepository.findByVisible(YesNoEnum.YES);
        List<ModuleDto> allModules = allVisible
                .stream()
                .map(m -> mapper.map(m, ModuleDto.class))
                .distinct()
                .collect(toList());
        return allModules;
    }

    protected List<ModuleDto> groupByParentModule(List<ModuleParentDto> parents){
        List<ModuleDto> modules = new ArrayList<>();

        if (parents.size() == 0) {
            return modules;
        }

        Mapper mapper = new DozerBeanMapper();


        int idx = 0;
        ModuleParentDto parent = parents.get(idx);
        while(idx < parents.size()){
            String codMod = parent.getParentCode();
            ModuleDto moduleDto = new ModuleDto();
            moduleDto.setCode(parent.getParentCode()); 
            moduleDto.setName(parent.getParentName());
            List<ModuleDto> subModules = new ArrayList<>();
            do {
                ModuleDto subModule = mapper.map(parent, ModuleDto.class);
                subModules.add(subModule);
                if (idx++ == parents.size()-1){
                    break;
                }
                parent = parents.get(idx);
            } while (codMod.equals(parent.getParentCode()));
            moduleDto.setSubModules(subModules);
            modules.add(moduleDto);

        }

        return modules;
    }

    public Long updateModule(ModuleViewDto value){
    	
    	Module entity = new Module();
    	BeanUtils.copyProperties(value, entity, "updatedBy", "updatedDate");
    	
    	entity.setVisible(YesNoEnum.findByCode(value.getVisible()));
    	
    	if(value.getParentModuleId() != null){
	    	Module entityParent = new Module();
	    	entityParent.setModuleId(value.getParentModuleId());
	    	entity.setModule(entityParent);
    	}
    	
    	try{
			entity=moduleJpaRepository.save(entity);
		}catch (Exception e) {
			throw new GenericRestException(errorcode, module_messageerror_create);
		}
    	
    	return entity.getModuleId();
    }
    
}