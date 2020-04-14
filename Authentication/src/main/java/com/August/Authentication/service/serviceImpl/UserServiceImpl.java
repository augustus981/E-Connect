package com.August.Authentication.service.serviceImpl;

import com.August.Authentication.entity.UserPrincipal;
import com.August.Authentication.repository.UserRepository;
import com.August.Authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<UserPrincipal> findUser(String account){
        return userRepository.findUserByAccount(account);
    }

    @Override
    public UserPrincipal update(UserPrincipal user){
        return userRepository.save(user);
    }

}
