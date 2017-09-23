package pe.joedayz.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.joedayz.api.dto.ArticuloDto;
import pe.joedayz.api.service.intf.BlogService;

@RestController
@RequestMapping("/blog")
public class BlogController {

	
	@Autowired
	private BlogService blogService;
	
    @RequestMapping(value="/destacados", method= RequestMethod.GET, produces="application/json")
    public List<ArticuloDto> articulosDestacados() {
        return blogService.getArticulosDestacados();
    }    
}
