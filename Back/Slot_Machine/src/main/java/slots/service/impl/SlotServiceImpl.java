package slots.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import slots.model.Linija;
import slots.model.Polje;
import slots.model.Slot;
import slots.model.Znak;
import slots.repository.SlotRepository;
import slots.service.SlotService;
import slots.service.ZnakService;

@Service

public class SlotServiceImpl implements SlotService {
	
	@Autowired
	private SlotRepository slotRepository;
	
	@Autowired
	private ZnakService znakService;
	
	@Override
	public List<Slot> getAll() {
		return slotRepository.findAll();
	}

	

	@Override
	public Slot getOne(Long id) {
		return slotRepository.findOneById(id);
	}



	@Override
	public Double spin(Double ulog,Long slotId) {
		Slot slot = getOne(slotId);
		
		HashMap verovatnoca = postaviVerovatnocu(slot.getZnakovi());
		
		Double isplata = 0.0;
		
		
		List<Znak> znakovi = slot.getZnakovi();
		
		
		
		
		
		List<Linija> linije  = slot.getLinije();
		
		
		
		List<Polje> polja = slot.getPolja();
		
		
		int demoBrojac = -2;
		
		for(Polje p: slot.getPolja()) {
		
			p.setZnak(generisiZnak(verovatnoca));
			
			

		}

		for(Linija l: slot.getLinije()) {
			
			isplata += payout(l);
		}
		slot.setIsplata(isplata * ulog);
		
		return isplata;
	}



	@Override
	public Double payout(Linija l) {
		Double isplata = 0.0;
		boolean check = true;
		List <Polje> polja = l.getPolja();
		Znak uporedniZnak =  polja.get(0).getZnak();
		

		for(Polje p: polja) {
			
			if(!p.getZnak().getOznaka().equals(uporedniZnak.getOznaka())) {
				check = false;
			}
		}
		if (check) {
			return(uporedniZnak.getVrednost());
			
		}
		return isplata;
		
	}



	



	@Override
	public HashMap<String, Integer> postaviVerovatnocu(List<Znak> lista) {
		HashMap<String,Integer> verovatnoca =  new HashMap<>();
		for(Znak z: lista) {
			verovatnoca.put(z.getOznaka(), z.getVerovatnoca());
		}
		return verovatnoca;
	}



	@Override
	public Znak generisiZnak(HashMap<String, Integer> verovatnoca) {
		Random random = new Random();
		Znak znak =  new Znak();
		int ukupanProcenat = 0;
		for (int proc : verovatnoca.values()) {
			ukupanProcenat += proc;
		}System.out.println("PROCENAT ::");
		System.out.println(ukupanProcenat);
		int broj = random.nextInt(ukupanProcenat);
		
		for(String simbol: verovatnoca.keySet()) {
			if(broj - verovatnoca.get(simbol) <0) {
				znak = znakService.findByOznaka(simbol);
				return znak;
			}
			broj -=verovatnoca.get(simbol);
		}
		
		return null;
	}

}
