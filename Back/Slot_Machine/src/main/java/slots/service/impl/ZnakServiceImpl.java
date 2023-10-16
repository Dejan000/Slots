package slots.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import slots.model.Znak;
import slots.repository.ZnakRepository;
import slots.service.ZnakService;


@Service
public class ZnakServiceImpl implements ZnakService {
	
	@Autowired
	private ZnakRepository znakRepository;

	@Override
	public List<Znak> findBySlot(Long slotId) {
		
		return znakRepository.getZnakovi(slotId);
	}

	@Override
	public Znak findByOznaka(String oznaka) {
		// TODO Auto-generated method stub
		return znakRepository.findOneByOznaka(oznaka);
	}

}
