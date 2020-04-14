package com.August.Authentication.controller;

import com.August.Authentication.entity.ClientPrincipal;
import com.August.Authentication.entity.UserPrincipal;
import com.August.Authentication.repository.ClientRepository;
import com.August.Authentication.service.UserService;
import org.springframework.security.oauth2.provider.ClientDetailsService;
//import com.Augus.Authentication.service.serviceImpl.CustomClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.Instant;

//import java.nio.file.attribute.UserPrincipal;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ClientDetailsService clientDetails;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/me")
    public Object hello(Principal userPrincipal){
        return userPrincipal;
    }

    @GetMapping("/client")
    public ClientPrincipal client(){
        return clientRepository.findClientByClientId("app").orElseThrow(()->new NullPointerException("app not found"));
    }

    @GetMapping("/clientDetails")
    public String clientDetails(){
        return clientDetails.loadClientByClientId("app").getAuthorizedGrantTypes().toString();
    }

    @PostMapping("/admin")
    public UserPrincipal addAdmin(){
        UserPrincipal admin = new UserPrincipal();
        admin.setAccount("admin");
        admin.setPassword("nhuaugustus");
        admin.setActivated(true);
        admin.setEmail("nhu.phungkhac1998@gmail.com");
        admin.setFirstName("Augustus");
        admin.setLastName("Nhu");
        admin.setCreatedBy("admin");
        admin.setLastModifiedBy("admin");
        Instant now = Instant.now();
        admin.setLastModifiedDate(now.toEpochMilli());
        admin.setCreatedDate(now.getEpochSecond());
        System.out.println(admin.getAccount());
        userService.update(admin);
        return userService.findUser("admin").orElseThrow(()->new UsernameNotFoundException("admin not found"));
    }


}
