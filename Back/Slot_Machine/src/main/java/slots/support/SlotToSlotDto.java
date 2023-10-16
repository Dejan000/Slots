package slots.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import slots.dto.SlotDto;
import slots.model.Polje;
import slots.model.Slot;

@Component
public class SlotToSlotDto implements Converter<Slot,SlotDto> {

	@Override
	public SlotDto convert(Slot slot) {
		SlotDto dto =  new SlotDto();
		dto.setSlotId(slot.getId());
		dto.setIsplata(slot.getIsplata());
		for(Polje p: slot.getPolja()) {

			dto.getPolja().put(p.getId(), p);
			
		}
		dto.setRedovi(slot.getRedovi());
		dto.setUlog(slot.getUlog());
		dto.setKolone(slot.getKolone());
		
		return dto;
	}
	
	public List<SlotDto> convert(List<Slot> slotovi){
		List<SlotDto> dtoRet = new ArrayList<>();
		for(Slot s: slotovi) {
			dtoRet.add(convert(s));
		}
		return dtoRet;
		
	}
	

}
