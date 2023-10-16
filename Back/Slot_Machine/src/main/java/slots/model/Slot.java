package slots.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import slots.enums.Kolone;
import slots.enums.Redovi;

@Entity
public class Slot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Double ulog;
	
	@Column
	private Double isplata;
	
	@Column
	private Integer kolone;
	
	@Column
	private Integer redovi;
	
	@ManyToMany(mappedBy = "slotovi_linije")
	private List<Linija> linije =  new ArrayList<>();
	
	@ManyToMany
	private List<Polje> polja = new ArrayList<>();
	
	@OneToMany(mappedBy = "slot")
	private List<Znak> znakovi = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getUlog() {
		return ulog;
	}

	public void setUlog(Double ulog) {
		this.ulog = ulog;
	}

	public Double getIsplata() {
		return isplata;
	}

	public void setIsplata(Double isplata) {
		this.isplata = isplata;
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

	public List<Polje> getPolja() {
		return polja;
	}

	public void setPolja(List<Polje> polja) {
		this.polja = polja;
	}

	public List<Znak> getZnakovi() {
		return znakovi;
	}

	public void setZnakovi(List<Znak> znakovi) {
		this.znakovi = znakovi;
	}

	public List<Linija> getLinije() {
		return linije;
	}

	public void setLinije(List<Linija> linije) {
		this.linije = linije;
	}
	
	
	
	

	
	
	
	

}
