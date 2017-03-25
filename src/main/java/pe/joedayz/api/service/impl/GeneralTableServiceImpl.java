package pe.joedayz.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.joedayz.api.domain.model.entities.GeneralTable;
import pe.joedayz.api.domain.model.repository.GeneralTableJdbcRepository;
import pe.joedayz.api.domain.model.repository.jpa.GeneralTableJpaRepository;
import pe.joedayz.api.dto.GeneralTableDto;
import pe.joedayz.api.dto.GeneralTableFilterDto;
import pe.joedayz.api.dto.GeneralTableViewRsl;
import pe.joedayz.api.dto.PageableResult;
import pe.joedayz.api.enums.GeneralTableStatusEnum;
import pe.joedayz.api.rest.GenericRestException;
import pe.joedayz.api.service.intf.GeneralTableService;
import pe.joedayz.api.service.intf.ProcessGeneralTableService;

@Service
public class GeneralTableServiceImpl implements GeneralTableService {

//	@Value("${generaltable.errorcode}")
	private String errorcode;

//	@Value("${generaltable.messageerror}")
	private String messageerror;

//	@Value("${generaltable.messagesuccess}")
	private String messagesuccess;
	
//	@Value("${generaltable.messageerror.create}")
	private String messageerrorcreate;
	
//	@Value("${generaltable.messageerror.create}")
	private String generaltable_messageerror_create;
	
	@Autowired
	GeneralTableJdbcRepository generalTableJdbcRepository;

	@Autowired
	GeneralTableJpaRepository generalTableJpaRepository;

	@Autowired
	ProcessGeneralTableService processGeneralTableService;

	@Override
	public PageableResult findList(GeneralTableFilterDto filter) {
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

	@Override
	public GeneralTableDto findById(Long generalTableId) {
		
		GeneralTable entity = new GeneralTable();
		GeneralTableDto viewDto = new GeneralTableDto();
		entity = generalTableJpaRepository.findOne(generalTableId);
		
		BeanUtils.copyProperties(entity, viewDto);
		
		viewDto.setStatus(entity.getStatus().getCode());
		
		return viewDto;
	}

	@Override
	public String delete(Long generalTableid) {
		try {
			
			generalTableJpaRepository.delete(generalTableid);
			
			return messagesuccess;
		} catch (Exception e) {

			throw new GenericRestException(errorcode, messageerror);
		}
	}

	@Override
	public Long create(GeneralTableDto value) {
		GeneralTable entity = new GeneralTable();
		if (value.getGeneralTableId() == null) {
			value.setGeneralTableId(-1L);
			if (generalTableJpaRepository.findByCode(value.getCode(),value.getTableName()) != null) {
				throw new GenericRestException(errorcode, messageerrorcreate);
			}
			BeanUtils.copyProperties(value, entity, "createdBy", "createdDate", "updatedBy", "updatedDate");
			
		} else {
			BeanUtils.copyProperties(value, entity, "updatedBy", "updatedDate");			
		}
		
		entity.setStatus(GeneralTableStatusEnum.findByCode(value.getStatus()));
		
		try{
			entity=generalTableJpaRepository.save(entity);
		}catch (Exception e) {
			throw new GenericRestException(errorcode, generaltable_messageerror_create);
		}
		
		return entity.getGeneralTableId();

	}

}