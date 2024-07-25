package com.texas.MovieReservationSystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.texas.MovieReservationSystem.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Integer id;
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be empty")
    private String name;
    private Role role;
    @NotNull(message = "Email cannot be null")
    @NotNull(message = "Email cannot be blank")
    private String email;
    private String password;


    public UserDto() {
    }

    public UserDto(Integer id, String name, Role role, String email) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
