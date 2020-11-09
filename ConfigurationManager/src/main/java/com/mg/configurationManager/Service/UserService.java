package com.mg.configurationManager.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.configurationManager.entity.User;
import com.mg.configurationManager.entityService.UserEntityService;
import com.mg.configurationManager.exceptions.NoElementFoundException;
import com.mg.configurationManager.model.UserDto;

@Service
public class UserService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserEntityService userEntityService;

	public UserDto getUserById(Integer id) {
		User user = userEntityService.getUserById(id);
		UserDto userDto = new UserDto();
		modelMapper.map(user, userDto);
		return userDto;
	}

	public UserDto createUser(UserDto userDto) {
		User user = new User();
		modelMapper.map(userDto, user);
		user = userEntityService.createUser(user);
		modelMapper.map(user, userDto);
		return userDto;
	}

	public UserDto updateUser(UserDto userDto, Boolean create) throws NoElementFoundException {
		User user = new User();
		modelMapper.map(userDto, user);
		user = userEntityService.updateUser(user, create);
		modelMapper.map(user, userDto);
		return userDto;
	}

	public void deleteUser(Integer id) {
		userEntityService.deleteUser(id);
	}

	public UserDto getUserByName(String UserName) {
		User user = userEntityService.getUserByName(UserName);
		UserDto userDto = new  UserDto();
		modelMapper.map(user, userDto);
		return userDto;
	}

}
