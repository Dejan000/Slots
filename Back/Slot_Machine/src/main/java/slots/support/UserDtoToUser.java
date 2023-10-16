package slots.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import slots.dto.UserDto;
import slots.model.User;
import slots.service.UserService;



@Component
public class UserDtoToUser implements Converter<UserDto, User> {

	@Autowired
	private UserService userService;
	
	@Override
	public User convert(UserDto source) {
		User target = null;
		if(source.getId() != null) {
			target = userService.one(source.getId()).get();
		}
		
		
		if(target == null) { 
			target = new User();
		}
				
		target.setUserName(source.getUsername());
		target.setBalance(source.getBalance());
		
		return target;
	}
	
	

}
