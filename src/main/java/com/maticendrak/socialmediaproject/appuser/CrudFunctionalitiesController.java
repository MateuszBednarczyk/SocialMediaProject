package com.maticendrak.socialmediaproject.appuser;

import com.maticendrak.socialmediaproject.appuser.crudfunctionalities.AppUserCrudFunctionalitiesFacade;
import com.maticendrak.socialmediaproject.appuser.dtos.requests.*;
import com.maticendrak.socialmediaproject.appuser.dtos.responses.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class CrudFunctionalitiesController {
    private final AppUserCrudFunctionalitiesFacade appUserCrudFunctionalitiesFacade;
    @RequestMapping(method = RequestMethod.POST, value = "/api/user/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO loginRequestDTO) {

        return appUserCrudFunctionalitiesFacade.login(loginRequestDTO);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/user/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO requestDTO) {

        return appUserCrudFunctionalitiesFacade.register(requestDTO);

    }


    @RequestMapping(method = RequestMethod.POST, value = "/api/user/find-user")
    public UserResponseDTO findUser(@RequestBody FindUserByUsernameRequestDTO requestDTO) {

        return appUserCrudFunctionalitiesFacade.findUser(requestDTO);

    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/api/user/update-username")
    public UserResponseDTO updateUsername(@RequestBody UpdateUsernameRequestDTO requestDTO) {

        return appUserCrudFunctionalitiesFacade.updateUsername(requestDTO);

    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/api/user/update-password")
    public String updatePassword(@RequestBody UpdatePasswordRequestDTO requestDTO) {

        return appUserCrudFunctionalitiesFacade.updatePassword(requestDTO);

    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/api/user/update-description")
    public UserResponseDTO updateDescription(@RequestBody UpdateDescriptionRequestDTO requestDTO) {

        return appUserCrudFunctionalitiesFacade.updateDescription(requestDTO);

    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/api/user/update-image")
    public UserResponseDTO updateImage(@RequestBody UpdateImageRequestDTO requestDTO) {

        return appUserCrudFunctionalitiesFacade.updateImage(requestDTO);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/user/delete-user")
    public String deleteAppUser(@RequestBody DeleteAppUserRequestDTO requestDTO) {

        return appUserCrudFunctionalitiesFacade.deleteAppUser(requestDTO);

    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/api/user/update-role")
    public UserResponseDTO updateRole(@RequestBody UpdateRoleRequestDTO requestDTO) {

        return appUserCrudFunctionalitiesFacade.updateRole(requestDTO);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/user/send-verification-mail")
    public void sendVerificationMail(@RequestBody SendMailRequestDTO requestDTO, HttpServletRequest httpServletRequest) {

        appUserCrudFunctionalitiesFacade.sendVerificationMail(requestDTO, httpServletRequest);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/user/verify")
    public ModelAndView verifyAppUser(@RequestParam("token") String token, @RequestParam("username") String username) {

        return appUserCrudFunctionalitiesFacade.verifyAppUser(new VerifyAppUserRequestDTO(token, username));

    }

}

