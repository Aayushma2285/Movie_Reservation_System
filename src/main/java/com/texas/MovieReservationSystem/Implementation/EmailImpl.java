package com.texas.MovieReservationSystem.Implementation;

import com.texas.MovieReservationSystem.dto.EmailDto;
import com.texas.MovieReservationSystem.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public void sendEmail(EmailDto emailDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailDto.getTo());
        message.setFrom("raiaayushma798@gmail.com");
        message.setSubject(emailDto.getSubject());
        message.setText(emailDto.getMessage());
        javaMailSender.send(message);
    }
}
