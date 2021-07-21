package pe.joedayz.api.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.joedayz.api.domain.model.entities.Parameter;
import pe.joedayz.api.domain.model.repository.jpa.ParameterJpaRepository;
import pe.joedayz.api.dto.ParameterDto;
import pe.joedayz.api.enums.ActiveInactiveStatusEnum;
import pe.joedayz.api.rest.GenericRestException;
import pe.joedayz.api.service.intf.ParameterService;

@Service
public class ParameterServiceImpl implements ParameterService {
	
	@Value("${parameter.errorcode}")
	private String errorcode;
	
	@Value("${parameter.messageerror}")
	private String messageerror;
	
	@Value("${parameter.messagesuccess}")
	private String messagesuccess;
	
	@Value("parameter.messageerrorcreate")
	private String messageerrorcreate;
	
	@Value("${parameter.messageerror.create}")
	private String parameter_messageerror_create;	

	@Autowired
	ParameterJpaRepository parameterJpaRepository;
	

	@Override
	@Transactional
	public Long createParameter(ParameterDto value) {
		Parameter entity = new Parameter();
		if(value.getParameterId() == null){
			value.setParameterId(-1L);
			if(parameterJpaRepository.findByCodeUnique(value.getCode()) != null){
				throw new GenericRestException(errorcode, messageerrorcreate);
			}
			BeanUtils.copyProperties(value, entity, "createdBy", "createdDate", "updatedBy", "updatedDate");
		} else {
			BeanUtils.copyProperties(value, entity, "updatedBy", "updatedDate");			
		}
		
		entity.setStatus(ActiveInactiveStatusEnum.findByCode(value.getStatus()));
		
		try{
			parameterJpaRepository.save(entity);
		}catch (Exception e) {
			throw new GenericRestException(errorcode, parameter_messageerror_create);
		}

		return entity.getParameterId();
	}

	@Override
	public ParameterDto searchUniqueParameter(Long parameterId) {
		Parameter entity = parameterJpaRepository.findOne(parameterId);
		ParameterDto viewDto = new ParameterDto();
		BeanUtils.copyProperties(entity, viewDto);
		
		viewDto.setStatus(entity.getStatus().getCode());
		
		return viewDto;
	}

}
