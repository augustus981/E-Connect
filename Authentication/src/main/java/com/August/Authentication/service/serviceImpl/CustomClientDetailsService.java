package com.August.Authentication.service.serviceImpl;

import com.August.Authentication.entity.ClientPrincipal;
import com.August.Authentication.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service (value = "clientDetails")
public class CustomClientDetailsService implements ClientDetailsService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        ClientPrincipal clientPrincipal = clientRepository.findClientByClientId(clientId)
                .orElseThrow(() ->new ClientRegistrationException(clientId + " not found"));
        BaseClientDetails clientDetails = new BaseClientDetails(
                clientPrincipal.getClientId(),
                clientPrincipal.getResourceIds(),
                clientPrincipal.getScope(),
                clientPrincipal.getAuthorizedGrantTypes(),
                clientPrincipal.getAuthorities(),
                clientPrincipal.getRedirectUri());
        clientDetails.setClientSecret(clientPrincipal.getClientSecret());
        clientDetails.setAccessTokenValiditySeconds(clientPrincipal.getAccessTokenValidity());
        clientDetails.setRefreshTokenValiditySeconds(clientPrincipal.getRefreshTokenValidity());
        clientDetails.addAdditionalInformation("INFO", clientPrincipal.getAdditionalInformation());
        Set<String> autoApproveScopes = new HashSet<String>();
        autoApproveScopes.add(clientPrincipal.getAutoapprove());
        clientDetails.setAutoApproveScopes(autoApproveScopes);
        System.out.println(clientDetails.getClientId() + " " + clientDetails.getAuthorizedGrantTypes());
        return clientDetails;
    }
}
