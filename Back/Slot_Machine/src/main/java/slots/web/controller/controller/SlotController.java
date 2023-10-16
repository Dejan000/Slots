package slots.web.controller.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import slots.dto.SlotDto;
import slots.dto.SlotMenuDto;
import slots.model.Polje;
import slots.model.Slot;
import slots.model.User;
import slots.model.Znak;
import slots.security.TokenUtils;
import slots.service.SlotService;
import slots.service.UserService;
import slots.service.ZnakService;
import slots.support.SlotToSlotDto;
import slots.support.SlotToSlotMenuDto;
import slots.support.UserToUserDto;

@Controller
@RequestMapping(value="/api/slots")
public class SlotController {
	
	@Autowired
	private SlotService slotService;
	
	@Autowired
	private ZnakService znakService;
	
	@Autowired
	private SlotToSlotDto toDto;
	
	@Autowired
	private SlotToSlotMenuDto toMenu;
	
	@Autowired
	private UserToUserDto toUserDto;
	
	@Autowired
	private UserService userService;
	

	
	@GetMapping
	public  ResponseEntity<List<SlotMenuDto>> get(){
		
		List<SlotMenuDto> dtoSlotovi = toMenu.convert(slotService.getAll());
		
		
		
		return new ResponseEntity<>(dtoSlotovi,HttpStatus.OK);
		
		
		
		
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SlotDto> getSlotGame(@PathVariable Long id){
		
		Slot slot =  slotService.getOne(id);
		return new ResponseEntity<>(toDto.convert(slot),HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/spin/{id}/{ulogDb}")
	public ResponseEntity<SlotDto> spin(@PathVariable Long id,@PathVariable Double ulogDb){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Optional<User> userOp = userService.findbyKorisnickoIme(authentication.getName());
		
		Slot slot = slotService.getOne(id);
		System.out.println(ulogDb);
		
		for(Znak z: slot.getZnakovi()) {
			System.out.println(z.getOznaka());
		}
		slotService.spin(ulogDb, id);
		
		if(userOp.isPresent()) {
			
			User user = userOp.get();
			
			System.out.println(user.getBalance());
			user.setBalance(user.getBalance() + slot.getIsplata() -ulogDb );
			userService.saveBalance(user);
			
		}
		for(Znak z: slot.getZnakovi()) {
			System.out.println(z.getOznaka());
		}
		SlotDto dto = toDto.convert(slot);
		for(Polje p:dto.getPolja().values()) {
			p.getZnak().setSlot(null);
		}
		
		return new ResponseEntity<>(toDto.convert(slot),HttpStatus.OK);
		
	}
	


}
