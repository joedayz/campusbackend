package pe.joedayz.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.joedayz.api.dto.HangoutDto;
import pe.joedayz.api.service.intf.HangoutService;

@RestController
@RequestMapping("/hangout")
public class HangoutController {

	
	@Autowired
	private HangoutService hangoutService;
	
    @RequestMapping(value="/destacados", method= RequestMethod.GET, produces="application/json")
    public List<HangoutDto> hangoutsDestacados() {
        return hangoutService.getHangoutsDestacados();
    }    
    
}
