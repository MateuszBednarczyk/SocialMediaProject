package com.maticendrak.socialmediaproject.mailing;

import com.maticendrak.socialmediaproject.appUser.dtos.requests.SendMailRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailFacade {

    private final MailSenderService mailSenderService;

    public void sendMail(SendMailRequestDTO requestDTO) {

        mailSenderService.sendEmail(requestDTO);

    }

}
