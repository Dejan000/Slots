package slots.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import slots.dto.SlotDto;
import slots.model.Slot;
import slots.service.LinijaService;
import slots.service.PoljeService;
import slots.service.SlotService;

@Component
public class SlotDtoToSlot implements Converter<SlotDto,Slot>{
	
	@Autowired
	private LinijaService linijaService;
	
	@Autowired
	private PoljeService poljeService;
	
	@Autowired
	private SlotService slotService;

	@Override
	public Slot convert(SlotDto dto) {
		Slot entity;
		if(dto.getSlotId()==null) {
			entity =  new Slot();
		}else {entity =  slotService.getOne(dto.getSlotId());}
		entity.setIsplata(dto.getIsplata());
		entity.setKolone(dto.getKolone());
		for(Long poljeId:dto.getPolja().keySet()) {
			entity.getPolja().add(poljeService.findOneById(poljeId));
		}
//		for(Long linijaId: dto.get)
		
		
		return entity;
	}

}
