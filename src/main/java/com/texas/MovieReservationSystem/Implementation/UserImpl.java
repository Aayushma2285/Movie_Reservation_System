package com.texas.MovieReservationSystem.Implementation;

import com.texas.MovieReservationSystem.dao.UserRepo;
import com.texas.MovieReservationSystem.dto.UserDto;
import com.texas.MovieReservationSystem.exceptions.UserNotFoundException;
import com.texas.MovieReservationSystem.model.User;
import com.texas.MovieReservationSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void saveUser(UserDto userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());
        String rawPassword = userDTO.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        user.setPassword(encodedPassword);
        userRepo.save(user);
    }

     public List<UserDto> findAllUsers(){
       List<User> UserList = userRepo.findAll();
       List<UserDto> userDtoList = UserList.stream()
               .map(user -> {
                   UserDto userDto = new UserDto(
                           user.getId(), user.getName(), user.getRole(), user.getEmail()
                   );
                   return userDto;
               }).collect(Collectors.toList());
       return userDtoList;
     }

    @Override
    public UserDto findById(Integer id){
        User user=userRepo.findById(id)
                .orElseThrow(()-> new UserNotFoundException("User not found with id:"+id));

        return ConverToDto(user);
    }

    @Override
    public String updateById(Integer id, UserDto userDto) {
        Optional<User> userOptional = userRepo.findById(id);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setRole(userDto.getRole());
            userRepo.save(user);
            return "User saved successfully.";
        }else {
            throw new UserNotFoundException("User with "+id+"does not exsist in database.");
        }
    }


    private UserDto ConverToDto(User user){
        UserDto userDto=new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole());
        return (userDto);

    }
}
