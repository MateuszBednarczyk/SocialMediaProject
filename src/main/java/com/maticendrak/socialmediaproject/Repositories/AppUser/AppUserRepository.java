package com.maticendrak.socialmediaproject.Repositories.AppUser;

import com.maticendrak.socialmediaproject.Entities.AppUser.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUserEntity, Long> {
    UserDetails findAppUserEntitiesByUsername(String username);
}
