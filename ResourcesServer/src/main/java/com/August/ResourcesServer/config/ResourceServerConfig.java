package com.August.ResourcesServer.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Qualifier("jwtTokenStore")
    @Autowired
    TokenStore tokenStore;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and().exceptionHandling()
                .authenticationEntryPoint((httpServletRequest, httpServletResponse, authException)
                        -> httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .accessDeniedHandler((httpServletRequest, httpServletResponse, authException)
                        -> httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED));
    }

    public void configure(ResourceServerSecurityConfigurer resource){
        resource.tokenStore(tokenStore)
                .resourceId("USER_ADMIN_RESOURCE");
    }

}
