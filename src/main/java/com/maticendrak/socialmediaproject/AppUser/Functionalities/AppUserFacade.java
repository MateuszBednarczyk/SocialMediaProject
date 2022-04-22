package com.maticendrak.socialmediaproject.AppUser.Functionalities;

import com.maticendrak.socialmediaproject.AppUser.DTOs.LoginResponseDTO;

public interface AppUserFacade {

    public LoginResponseDTO login(String username, String password);
    public LoginResponseDTO register(String username, String password);
    public boolean checkIfUserExists(String username);

}
