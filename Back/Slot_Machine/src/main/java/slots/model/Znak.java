package slots.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Znak {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String oznaka;
	
	@Column
	private Double vrednost;
	
	@Column
	private Integer verovatnoca;
	
	@ManyToOne
	private Slot slot;
	
	public String getOznaka() {
		return oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getVrednost() {
		return vrednost;
	}

	public void setVrednost(Double vrednost) {
		this.vrednost = vrednost;
	}

	public Integer getVerovatnoca() {
		return verovatnoca;
	}

	public void setVerovatnoca(Integer verovatnoca) {
		this.verovatnoca = verovatnoca;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}
	
	
	
	
	

}
