package slots.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import slots.model.Linija;
import slots.service.LinijaService;

@Service
public class LinijaServiceImpl implements LinijaService {
	
	@Autowired
	private LinijaService linijaService;

	@Override
	public Linija findOneById(Long id) {
		
		return linijaService.findOneById(id);
	}

}
