package com.maticendrak.socialmediaproject.appUser.functionalities;

import com.maticendrak.socialmediaproject.appUser.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
interface AppUserRepository extends JpaRepository<AppUserEntity, Long> {
    UserDetails findAppUserEntityByUsername(String username);

    void deleteAppUserEntityByUsername(String username);

}
