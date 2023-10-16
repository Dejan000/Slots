package slots.service;

import java.util.List;

import slots.model.Znak;

public interface ZnakService {
	
	List<Znak> findBySlot(Long slotId);
	Znak findByOznaka(String oznaka);

}
