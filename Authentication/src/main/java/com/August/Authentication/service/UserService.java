package com.August.Authentication.service;

import com.August.Authentication.entity.UserPrincipal;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    Optional<UserPrincipal> findUser(String account);
    UserPrincipal update(UserPrincipal user);

}
