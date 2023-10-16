package slots.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Linija {
	
	@Id
	private Long id;
	
	@Column
	private Integer brojPolja;
	
	@ManyToMany
	private List<Slot> slotovi_linije = new ArrayList<>();
	
	@ManyToMany
	private List<Polje> polja =  new ArrayList<>();
	
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBrojPolja() {
		return brojPolja;
	}

	public void setBrojPolja(Integer brojPolja) {
		this.brojPolja = brojPolja;
	}

	public List<Slot> getSlotovi_linije() {
		return slotovi_linije;
	}

	public void setSlotovi_linije(List<Slot> slotovi_linije) {
		this.slotovi_linije = slotovi_linije;
	}

	public List<Polje> getPolja() {
		return polja;
	}

	public void setPolja(List<Polje> polja) {
		this.polja = polja;
	}
	

	
	

}
