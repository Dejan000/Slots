package slots.web.controller.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import slots.dto.AuthDto;
import slots.dto.UserDto;
import slots.dto.UserPasswordChangeDto;
import slots.dto.UserRegistrationDto;
import slots.model.User;
import slots.security.TokenUtils;
import slots.service.UserService;
import slots.support.UserToUserDto;


@RestController
@RequestMapping("api/users")
public class ApiUserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserToUserDto toDto;

	@Autowired
	private Converter<UserDto, User> toUser;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private TokenUtils tokenUtils;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;


	@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> get(@PathVariable Long id){
		Optional<User> user = userService.one(id);
		
		if(user.isPresent()) {
			UserDto body = toDto.convert(user.get());
			return new ResponseEntity<>(body, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<UserDto>> get(
			@RequestParam(defaultValue="0") int page){
		
		Page<User> usersPage = userService.all(page);
		List<User> users = usersPage.getContent();
		for(User u:users) {
			System.out.println(u.getUserName());
		}
		List<UserDto> body = toDto.convert(users);
		return new ResponseEntity<>(body, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		if(!userService.one(id).isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 

		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping
	public ResponseEntity<UserDto> add(
			@RequestBody @Validated UserRegistrationDto reqBody){
		
		System.out.println(reqBody.getUsername());
		System.out.println(reqBody.getPassword());
		System.out.println(reqBody.getPasswordConfirm());
		

		if(reqBody.getId() != null 
				|| !reqBody.getPassword().equals(reqBody.getPasswordConfirm())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	
		User toAdd = toUser.convert(reqBody);
		toAdd.setPassword(passwordEncoder.encode(reqBody.getPassword()));
		
		User persisted = userService.save(toAdd);
		
		UserDto respBody = toDto.convert(persisted);
		return new ResponseEntity<>(respBody, HttpStatus.CREATED);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle(){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> edit(
			@PathVariable Long id,
			@RequestBody UserDto reqBody){
		
		
		
		if(!id.equals(reqBody.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		User toEdit = toUser.convert(reqBody);
		User persisted = userService.save(toEdit);
		
		UserDto respBody = toDto.convert(persisted);
		return new ResponseEntity<>(respBody, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, params = "chpass")
	public ResponseEntity<Void> changePassword(
			@PathVariable Long id,
			@RequestBody UserPasswordChangeDto reqBody){
		
		
		if(!reqBody.getPassword().equals(reqBody.getPasswordConfirm())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		boolean result;
		try {
			result = userService.changePassword(id, reqBody);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		
		if(result) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
	}

	@PostMapping("/auth")
	public ResponseEntity<String> login(@RequestBody AuthDto dto) {
	
		
		UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());
		Authentication authentication = authenticationManager.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		try {
		
			UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getUsername());
			return ResponseEntity.ok(tokenUtils.generateToken(userDetails));
		} catch (UsernameNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/balance")
	public ResponseEntity<Double> getBalance(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Optional<User> userOp = userService.findbyKorisnickoIme(authentication.getName());
		if(userOp.isPresent()) {
			
			User user = userOp.get();
			Double balance = user.getBalance();
			
			System.out.println(user.getBalance());
			return new ResponseEntity<>(balance,HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		
		
	}
}
