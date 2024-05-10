package com.anudip.training.service;

import java.util.List;

import com.anudip.training.dto.UserDTO;



public interface UserService {

	List<UserDTO> getAllUser();
	
	UserDTO getUserById(Long userId);
	
	UserDTO addUser(UserDTO userdto);
	
	UserDTO updateUserById(Long userId,UserDTO userdto);
	
	void deleteUserById(Long userId);
	
    List<UserDTO> getUserByName(String username);

     
}
