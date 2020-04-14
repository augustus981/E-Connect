package com.August.Authentication.repository;

import com.August.Authentication.entity.UserPrincipal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserPrincipal, String> {

    Optional<UserPrincipal> findUserByAccount(String account);
}
