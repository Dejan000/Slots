package slots.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import slots.model.Polje;
import slots.repository.PoljeRepository;
import slots.service.PoljeService;

@Service
public class PoljeServiceImpl implements PoljeService {
	
	@Autowired
	private PoljeRepository poljeRepository;

	@Override
	public Polje findOneById(Long id) {
		// TODO Auto-generated method stub
		return poljeRepository.findOneById(id);
	}

}
