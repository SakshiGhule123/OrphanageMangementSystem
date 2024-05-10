package com.anudip.training.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.anudip.training.dto.UserDTO;
import com.anudip.training.entity.User;

@Component
public class UserConverter {

    // Converting User TO UserDTO
    public UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        if (user != null) {
            BeanUtils.copyProperties(user, userDTO);
        }
        return userDTO;
    }

    // Converting UserDTO TO User
    public User convertToUser(UserDTO userDTO) {
        User user = new User();
        if (userDTO != null) {
            BeanUtils.copyProperties(userDTO, user);
        }
        return user;
    }
}
