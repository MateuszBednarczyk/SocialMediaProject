package com.maticendrak.socialmediaproject.appuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUserEntity, Long> {
    UserDetails findAppUserEntityByUsername(String username);

    void deleteAppUserEntityByUsername(String username);

}
