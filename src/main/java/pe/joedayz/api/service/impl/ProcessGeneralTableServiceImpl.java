package pe.joedayz.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.joedayz.api.domain.model.entities.GeneralTable;
import pe.joedayz.api.domain.model.repository.GeneralTableJdbcRepository;
import pe.joedayz.api.domain.model.repository.jpa.GeneralTableJpaRepository;
import pe.joedayz.api.dto.GeneralTableDto;
import pe.joedayz.api.dto.GeneralTableFilterDto;
import pe.joedayz.api.dto.maintenance.StatusProcessDto;
import pe.joedayz.api.enums.GeneralTableStatusEnum;
import pe.joedayz.api.rest.GenericRestException;
import pe.joedayz.api.service.intf.ProcessGeneralTableService;


@Service
public class ProcessGeneralTableServiceImpl implements ProcessGeneralTableService {

	final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	GeneralTableJpaRepository generalTableJpaRepository;

	@Autowired
	GeneralTableJdbcRepository generalTableJdbcRepository;

	@Override
	public List<StatusProcessDto> validateUniqueCodeForGroup(GeneralTableDto dto, boolean isEdit) {
		List<StatusProcessDto> statusProcessDtos = new ArrayList<>();

		GeneralTableFilterDto filter = new GeneralTableFilterDto();
		//filter.setGroup(dto.getGroup());
		filter.setCode(dto.getCode());

		long val;
		if (isEdit) {
			filter.setValidateNotGeneralTableId(dto.getGeneralTableId());
			val = generalTableJdbcRepository.generateGeneralTableSearchQueryCodeUniqueTotalCount(filter);
		} else {
			val = generalTableJdbcRepository.generateGeneralTableSearchQueryCodeUniqueTotalCount(filter);
		}

		if (val > 0) {
			StatusProcessDto statusProcessDto = new StatusProcessDto();
			statusProcessDto.setStatus("Error");
			statusProcessDto.setMessage("Code in group must be unique");
			statusProcessDtos.add(statusProcessDto);
		}

		return statusProcessDtos;
	}

	@Override
	public Long processDataSaveGeneralTable(GeneralTableDto dto) throws Exception {

		try {

			GeneralTable entity = new GeneralTable();

			entity.setCode(dto.getCode());
			entity.setSortOrder(dto.getSortOrder());
			entity.setStatus(GeneralTableStatusEnum.findByCode(dto.getStatus()));
			//entity.setTableName(dto.getGroup());
			entity.setValue(dto.getValue());

			generalTableJpaRepository.save(entity);
			generalTableJpaRepository.flush();

			return entity.getGeneralTableId();

		} catch (Exception e) {
			LOG.debug("ERROR", e);
			String msg = ((e == null) ? "" : e.getMessage());

			throw new GenericRestException("ERR_001", msg);
		}

	}

	@Override
	public Long processDataUpdateGeneralTable(GeneralTableDto dto) throws Exception {
		try {

			GeneralTable entity = generalTableJpaRepository.findOne(dto.getGeneralTableId());

			entity.setCode(dto.getCode());
			entity.setSortOrder(dto.getSortOrder());
			entity.setStatus(GeneralTableStatusEnum.findByCode(dto.getStatus()));
			//entity.setTableName(dto.getGroup());
			entity.setValue(dto.getValue());

			generalTableJpaRepository.save(entity);
			generalTableJpaRepository.flush();

			return entity.getGeneralTableId();

		} catch (Exception e) {
			LOG.debug("ERROR", e);
			String msg = ((e == null) ? "" : e.getMessage());

			throw new GenericRestException("ERR_001", msg);
		}
	}

	/*
	 * @Override public List<StatusProcessDto>
	 * validateDataGeneralTable(GeneralTableDto drayMilesRestrictionViewItem,
	 * boolean b) { // TODO Auto-generated method stub return null; }
	 */

}
