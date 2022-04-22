package com.maticendrak.socialmediaproject.AppUser.Functionalities;

import com.maticendrak.socialmediaproject.AppUser.Entities.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
interface AppUserRepository extends JpaRepository<AppUserEntity, Long> {
    UserDetails findAppUserEntitiesByUsername(String username);
}
