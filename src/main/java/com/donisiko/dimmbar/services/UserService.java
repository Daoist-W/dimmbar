package com.donisiko.dimmbar.services;

import com.donisiko.dimmbar.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // fields
    private UserRepository userRepository;
    private ModelMapper UserMapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper userMapper) {
        this.userRepository = userRepository;
        UserMapper = userMapper;
    }


}
