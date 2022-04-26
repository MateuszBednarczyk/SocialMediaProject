package com.maticendrak.socialmediaproject.appUser;

import com.maticendrak.socialmediaproject.appUser.dtos.requests.*;
import com.maticendrak.socialmediaproject.appUser.dtos.responses.UserResponseDTO;
import com.maticendrak.socialmediaproject.appUser.appuserfunctionalities.AppUserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class AppUserController {
    private final AppUserFacade appUserFacade;
    private HttpStatus codeToReturn;

    @RequestMapping(method = RequestMethod.POST, value = "/api/user/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO loginRequestDTO) {

        //goes to login service with given credentials
        UserResponseDTO user = appUserFacade.login(loginRequestDTO);
        ResponseEntity<UserResponseDTO> response;

        //checking if user found correctly
        if (user == null) {

            //if no, pass not found error
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {

            //if yes, set up user model as a response and then return
            response = new ResponseEntity<>(user, HttpStatus.OK);

        }

        return response;

    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/user/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO requestDTO) {

        //Check if users exists
        if (appUserFacade.checkIfUserExists(requestDTO.getUsername())) {

            //if user already exists, api drops conflict (409)
            codeToReturn = HttpStatus.CONFLICT;

        } else {

            //if user doesn't exist it goes to register method
            UserResponseDTO newUser = appUserFacade.register(requestDTO);

            //checking if register method created user correct
            if (newUser == null) {

                //if no it drops error
                codeToReturn = HttpStatus.NOT_FOUND;

            } else {

                //if yes it just pass ok status to response entity
                codeToReturn = HttpStatus.OK;

            }
        }

        ResponseEntity response = new ResponseEntity<>(codeToReturn);

        return response;

    }


    @RequestMapping(method = RequestMethod.POST, value = "/api/user/find-user")
    public UserResponseDTO findUser(@RequestBody FindUserRequestDTO requestDTO) {

        return appUserFacade.findUser(requestDTO);

    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/api/user/update-username")
    public UserResponseDTO updateUsername(@RequestBody UpdateUsernameRequestDTO requestDTO) {

        return appUserFacade.updateUsername(requestDTO);

    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/api/user/update-password")
    public String updatePassword(@RequestBody UpdatePasswordRequestDTO requestDTO) {

        if (appUserFacade.updatePassword(requestDTO)) {

            return "redirect:" + "http://localhost:8080/logout";

        } else {

            throw new IllegalStateException("Passwords aren't same, or password isn't correct");
        }

    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/api/user/update-description")
    public UserResponseDTO updateDescription(@RequestBody UpdateDescriptionRequestDTO requestDTO) {

        return appUserFacade.updateDescription(requestDTO);

    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/api/user/update-image")
    public UserResponseDTO updateImage(@RequestBody UpdateImageRequestDTO requestDTO) {

        return appUserFacade.updateImage(requestDTO);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/user/delete-user")
    public String deleteAppUser(@RequestBody DeleteAppUserRequestDTO requestDTO) {

        if (appUserFacade.deleteAppUser(requestDTO)) {

            return "redirect:" + "http://localhost:8080/";

        } else {

            throw new IllegalArgumentException("something went wrong");

        }

    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/api/user/update-role")
    public UserResponseDTO updateRole(@RequestBody UpdateRoleRequestDTO requestDTO) {

        return appUserFacade.updateRole(requestDTO);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/user/send-verification-mail")
    public void sendVerificationMail(@RequestBody SendMailRequestDTO requestDTO, HttpServletRequest httpServletRequest) {

        appUserFacade.sendVerificationMail(requestDTO, httpServletRequest);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/user/verify")
    public ModelAndView verifyAppUser(@RequestParam("token") String token, @RequestParam("username") String username) {

        return new ModelAndView("redirect:http://localhost:8080/", "model", appUserFacade.verifyAppUser(new VerifyAppUserRequestDTO(token, username)));

    }

}

