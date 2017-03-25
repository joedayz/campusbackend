package pe.joedayz.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.joedayz.api.domain.model.repository.jdbc.PortadaCustomRepository;
import pe.joedayz.api.dto.PortadaDto;

@RestController
@RequestMapping("/portada")
public class PortadaController {

	@Autowired
	private PortadaCustomRepository portadaJdbcRepository;
	
    @RequestMapping(value="/fotos", method= RequestMethod.GET, produces="application/json")
    public List<PortadaDto> getFotos() {
        return portadaJdbcRepository.getFotosPrincipalesDelHome();
    }
    
	
}
