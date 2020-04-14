package com.August.ResourcesServer.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class ResourcesController {

    @GetMapping("/user")
    public Object returnPrincipal(Principal user){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
