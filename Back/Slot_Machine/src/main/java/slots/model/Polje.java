package slots.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;

@Entity
public class Polje {
	
	@Id
	private Long id;
	
	@Column
	private Integer kolona;
	
	@Column
	private Integer red;
	
	@Transient
	private Znak znak;
	

	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getKolona() {
		return kolona;
	}

	public void setKolona(Integer kolona) {
		this.kolona = kolona;
	}

	public Integer getRed() {
		return red;
	}

	public void setRed(Integer red) {
		this.red = red;
	}

	public Znak getZnak() {
		return znak;
	}

	public void setZnak(Znak znak) {
		this.znak = znak;
	}




//	public Znak getZnak() {
//		return znak;
//	}
//
//	public void setZnak(Znak znak) {
//		this.znak = znak;
//	}
	
	

}
