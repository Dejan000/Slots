package slots.dto;

import java.util.HashMap;
import java.util.Map;

import slots.model.Polje;

public class SlotDto {
	
	private Long slotId;
	
	private Double isplata;
	
	private Double ulog;
	
	private Integer kolone;
	
	private Integer redovi;
	
	private Map<Long,Polje> polja =  new HashMap<>();

	

	public Long getSlotId() {
		return slotId;
	}

	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}

	public Double getIsplata() {
		return isplata;
	}

	public void setIsplata(Double isplata) {
		this.isplata = isplata;
	}

	public Double getUlog() {
		return ulog;
	}

	public void setUlog(Double ulog) {
		this.ulog = ulog;
	}

	public Integer getKolone() {
		return kolone;
	}

	public void setKolone(Integer kolone) {
		this.kolone = kolone;
	}

	public Integer getRedovi() {
		return redovi;
	}

	public void setRedovi(Integer redovi) {
		this.redovi = redovi;
	}

	public Map<Long, Polje> getPolja() {
		return polja;
	}

	public void setPolja(Map<Long, Polje> polja) {
		this.polja = polja;
	}
	
	
	

}
