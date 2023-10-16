package slots.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import slots.dto.UserDto;
import slots.model.User;

@Component
public class UserToUserDto implements Converter<User,UserDto> {

	@Override
	public UserDto convert(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setUsername(user.getUserName());
		
		userDto.setBalance(user.getBalance());
		return userDto;
	}
	public List<UserDto> convert(List<User> useri){
		List<UserDto> listaRet = new ArrayList<>() ;
		for(User u:useri) {
			listaRet.add(convert(u));
		}
		
		return listaRet;
		
	}

}
