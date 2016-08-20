package pe.joedayz.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import pe.joedayz.api.domain.model.entities.Parameter;
import pe.joedayz.api.domain.model.repository.jpa.ParameterJpaRepository;
import pe.joedayz.api.service.intf.ParamService;

@Service
public class ParamServiceImpl implements ParamService {


    @Autowired
    ParameterJpaRepository parameterJpaRepository;


    @Override
    @Cacheable("parameter" )
    public Parameter getByCode(String code) {
        List<Parameter> list = parameterJpaRepository.findByCode(code);
        return list.size() == 0 ? null : list.get(0);
    }
}
