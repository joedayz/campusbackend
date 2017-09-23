package pe.joedayz.api.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.joedayz.api.service.intf.TestService;

import javax.persistence.EntityManager;

@Service
public class TestServiceImpl implements TestService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    EntityManager em;

	public String test() {
        return "Hello, World!";
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateLocation(Long locationId, String creator, Integer rowVersion) {
/*
        Location location = em.find(Location.class, locationId);
        log.info("LOCATION "+location.getLocationId()+" "+location.getRowVersion()+"-->"+rowVersion);
        em.detach(location);
        //locationRepository.e
        location.setCreatedBy(creator);
        location.setRowVersion(rowVersion);

*/

        //em.merge(location);
    }
}
