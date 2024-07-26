package com.texas.MovieReservationSystem.service;

import com.texas.MovieReservationSystem.dto.EmailDto;

public interface EmailService {
    public void sendEmail(EmailDto emailDto);
}
