package com.August.Authentication.repository;

import com.August.Authentication.entity.ClientPrincipal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientPrincipal, String> {

    Optional<ClientPrincipal> findClientByClientId(String clientId);
}
