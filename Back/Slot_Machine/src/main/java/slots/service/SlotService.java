package slots.service;

import java.util.HashMap;
import java.util.List;

import slots.model.Linija;
import slots.model.Polje;
import slots.model.Slot;
import slots.model.Znak;

public interface SlotService {
	
	List <Slot> getAll();
	
	Slot getOne(Long id);
	
	Double spin(Double ulog,Long slotId);
	
	Double payout(Linija l);
	
	Znak generisiZnak (HashMap<String,Integer> verovatnoca);
	
	HashMap<String,Integer> postaviVerovatnocu(List<Znak> lista);
	
	

}
