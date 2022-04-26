package com.maticendrak.socialmediaproject.mailing;

import com.maticendrak.socialmediaproject.appUser.dtos.requests.SendMailRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class MailSenderService{
    private final JavaMailSender javaMailSender;

    public void sendEmail(SendMailRequestDTO requestDTO) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(requestDTO.getDirectionMail());
        msg.setSubject(requestDTO.getTitle());
        msg.setText(requestDTO.getContent());

        javaMailSender.send(msg);
    }
}