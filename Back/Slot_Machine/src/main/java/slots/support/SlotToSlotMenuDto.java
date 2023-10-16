package slots.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import slots.dto.SlotMenuDto;
import slots.model.Slot;

@Component
public class SlotToSlotMenuDto implements Converter<Slot,SlotMenuDto> {

	@Override
	public SlotMenuDto convert(Slot source) {
		
		SlotMenuDto dto = new SlotMenuDto();
		dto.setId(source.getId());
		
		
		return dto;
	}
	
	public List<SlotMenuDto> convert(List<Slot> slotovi){
		List<SlotMenuDto> listaRet  = new ArrayList<>();
		for(Slot s:slotovi) {
			listaRet.add(convert(s));
		}
		return listaRet;
		
	}

}
