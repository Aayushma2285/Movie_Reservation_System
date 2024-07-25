package com.texas.MovieReservationSystem.dto;

public class AuthResponseDto {
    private String responseToken;
    private Long expirationTime;

    public AuthResponseDto(String responseToken, Long expirationTime) {
        this.responseToken = responseToken;
        this.expirationTime = expirationTime;
    }

    public String getResponseToken() {
        return responseToken;
    }

    public void setResponseToken(String responseToken) {
        this.responseToken = responseToken;
    }

    public Long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Long expirationTime) {
        this.expirationTime = expirationTime;
    }
}
