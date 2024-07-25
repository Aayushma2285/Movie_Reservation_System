package com.texas.MovieReservationSystem.dao;
import com.texas.MovieReservationSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email) throws UsernameNotFoundException;
}
