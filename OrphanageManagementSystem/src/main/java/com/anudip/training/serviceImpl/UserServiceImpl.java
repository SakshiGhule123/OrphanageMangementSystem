package com.anudip.training.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.training.dto.UserDTO;
import com.anudip.training.entity.User;
import com.anudip.training.exception.UserIdNotFoundException;
import com.anudip.training.repository.UserRepository;
import com.anudip.training.service.UserService;
import com.anudip.training.util.UserConverter;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserConverter userConverter;
	
	@Override
	public List<UserDTO> getAllUser() {

		List<User> allUser=this.userRepository.findAll();
		List<UserDTO> collect=allUser.stream().map((user)->this.userConverter.convertToUserDTO(user)).collect(Collectors.toList());
		return collect;	}

	@Override
	public UserDTO getUserById(Long userId) {
	
		User user=userRepository.findById(userId).orElseThrow(() -> new UserIdNotFoundException("UserId is not correct"));
		return this.userConverter.convertToUserDTO(user);
		}

	@Override
	public UserDTO addUser(UserDTO userdto) {

		User user = this.userConverter.convertToUser(userdto);
		User saveUser = this.userRepository.save(user);
		return this.userConverter.convertToUserDTO(saveUser);	}

	@Override
	public UserDTO updateUserById(Long userId, UserDTO userdto) {
 
		User updatedUser= userRepository.findById(userId).orElseThrow(() -> new UserIdNotFoundException("user id is not correct"));
		updatedUser.setEmail(userdto.getEmail());
		updatedUser.setPassword(userdto.getPassword());
		updatedUser.setUsername(userdto.getUsername());
		
         User saveUser=userRepository.save(updatedUser);

		
		
		return userConverter.convertToUserDTO(saveUser);
	}

	@Override
	public void deleteUserById(Long userId) {
		
		 userRepository.findById(userId).orElseThrow(() -> new UserIdNotFoundException("user id is not correct"));
		
		 userRepository.existsById(userId);
	}

	@Override
    public List<UserDTO> getUserByName(String username) {
        List<User> users = userRepository.findByUsernameIgnoreCase(username);
        return users.stream().map(userConverter::convertToUserDTO).collect(Collectors.toList());
    }
	

	}
