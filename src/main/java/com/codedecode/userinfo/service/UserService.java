package com.codedecode.userinfo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codedecode.userinfo.dto.UserDTO;
import com.codedecode.userinfo.entity.User;
import com.codedecode.userinfo.mapper.UserMapper;
import com.codedecode.userinfo.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public UserDTO addUser(UserDTO userDTO) {
        
        User user = userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
        return UserMapper.INSTANCE.mapUserToUserDTO(user);

    }

    public UserDTO fetchUserDetailsById(Integer userId) {

        Optional<User> user = userRepo.findById(userId);
        return user.isPresent() ? UserMapper.INSTANCE.mapUserToUserDTO(user.get()) : null;
        
    }
    
}
