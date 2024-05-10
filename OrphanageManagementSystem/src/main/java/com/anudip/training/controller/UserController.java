package com.anudip.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.training.dto.UserDTO;
import com.anudip.training.entity.User;
import com.anudip.training.service.UserService;
import com.anudip.training.util.UserConverter;

@RestController
@RequestMapping("/User")
@CrossOrigin("*")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserConverter userConverter;
	
	//  http://localhost:8080/User/getAllUser
	@GetMapping("/getAllUser")
	public ResponseEntity<List<UserDTO>> getAllUser()
	{
		return new ResponseEntity<List<UserDTO>>(userService.getAllUser(),HttpStatus.OK);
		
	}
	
    //  http://localhost:8080/User/getUser/1
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId)
	{
		return new ResponseEntity<>(userService.getUserById(userId),HttpStatus.OK);
		
	}
	
	 //  http://localhost:8080/User/addUser
	@PostMapping("/addUser")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userdto)
	{
		return new ResponseEntity<>(userService.addUser(userdto),HttpStatus.CREATED);
			
	}	
	
	 //  http://localhost:8080/User/updateUser/1
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable Long userId,@RequestBody UserDTO userdto)
	{
		return new ResponseEntity<>(userService.updateUserById(userId, userdto),HttpStatus.OK);
				
	}	

	 //  http://localhost:8080/User/deleteUser/4
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<User> deleteUser(@PathVariable Long userId)
	{
		userService.deleteUserById(userId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
					
	}
	
	// http://localhost:8080/User/getUserByName/
    @GetMapping("/getUserByName/{username}")
    public ResponseEntity<List<UserDTO>> getUserByName(@PathVariable String username) {
        return new ResponseEntity<>(userService.getUserByName(username), HttpStatus.OK);
    }
    
    @PostMapping("/userlogin")
    public ResponseEntity<?> userLogin(@RequestBody UserDTO userdto) {
        
        User user = (User) userService.getUserByName(userdto.getUsername());

        if (user != null && user.getPassword().equals(userdto.getPassword())) {
            return ResponseEntity.ok(userdto);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

}
