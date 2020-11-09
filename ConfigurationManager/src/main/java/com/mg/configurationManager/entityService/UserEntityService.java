package com.mg.configurationManager.entityService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.configurationManager.entity.User;
import com.mg.configurationManager.exceptions.NoElementFoundException;
import com.mg.configurationManager.repository.UserRepository;

@Service
public class UserEntityService {

	@Autowired
	private UserRepository userRepositor;
	
	public User getUserById(Integer id)
	{
		return userRepositor.findById(id).orElseThrow(()->new NoElementFoundException(id));
	}

	public User createUser(User User) {
		return userRepositor.save(User);
	}

	public User updateUser(User User, Boolean create) throws NoElementFoundException{
		Optional<User> UserOptional = userRepositor.findById(User.getId());
		if(UserOptional.isPresent())
		{
			User UserToSave = UserOptional.get();
			UserToSave.setId(User.getId());
			return userRepositor.save(UserToSave);
		}
		else
		{
			if(create)
				return createUser(User);
			else
				throw new NoElementFoundException(User.getId());
		}	
	}

	public void deleteUser(Integer id) {
		userRepositor.deleteById(id);
	}

	public User getUserByName(String UserName) {
		return userRepositor.findByUsername(UserName);
	}
}
