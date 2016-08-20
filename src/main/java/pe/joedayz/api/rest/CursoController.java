package pe.joedayz.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.joedayz.api.dto.CursoDto;
import pe.joedayz.api.dto.TemasCursoDto;
import pe.joedayz.api.service.impl.TemasCursoServiceImpl;
import pe.joedayz.api.service.intf.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private TemasCursoServiceImpl temasCursoService;
	
	@Autowired
	private CursoService cursoService;
	
	
    @RequestMapping(value="/temasDisponibles", method= RequestMethod.GET, produces="application/json")
    public List<TemasCursoDto> temasCursoByKey(@RequestParam("keyCurso") String keyCurso) {
        return temasCursoService.getTemasCursoByKey(keyCurso);
    }
    
    @RequestMapping(value="/datos/{keyCurso}", method= RequestMethod.GET, produces="application/json")
    public CursoDto datosCurso(@PathVariable("keyCurso") String keyCurso) {
        return cursoService.getDatosCurso(keyCurso);
    }
    
    
    @RequestMapping(value="/presenciales", method= RequestMethod.GET, produces="application/json")
    public List<CursoDto> cursosPresenciales() {
        return cursoService.getCursosPresenciales();
    }
    

    

    @RequestMapping(value="/online", method= RequestMethod.GET, produces="application/json")
    public List<CursoDto> cursosOnline() {
        return cursoService.getCursosOnline();
    }
    
    @RequestMapping(value="/videoCursos", method= RequestMethod.GET, produces="application/json")
    public List<CursoDto> videoCursos() {
        return cursoService.getVideoCursos();
    }
    
    
    @RequestMapping(value="/onlineDestacados", method= RequestMethod.GET, produces="application/json")
    public List<CursoDto> cursosOnlineDestacados() {
        return cursoService.getCursosOnlineDestacados();
    }    
    
    @RequestMapping(value="/presencialesDestacados", method= RequestMethod.GET, produces="application/json")
    public List<CursoDto> cursosPresencialesDestacados() {
        return cursoService.getCursosPresencialesDestacados();
    }    
    
    
    
    
    
    
    
}
